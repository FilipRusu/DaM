package Ejercicio3;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "duracion")
@XmlType(propOrder = {"extra"})

public class Duracion {

	private boolean extra;
	
	public Duracion() {
		
	}

	
	@XmlAttribute(name = "extra")
	public boolean isExtra() {
		return extra;
	}

	public void setExtra(boolean extra) {
		this.extra = extra;
	}
	
	
	
	
}
