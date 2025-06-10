import { Component } from '@angular/core';
import { RouterLink, RouterOutlet } from '@angular/router';
import { SomeComponentComponent } from './some-component/some-component/some-component.component';
import { NavbarComponent } from './layout/navbar/navbar.component';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet, RouterLink, NavbarComponent],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'pc-parts-ui';
}
