package ej1repetido;

import java.net.Socket;

public class HiloContador extends Thread{
	private Socket socket;
	private ServidorContador server;
	public String comprobadorlinea;
	
	
	public HiloContador(Socket socket, ServidorContador server) {
	this.socket=socket;
	this.server=server;
	
	}


}
