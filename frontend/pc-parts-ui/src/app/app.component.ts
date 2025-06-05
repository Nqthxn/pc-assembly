import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { SomeComponentComponent } from './some-component/some-component/some-component.component';

@Component({
  selector: 'app-root',
  imports: [RouterOutlet, SomeComponentComponent],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'pc-parts-ui';
}
