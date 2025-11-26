package practicarSyncronized;

public class Controlador {
	private static int contador=0;
	private int id,nrhilos;
	
	public Controlador(int nrhilos) {
	this.nrhilos=nrhilos-1;
	}
	
	public synchronized void preparar(int id) {
		contador++;
		System.out.println("Hilo-"+id+" preparando.....");
		if(contador<nrhilos) {
			try {
				wait();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		else {
			contador=0;
			System.out.println("__Todos los hilos han terminado de preparar__");
			notifyAll();
		}
		System.out.println("Hilo-"+id+" ha terminado la fase: PREPARAR");
		try {
			Thread.sleep(6000);
		} catch (Exception e) {
			
		}
		
		if(contador<nrhilos) {
			contador++;
			System.out.println("Hilo-"+id+" ejecutando...");
			while(contador<nrhilos) {
			try {
				wait();
			} catch (Exception e) {
				e.printStackTrace();
				}
	
			}
		
		}
		else {
			System.out.println("Hilo-"+id+" ejecutando...");
			notifyAll();
		}
		System.out.println("Hilo-"+id+" ha terminado la fase: EJECUTAR");
		contador=0;
		try {
			Thread.sleep(6000);
		} catch (Exception e) {
			e.printStackTrace();
		}		
		if(contador<nrhilos) {
			contador++;
			System.out.println("Hilo-"+id+" preparando.....");
			while(contador<nrhilos) {
			try {
				wait();
			} catch (Exception e) {
				e.printStackTrace();
				}
	
			}
		
		}
		else {
			System.out.println("Hilo-"+id+" preparando.....");
			notifyAll();
		}
		System.out.println("Hilo-"+id+" ha terminado la fase: PREPARAR");
		contador=0;
		try {
			Thread.sleep(6000);
		} catch (Exception e) {
			
		}
		
		
	}
}
