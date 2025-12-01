package modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;



@Entity
@Table(name = "EMPLEADO")
public class Empleado {
	@Id
	@Column(name="ID_Empleado")
	private int Idempleado;

	@Column(name="NOMBRE")
	private String nombre;
	
	@Column(name = "DEPARTAMENTO")
	private String departamento;
	
	@Column(name = "SALARIO")
	private double salario;
	
	public Empleado(){
		
	}

	public Empleado(int idempleado, String nombre, String departamento, double salario) {
		super();
		Idempleado = idempleado;
		this.nombre = nombre;
		this.departamento = departamento;
		this.salario = salario;
	}

	public int getIdempleado() {
		return Idempleado;
	}

	public void setIdempleado(int idempleado) {
		Idempleado = idempleado;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDepartamento() {
		return departamento;
	}

	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}

	
	@Override
	public String toString() {
		return "Empleado [Idempleado=" + Idempleado + ", nombre=" + nombre + ", departamento=" + departamento
				+ ", salario=" + salario + "]";
	}
	
	
	
	
}
