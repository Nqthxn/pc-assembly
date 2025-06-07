import { Routes } from '@angular/router';
import { HomeComponent } from './pages/home/home.component';
import { ProductsComponent } from './pages/products/products.component';
import { BuildsComponent } from './pages/builds/builds.component';
import { AuthenticationComponent } from './pages/authentication/authentication.component';

export const routes: Routes = [
  { path: '', component: HomeComponent },
  { path: 'products', component: ProductsComponent},
  { path: 'builds', component: BuildsComponent},
  { path: 'auth', component: AuthenticationComponent}
];