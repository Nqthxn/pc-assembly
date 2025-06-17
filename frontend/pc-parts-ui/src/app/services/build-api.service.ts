import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

export interface BuildRequest{
  buildName: string;
  componentIds: number[];
}

export interface BuildResponse{
  id: number;
  buildName: string;
  componentIds: number[];
}

@Injectable({
  providedIn: 'root'
})

export class BuildApiService {
  private apiUrl = 'http://localhost:8080/api/builds';

  constructor(private http: HttpClient){}

  saveBuild(buildData: BuildRequest): Observable<BuildResponse>{
    return this.http.post<BuildResponse>(this.apiUrl, buildData);
  }

  getUserBuilds(): Observable<BuildResponse[]>{
    return this.http.get<BuildResponse[]>(this.apiUrl);
  }
}
