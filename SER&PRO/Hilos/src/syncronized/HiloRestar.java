package syncronized;

public class HiloRestar implements Runnable{
	private	Cuenta c;
	private int n1,n2;
	
	
	public HiloRestar(Cuenta c, int n1, int n2) {
		this.c = c;
		this.n1 = n1;
		this.n2 = n2;
	}



	@Override
	public void run() {
		synchronized (c) {
			c.desminuirSaldo(n1);
			c.desminuirSaldo(n2);
			c.mostrarCuenta();
			
		}
		
		
		
	}

	
	
	
}
