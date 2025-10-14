package ej7;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;

public class Ejecutor {

	public static void main(String[] args) {
		File f = new File("./bin");
		ProcessBuilder pb= new ProcessBuilder("java","ej7.App","4","hola");
		pb.directory(f);
		
		try {
			Process proceso=pb.start();
		BufferedReader br= new BufferedReader(new InputStreamReader(proceso.getInputStream()));
		String line;
		while((line=br.readLine())!=null) {
			System.out.println(line);
		}
		int salida=proceso.waitFor();
		System.out.println("Proceso:"+salida);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
