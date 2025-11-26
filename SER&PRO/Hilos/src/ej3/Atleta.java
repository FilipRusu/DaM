package ej3;

public class Atleta extends Thread{
	private String nombre;

	public Atleta(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public void run() {
		for (int i = 0; i <=30; i++) {
			System.out.print(i+" km ");
		try {
			this.sleep(3500);
		} catch (Exception e) {
			e.printStackTrace();
		}
			
		}
	System.out.println();
	System.out.println(nombre+" llego a la meta");
	}
	
	
	
}
