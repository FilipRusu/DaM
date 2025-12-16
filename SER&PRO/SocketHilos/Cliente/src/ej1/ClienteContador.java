package ej1;

import java.io.BufferedReader;
import java.io.IOError;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;


public class ClienteContador extends Thread{
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
	
	public void iniciar() throws UnknownHostException,IOException{
		System.out.println("(Cliente) Estableciendo conexion");
		socket= new Socket(serverip,serverport);
		isr= new InputStreamReader(socket.getInputStream(),"UTF-8");
		bfr= new BufferedReader(isr);
		System.out.println("(Cliente) Conexion establecida");
	}
	
	
}
