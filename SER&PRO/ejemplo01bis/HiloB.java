package ejemplo01bis;

class HiloB extends Thread {
	private Contador contador;

	public HiloB(String n, Contador c) {
		setName(n);
		contador = c;
	}

	public void run() {
		for (int j = 0; j < 300; j++) {
			contador.decrementa();

		}
		System.out.println(getName() + " contador vale " + contador.getValor());//aquí el hilo B puede que haya terminado antes que el A y veamos el contador con valor distinto de 100

	}
}// FIN HILOB
