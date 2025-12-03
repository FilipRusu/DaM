package ej4;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class SocketUDPServer {
	private DatagramSocket socket;

	public void start(int puerto) throws SocketException {
		System.out.println("(Servidor) Creando socket");
		socket = new DatagramSocket(puerto);

		System.out.println("(Servidor) Recibiendo ");
	}

	public void gestionandoINFO() throws IOException {
		String cadena = null;
		do {
			byte[] bufferLectura = new byte[64];
			DatagramPacket datagramaEntrada = new DatagramPacket(bufferLectura, bufferLectura.length);

			socket.receive(datagramaEntrada);
			System.out.println("(Servidor) Mensaje recibido");
			cadena = new String(bufferLectura).toUpperCase().trim();

			byte[] buffersalida = cadena.getBytes();
			DatagramPacket datagramaSalida = new DatagramPacket(buffersalida, buffersalida.length,
					datagramaEntrada.getAddress(), datagramaEntrada.getPort());

			socket.send(datagramaSalida);
			System.out.println("(Servidro) Mensaje Enviado");
		} while (!cadena.equals("*"));
		System.out.println("(Servidor) Cerrado");
		socket.close();

	}

	public static void main(String[] args) {
		SocketUDPServer servidor = new SocketUDPServer();
		try {
			servidor.start(49171);
			servidor.gestionandoINFO();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
