package aleatorio;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Random;
import java.util.Scanner;

public class App {
	
	public static void mostrarFichero(File f) throws IOException {
	long posicion=0;
		RandomAccessFile rf = new RandomAccessFile(f, "r");
	while(rf.getFilePointer()<rf.length()) {
		rf.seek(posicion);
	int nr=rf.readInt();
	System.out.println("Numero="+nr);
	posicion+=4;
	}	
		
	}
	
	
	
	public static void main(String[] args) {
	Scanner src = new Scanner(System.in);
		long posicion=0;
		int nr;
		int nrmostrar;
		File f = new File("enteros.dat");
	try {
		if(!f.exists()) {
			f.createNewFile();			
		}	
	RandomAccessFile rf= new RandomAccessFile(f, "rw");
	System.out.println("posicion");
	nr=src.nextInt();
	posicion=nr*4;
	rf.seek(posicion);
	nr=rf.readInt();
	System.out.println(nr);
	rf.seek(posicion);
	System.out.println("Nuevo numero");
	nr=src.nextInt();
	rf.writeInt(nr);
	mostrarFichero(f);
	
	} catch (Exception e) {
		e.printStackTrace();
	}

	}
}
