package ejerciciosparada;

public class ContadorInterrumpible extends Thread{

	@Override
	public void run() {
		try {
		for(int i =0;i<=100;i++) {
		
				Thread.sleep(200);
			System.out.println(i);
		}
		} catch (Exception e) {
			System.out.println("El hilo ha sido interumpido");
		}
	}

	
	
	public static void main(String[] args) {
		ContadorInterrumpible contador1= new ContadorInterrumpible();
		
	
		contador1.start();
		try {
			Thread.sleep(2000);
		} catch (Exception e) {
	
		}
		contador1.interrupt();
	}
}
