import { Injectable } from '@angular/core';
import { BehaviorSubject } from 'rxjs';
import { PCComponent } from './component-api.service';

@Injectable({
  providedIn: 'root'
})
export class CurrentBuildService {
  private buildSource = new BehaviorSubject<PCComponent[]>([]);
  private currentBuild$ = this.buildSource.asObservable();

  constructor() { }

  addComponent(component: PCComponent): void{
    const currentBuild = this.buildSource.getValue();
    const updatedBuild = [...currentBuild, component];

    this.buildSource.next(updatedBuild);

    console.log('Updated to build: ',  component);
  }

  removeComponent(componentToRemove: PCComponent): void{
    const currentBuild = this.buildSource.getValue();

    const updatedBuild = currentBuild.filter(comp => comp.id !== componentToRemove.id);

    this.buildSource.next(updatedBuild);
    console.log('Removed from build: ', componentToRemove);
  }

  clearBuild(): void{
    this.buildSource.next([]);
    console.log('Build cleared');
  }

  getBuildSnapshot(): PCComponent[]{
    return this.buildSource.getValue();
  }
}
