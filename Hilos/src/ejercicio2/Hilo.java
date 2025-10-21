package ejercicio2;

public class Hilo extends Thread{

	public Hilo() {

	}
	@Override
	public void run() {
		for (int i = 0; i <= 20; i++) {
		try {
			this.sleep(1500);
			System.out.println(i);
		} catch (Exception e) {
			// TODO: handle exception
		}
	
			
		}
		
	}
	
}
