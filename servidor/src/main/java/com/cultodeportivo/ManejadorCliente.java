package com.cultodeportivo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class ManejadorCliente extends Thread  {

    private final Socket socket;
    private PrintWriter salida;
     private static final Set<PrintWriter> clientes = Collections.synchronizedSet(new HashSet<>());

    public ManejadorCliente(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try (
            BufferedReader entrada = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        ) {
            salida = new PrintWriter(socket.getOutputStream(), true);
            clientes.add(salida);

            String mensaje;
            while ((mensaje = entrada.readLine()) != null) {
                System.out.println("Mensaje recibido: " + mensaje);
                String hora = java.time.LocalTime.now().withNano(0).toString();
                String mensajeFormateado = "[" + hora + "] " + mensaje;
                for (PrintWriter escritor : clientes) {
                    escritor.println(mensajeFormateado);
                }
                

            }
        } catch (IOException e) {
            System.out.println("Error con cliente: " + socket.getInetAddress());
        } finally {
            if (salida != null) {
                clientes.remove(salida);
            }
            try {
                socket.close();
            } catch (IOException e) {}
        }
    }
    
}
