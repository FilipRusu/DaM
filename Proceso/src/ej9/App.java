package ej9;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class App {

	public static void main(String[] args) {
		File f = new File("texto.txt");
	try (BufferedReader br = new BufferedReader(new FileReader(f))){
	String line=br.readLine();
	while(!line.equalsIgnoreCase("*")) {
		System.out.println(line);
	line=br.readLine();
	}
	System.exit(1);
	} catch (Exception e) {
	}
	System.exit(0);
	}

}
