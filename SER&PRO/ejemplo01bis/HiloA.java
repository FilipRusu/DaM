package ejemplo01bis;

class HiloA extends Thread {
	private Contador contador;

	public HiloA(String n, Contador c) {
		setName(n);
		contador = c;
	}

	public void run() {
		for (int j = 0; j < 300; j++) {
			contador.incrementa();

		}
		System.out.println(getName() + " contador vale " + contador.getValor()); //aquí el hilo A puede que haya terminado antes que el B y veamos el contador con valor distinto de 100

	}
}// FIN HILOA