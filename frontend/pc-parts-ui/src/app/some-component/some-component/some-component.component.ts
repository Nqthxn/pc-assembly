import { CommonModule } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { ComponentApiService, PCComponent } from '../../services/component-api.service'; // Adjust path

@Component({
  selector: 'app-some-component',
  imports: [CommonModule],
  templateUrl: './some-component.component.html',
  styleUrl: './some-component.component.css'
})
export class SomeComponentComponent implements OnInit {
  components: PCComponent[] = [];
  isLoading = false;
  errorMessage = '';

  constructor(private componentApi: ComponentApiService) { } // Inject the service

  ngOnInit(): void {
    this.loadAllComponents();
  }

  loadAllComponents(): void {
    this.isLoading = true;
    this.errorMessage = '';
    this.componentApi.getComponents().subscribe({
      next: (data) => { // This is called when data is successfully received
        this.components = data;
        this.isLoading = false;
      },
      error: (err) => { // This is called if there's an error
        this.errorMessage = `Failed to load components. Status: ${err.status}, Message: ${err.message}`;
        console.error('Error fetching components:', err);
        this.isLoading = false;
      },
      complete: () => { // This is called when the Observable completes (optional)
        console.log('Component fetching complete.');
      }
    });
  }

  fetchCPUs(): void {
    this.isLoading = true;
    this.errorMessage = '';
    this.componentApi.getComponents('CPU').subscribe(data => { // Example of filtering
      this.components = data;
      this.isLoading = false;
    }, err => { /* ... error handling ... */ this.isLoading = false; });
  }

  deletePart(id: number): void {
    if (confirm(`Are you sure you want to delete component with ID ${id}?`)) {
      this.componentApi.deleteComponent(id).subscribe({
        next: () => {
          console.log(`Component ${id} deleted`);
          this.loadAllComponents(); // Refresh the list
        },
        error: (err) => {
          this.errorMessage = `Failed to delete component ${id}. Error: ${err.message}`;
          console.error(err);
        }
      });
    }
  }
}