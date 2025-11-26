package ejemplo02;

class SacarDinero2 extends Thread {
	private Cuenta2 c;
	String nom;

	public SacarDinero2(String n, Cuenta2 c) {
		super(n);
		this.c = c;
	}

	public void run() {
		for (int x = 1; x <= 4; x++) {
			c.retirarDinero(10, getName());
			try {
				this.sleep(500); // este sleep no interfiere en la sincronización, pero deja al planificador la
									// posibilidad de que otro hilo se ejecute mientras el actual está bloqueado
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}// run

}