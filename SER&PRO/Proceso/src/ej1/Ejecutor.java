package ej1;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;

public class Ejecutor {

	public static void main(String[] args) {
		File f = new File("./bin");
		ProcessBuilder pb = new ProcessBuilder("java","ej1.App","49","1");
		pb.directory(f);
		
		
		try {
			Process proceso=pb.start();
		BufferedReader br = new BufferedReader(new InputStreamReader(proceso.getInputStream()));
		String linea;
		
		while((linea=br.readLine())!=null) {
			System.out.println(linea);
		}	
		int salida = proceso.waitFor();
		System.out.println("Proceso:"+salida);
		
		} catch (Exception e) {
		}
	}
}
