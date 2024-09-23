import { Component, OnInit } from '@angular/core';
import { Validacion } from '../../models/validacion';
import { MenuItem } from 'primeng/api';
import { FormsModule } from '@angular/forms';
import { AdministrationService } from '../../services/administration.services';
import { Restriction } from '../../models/restriction.model';
import { Exception } from '../../models/exception.model';
import { DatePipe } from '@angular/common';

@Component({
  selector: 'app-administracion',
  templateUrl: './administracion.component.html',
  styleUrl: './administracion.component.scss'
})
export class AdministracionComponent implements OnInit {
  totalRestrictionException: any[] = [];

  items: MenuItem[] | undefined;
  active: number = 0;
  validacion: Validacion;
  type: "e" | "r" = "r";
  recurrency: "cs" | "uv" = "cs";
  fecha: Date = new Date();
  startTime: Date = new Date();
  endTime: Date = new Date();
  daysArray: any[] = [
    { name: 'Lunes', key: '1' },
    { name: 'Martes', key: '2' },
    { name: 'Miércoles', key: '3' },
    { name: 'Jueves', key: '4' },
    { name: 'Viernes', key: '5' },
    { name: 'Sábado', key: '6' },
    { name: 'Domingo', key: '0' }
  ];
  selectedDays: any[] = [];
  platesArray: any[] = [
    { name: '1', key: '1' },
    { name: '2', key: '2' },
    { name: '3', key: '3' },
    { name: '4', key: '4' },
    { name: '5', key: '5' },
    { name: '6', key: '6' },
    { name: '7', key: '7' },
    { name: '8', key: '8' },
    { name: '9', key: '9' },
    { name: '0', key: '0' }
  ];
  selectedPlates: any[] = [];
  constructor(private administrationService: AdministrationService, private datePipe: DatePipe) {
    this.validacion = new Validacion(new Date, new Date, "")

    this.items = [
      {
        label: 'Tipo'
      },
      {
        label: 'Configuracion'
      },
      {
        label: 'Confirmacion'
      }
    ];
  }
  mostrarMernsaje: boolean = false;
  validationResponse: any;

  hora: string = "";

  listaHitorial: Array<any> = [];

  ngOnInit(): void {
    this.getRestriccionException()
  }

  limpiarCampos() {
      this.fecha=new Date();
      this.selectedDays=[];
      this.selectedPlates=[];
      this.active=0;
      this.type="r";
      this.recurrency="cs";
  }
  limpiarCamposSinMensaje() {

  }
  ocultarMostrarMensaje() {

  }

  guardarRestriccionExcepcion() {
    if (this.type == "r") {
      this.guardarRestriccion();
    } else {
      this.guardarExcepcion();
    }

  }
  guardarRestriccion() {
    const auxDate=(this.recurrency=="uv")? this.fecha:null;
    const auxSelectedDays=(this.recurrency=="cs")? this.selectedDays.join(","):null;
    const restriction: Restriction = new Restriction(0, "", this.extractTimeFromDate(this.startTime), this.extractTimeFromDate(this.endTime), auxDate, auxSelectedDays, this.selectedPlates.join(","));
    this.administrationService.addRestriction(restriction).subscribe((response) => {
      console.log("Restriccion guardada " + response)
      this.getRestriccionException();
      this.limpiarCampos()
    }, (error) => {
      console.log("Error: " + error)
    })
  }

  extractTimeFromDate(date: Date): number {
    const hour: number = date.getHours();
    const minutes: number = date.getMinutes();

    return hour + (minutes / 60);
  }

  guardarExcepcion() {
    const auxDate=(this.recurrency=="uv")? this.fecha:null;
    const auxSelectedDays=(this.recurrency=="cs")? this.selectedDays.join(","):null;
    const excepction: Exception = new Exception(0, "", this.extractTimeFromDate(this.startTime), this.extractTimeFromDate(this.endTime), auxDate, auxSelectedDays, this.selectedPlates.join(","));
    this.administrationService.addException(excepction).subscribe((response) => {
      console.log("Excepction guardada " + response)
      this.getRestriccionException()
      this.limpiarCampos()
    }, (error) => {
      console.log("Error: " + error)
    })
  }

  getRestriccionException() {
    this.totalRestrictionException = [];
    this.administrationService.getRestrictions().subscribe((response) => {
      console.log("obtuvo restricciones " + response)
      const restricciones: any = response || [];
      restricciones.forEach((rest: any) => {
        const item = {
          fechaDia: (rest.applicationDate) ? this.formateDate(rest.applicationDate) : this.formateDays(rest.applicationDays),
          horaInicio: this.numberToTime(rest.startTime),
          horaFin: this.numberToTime(rest.endTime),
          digitoPlacas: rest.lastDigitPlates,
          tipo: "r"
        }
        this.totalRestrictionException.push(item);
      });


      this.administrationService.getExceptions().subscribe((response) => {
        console.log("obtuvo escepciones " + response)
        const excepciones: any = response || [];
        excepciones.forEach((rest: any) => {
          const item = {
            fechaDia: (rest.applicationDate) ? this.formateDate(rest.applicationDate) : this.formateDays(rest.applicationDays),
            horaInicio: this.numberToTime(rest.startTime),
            horaFin: this.numberToTime(rest.endTime),
            digitoPlacas: rest.lastDigitPlates,
            tipo: "e"
          }
          this.totalRestrictionException.push(item);
        });


      }, (error) => {
        console.log("Error: " + error)
      })

    }, (error) => {
      console.log("Error: " + error)
    })

  }
  formateDate(date: Date): string {
    return this.datePipe.transform(date, "yyyy-MM-dd") || "-";
  }

  formateDays(days: string): string {
    const daysArray = days.split(",");
    const answ: any[] = [];
    daysArray.forEach((day) => {
      answ.push(this.daysArray.filter((d) => d.key == day)[0].name)
    })
    return answ.join(",");
  }

  numberToTime(number: number): string {
    const auxDate: Date = new Date();
    auxDate.setHours(Math.floor(number))
    auxDate.setMinutes((number - Math.floor(number)) * 60)

    return this.datePipe.transform(auxDate, "hh:mm") || "-";

  }

  validateForm(): boolean {
    if (this.active == 0) {
      return true;
    } else {
      let isValid = true;
      if (this.selectedPlates.length == 0) {
        isValid = false;
      }
      if (this.recurrency == "cs" && this.selectedDays.length == 0) {
        isValid = false;
      }
      return isValid;
    }
  }

}
