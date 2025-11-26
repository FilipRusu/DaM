package textoplano;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class App {
	public static int contarLineas(File f) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(f));
		String linea;
		int contador = 0;
		while ((linea = br.readLine()) != null) {
			contador++;

		}
		br.close();
		return contador;
	}

	public static int contarCaracteres(File f) throws IOException {

		BufferedReader br = new BufferedReader(new FileReader(f));
		String linea;
		int contador = 0;
		while ((linea = br.readLine()) != null) {
			contador += linea.length();

		}
		br.close();
		return contador;
	}

	public static int contadorPalabras(File f) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(f));
		String linea;
		int contador = 0;
		while ((linea = br.readLine()) != null) {
			StringTokenizer st = new StringTokenizer(linea);
			while (st.hasMoreTokens()) {
				contador++;
				st.nextToken();
			}

		}
		br.close();
		return contador;
	}

	public static void main(String[] args) {
		File f = new File("texto.txt");
		try {
			System.out.println("El archivo tiene:" + contarLineas(f) + " lineas");
			System.out.println("El archivo tiene:" + contarCaracteres(f) + " caracteres");
			System.out.println("El archivo tiene:" + contadorPalabras(f) + " palabras");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
