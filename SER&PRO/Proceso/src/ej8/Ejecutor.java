package ej8;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ejecutor {
	
	public static void procesoCAT() throws IOException, InterruptedException{
		ProcessBuilder pb= new ProcessBuilder("cmd","/c","type inputEj08.txt >>salida08.txt");
		
		Process proceso=pb.start();
	int salida=proceso.waitFor();
	System.out.println("Proceso:"+salida);
	}
	
	public static void procesoLeer() throws IOException, InterruptedException {
		File f = new File("./bin");
		ProcessBuilder pb= new ProcessBuilder("java","ej8.App");
		pb.directory(f);
	Process proceso=pb.start();
	BufferedReader br = new BufferedReader(new InputStreamReader(proceso.getInputStream()));
	String linea;	
		while((linea=br.readLine())!=null) {
			System.out.println(linea);
		}
	int salida=proceso.waitFor();
		System.out.println("Proceso 2:"+salida);
	}
	
	
		public static void main(String[] args) {
			
		try {
			procesoCAT();
			Thread.sleep(5000);
			procesoLeer();
		} catch (Exception e) {
		e.printStackTrace();
		}
			
			
		}
}
