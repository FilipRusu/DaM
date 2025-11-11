package ej2;

import java.util.Iterator;
import java.util.concurrent.Semaphore;

public class Paciente extends Thread{
	private int id;
	private ConsultoriaMedica cn;
	
	
	
	public Paciente(int id, ConsultoriaMedica cn) {
		
		this.id = id;
		this.cn = cn;
	}



	@Override
	public void run() {
	cn.atenderpaciente(id);
		
	}
	
	public static void main(String[] args) {
		ConsultoriaMedica cm = new ConsultoriaMedica();
	for (int i = 0; i < 10; i++) {
	Paciente p= new Paciente(i, cm);
	p.start();
		
	}
		
	}
	
}
