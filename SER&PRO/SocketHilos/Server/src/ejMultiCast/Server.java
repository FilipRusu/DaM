package ejMultiCast;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import ej1.ServidorContador;

public class Server {
	private ServerSocket serverSocket;
	private HiloTCP tcp;
	public Server(int puerto) throws IOException {
		serverSocket = new ServerSocket(puerto);

	}

	public void start() {
		System.out.println("(Server) Esperando peticion");

		try {
			Socket socket = serverSocket.accept();
			tcp =new HiloTCP(socket);
			tcp.start();
			;
		} catch (Exception e) {
			e.printStackTrace();

		}
	}
	public void stop() throws IOException {
		serverSocket.close();
	}
	
	
	public static void main(String[] args) {
		try {
			Server server=new Server(9000);
			server.start();
			server.tcp.join();
		} catch (Exception e) {
			e.printStackTrace();
		}
	
		
	}
}
