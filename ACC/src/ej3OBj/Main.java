package ej3OBj;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Iterator;

public class Main {

	public static void guardarAlumnos(File f, ArrayList<Alumno> alumno) throws Exception {
		ObjectOutputStream oos =null;
		
		if(f.exists()) {
			oos = new ObjectOutputStreamSinCabecera(new FileOutputStream(f,true));
		}
		else {
			oos = new ObjectOutputStream(new FileOutputStream(f));
		}
		for (int i = 0; i < alumno.size(); i++) {
			oos.writeObject(alumno.get(i));
		}
		oos.close();
	}

	public static void mostrarAlumno(File f) throws Exception {
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f));
		try {
			while (true) {
				Alumno alumno = (Alumno) ois.readObject();
				System.out.println(alumno);
			}

		} catch (Exception e) {

		}

	}

	public static void main(String[] args) {
		File f = new File("alumnos.dat");

		ArrayList<Alumno> lista = new ArrayList<Alumno>();
		Fecha fecha = new Fecha(04, 02, 2005);
		lista.add(new Alumno(fecha, "Andres", 20));
		lista.add(new Alumno(fecha, "Bndres", 20));
		lista.add(new Alumno(fecha, "Cndres", 20));
		lista.add(new Alumno(fecha, "Dndres", 20));
		lista.add(new Alumno(fecha, "Endres", 20));
		try {
			guardarAlumnos(f, lista);
			mostrarAlumno(f);
		} catch (Exception e) {

		}

	}

}
