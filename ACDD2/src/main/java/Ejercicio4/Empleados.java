package Ejercicio4;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Empleados")
public class Empleados {

	private ArrayList<Empleado> empleados = new ArrayList<>();
	
	public Empleados() {
		// TODO Auto-generated constructor stub
	}
	@XmlElement(name = "empleados")
	public ArrayList<Empleado> getEmpleados() {
		return empleados;
	}

	public void setEmpleados(ArrayList<Empleado> empleados) {
		this.empleados = empleados;
	}
	
	
	
}
