package com.cultodeportivo;

import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;

public class GenerarMensajesAleatorios extends Thread {
    
    private final List<String> mensajes = Arrays.asList(
        "Mensaje aleatorio 1",
        "Mensaje aleatorio 2",
        "Mensaje aleatorio 3",
        "Mensaje aleatorio 4",
        "Mensaje aleatorio 5"
    );
    private final PrintWriter salida;

    public GenerarMensajesAleatorios(PrintWriter salida) {
        this.salida = salida;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println(e);
            }
            String mensaje = mensajes.get((int) (Math.random() * mensajes.size()));
            salida.println(mensaje);
        }
    }

}
