package ejemplo01;

class HiloB extends Thread {
	private Contador contador;

	public HiloB(String n, Contador c) {
		setName(n);
		contador = c;
	}

	public void run() {
		for (int j = 0; j < 300; j++) {
			synchronized (contador) {
				contador.decrementa();
			}

		}
		synchronized (contador) {
			System.out.println(getName() + " contador vale " + contador.getValor());

		}
	}
}// FIN HILOB
