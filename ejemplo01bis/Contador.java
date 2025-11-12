package ejemplo01bis;

public class Contador {
	private int c = 0;

	public Contador(int c) {
		this.c = c;
	}

	/*
	 * El bloqueo no depende del método, sino del objeto al que pertenecen esos
	 * métodos. Como los tres métodos usan el mismo lock (this), se sincronizan entre
	 * sí.
	 */
	public synchronized void incrementa() {
		c = c + 1;
	}

	public synchronized void decrementa() {
		c = c - 1;
	}

	public synchronized int getValor() {
		return c;
	}

}
