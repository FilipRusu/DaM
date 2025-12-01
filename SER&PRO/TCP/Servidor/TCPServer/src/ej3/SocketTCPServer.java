package ej3;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketTCPServer {
	private ServerSocket serversocket;

	public SocketTCPServer(int puerto) throws IOException {
		serversocket = new ServerSocket(puerto);
		System.out.println("(Servidor) inciado en el puerto 49171");
	}
	
	public void start() {
	System.out.println("(Servidor) Esperando conexiones");
		while(true) {
			try {
				Socket socket= serversocket.accept();
				
				new Thread(new ClientHandler(socket)).start();
			} catch (IOException e) {
				e.printStackTrace();
				System.out.println("(Servidor) Error inciando servidor");
			}
		}
	
	
	}
	
	public static void main(String[] args) {
		try {
			SocketTCPServer servidor = new SocketTCPServer(49171);
			servidor.start();
		} catch (Exception e) {
		System.out.println("(Servidor) Error inciando el servidor");
		e.printStackTrace();
		}
	}
	
}
