import { Component, OnDestroy, OnInit } from '@angular/core';
import { PCComponent } from '../../services/component-api.service';
import { Subscription } from 'rxjs';
import { CurrentBuildService } from '../../services/current-build.service';
import { CommonModule } from '@angular/common';

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

  constructor(private currentBuildService: CurrentBuildService){}

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
