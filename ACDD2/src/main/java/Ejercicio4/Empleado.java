package Ejercicio4;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "empleado")
@XmlType(propOrder ={"dni","nombre","edad","cargo"})
public class Empleado {
	
	private String dni;
	private String nombre;
	private int edad;
	private Cargo cargo;
	
	public Empleado() {
		// TODO Auto-generated constructor stub
	}

	@XmlElement(name = "dni")
	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}
	@XmlElement(name = "nombre")
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	@XmlElement(name = "cargo")
	public Cargo getCargo() {
		return cargo;
	}

	public void setCargo(Cargo cargo) {
		this.cargo = cargo;
	}
	@XmlElement(name ="edad")
	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}
	
	
	
}
