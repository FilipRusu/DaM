package tema1;

import java.io.File;
import java.io.RandomAccessFile;
import java.util.Scanner;

public class Ejercicio2 {
	static File f = new File("enteros.dat");
	public static void mostrarinfo() throws Exception {
	if(f.exists()){
		RandomAccessFile fr = new RandomAccessFile(f, "r");
		long posicion=0;
	while(fr.getFilePointer()<fr.length()) {
		fr.seek(posicion);
		System.out.println("Numero:"+fr.readInt());
	posicion=posicion+4;
	}

	}
	else {
		f.createNewFile();
	}
	
	}
	
	public static void añadirinfo(int numero) throws Exception{
		RandomAccessFile fr = new RandomAccessFile(f, "rw");
	long posicion =(fr.length());
	fr.seek(posicion);
	fr.writeInt(numero);
	fr.close();
	}
	
	public static void main(String[] args) {
try {
	Scanner src = new Scanner(System.in);
	int numero;
	mostrarinfo();
	System.out.println("Introduzca un entero");
		numero=src.nextInt();
		añadirinfo(numero);
	System.out.println("------------------------------");
	mostrarinfo();
	
	
	
	src.close();
} catch (Exception e) {
	e.printStackTrace();
}		
	
	}

}
