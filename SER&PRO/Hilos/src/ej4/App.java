package ej4;

import java.util.ArrayList;

public class App {
	public static void main(String[] args) {

		Mascotas m = new Mascotas("lobo");
		Mascotas m1= new Mascotas("tortuga");
		Mascotas m2= new Mascotas("conejosoon");
		
		ArrayList<String> posicion = new ArrayList<String>();
		posicion.add("Primero");
		posicion.add("Segundo");
		posicion.add("Tercero");
		
		m.setPriority(5);
		m1.setPriority(5);
		m2.setPriority(5);
		
		m2.start();
		m.start();
		m1.start();
		
		boolean lobo=true;
		boolean tortuga=true;
		boolean conejo=true;
		
		
		while(m.isAlive() || m2.isAlive() || m.isAlive()) {
			if (!m1.isAlive() && tortuga) {
				m1.setPosicion(posicion.get(0));
				posicion.remove(0);
				tortuga=false;
			}
			if (!m.isAlive() && lobo) {
				m.setPosicion(posicion.get(0));
				posicion.remove(0);
				lobo=false;
			}
			if (!m2.isAlive() && conejo) {
				m2.setPosicion(posicion.get(0));
				posicion.remove(0);
				conejo=false;
			}
		}
		try {
			Thread.sleep(4000);
		System.out.println(m.getNombre()+m.getPosicion());
		System.out.println(m1.getNombre()+m1.getPosicion());
		System.out.println(m2.getNombre()+m2.getPosicion());
			
		} catch (Exception e) {
			
		}
	
		
	}
}
