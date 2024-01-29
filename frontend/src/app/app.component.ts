import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterOutlet } from '@angular/router';
import { CardModule } from 'primeng/card';
import { ButtonModule } from 'primeng/button';
import { TableModule } from 'primeng/table';
import { InputMaskModule } from 'primeng/inputmask';
import { FormsModule } from '@angular/forms';
import { ValidationRequest } from './models/validationRequest.model';
import { ValidationService } from './services/validation.service';
import { MessageService } from 'primeng/api';
import { ToastModule } from 'primeng/toast';
import { DialogModule } from 'primeng/dialog';
import { ValidationResponse } from './models/validationResponse.model';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [DialogModule,
    ToastModule,
    CommonModule,
    RouterOutlet,
    CardModule,
    ButtonModule,
    TableModule,
    InputMaskModule,
    FormsModule],
  templateUrl: './app.component.html',
  styleUrl: './app.component.scss'
})
export class AppComponent implements OnInit {
  constructor(
    public validationService: ValidationService,
    private messageService: MessageService) { }
  title = 'frontend';
  horarios: any = [
    {
      numero: 1,
      dia: "Lunes",
      horaInicio: "06:00",
      horaFin: "09:00",
      placaRes: "1 y 2"
    }
  ];
  mostrarMernsaje: boolean = false;
  validationRequest: ValidationRequest = new ValidationRequest();
  validationResponse: ValidationResponse = new ValidationResponse();
  fecha: string = "";
  hora: string = "";


  ngOnInit(): void {

  }

  validarCirculacion() {
    this.unirCampos();
    this.validationService.validarConBackend(this.validationRequest).subscribe(
      (response: any) => {
        console.log("response:");
        console.log(response);
        this.validationResponse.circula = response.circula;
        this.validationResponse.mensaje = response.mensaje;
        this.ocultarMostrarMensaje();

      },
      (error: any) => {
        console.log("error");
        if (error.error && typeof (error.error) === typeof ("")) {
          this.messageService.add({ severity: 'warn', summary: 'Alerta', detail: error.error });
        }
        else {
          this.messageService.add({ severity: 'error', summary: 'Alerta', detail: 'Ha ocurrido un error inesperado' });
        }





      }
    )
  }
  unirCampos() {
    //this.validationRequest.fechaConsultada=this.fecha+ " "+this.hora;
    this.validationRequest.fechaConsultada = `${this.fecha}T${this.hora}:00.000Z`;
    this.validationRequest.fechaConsulta = new Date().toISOString();
  }
  imprimirCampos() {
    console.log(this.validationRequest.placa)
    console.log(this.fecha);
    console.log(this.hora);
    console.log(this.validationRequest.fechaConsulta);
    console.log(this.validationRequest.fechaConsultada);

  }
  limpiarCampos() {
    this.messageService.add({ severity: 'info', summary: 'Información', detail: 'Campos vaciados' });
    this.limpiarCamposSinMensaje();
  }
  limpiarCamposSinMensaje() {
    this.validationRequest.placa = "";
    this.fecha = "";
    this.hora = "";
  }

  ocultarMostrarMensaje() {
    /*  if (this.mostrarMernsaje)
        this.mostrarMernsaje = false;
      else
        this.mostrarMernsaje = true*/

    this.mostrarMernsaje = !this.mostrarMernsaje;
  }

}

