package ej10;

import java.io.File;

public class Ejecutor {

	public static void main(String[] args){
		File fInput = new File("miscript.sh");
		
		ProcessBuilder pb = new ProcessBuilder("sh");
		
		pb.redirectInput(ProcessBuilder.Redirect.from(fInput));
		
	try {
		Process proceso= pb.start();
		 
		int salida=proceso.waitFor();
		System.out.println("Salida");
	} catch (Exception e) {
		e.printStackTrace();
	}
		
		
		
		File f= new File("Micarpeta/ejercicio.txt");
		pb = new ProcessBuilder();
		pb.command("echo","Esto es otra prueba del ejercicio").redirectOutput(ProcessBuilder.Redirect.appendTo(f));
		Process p2;
		try {
			p2=pb.start();
		int salida=p2.waitFor();
		System.out.println(salida);
		} catch (Exception e) {
		
		}
		


		
		
	}
	
}
