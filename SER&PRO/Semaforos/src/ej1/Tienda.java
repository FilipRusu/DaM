package ej1;

import java.util.concurrent.Semaphore;

public class Tienda {
			
	private int id;
	private Semaphore semaphore = new Semaphore(5);
	
	
	public void vestirse(int id) {
		try {
			System.out.println(id+"-->Quiere entrar al probador");
		semaphore.acquire();
		System.out.println(id+"------>ESTA EN EL PROBADOR");
		Thread.sleep(2000);
		System.out.println(id+"SALIO DEL PROBADOR");
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			semaphore.release();
		}
	}
	
}
