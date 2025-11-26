package ejrepaso;

import java.lang.reflect.Array;
import java.util.ArrayList;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name="vehiculos")
@XmlType(propOrder = {"vehiculos"})
public class Vehiculos {
	
	private ArrayList<Vehiculo> vehiculos=new ArrayList<Vehiculo>();
	
	public Vehiculos() {
		
	}
	@XmlElement(name ="vehiculos")
	public ArrayList<Vehiculo> getVehiculos() {
		return vehiculos;
	}

	public void setVehiculos(ArrayList<Vehiculo> vehiculos) {
		this.vehiculos = vehiculos;
	}

	
	
}