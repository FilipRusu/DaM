package syncronized;

public class Cuenta {

	private int saldo=0;
		
	public void aumentarSaldo(int n1) {
		saldo+=n1;
	}
	
	public void desminuirSaldo(int n2) {
		saldo-=n2;
	}
	
	public void mostrarCuenta() {
		System.out.println(saldo);
	}
}
