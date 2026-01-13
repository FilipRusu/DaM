package ejMultiCast;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.net.NetworkInterface;

public class HiloUDP extends Thread{
	private static final String IP_Multicast="235.10.10.1";
	private static final int puerto_Multicast=8080;
	private static final String iplocal="localhost";
	private static String mensaje="";
	
	public HiloUDP(String mensaje) {
	this.mensaje=mensaje;
	}
	
	@Override
	public void run() {
		try {
			
			enviarMensaje();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	
	public void enviarMensaje() throws IOException {
		try(MulticastSocket ms = new MulticastSocket()){
			InetAddress grupo= InetAddress.getByName(IP_Multicast);
			InetAddress ipLocal= InetAddress.getByName(iplocal);
		NetworkInterface netif= NetworkInterface.getByInetAddress(ipLocal);
		
		if(netif !=null) {
			ms.setNetworkInterface(netif);
		}

		byte[] salida=mensaje.getBytes();
		DatagramPacket paquete=new DatagramPacket(salida,salida.length,grupo,puerto_Multicast);
		ms.send(paquete);
	
		}
	}
	
}
