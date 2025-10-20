package ejrepaso;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
@XmlRootElement(name = "concesionario")
@XmlType(propOrder = {"nombre","vehiculos","ubicacion"})
public class Concesionario {
	private String nombre;
	private Vehiculos vehiculos;
	private String ubicacion;
	
	public Concesionario() {
		// TODO Auto-generated constructor stub
	}
	@XmlAttribute(name = "nombre")
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	@XmlElement(name = "vehiculos")
	public Vehiculos getVehiculos() {
		return vehiculos;
	}

	public void setVehiculos(Vehiculos vehiculos) {
		this.vehiculos = vehiculos;
	}
	@XmlElement(name = "ubicacion")
	public String getUbicacion() {
		return ubicacion;
	}

	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}
	
}
