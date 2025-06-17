import { Component, OnDestroy, OnInit } from '@angular/core';
import { PCComponent } from '../../services/component-api.service';
import { Subscription } from 'rxjs';
import { CurrentBuildService } from '../../services/current-build.service';
import { CommonModule } from '@angular/common';
import { BuildApiService, BuildRequest } from '../../services/build-api.service';
import { AuthService } from '../../services/auth.service';

@Component({
  selector: 'app-builds',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './builds.component.html',
  styleUrl: './builds.component.css'
})
export class BuildsComponent implements OnInit, OnDestroy{
  public currentBuild: PCComponent[] = [];
  public totalPrice: number = 0;
  private buildSubscription: Subscription | undefined;

  public buildName: string = 'My New PC Build';
  public saveStatusMessage: string = '';

  constructor(
    private currentBuildService: CurrentBuildService,
    private buildApiService: BuildApiService,
    private authService: AuthService
  ){}
  
  saveBuild(): void{
    this.saveStatusMessage = '';

    if(this.currentBuild.length === 0){
      this.saveStatusMessage = 'Cannot save an empty build';
      return;
    }

    if(!this.buildName.trim()){
      this.saveStatusMessage = 'Please enter a name for your build.';
      return; 
    }

    const componentIds = this.currentBuild.map(comp => comp.id);
    const buildRequest: BuildRequest = {
      buildName: this.buildName,
      componentIds: componentIds
    };

    this.buildApiService.saveBuild(buildRequest).subscribe({
      next: (response) => {
        console.log('Build saved successfully!', response);
        this.saveStatusMessage = `${response.buildName} saved successfully!`;
        this.currentBuildService.clearBuild();
      },
      error: (err) => {
        console.log('Failed to save build', err);
        this.saveStatusMessage = 'Failed to save build, Please try again';
      }
    });
  }

  ngOnInit(): void {
      this.buildSubscription = this.currentBuildService.currentBuild$.subscribe(components => {
        this.currentBuild = components;
        this.calculateTotalPrice();
        console.log('BuildViewComponent updated with build:', this.currentBuild);
      });
  }

  ngOnDestroy(): void {
      if(this.buildSubscription){
        this.buildSubscription.unsubscribe();
      }
  }

  calculateTotalPrice(): void{
    this.totalPrice = this.currentBuild.reduce((total, component) => total + component.price, 0);
  }

  removeFromBuild(component: PCComponent): void{
    this.currentBuildService.removeComponent(component);
  } 
}
