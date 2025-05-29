import { Component, OnInit } from '@angular/core';
import { ServicioService } from './services/servicio.service';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './app.component.html',
  styleUrl: './app.component.scss'
})
export class AppComponent implements OnInit {
  title = 'angular-app';
  mensajes: string[] = [];

  constructor(private servicio: ServicioService) {}

  ngOnInit(): void {
    this.servicio.recibirMensaje.subscribe((mensaje) => {
      this.mensajes.push(mensaje);
    });
  }
}
