package ej1;

public class Persona extends Thread{
	private Tienda tienda;
	private int id;

	
	
	
	public Persona(Tienda tienda, int id) {
		this.tienda = tienda;
		this.id = id;
	}


	@Override
	public void run() {
	tienda.vestirse(id);
	}
	
	
	public static void main(String[] args) {
		Tienda t = new Tienda();
		for (int i = 0; i <= 20; i++) {
		Persona p = new Persona(t,i);
		p.start();
		}
	}
}
