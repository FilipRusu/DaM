package ejtcp;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerTCP {
	private ServerSocket serversocket;
	private Socket socket;
	private DataInputStream dis;
	private DataOutputStream dos;
	private static String mensaje="";
	public ServerTCP(int puerto) throws IOException {
		this.serversocket = new ServerSocket(puerto);
	}

	public void start() throws IOException {
		System.out.println("(Servidor) Esperando conexiones");
		socket = serversocket.accept();
		
		dis = new DataInputStream(socket.getInputStream());
		dos = new DataOutputStream(socket.getOutputStream());
		
		System.out.println("(Servidor) Conexion establecida");
		gestionPeticion();
	}

	public void stop() throws IOException {
		System.out.println("(Servidor) Cerrando conexiones..");
	dis.close();
	dos.close();
	socket.close();
	serversocket.close();
		System.out.println("(Servidor) Conexion cerrada");
	}

	public void gestionPeticion() throws IOException {
	mensaje=dis.readUTF();
	dos.writeUTF(mensaje.toLowerCase());
	}
	
	public static void main(String[] args) {
		try {
			ServerTCP servidor= new ServerTCP(49171);
		while(!ServerTCP.mensaje.equalsIgnoreCase("bye")) {
		servidor.start();
		}
		servidor.stop();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}


