package app.RepasoClase;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;



@XmlRootElement(name = "vehiculos")
@XmlType(propOrder = { "precio", "vehiculos" })

public class Vehiculos {
	private double precio;
	private ArrayList<Vehiculo> vehiculos = new ArrayList<Vehiculo>();

	public Vehiculos() {

	}
@XmlAttribute(name ="precio")
	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	@XmlElement(name = "vehiculos")
	public ArrayList<Vehiculo> getVehiculos() {
		return vehiculos;
	}

	public void setVehiculos(ArrayList<Vehiculo> vehiculos) {
		this.vehiculos = vehiculos;
	}

}
