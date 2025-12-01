package ej3;

import java.io.DataInputStream;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ClientHandler implements Runnable {
	private Socket socket;
	private DataInputStream dis;
	private DataOutputStream dos;

	public ClientHandler(Socket socket) {

		this.socket = socket;
	}

	@Override
	public void run() {
		try {
			dis = new DataInputStream(socket.getInputStream());
			dos = new DataOutputStream(socket.getOutputStream());

			System.out.println("(Servidor) Cliente conectado:" + socket.getInetAddress());

		String palabra=dis.readUTF();
		String aux=palabra.toLowerCase();
		dos.writeUTF(aux);
		
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("(Servidor) Error cliente");

		}finally {
            try {
                if (dis != null) dis.close();
                if (dos != null) dos.close();
                if (socket != null) socket.close();
                System.out.println("(Servidor) Cliente desconectado");
            } catch (IOException ignored) { 
            	ignored.printStackTrace();
            }
            
		}
		
	}

}
