import { Injectable } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';
import { Observable } from 'rxjs';

export interface PCComponent {
  id: number;
  name: string;
  type: string;
  brand: string;
  price: number;
}

export interface ComponentRequestData { 
  name: string;
  type: string;
  brand: string;
  price: number;
}

@Injectable({
  providedIn: 'root'
})
export class ComponentApiService {
  private apiUrl = 'http://localhost:8080/api/components';

  constructor(private http: HttpClient) { }

  // GET all components (with optional filters)
  getComponents(type?: string, name?: string): Observable<PCComponent[]> {
    let params = new HttpParams();
    if (type) {
      params = params.append('type', type);
    }
    if (name) {
      params = params.append('name', name);
    }
    return this.http.get<PCComponent[]>(this.apiUrl, { params });
  }

  // GET a single component by ID
  getComponentById(id: number): Observable<PCComponent> {
    return this.http.get<PCComponent>(`<span class="math-inline">\{this\.apiUrl\}/</span>{id}`);
  }

  // POST to create a new component
  createComponent(componentData: ComponentRequestData): Observable<PCComponent> {
    return this.http.post<PCComponent>(this.apiUrl, componentData);
  }

  // PUT to update an existing component
  updateComponent(id: number, componentData: ComponentRequestData): Observable<PCComponent> {
    return this.http.put<PCComponent>(`<span class="math-inline">\{this\.apiUrl\}/</span>{id}`, componentData);
  }

  // DELETE a component
  deleteComponent(id: number): Observable<void> { // Returns no content, so Observable<void>
    return this.http.delete<void>(`<span class="math-inline">\{this\.apiUrl\}/</span>{id}`);
  }
}
