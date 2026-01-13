package ej1;

import java.io.BufferedReader;
import java.io.IOError;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;

public class ClienteContador extends Thread {
	private String serverip;
	private int serverport;
	private Socket socket;
	private BufferedReader bfr;
	private InputStreamReader isr;

	public ClienteContador(String serverip, int serverport) {
		super();
		this.serverip = serverip;
		this.serverport = serverport;
	}
	
	@Override
	public void run() {
			if(iniciar()) {
				leerMensaje();
			}
			cerrarconexion();
	}

	
	public boolean iniciar(){
		System.out.println("(Cliente) Estableciendo conexion");
		try {
			socket = new Socket(serverip, serverport);
			isr = new InputStreamReader(socket.getInputStream(), "UTF-8");
			bfr = new BufferedReader(isr);
			System.out.println("(Cliente) Conexion establecida");
			return true;
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	
	}

	public void leerMensaje() {
		try {
			String mensajeServidor = bfr.readLine();
			if (mensajeServidor != null) {
				System.out.println("Hilo:" + mensajeServidor);
			}
		} catch (IOException e) {
			System.out.println("Error al leer el mensaje del hilo");
		}

	}

	public void cerrarconexion() {
		try {
			socket.close();
		} catch (Exception e) {

		}
	}
}
