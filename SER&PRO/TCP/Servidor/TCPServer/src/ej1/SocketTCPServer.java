package ej1;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketTCPServer {
	private ServerSocket serversocket;
	private Socket socket;
	private DataOutputStream dos;
	private DataInputStream dis;
	
	public SocketTCPServer(int puerto) throws IOException {
		serversocket =new ServerSocket(puerto);
	}
	
	
	public void start() throws IOException {
		System.out.println("(Servidor) Esperando conexiones");
		socket=serversocket.accept();
		dis=new DataInputStream(socket.getInputStream());
		dos=new DataOutputStream(socket.getOutputStream());
		System.out.println("(Servidor) Conexion establecida");
	}
	public void stop() throws IOException {
		System.out.println("(Servidor) Cerrando conexion");
		socket.close();
		dis.close();
		dos.close();
	}
	
	public static void main(String[] args) {
		try {
		SocketTCPServer servidor=new SocketTCPServer(49171);
	while(true) {
		servidor.start();
		String palabra=servidor.dis.readUTF();
		String aux=palabra.toLowerCase();
		servidor.dos.writeUTF(aux);
		servidor.stop();
	}
	} catch (Exception e) {
		
		}
	}
	
}
