package ejUdp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Scanner;

public class ClienteUDP {
	private static int puertoServer = 49171;
	private DatagramSocket socketUDP;
	private InetAddress hostServidor;
	public void conexion() throws UnknownHostException, SocketException {
		hostServidor= InetAddress.getByName("localhost");
		System.out.println("(Cliente) Creando socket");

		socketUDP = new DatagramSocket();
	}

	public void enviarMsj(String mensaje) throws IOException {
		System.out.println("(Cliente) Enviando datagrama");
		byte[] salida = mensaje.getBytes();
		DatagramPacket peticion = new DatagramPacket(salida, salida.length,hostServidor,puertoServer);
		socketUDP.send(peticion);
	}
	
	public void recibirMSJ() throws IOException {
		System.out.println("(Cliente) Recibiendo Mensaje");
		byte[] entrada= new byte[128];
		DatagramPacket respuesta=new DatagramPacket(entrada, entrada.length,hostServidor,puertoServer);
		socketUDP.receive(respuesta);
		System.out.println("(Cliente) Mensaje recibido: "+new String(entrada));
	}
	
	public void stop() {
		socketUDP.close();
	}
	
	
	
	public static void main(String[] args) {
		ClienteUDP cliente= new ClienteUDP();
		Scanner src=new Scanner(System.in);
		String mensaje="";
		try {
			
		cliente.conexion();
		
		while(!mensaje.equalsIgnoreCase("bye")) {	
		System.out.print("Mensaje:");
			mensaje=src.nextLine();
		
			cliente.enviarMsj(mensaje);
		
				cliente.recibirMSJ();
		}
		cliente.stop();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
