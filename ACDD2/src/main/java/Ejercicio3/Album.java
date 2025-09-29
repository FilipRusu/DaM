package Ejercicio3;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "Album")
@XmlType(propOrder = {"anio","artista","canciones","nombre"})


public class Album {
	private String anio;
	private String artista;
	private Canciones canciones;
	private String nombre;
	
	public Album() {
	
	}
	
	@XmlAttribute(name = "anio" )
	public String getAnio() {
		return anio;
	}

	public void setAnio(String anio) {
		this.anio = anio;
	}
	@XmlElement(name="artista")
	public String getArtista() {
		return artista;
	}

	public void setArtista(String artista) {
		this.artista = artista;
	}
	@XmlElement(name="canciones")
	public Canciones getCanciones() {
		return canciones;
	}

	public void setCanciones(Canciones canciones) {
		this.canciones = canciones;
	}
	@XmlElement(name="nombre")
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
}
