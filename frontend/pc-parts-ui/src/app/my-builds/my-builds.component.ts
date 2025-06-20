import { Component, OnInit } from '@angular/core';
import { BuildApiService, BuildResponse } from '../services/build-api.service';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-my-builds',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './my-builds.component.html',
  styleUrl: './my-builds.component.css'
})
export class MyBuildsComponent implements OnInit{
  public userBuilds: BuildResponse[] = [];
  public isLoading: boolean = true;
  public errorMessage: string = '';

  constructor(private buildApiService: BuildApiService){}

  ngOnInit(): void {
      this.loadUserBuilds();
  }

  loadUserBuilds(): void{
    this.isLoading = true;
    this.errorMessage = '';

    this.buildApiService.getUserBuilds().subscribe({
      next: (data) => {
        this.userBuilds = data;
        this.isLoading = false;
        console.log('User Builds Loaded: ', this.userBuilds);
      }, 
      error: (err) => {
        this.errorMessage = 'Failed to load saved builds';
        this.isLoading = false;
        console.error('Error fetching user builds: ', err);
      }
    })
  }
}
