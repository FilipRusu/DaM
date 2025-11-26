package tema1;

import java.io.File;
import java.io.RandomAccessFile;
import java.util.Scanner;

public class Ejercicio4 {

	public static int validarpos(File f, Scanner src) {

		int nr = -1;
		while (nr < 0 || nr > f.length()) {
			System.out.print("Introduzca la posicion que quiera cambiar:");
			nr = (src.nextInt() - 1) * 4;
		}
		return nr;
	}

	public static void modificarinfo(File f, int posicion, Scanner src) throws Exception {
		int nr;
		RandomAccessFile fr = new RandomAccessFile(f, "rw");
		fr.seek(posicion);
		System.out.println("Se encuentra este numero-->" + fr.readInt());
		System.out.print("Introduzca el numero con el cual quiera reemplazarlo,introduzca -1 si no desea hacerlo:");
		nr = src.nextInt();
		if (nr > 0) {
			fr.seek(posicion);
			fr.writeInt(nr);
		} else {
			System.out.println("El numero no ha sido reemplazado");
		}

	}

	public static void main(String[] args) {
		File f = new File("enteros.dat");
		Scanner src = new Scanner(System.in);
		int numero = validarpos(f, src);
		try {
			modificarinfo(f, numero, src);
		} catch (Exception e) {
			e.printStackTrace();
		}

		src.close();
	}

	public static void hola() {

	}

}
