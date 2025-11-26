package ej3OBj;

import java.io.Serializable;

public class Alumno implements Serializable {	
	Fecha fecha;
	String nombre;
	int edad;
	public Alumno(Fecha fecha, String nombre, int edad){
	
		this.fecha = fecha;
		this.nombre = nombre;
		this.edad = edad;
	}
	public Fecha getFecha() {
		return fecha;
	}
	public void setFecha(Fecha fecha) {
		this.fecha = fecha;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	@Override
	public String toString() {
		return "Alumno [fecha=" + fecha + ", nombre=" + nombre + ", edad=" + edad + "]";
	}
	
	
	
		
}
