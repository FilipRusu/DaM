package syncronized;

public class Main {

	public static void main(String[] args) {

		Cuenta c = new Cuenta();
	HiloSumar h1 = new HiloSumar(c, 8, 9);
	HiloRestar h2= new HiloRestar(c, 8, 9);
	Thread t1= new Thread(h1);
	Thread t2 = new Thread(h2);
	t2.start();
	t1.start();
	}

}
