package ej8;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class Ejecutor {

	
		public static void main(String[] args) throws Exception{
		File f =new File("./bin");
		File fIN =new File("inputEj08.txt");
		File fOUT= new File("salida08.txt");

		BufferedReader br = new BufferedReader(new FileReader(fIN));
		String linea="";
		while((linea =br.readLine())!= null) {
		ProcessBuilder pb = new ProcessBuilder("java","ej8.Ejercicio",linea);
		pb.directory(f);
		pb.redirectOutput(ProcessBuilder.Redirect.appendTo(fOUT));
		Process proceso=pb.start();
		
		int salida=-1;
		salida=proceso.waitFor();
		System.out.println("Resultado:"+salida);
		}
		br.close();
		
			
			
			
			
		}
}
