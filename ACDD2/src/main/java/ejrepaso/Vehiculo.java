package ejrepaso;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "vehiculo")
@XmlType(propOrder = { "precio", "anio", "marca", "modelo", "vendedor" })
public class Vehiculo {
	private String marca;
	private String modelo;
	private String vendedor;
	private double precio;
	private int anio;

	public Vehiculo() {

	}

	@XmlElement(name = "marca")
	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	@XmlElement(name = "modelo")
	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	@XmlElement(name = "vendedor")
	public String getVendedor() {
		return vendedor;
	}

	public void setVendedor(String vendedor) {
		this.vendedor = vendedor;
	}
	@XmlAttribute(name="precio")
	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}
	@XmlElement(name = "anio")
	public int getAnio() {
		return anio;
	}

	public void setAnio(int anio) {
		this.anio = anio;
	}

	@Override
	public String toString() {
		return "Vehiculo [marca=" + marca + ", modelo=" + modelo + ", vendedor=" + vendedor + ", precio=" + precio
				+ ", anio=" + anio + "]";
	}

	
	
}
