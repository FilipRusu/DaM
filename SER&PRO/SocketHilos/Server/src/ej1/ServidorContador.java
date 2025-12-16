package ej1;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;


public class ServidorContador {
	private ServerSocket serversocket;
	private static int nr=0;
	
	public ServidorContador(int puerto) throws IOException {
		serversocket=new ServerSocket(puerto);
		System.out.println("(Servidor) iniciado en el puerto 49171");
	}
	

	
	public void start(ServidorContador server) {
		System.out.println("(Server) Esperando conexiones");
		while(true) {
			try {
			Socket socket=serversocket.accept();
			new HiloContador(socket, server).start();
			} catch (IOException e) {
			e.printStackTrace();
			System.out.println("(Server) Error iniciando el servidor");
			}
		}

		
	}
	
	public synchronized int sumar() {
		nr++;
		return nr;
	}
	public static void main(String[] args) {
		try {
			
		} catch (Exception e) {
			
		}
	}
	
}
