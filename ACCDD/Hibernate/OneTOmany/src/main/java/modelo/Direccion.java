package modelo;

import jakarta.persistence.CascadeType;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;

public class Direccion {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_dir")
	@SequenceGenerator(name = "seq_dir",sequenceName = "SEQ_DIRECCION")
	
	private int id;
	
	@OneToOne(mappedBy = "direccion",fetch = FetchType.EAGER)
	private Cliente cliente;
	
	private String calle;
	private String ciudad;
	
	
	public Direccion() {
	}
	
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public String getCalle() {
		return calle;
	}
	public void setCalle(String calle) {
		this.calle = calle;
	}
	public String getCiudad() {
		return ciudad;
	}
	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}
	
	
}
