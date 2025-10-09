package app.RepasoClase;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name="vehiculo")
@XmlType(propOrder = {"año","modelo","marca","vendedor"})

public class Vehiculo {
	private String año;
	private String modelo;
	private String vendedor;
	private String marca;


	public Vehiculo() {
		
	}
@XmlElement(name="año")
	public String getAño() {
		return año;
	}

	public void setAño(String año) {
		this.año = año;
	}
@XmlElement(name="modelo")
	public String getModelo() {
		return modelo;
	}

	public void setmarca(String modelo) {
		this.modelo = modelo;
	}
@XmlElement(name="vendedor")
	public String getVendedor() {
		return vendedor;
	}

	public void setVendedor(String vendedor) {
		this.vendedor = vendedor;
	}
@XmlElement(name="marca")
	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}
	@Override
	public String toString() {
		return "Vehiculo [año=" + año + ", modelo=" + modelo + ", vendedor=" + vendedor + ", marca=" + marca + "]";
	}
	
	
	
}
