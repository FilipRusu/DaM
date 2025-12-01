package test;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class SocketTCPClient {
	private String serverip;
	private int serverport;
	private DataOutputStream dos;
	private DataInputStream dis;
	private Socket socket;

	public SocketTCPClient(String serverip, int serverport) {
		this.serverip = serverip;
		this.serverport = serverport;
	}

	public void start() throws UnknownHostException, IOException {
		System.out.println("(Cliente) Estableciendo conexion...");
		socket = new Socket(serverip, serverport);
		dis=new DataInputStream(socket.getInputStream());
		dos=new DataOutputStream(socket.getOutputStream());	
		System.out.println("(Cliente) Conexion etablecida");
	}
	public void stop() throws IOException{
		System.out.println("(Cliente) Cerrando conexion");
		dis.close();
		dos.close();
		socket.close();
		System.out.println("(Cliente) Conexion cerrada");
	}
	
	public static void main(String[] args) {
		SocketTCPClient cliente=new SocketTCPClient("localhost", 49171);
		try {
		cliente.start();
		cliente.dos.writeUTF("SAMI");
		Thread.sleep(4000);
		System.out.println("Palabra en minuscula: "+cliente.dis.readUTF());
		cliente.stop();
			
		} catch (Exception e) {
		e.printStackTrace();
		}
	}
}
