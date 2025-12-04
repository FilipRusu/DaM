package modelo;

import jakarta.persistence.*;

@Entity
@Table(name = "DETALLE_LIBRO")
public class DetalleLibro {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_dl")
	@SequenceGenerator(name = "seq_dl", sequenceName ="SEQ_DETALLE_LIBRO",allocationSize = 1)
	@Column(name = "ID")
	private int id;
	
	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
	private Libro libro;
	
	@Column(name = "SINOPSIS_LARGA")
	private String sinposis_larga;

	@Column(name = "EDITORIAL")
	private String editorial;



	public DetalleLibro() {

	}
 
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSinposis_larga() {
		return sinposis_larga;
	}

	public void setSinposis_larga(String sinposis_larga) {
		this.sinposis_larga = sinposis_larga;
	}

	public String getEditorial() {
		return editorial;
	}

	public void setEditorial(String editorial) {
		this.editorial = editorial;
	}

	public Libro getLibro() {
		return libro;
	}

	public void setLibro(Libro libro) {
		this.libro = libro;
	}

	@Override
	public String toString() {
		return "DetalleLibro [id=" + id + ", libro=" + libro + ", sinposis_larga=" + sinposis_larga + ", editorial="
				+ editorial + "]";
	}

	

}
