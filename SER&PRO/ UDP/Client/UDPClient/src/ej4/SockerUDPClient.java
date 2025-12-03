package ej4;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class SockerUDPClient {
	private ArrayList<String> lista;
	private DatagramSocket socketUDP;

	public SockerUDPClient(ArrayList<String> lista) {
		this.lista = lista;
	}
	
	public static ArrayList<String> rellenarLista(){
		Scanner src=new Scanner(System.in);
		ArrayList<String> lista= new ArrayList<String>();
		String palabra=null;
		do {
		System.out.print("(Cliente) Mensaje a enviar:");
			palabra=src.nextLine();
		lista.add(palabra);
		} while (!palabra.equalsIgnoreCase("*"));
		return lista;
	}
	
	public void enviarinfo() {
		try {
			InetAddress hostServer = InetAddress.getByName("localhost");
			int puertoservidor = 49171;
			System.out.println("(Cliente) Creando Socket");
			for (String string : lista) {
				socketUDP = new DatagramSocket();
				System.out.println("(Cliente) Enviando datagrama");
				byte[] mensaje = string.getBytes();
				DatagramPacket peticion = new DatagramPacket(mensaje, mensaje.length, hostServer, puertoservidor);
				socketUDP.send(peticion);
				System.out.println("(Cliente) Recibiendo datagrama");
				
				byte [] bufferleer = new byte [64];
				
				DatagramPacket respuesta= new DatagramPacket(bufferleer, bufferleer.length,hostServer,puertoservidor);
				socketUDP.receive(respuesta);
				
				System.out.println("Texto en mayusculas: "+new String(bufferleer));
				
			}
			System.out.println("(Cliente) Cerrando socket");
			socketUDP.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		try {
		SockerUDPClient cliente=new SockerUDPClient(rellenarLista());
		cliente.enviarinfo();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
