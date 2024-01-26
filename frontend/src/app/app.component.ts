import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterOutlet } from '@angular/router';
import { CardModule } from 'primeng/card';
import {ButtonModule} from 'primeng/button';
import { TableModule } from 'primeng/table';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [CommonModule, RouterOutlet,CardModule,ButtonModule,TableModule],
  templateUrl: './app.component.html',
  styleUrl: './app.component.scss'
})
export class AppComponent {
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

}
