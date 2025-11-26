package binario;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class App {

	public static void main(String[] args) {
		String[] nombres= {"Luis","Andres","Julia"};
		int[] edades= {14,15,16};
		
		File f = new File("practicabin.bin");
	try {
		FileOutputStream fos = new FileOutputStream(f);
		DataOutputStream dos= new DataOutputStream(fos);
		for (int i = 0; i < nombres.length; i++) {
			dos.writeUTF(nombres[i]);
			dos.writeInt(edades[i]);	
		}
		dos.close();
		
		FileInputStream fis= new FileInputStream(f);
		DataInputStream dis= new DataInputStream(fis);
		String nombre;
		int edad;
		
		while (true) {
			nombre=dis.readUTF();
			edad=dis.readInt();
			System.out.println("Nombre: "+nombre+" edad: "+edad);
		}
		
		
	} catch (Exception e) {
	e.printStackTrace();
	}	
		

	}
}
