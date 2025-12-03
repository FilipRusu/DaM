package ej3;


import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {	
	private ServerSocket serversocket;
	private Socket socket;
	private DataInputStream dis;
	private int puertoMulti;
	private InetAddress grupo;
	
	public Servidor(int PuertoTcp,int PuertoMulti ) throws IOException {
		serversocket= new ServerSocket(PuertoTcp);
		puertoMulti=PuertoMulti;
	}
	
	public void startTCP() throws IOException {
		System.out.println("(Servidor TCP) Esperando peticiones");
		socket=serversocket.accept();
		dis=new DataInputStream(socket.getInputStream());
		System.out.println("(Servidor TCP) Conexion establecida");
	}

	public void stopTCP() throws IOException {
		System.out.println("(Servidor TCP) Cerrando conexion");
		socket.close();
		dis.close();
	}
	
	public void Gestionarpeticion() throws IOException {
		int id=dis.readInt();
	String msj=BASEDEDATOS.consultarInventario(id);
		enviarMensaje(msj);
	}
	
	public void enviarMensaje(String msj) throws IOException {
		MulticastSocket ms= new MulticastSocket();
		grupo=InetAddress.getByName("225.0.0.1");
		DatagramPacket paquete=new DatagramPacket(msj., puertoMulti)
	}
	
	
}
