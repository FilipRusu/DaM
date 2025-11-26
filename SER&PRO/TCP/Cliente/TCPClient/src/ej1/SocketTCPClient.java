package ej1;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
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
		SocketTCPClient cliente=new SocketTCPClient("192.168.1.72", 49171);
		try {
		cliente.start();
		cliente.dos.writeUTF("FiLIp");
		System.out.println("Palabra en minuscula: "+cliente.dis.readUTF());
		cliente.stop();
			
		} catch (Exception e) {
		e.printStackTrace();
		}
	}
}
