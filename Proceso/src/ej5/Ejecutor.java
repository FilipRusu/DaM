package ej5;

import java.io.File;

public class Ejecutor {


	public static void main(String[] args) {
		File f = new File("./bin");
		ProcessBuilder pb= new ProcessBuilder("java","ej5.App","0");
		pb.directory(f);
		
		try {
		Process proceso=pb.start();
		int salida = proceso.waitFor();
		
		System.out.println("Resultado:"+salida);
		} catch (Exception e) {
		
		}
	}

}

