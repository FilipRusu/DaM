package ejerciciosparada;

public class Ejercicio6 extends Thread{

	
	@Override
	public void run() {
		while(!this.isInterrupted()) {
				System.out.println("Hola");
		}
		
	}
	
	public static void main(String[] args) {
		Ejercicio6 ej= new Ejercicio6();
	
		ej.start();
		System.out.println("El hilo sigue vivio?"+ej.isAlive());
		try {
			Thread.sleep(5000);
		} catch (Exception e) {
			// TODO: handle exception
		}
		ej.interrupt();
		System.out.println("El hilo sigue vivio?"+ej.isAlive());
		System.out.println("El hilo sigue vivio?"+ej.isAlive());
		System.out.println("El hilo sigue vivio?"+ej.isAlive());

	}
	
}
