import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AdministracionComponent } from './pages/administracion/administracion.component';
import { LoginSignupComponent } from './pages/login-signup/login-signup.component';
import { ConsultaComponent } from './pages/consulta/consulta.component';
import { PrincipalComponent } from './pages/principal/principal.component';

const routes: Routes = [
  
   {
    path: 'login_signup',
    component: LoginSignupComponent,

   },
   {
    path: 'principal',
    component: PrincipalComponent,

   },
   {
    path: '**',
    redirectTo: 'login_signup',
    pathMatch: 'full'
   }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
