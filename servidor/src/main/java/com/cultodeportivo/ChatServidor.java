package com.cultodeportivo;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ChatServidor {
    private static final int PUERTO = 12345;

    public void iniciarServidor(){
        System.out.println("Servidor de chat iniciado...");

        try (ServerSocket serverSocket = new ServerSocket(PUERTO)) {
            while (true) {
                Socket cliente = serverSocket.accept();
                System.out.println("Nuevo cliente conectado: " + cliente.getInetAddress());
                
                new Thread(new ManejadorCliente(cliente)).start();
            }
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    public void iniciarServidorWebSocket(){

    }

}


