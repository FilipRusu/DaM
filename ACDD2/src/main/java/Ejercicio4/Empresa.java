package Ejercicio4;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "empresa")
@XmlType(propOrder = {"cif","empleados","nombre"})
public class Empresa {

		private String cif;
		private Empleados empleados;
		private String nombre;
	
		public Empresa() {
			// TODO Auto-generated constructor stub
		}
		@XmlElement
		public String getCif() {
			return cif;
		}

		public void setCif(String cif) {
			this.cif = cif;
		}
		@XmlElement
		public Empleados getEmpleados() {
			return empleados;
		}

		public void setEmpleados(Empleados empleados) {
			this.empleados = empleados;
		}
		@XmlElement
		public String getNombre() {
			return nombre;
		}

		public void setNombre(String nombre) {
			this.nombre = nombre;
		}
		
		
		
}
