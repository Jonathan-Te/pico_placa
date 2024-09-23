import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginSignupComponent } from './pages/login-signup/login-signup.component';
import { ConsultaComponent } from './pages/consulta/consulta.component';
import { AdministracionComponent } from './pages/administracion/administracion.component';

import { CardModule } from 'primeng/card';

import { ButtonModule } from 'primeng/button';
import { InputTextModule } from 'primeng/inputtext';
import { CampoComponent } from './components/campo/campo.component';
import { FormsModule } from '@angular/forms';
import { CheckboxModule } from 'primeng/checkbox';
import { AuthenticationService } from './services/auth.services';
import { HttpClient, HttpClientModule } from '@angular/common/http';
import { PrincipalComponent } from './pages/principal/principal.component';
import { TabViewModule } from 'primeng/tabview';
import { ToastModule } from 'primeng/toast';
import { CommonModule } from '@angular/common';
import { DialogModule } from 'primeng/dialog';
import { RouterOutlet } from '@angular/router';
import { TableModule } from 'primeng/table';
import { InputMaskModule } from 'primeng/inputmask';
import { CalendarModule } from 'primeng/calendar';
import { MessageService } from 'primeng/api';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { StepsModule } from 'primeng/steps';
import { RadioButtonModule } from 'primeng/radiobutton';
import { FieldsetModule } from 'primeng/fieldset';
import { DatePipe } from '@angular/common';
import { ChipModule } from 'primeng/chip';

@NgModule({
  declarations: [
    AppComponent,
    LoginSignupComponent,
    ConsultaComponent,
    AdministracionComponent,
    CampoComponent,
    PrincipalComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    ButtonModule,
    CardModule,
    InputTextModule,
    FormsModule,
    CheckboxModule,
    HttpClientModule,
    TabViewModule,
    DialogModule,
    ToastModule,
    CommonModule,
    RouterOutlet,
    CardModule,
    ButtonModule,
    TableModule,
    InputMaskModule,
    FormsModule,
    CalendarModule,
    BrowserAnimationsModule,
    StepsModule,
    RadioButtonModule,
    FieldsetModule,
    ChipModule
  ],
  providers: [AuthenticationService,HttpClient,MessageService,DatePipe],
  bootstrap: [AppComponent]
})
export class AppModule { }
