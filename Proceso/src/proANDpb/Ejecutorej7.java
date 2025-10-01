package proANDpb;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Iterator;


public class Ejecutorej7 {
	public static void main(String[] args) throws Exception{
		
		File f=new File("./bin");
		File fOut = new File("salida.txt");
		ProcessBuilder pb= new ProcessBuilder("java","proANDpb.Ejercicio7","8","9");
		pb.directory(f);
		pb.redirectOutput(ProcessBuilder.Redirect.appendTo(fOut));
		
		
		
		ProcessBuilder pb1= new ProcessBuilder("java","proANDpb.Ejercicio7","8","10");
		pb1.directory(f);
		pb1.redirectOutput(ProcessBuilder.Redirect.appendTo(fOut));
		ArrayList<Process> lista = new ArrayList<Process>();
		lista.add(pb.start());
		lista.add(pb1.start());
		int salida=0;
		for (Process process : lista) {
			salida=process.waitFor();
		System.out.println("Salida del resutlado"+salida);
		}
		BufferedReader br= new BufferedReader(new FileReader(fOut));
		String linea;
		int nr=0;
		int nr2=0;
		while((linea=br.readLine())!=null) {
		nr=Integer.parseInt(linea);
		nr2+=nr;
		}
		System.out.println("Resultado="+nr2);
		
	}
}
