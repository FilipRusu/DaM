package tema1;

import java.io.File;
import java.io.RandomAccessFile;
import java.util.Scanner;

public class Ejercicio6Objetos {

	public static void main(String[] args) {
		Scanner src = new Scanner(System.in);
		String cadena = "";
		int contador = 0;
		int conversor = 0;
		File f = new File("fichero.dat");
		RandomAccessFile fr = null;
		try {
			if (!f.exists()) {
				f.createNewFile();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		try {
			fr = new RandomAccessFile(f, "rw");
		} catch (Exception e) {
			e.printStackTrace();
		}

		while (!cadena.equalsIgnoreCase("fin")) {
			try {
				System.out.print("Entrada:");
				cadena = src.nextLine();
				conversor = Integer.parseInt(cadena);
				long posicion = (fr.length());
				fr.seek(posicion);
				fr.writeInt(conversor);
			} catch (Exception e) {
				contador++;
			}

		}
		System.out.println("Total caracteres no numericos: " + contador);
		long position = 0;
		System.out.println("Valores numericos:");
		try {
			fr.seek(position);
			while (fr.getFilePointer() < fr.length()) {
			fr.seek(position);
			System.out.println(fr.readInt());
			position=position+4;
			
			}
			
		} catch (Exception e) {

		}

	}

}
