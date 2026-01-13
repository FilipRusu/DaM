package ejUdp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.Socket;
import java.net.SocketException;

public class ServerUDP {
	private DatagramSocket socket;
	private static String aux = "";
	DatagramPacket entrada;

	public void crearsocket() throws SocketException {
		System.out.println("(Server) creando socket..");
		socket = new DatagramSocket(49171);
	}

	public void recibirmensaje() throws IOException {
		System.out.println("(Server) recibiendo datagrama");
		byte[] bufferLectura = new byte[128];
		entrada = new DatagramPacket(bufferLectura, bufferLectura.length);
		socket.receive(entrada);
		aux = new String(bufferLectura);
		System.out.println("(Server) mensaje recibido:" + aux);
	}

	public void enviarMensaje() throws IOException {
		byte[] mensajeEnviado = aux.toUpperCase().getBytes();
		DatagramPacket salida = new DatagramPacket(mensajeEnviado, mensajeEnviado.length, entrada.getAddress(),
				entrada.getPort());
		socket.send(salida);
		System.out.println("(Server) Mensaje enviado:" + aux.toUpperCase());
	}

	public void stop() {
		socket.close();
	}

	public static void main(String[] args) {
		ServerUDP server = new ServerUDP();
		try {
			
			server.crearsocket();
			while (!ServerUDP.aux.equalsIgnoreCase("*")) {
				server.recibirmensaje();
				server.enviarMensaje();
			}
			server.stop();
		} catch (Exception e) {
			server.stop();
			e.printStackTrace();
		}

	}
}
