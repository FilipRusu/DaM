package ejemplo;

public class PrimerHilo extends Thread{
	private int hora;
	private String nombre;
	private String dia;

	public PrimerHilo(int hora, String nombre, String dia) {
	
		this.hora = hora;
		this.nombre = nombre;
		this.dia = dia;
	}
	@Override
	public void run() {
		if(hora>8) {
			System.out.println(nombre+" ha llegado tarde el dia "+dia);
		}
		else {
			System.out.println(nombre+" ha llegado temprano el dia "+dia);
		}
	}
	
	
	
}
