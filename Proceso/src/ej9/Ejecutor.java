package ej9;

import java.io.File;

public class Ejecutor {

	public static void main(String[] args) {
		File f = new File("./bin");
		File fout= new File("salida09.txt");
		File ferr= new File("error.09.txt");
		ProcessBuilder pb = new ProcessBuilder("java","ej9.App");
		pb.redirectOutput(ProcessBuilder.Redirect.appendTo(fout));
		pb.redirectError(ProcessBuilder.Redirect.to(ferr));
		pb.directory(f);
		try {
			Process proceso= pb.start();
			
		int salida=proceso.waitFor();	
		System.out.println("Resultado"+salida);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		
		
		
	}
	
}
