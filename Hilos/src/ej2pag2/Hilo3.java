package ej2pag2;

public class Hilo3 extends Thread{
	
	
	public Hilo3() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void run() {
		for (int i = 0; i <= 1000000000; i++) {
			try {
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}

