package modelo;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "Pedido")
public class Pedido {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "seq_pedido")
	@SequenceGenerator(name = "seq_pedido",sequenceName = "SEQ_PEDIDO",allocationSize = 1)
	private Long id;
	
	private String descripcion;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "CLIENTE_ID",nullable = true,unique = false)
	private Cliente cliente;

	public Pedido() {
		// TODO Auto-generated constructor stub
	}

	public Pedido(String nextLine) {
		descripcion=nextLine;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	
	
	
}
