package ej2pag2;

public class Hilo2 extends Thread{
	
	
	public Hilo2() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void run() {
		for (int i = 0; i <= 100000000; i++) {
			try {
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}

