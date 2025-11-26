package ejerciciosparada;

public class ContadorRapido extends Thread{


	
	@Override
	public void run() {
		int contador=0;
		
	while(!this.isInterrupted()) {
		System.out.println(contador);
		contador++;
	}

	}
	
	
	public static void main(String[] args) {
		ContadorRapido contadorrapido= new ContadorRapido();
		
		contadorrapido.start();
		try {
		
		Thread.sleep(4000);
		} catch (Exception e) {
		}	
		
		contadorrapido.interrupt();
	}
	
}
