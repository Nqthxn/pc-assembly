import { CommonModule } from '@angular/common';
import { Component, OnInit} from '@angular/core';
import { ComponentApiService, PCComponent } from '../../services/component-api.service';

@Component({
  selector: 'app-products',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './products.component.html',
  styleUrl: './products.component.css'
})
export class ProductsComponent {
  public components: PCComponent[] = [];
  public isLoading: boolean = true;
  public errorMessage: string = '';

  constructor(private componentApi: ComponentApiService){}

  ngOnInit(): void{
    this.loadComponents();
  }

  loadComponents(): void{
    this.isLoading = true;
    this.errorMessage = '';

    this.componentApi.getComponents().subscribe({
      next: (data) => {
        this.components = data;
        this.isLoading = false;
        console.log('Components Loaded Successfully', this.components);
      },
      error: (err) => {
        this.errorMessage = "Failed to load components. Please Try again later.";
        this.isLoading = false;
        console.error('Error Fetching components');
      },
      complete: () => {
        console.log('Component Fetching Completed.');
      }
    });
  }

}
