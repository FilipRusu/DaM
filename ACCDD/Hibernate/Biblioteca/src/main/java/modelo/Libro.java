package modelo;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "LIBRO")
public class Libro {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_libro")
	@SequenceGenerator(name = "seq_libro",sequenceName = "SEQ_LIBRO", allocationSize = 1)
	private Long id;
	
	
	@OneToOne(mappedBy = "libro",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	private DetalleLibro detalleLibro;
	
	
	private String titulo;
	
	
	private String autor;


	public Libro() {
		
	}
	
	
	
	public DetalleLibro getDetalleLibro() {
		return detalleLibro;
	}



	public void setDetalleLibro(DetalleLibro detalleLibro) {
		this.detalleLibro = detalleLibro;
	}



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}


	@Override
	public String toString() {
		return "Libro id=" + id + ", titulo=" + titulo + ", autor=" + autor + "]";
	}
	
	
	
}
