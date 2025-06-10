import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { Router, RouterLink, RouterLinkActive } from '@angular/router';
import { AuthService } from '../../services/auth.service';

@Component({
  selector: 'app-navbar',
  standalone: true, 
  imports: [RouterLink, CommonModule, RouterLinkActive],
  templateUrl: './navbar.component.html',
  styleUrl: './navbar.component.css'
})
export class NavbarComponent {
  constructor(private authService: AuthService, private router: Router){}

  isLoggedIn(): boolean{
    return this.authService.isLoggedIn();
  }

  logout(): void{
    this.authService.logout();
    this.router.navigate(['/']);
    console.log('User logged out');
  }
}
