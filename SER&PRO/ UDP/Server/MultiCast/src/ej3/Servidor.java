package ej3;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.net.NetworkInterface;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {
	private ServerSocket serversocket;
	private Socket socket;
	private DataInputStream dis;

	private String IPgrupo = "235.10.10.1";
	private String iplocal = "192.168.56.1";
	private int puertoMULTI = 8080;

	private InetAddress grupo;
	private MulticastSocket multicastSocket;
	private NetworkInterface interfaz;

	public Servidor(int PuertoTcp) throws IOException {
		serversocket = new ServerSocket(PuertoTcp);
	}

	public void startTCP() throws IOException {
		System.out.println("(Servidor TCP) Esperando peticiones");
		socket = serversocket.accept();
		dis = new DataInputStream(socket.getInputStream());
		System.out.println("(Servidor TCP) Conexion establecida");
	}

	public void stopTCP() throws IOException {
		System.out.println("(Servidor TCP) Cerrando conexion");
		socket.close();
		dis.close();
	}

	public String gestionarpeticion() throws IOException {
		int id = dis.readInt();
		String msj = BASEDEDATOS.consultarInventario(id);
		return msj;
	}

	public void arrancar() {
		try {
			InetAddress direccionlocal = InetAddress.getByName(iplocal);
			interfaz = NetworkInterface.getByInetAddress(direccionlocal);

			multicastSocket = new MulticastSocket(puertoMULTI);
			grupo = InetAddress.getByName(IPgrupo);

			multicastSocket.setNetworkInterface(interfaz);

			System.out.println("SERVER UDP ARRANCADO ID:" + grupo.getHostAddress() + ", Puerto:" + puertoMULTI);
			System.out.println(
					"Usando interfaz de ENVÍO: " + interfaz.getDisplayName() + direccionlocal.getHostAddress());
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("ERROR AL ARRANCAR MULTICAST");
		}

	}
	
	public void enviarMensaje(){
	try {
		String mensaje=gestionarpeticion();
		byte[] datos=mensaje.getBytes();
		DatagramPacket paquete= new DatagramPacket(datos, datos.length,grupo,puertoMULTI);
		multicastSocket.send(paquete);
		System.out.println("SERVER UDP HA ENVIADO EL MENSAJE");
	} catch (Exception e) {
		e.printStackTrace();
		
	}finally {
		parar();
	}

	
	}
	
	public void parar() {
		try {
			if(multicastSocket != null && !multicastSocket.isClosed()) {
				multicastSocket.close();
				System.out.println("SERVIDOR UDP DETENIDO");
			}
			
		} catch (Exception e) {
			System.out.println("Error al detener Servidor MultiCast");
			e.printStackTrace();
		}
	}
 
	public static void main(String[] args) {
		try {
			Servidor server= new Servidor(9000);
		while (true) {
			server.startTCP();
			server.arrancar();
			server.enviarMensaje();
			server.stopTCP();
		}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
