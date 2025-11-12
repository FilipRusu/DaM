package practicarSyncronized;

public class Main {

	
	public static void main(String[] args) {
		int nrhilos=6;
		Controlador cn = new Controlador(nrhilos);
		for (int i = 0; i < nrhilos; i++) {
			Tarea t= new Tarea(cn,i);
		Thread h= new Thread(t);
		h.start();
		}
		
		
	}
}
