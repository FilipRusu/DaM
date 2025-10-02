package Ejercicio3;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "cancion")
@XmlType(propOrder = { "titulo", "duracion","extra" })

public class Cancion {

	private String titulo;
	private int duracion;
	private boolean extra;

	public Cancion() {
	}

	@XmlElement(name = "titulo")
	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	@XmlElement(name = "duracion")
	public int getDuracion() {
		return duracion;
	}

	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}
	@XmlAttribute(name="extra")
	public boolean isExtra() {
		return extra;
	}

	public void setExtra(boolean extra) {
		this.extra = extra;
	}

	@Override
	public String toString() {
		return "Cancion [titulo=" + titulo + ", duracion=" + duracion + ", extra=" + extra + "]";
	}
	

}
