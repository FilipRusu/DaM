package ej1repetido;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServidorContador {
	private ServerSocket serversocket;
	public static int contadorvisitas = 0;

	public ServidorContador(int puerto) throws IOException {
		serversocket = new ServerSocket(puerto);
		System.out.println("(Servidor) inicando... en el puerto 49171.");
	}

	public void start(ServidorContador server) {
		System.out.println("(Servividor) Esperando conexiones");
		String linea = null;
		while (!linea.equalsIgnoreCase("bye")) {
			try {
				Socket socket=serversocket.accept();
			HiloContador a	=new HiloContador(socket,server);
			linea=a.comprobadorlinea;
			} catch (Exception e) {
				System.out.println("(Servidor) Error iniciando el servidor");
				e.printStackTrace();
			}
			finally {
				try {
					serversocket.close();
				} catch (Exception e2) {
				e2.printStackTrace();
				}
			}
		}
	}
}
