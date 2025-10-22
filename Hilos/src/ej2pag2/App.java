package ej2pag2;

public class App{

	
	
	
	@SuppressWarnings("removal")
	public static void main(String[] args) {
		Hilo1 h1 = new Hilo1();
		Hilo2 h2= new Hilo2();
		Hilo3 h3= new Hilo3();
	
	ThreadGroup grupo=new ThreadGroup("ELMISMOFOCKING GRUPO");
	Thread t1=new Thread(grupo, h1);
	Thread t2=new Thread(grupo, h2);
	Thread t3=new Thread(grupo, h3);
		
	t1.start();
	t2.start();
	t3.start();
	System.out.println(Thread.activeCount());
	
	grupo.stop();
	
	System.out.println(Thread.activeCount());
	
	
	}
}
