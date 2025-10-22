package ej1pag2;

public class App extends Thread {
	
	public App() {
		
	}
	@Override
	public void run() {
		System.out.println(Thread.currentThread().toString());
		System.out.println("HOLAAAAAAAAAAAAAAAA "+Thread.currentThread().getName());
		
	}
	
	
	public static void main(String[] args) {
	ThreadGroup grupo = new ThreadGroup("EQUIPAZOOOO");
	App a = new App();
	
	Thread h1=new Thread(grupo, a, "Filip");
	Thread h2=new Thread(grupo, a, "Andres");
	Thread h3=new Thread(grupo, a, "Julia");
	
	h1.start();
	h3.start();
	h2.start();
		
		
	
		
	}
}
