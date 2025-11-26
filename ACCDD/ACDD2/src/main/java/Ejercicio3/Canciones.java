package Ejercicio3;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "canciones")
@XmlType(propOrder = {"canciones"})

public class Canciones {

	private ArrayList<Cancion> canciones = new ArrayList<>();
	
	public Canciones() {
	
	}
	@XmlElement(name = "cancion")
	public ArrayList<Cancion> getCanciones() {
		return canciones;
	}

	public void setCanciones(ArrayList<Cancion> canciones) {
		this.canciones = canciones;
	}
	
	
	
	
}
