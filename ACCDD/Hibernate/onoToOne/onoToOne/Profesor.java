package onoToOne;

import jakarta.persistence.*;

@Entity
@Table(name = "PROFESOR")
public class Profesor {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_prof")
	@SequenceGenerator(name = "seq_prof", sequenceName = "SEQ_PROFESOR", allocationSize = 1)
	private Long id;

	private String nombre;
	@OneToOne(mappedBy = "profesor", fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	private FichaTecnica fichaTecnica;

	public Profesor() {
	}

	// getters/setters
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public FichaTecnica getFichaTecnica() {
		return fichaTecnica;
	}

	public void setFichaTecnica(FichaTecnica fichaTecnica) {
		this.fichaTecnica = fichaTecnica;
	}

	@Override
	public String toString() {
		return "Profesor [id=" + id + ", nombre=" + nombre + ", fichaTecnica=" + fichaTecnica + "]";
	}

}
