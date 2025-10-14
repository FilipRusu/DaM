package ej3;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;

public class Ejecutor {
	
	public static void main(String[] args) {
		
		File f = new File("./bin");
		ProcessBuilder pb =new ProcessBuilder("java","ej3.LeerNombre");
		pb.directory(f);
		
		try {
		Process proceso=pb.start();
		BufferedReader br = new BufferedReader(new InputStreamReader(proceso.getErrorStream()));
		String line;
		while((line=br.readLine())!=null) {
			System.out.println("Nombre:"+line);
		}
		int salida=proceso.waitFor();
		System.out.println("Proceso:"+salida);
		} catch (Exception e) {
		}
		
	}
}
