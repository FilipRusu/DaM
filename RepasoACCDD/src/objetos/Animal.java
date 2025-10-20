package objetos;

import java.io.Serializable;

public class Animal implements Serializable{
	private String nombre;
	private int edad;
	public Animal(String nombre, int edad) {
		super();
		this.nombre = nombre;
		this.edad = edad;
	}
	@Override
	public String toString() {
		return "Animal [nombre=" + nombre + ", edad=" + edad + "]";
	}
	 
	
}
