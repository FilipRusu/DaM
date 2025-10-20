package objetos;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class App {

	public static void main(String[] args) {
		ArrayList<Animal> lista = new ArrayList<Animal>();
	File f = new File("animales.dat");
	lista.add(new Animal("A", 2));
	lista.add(new Animal("B", 2));
	lista.add(new Animal("C", 2));
try {
	ObjectOutputStream oos;
	if(!f.exists()) {	
		FileOutputStream fos = new FileOutputStream(f,true);
		oos=new ObjectOutputStream(fos);
	}
	else {
		FileOutputStream fos = new FileOutputStream(f,true);
		oos=new ObjectOutputStreamSinCabecera(fos);
	}
	for (int i = 0; i < lista.size(); i++) {
		oos.writeObject(lista.get(i));
		
	}
	oos.close();
	
	FileInputStream fis =new FileInputStream(f);
	ObjectInputStream ois=new ObjectInputStream(fis);
	
	while (true) {
	Animal animal = (Animal) ois.readObject();
	System.out.println(animal);
	}
	
} catch (Exception e) {
	e.printStackTrace();
}
	

	
	
	
	
	
	}
}
