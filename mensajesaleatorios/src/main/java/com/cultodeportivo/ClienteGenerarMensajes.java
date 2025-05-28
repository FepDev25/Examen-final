package com.cultodeportivo;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

public class ClienteGenerarMensajes {
    
    @SuppressWarnings("resource")
    public void iniciarChat() {
        try {
            String serverHost = System.getenv().getOrDefault("SERVER_HOST", "servidor");
            int serverPort = Integer.parseInt(System.getenv().getOrDefault("SERVER_PORT", "12345"));
            
            System.out.println("Intentando conectar a " + serverHost + ":" + serverPort);
            Socket socket = new Socket(serverHost, serverPort);
            PrintWriter salida = new PrintWriter(socket.getOutputStream(), true);
            new Thread(new GenerarMensajesAleatorios(salida)).start();

        } catch (IOException e) {
            System.out.println("No se pudo conectar al servidor: " + e.getMessage());
        } 
    }

}
