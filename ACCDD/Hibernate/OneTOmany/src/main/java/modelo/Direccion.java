package modelo;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
@Entity
@Table(name = "DIRECCION")
public class Direccion {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_dir")
	@SequenceGenerator(name = "seq_dir",sequenceName = "SEQ_DIRECCION",allocationSize = 1)
	
	private Long id;
	
	@OneToOne(mappedBy = "direccion", fetch = FetchType.EAGER)
	private Cliente cliente;
	
	private String calle;
	private String ciudad;
	
	
	public Direccion() {
	}
	
	public Direccion(String calle2, String ciudad2) {
		this.calle=calle2;
		this.ciudad=ciudad2;
	}



	public Long getId() {
		return id;
	}
	public void setId(Long id) {
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



	@Override
	public String toString() {
		return "Direccion [id=" + id + ", cliente=" + cliente + ", calle=" + calle + ", ciudad=" + ciudad + "]";
	}
	
	
}
