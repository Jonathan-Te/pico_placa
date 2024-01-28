import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterOutlet } from '@angular/router';
import { CardModule } from 'primeng/card';
import {ButtonModule} from 'primeng/button';
import { TableModule } from 'primeng/table';
import { InputMaskModule } from 'primeng/inputmask';
import { FormsModule } from '@angular/forms';
import { ValidationRequest } from './models/validationRequest.model';
import { ValidationService } from './services/validation.service';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [CommonModule, RouterOutlet,CardModule,ButtonModule,TableModule,InputMaskModule,FormsModule],
  templateUrl: './app.component.html',
  styleUrl: './app.component.scss'
})
export class AppComponent implements OnInit {
  constructor(public validationService: ValidationService) { }
  title = 'frontend';
  horarios: any=[
    {
      numero: 1,
      dia: "Lunes",
      horaInicio: "06:00",
      horaFin: "09:00",
      placaRes: "1 y 2"
    }
  ];
    
  validationRequest: ValidationRequest =new ValidationRequest();
  fecha: string="";
  hora: string="";

  
  ngOnInit(): void {
      
  }

  validarCirculacion(){
    this.imprimirCampos();
    this.unirCampos();
    this.imprimirCampos();
    this.validationService.validarConBackend(this.validationRequest).subscribe(
      (response: any) => {
          console.log("response:");
          console.log(response);
          this.limpiarCampos();

      },
      (error: any)=>{
          console.log("error");
          console.log(error.error);
      }
  )
  }
  unirCampos(){
    //this.validationRequest.fechaConsultada=this.fecha+ " "+this.hora;
    this.validationRequest.fechaConsultada=`${this.fecha}T${this.hora}:00.000Z`;
    this.validationRequest.fechaConsulta=new Date().toISOString();
  }
  imprimirCampos(){
    console.log(this.validationRequest.placa)
    console.log(this.fecha);
    console.log(this.hora);
    console.log(this.validationRequest.fechaConsulta);
    console.log(this.validationRequest.fechaConsultada);
  }
  limpiarCampos(){
    this.validationRequest.placa="";
    this.fecha="";
    this.hora="";
  }


}

