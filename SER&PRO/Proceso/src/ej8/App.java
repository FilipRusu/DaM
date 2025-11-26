package ej8;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class App {

	public static void main(String[] args) {
		
		File f =new File("../salida08.txt");
		try (BufferedReader br =new BufferedReader(new FileReader(f))){
		String linea;	
		while((linea=br.readLine())!=null) {
		StringBuilder sb=new StringBuilder(linea);
		sb.reverse();
			if(sb.toString().equalsIgnoreCase(linea)) {
				System.out.println(linea+"-->SI ES UN POLINDROMO");
			}
			else {
				System.out.println(linea+"-->NO ES UN POLINDROMO");
			}
		}
		br.close();
		System.exit(0);
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(1);
		}
		
	}
}
