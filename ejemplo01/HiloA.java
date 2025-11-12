package ejemplo01;

class HiloA extends Thread {
	private Contador contador;

	public HiloA(String n, Contador c) {
		setName(n);
		contador = c;
	}

	public void run() {

		// Sincronizamos sobre el mismo objeto todas las operaciones, si lo hago así los
		// métodos no necesitan sincronización,pero tengo que usar el mismo monitor para
		// sincronizar todos los métodos en el run de todos los hilos.
		for (int j = 0; j < 300; j++) {
			synchronized (contador) {
				contador.incrementa();
			}

		}
		//si no sincronizo, getValor puede ver valores inconsistentes ya que no está sincronizado
		synchronized (contador) {
			System.out.println(getName() + " contador vale " + contador.getValor());

		}
	}
}// FIN HILOA