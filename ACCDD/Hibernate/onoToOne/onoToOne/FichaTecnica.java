package onoToOne;

import jakarta.persistence.*;

@Entity
@Table(name = "FICHA_TECNICA")
public class FichaTecnica {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="seq_ft")
    @SequenceGenerator(name="seq_ft", sequenceName="SEQ_FICHA_TECNICA", allocationSize=1)
    private Long id;

    //La ficha técnica es el owner de la relación, es donde tengo registrada la FK de la relación.
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval=true)
    @JoinColumn(name = "PROFESOR_ID", unique = true, nullable = false)
    private Profesor profesor;

        
    public FichaTecnica() {
	}

	// getters/setters
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Profesor getProfesor() {
		return profesor;
	}

	public void setProfesor(Profesor profesor) {
		this.profesor = profesor;
	}

	@Override
	public String toString() {
		return "FichaTecnica [id=" + id + ", profesor=" + profesor + "]";
	}

	
    
}


