package ejtcp;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class ClienteTCP {
	private String serverIP;
	private int serverport;
	private Socket socket;
	private DataInputStream dis;
	private DataOutputStream dos;
	
	
	public ClienteTCP(String serverIP, int serverport) {
		this.serverIP = serverIP;
		this.serverport = serverport;
	}
	
	public void start() throws UnknownHostException, IOException {
		System.out.println("(Cliente) Estableciendo conexion");	
		socket=new Socket(serverIP,serverport);
		dos= new DataOutputStream(socket.getOutputStream());
		dis= new DataInputStream(socket.getInputStream());
		System.out.println("(Cliente) Conexion establecida");
	}
	
	public void stop() throws IOException {
		System.out.println("Cerrando conexion....");
	dos.close();
	dis.close();
	socket.close();
		System.out.println("Conexion cerrada");
	}
	
	public static void main(String[] args) {
		ClienteTCP cliente= new ClienteTCP("localhost", 49171);
	try {
		cliente.start();
		cliente.dos.writeUTF("BYE                                                                                                                     ");
		System.out.println("Mensaje en minusculas:"+cliente.dis.readUTF());
		cliente.stop();
	} catch (Exception e) {
		e.printStackTrace();
	}
	
	}
	
}
