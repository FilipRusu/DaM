package ejMulticast;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.MulticastSocket;
import java.net.NetworkInterface;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class ClienteTCP_MULTI {
	private String serverip = "localhost";
	private int serverport = 9000;
	private DataOutputStream dos;
	private Socket socket;
	
	private final int puertoMULTI=8080;
	private final String IP_GRUPO="235.10.10.1";
	private final String IP_INTERFAZ_LOCAL ="192.168.56.1";
	private MulticastSocket socketMulti;
	private InetAddress grupoMulti;
	private byte [] buffer = new byte[1024];
	private NetworkInterface interfaz;
	

// PARTE DE TCP CLIENT
	
	public void start() throws UnknownHostException, IOException {
		System.out.println("(CLIENTE TCP) Estableciendo conexion");
		socket = new Socket(serverip, serverport);
		dos = new DataOutputStream(socket.getOutputStream());
		System.out.println("(CLIENTE TCP) Conexion establecida");
	}

	public void stop() throws IOException {
		System.out.println("(CLIENTE TCP) Cerrando conexion");
		socket.close();
		dos.close();
		System.out.println("(CLIENTE TCP) Conexion cerrada");
	}

	public void enviarPeticion(int ip) throws IOException {
		dos.writeInt(ip);
		;
	}

// PARTE DE MULTICAST CLIENT	
	
	public void arrancar() {
		try {
			InetAddress direccionLocal= InetAddress.getByName(IP_INTERFAZ_LOCAL);
			interfaz= NetworkInterface.getByInetAddress(direccionLocal);
			
			socketMulti = new MulticastSocket(puertoMULTI);
			grupoMulti= InetAddress.getByName(IP_GRUPO);
			
			socketMulti.joinGroup(new InetSocketAddress(grupoMulti,puertoMULTI), interfaz);
			
			System.out.println("Cliente MULTI ARRANCADO");
			
			
		} catch (Exception e) {
			System.out.println("Error al arrancar MULTICAST");
		e.printStackTrace();
		}
	}
	
	public void parar() {
		try {
			if (socketMulti != null && !socketMulti.isClosed()) {
				// Dejamos el grupo (con version de interfaz)
				socketMulti.leaveGroup(new InetSocketAddress(grupoMulti, puertoMULTI), interfaz);
				socketMulti.close();
				System.out.println("Cliente UDP salió del grupo multicast y cerró el socket.");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("error al parar el cliente");
		}
	}
	public String recibirMensaje() {
		try {
			boolean activo=true;
			
				DatagramPacket paqueteRecibido = new DatagramPacket(buffer, buffer.length);
				socketMulti.receive(paqueteRecibido);
				String mensaje= new String(paqueteRecibido.getData(), 0, paqueteRecibido.getLength());
				return mensaje;
			
		} catch (Exception e) {
			e.printStackTrace();
		return null;
		}finally {
			parar();
		}
		
		}
	
	public static void main(String[] args) {
		ClienteTCP_MULTI cliente1 = new ClienteTCP_MULTI();
		Scanner src = new Scanner(System.in);
		try {
			cliente1.start();
			cliente1.arrancar();
			System.out.print("Introduzca el id del prducto:");
			int id = src.nextInt();
			cliente1.enviarPeticion(id);
			System.out.print("INFORMACION RECIBIDA-->");
			System.out.println(cliente1.recibirMensaje());
			
		} catch (Exception e) {

		}
	}

}
