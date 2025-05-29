import { EventEmitter, Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class ServicioService {

  ws = new WebSocket('ws://localhost:8080');

  recibirMensaje = new EventEmitter<string>();

  constructor() {
    this.ws.onmessage = (event) => {
      this.recibirMensaje.emit(event.data);
    }
  }
}
