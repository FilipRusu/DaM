package Jaxb.PruebaUT1;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "articulo")
@XmlType(propOrder = {"stock","codigo","nombre","precio"})
public class Articulo implements Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String codigo;
    private String nombre;
    private int stock;
    private double precio;

    public Articulo() {}

    public Articulo(String codigo, String nombre, int stock, double precio) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.stock = stock;
        this.precio = precio;
    }

    // --- Getters y Setters ---
    @XmlElement(name = "codigo")
    public String getCodigo() { return codigo; }
    public void setCodigo(String codigo) { this.codigo = codigo; }
    @XmlElement(name = "nombre")
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    @XmlAttribute(name="stock")
    public int getStock() { return stock; }
    public void setStock(int stock) { this.stock = stock; }
    @XmlElement(name = "precio")
    public double getPrecio() { return precio; }
    public void setPrecio(double precio) { this.precio = precio; }

    @Override
    public String toString() {
        return codigo + ";" + nombre + ";" + stock + ";" + String.format("%.2f", precio);
    }
}