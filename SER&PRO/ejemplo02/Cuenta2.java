package ejemplo02;

class Cuenta2 {
	private int saldo;

	Cuenta2(int s) {
		saldo = s;
	}

	int getSaldo() {
		return saldo;
	}

	void restar(int cantidad) {
		saldo = saldo - cantidad;
	}

	synchronized void retirarDinero(int cant, String nom) {
		if (getSaldo() >= cant) {
			System.out.println(nom + ": SE VA A RETIRAR SALDO (ACTUAL ES: " + getSaldo() + ")");
			try {
				Thread.sleep(500);// este sleep no libera el monitor, sigue la cuenta bloqueada con sus
									// operaciones (métodos) por el hilo que está bloqueado
			} catch (InterruptedException ex) {
				System.out.println("Me han interrumpido:" + nom);
			}

			restar(cant);

			System.out.println("\t" + nom + " retira =>" + cant + " ACTUAL(" + getSaldo() + ")");
		} else {
			System.out.println(nom + " No puede retirar dinero, NO HAY SALDO(" + getSaldo() + ")");
		}
		if (getSaldo() < 0) {
			System.out.println("SALDO NEGATIVO => " + getSaldo());
		}

	}// retirar
}