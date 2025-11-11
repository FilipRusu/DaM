package ej2;

import java.util.concurrent.Semaphore;

public class ConsultoriaMedica {

	private Semaphore semaphore = new Semaphore(5);

	public void atenderpaciente(int id) {
		try {
			System.out.println("El paciente: " + id + " esta esperando a ser atendido");
			semaphore.acquire();
			System.out.println("!ATENDIENDO AL PACIENTE: "+id);
				
			Thread.sleep(5000);
			System.out.println(id+" ha sido atendido");
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			semaphore.release();
		}

	}

}
