package ejMultiCast;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.MulticastSocket;
import java.net.NetworkInterface;

public class HClienteUDP extends Thread{
	private static final String IP_MULTICAST="235.10.10.1";
	private static final String ip_local="127.0.0.1";
	private static final int puerto_multicast=8080;



	@Override
	public void run() {
	MulticastSocket ms=null;
		try {
		ms=configurarMulti();
		ejecutarescucha(ms);
		ms.close();
		} catch (Exception e) {
		
		}
	
	
	
	}

	
	private static MulticastSocket configurarMulti() throws IOException {
		MulticastSocket ms = new MulticastSocket(puerto_multicast);
		InetAddress ipLocal=InetAddress.getByName(ip_local);
		InetAddress grupo=InetAddress.getByName(IP_MULTICAST);
		
		NetworkInterface netif=NetworkInterface.getByInetAddress(ipLocal);
		
		if(netif ==null) {
			throw new IOException("Interfaz de red no encontrada para " + ip_local);
		}
		
		ms.joinGroup(new InetSocketAddress(grupo,puerto_multicast),netif);
		return ms;
	}

	public void ejecutarescucha(MulticastSocket ms) throws IOException {
		byte[] entrada= new byte[128];
		DatagramPacket paqueta= new DatagramPacket(entrada, entrada.length);
		ms.receive(paqueta);
		
		String mensaje= new String(paqueta.getData(),0,paqueta.getLength());
		
		System.out.println("Mensaje desede UDP:"+mensaje);
		
		
	}
	

}

