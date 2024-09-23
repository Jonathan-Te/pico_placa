import { Component, OnInit } from '@angular/core';
import { Validacion } from '../../models/validacion';
import { ValidationService } from '../../services/validacion.services';
import { DatePipe } from '@angular/common';
import { AuthenticationService } from '../../services/auth.services';

@Component({
  selector: 'app-consulta',
  templateUrl: './consulta.component.html',
  styleUrl: './consulta.component.scss'
})
export class ConsultaComponent implements OnInit {
  mostrarMernsaje: boolean = false;
  validationResponse: any;
  fecha: string = "";
  hora: string = "";

  listaHistorial: Array<any> = [];

  validacion: Validacion


  constructor(private validacionService: ValidationService, private datePipe: DatePipe,private authenticationService:AuthenticationService) {
    this.validacion = new Validacion(new Date, new Date, "")

  }
  ngOnInit(): void {
    this.getHistory();
  }


  validarCirculacion() {
    this.validacionService.validation(this.validacion).subscribe((response: any) => {
      console.log("Validado con exito " + response)
      this.validationResponse = {
        circula: response.id == 11,
        mensaje: response.message
      }
      this.ocultarMostrarMensaje();
      this.getHistory();
    }, (error) => {
      console.log("Error: " + error)
    })
  }

  limpiarCampos() {
    this.validacion = new Validacion(new Date, new Date, "")
  }



  ocultarMostrarMensaje() {

    this.mostrarMernsaje = !this.mostrarMernsaje;
  }

  validateForm(): boolean {

    return this.validacion.plate?.length >= 7;
  }

  getHistory() {
    this.listaHistorial=[];
    this.validacionService.getHistory().subscribe((response: any) => {
      console.log("Consultado" + response)
      const consultas: any = response || [];
      consultas.forEach((consulta: any) => {
        const item = {
          placa:consulta.plate,
          fechaConsultada:this.formateDate(consulta.queriedDate),
          circula:consulta.allowed,
          fechaConsulta:this.formateDate(consulta.queryDate)
        }
        this.listaHistorial.push(item);
      });
    }, (error) => {
      console.log("Error: " + error)
    })
  }
  formateDate(date: Date): string {
    return this.datePipe.transform(date, "yyyy-MM-dd hh:mm") || "-";
  }

  public get authenticationServiceValue() : AuthenticationService {
    return this.authenticationService
  }
  
}
