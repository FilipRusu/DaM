package ej4;

import java.util.Iterator;

public class Mascotas extends Thread{
	private String nombre;
	private String posicion;
//	private static final int COMPROBANTE;
	public Mascotas(String nombre) {
	
		this.nombre = nombre;
	}
	
	@Override
	public void run() {
		for (int i = 0; i <= 30; i++) {
		System.out.println(i+"mt hilo "+nombre+" con prioridad"+this.getPriority());
		try {
			this.sleep(200);
		} catch (Exception e) {
			// TODO: handle exception
		}
		}
		
	}

	public String getPosicion() {
		return posicion;
	}

	public void setPosicion(String posicion) {
		this.posicion = posicion;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
	
	
}
