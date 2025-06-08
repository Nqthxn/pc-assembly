import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, tap } from 'rxjs';



export interface RegisterReuqest{
  username: string;
  email: string;
  password?: string;
}

export interface LoginRequest{
  username: string;
  password?: string; 
}

export interface JwtResponse{
  token: string;
  type: string;
  id: number;
  username: string;
  password: string;
}

@Injectable({
  providedIn: 'root'
})

export class AuthService {
  private apiUrl = 'http://localhost:8080/api/auth';
  private tokenKey = 'auth-token';

  constructor(private http: HttpClient) { }

  register(registerData: RegisterReuqest): Observable<any>{
    return this.http.post(`${this.apiUrl}/register`, registerData, { responseType: 'text' });
  }

  login(loginData: LoginRequest): Observable<JwtResponse>{
    return this.http.post<JwtResponse>(`${this.apiUrl}/login`, loginData).pipe(
      tap(response => {
        if(response && response.token){
          this.saveToken(response.token);
        }
      })
    )
  }

  saveToken(token: string): void{
    localStorage.setItem(this.tokenKey, token);
  }

  getToken(): string | null {
    return localStorage.getItem(this.tokenKey);
  }

  logout(): void{
    localStorage.removeItem(this.tokenKey);
  }

  isLoggedIn(): boolean{
    const token = this.getToken();
    return !!token;
  }
}
