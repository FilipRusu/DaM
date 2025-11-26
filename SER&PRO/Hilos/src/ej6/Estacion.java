package ej6;

import java.util.ArrayList;

public class Estacion implements	Runnable{
private ArrayList<String> lista = new ArrayList<String>();
		
	
	public Estacion(ArrayList<String> lista) {
	
	this.lista = lista;
}


	@Override
	public void run() {
	try {
		Thread.sleep(2000);
		System.out.println(lista.get(0));	
		Thread.sleep(3000);
		System.out.println(lista.get(1));
		Thread.sleep(4000);
		System.out.println(lista.get(2));
	} catch (InterruptedException e) {
		
		e.printStackTrace();
	}
		
	}

	
}
