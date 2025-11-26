package app.RepasoClase;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "concesionario")
@XmlType(propOrder = {"vehiculos"})

public class Concesionario {
	
	private Vehiculos vehiculos;
	
	public Concesionario() {
		
	}
@XmlElement(name ="vehiculos")
	public Vehiculos getVehiculos() {
		return vehiculos;
	}

	public void setVehiculos(Vehiculos vehiculos) {
		this.vehiculos = vehiculos;
	}
	
	
}
