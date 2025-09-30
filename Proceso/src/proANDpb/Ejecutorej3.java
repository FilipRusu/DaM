package proANDpb;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;

public class Ejecutorej3 {

	public static void main(String[] args) {
	try {
		File f = new File("./bin");
		ProcessBuilder pb = new ProcessBuilder("java","proANDpb.LeerNombre1","Lozano");
		pb.directory(f);
		
		Process proceso =pb.start();
		 
		BufferedReader br = new BufferedReader(new InputStreamReader(proceso.getInputStream()));
	//PARA EL EJERCICIO4 PS-- COMENTA LA LINEA DE ARRIBA Y DESCOMENTA LA DE ABAJO
	//	BufferedReader br = new BufferedReader(new InputStreamReader(proceso.getErrorStream()));
		String linea;
		while((linea =br.readLine())!=null) {
			System.out.println(linea);
		}
		
		int salida= proceso.waitFor();
		System.out.println("Salida proceso Ejercicio3:"+salida);
		
	
	} catch (Exception e) {
		e.printStackTrace();
		
	}
		


		
	}
	
}
