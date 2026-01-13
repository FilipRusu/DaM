package modelo;

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
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_direccion")
	@SequenceGenerator(name = "seq_direccion", sequenceName = "SEQ_DIRECCION",allocationSize = 1)
	private long id;

	private String calle;

	private String ciudad;

	@OneToOne(mappedBy = "direccion",fetch = FetchType.EAGER)
	private Cliente cliente;

	public Direccion() {

	}

	public Direccion(String calle2, String ciudad2) {
		this.calle=calle2;
		this.ciudad=ciudad2;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}



}
