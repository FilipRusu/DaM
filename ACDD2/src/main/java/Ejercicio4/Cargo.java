package Ejercicio4;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;

@XmlRootElement(name = "cargo")
public class Cargo {
	
	private int nivel;
	private String valor;
	
	public Cargo() {


	}
	@XmlAttribute(name = "nivel")
	public int getNivel() {
		return nivel;
	}

	public void setNivel(int nivel) {
		this.nivel = nivel;
	}
	@XmlValue
	public String getValor() {
		return valor;
	}
	public void setValor(String valor) {
		this.valor = valor;
	}
	@Override
	public String toString() {
		return "nivel=" + nivel + ", valor=" + valor;
	}
	
	
	
	
}
