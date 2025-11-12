package ejemplo01bis;

public class CompartirInf1 {
	public static void main(String[] args) {
		Contador cont = new Contador(100);
		HiloA a = new HiloA("HiloA", cont);
		HiloB b = new HiloB("HiloB", cont);
		a.start();
		b.start();   
		
		
		//Espero a que terminen los dos sus incrementos/decrementos y como sumo y resto 300 pues tiene que seguir siendo siempre... 100 el contador
		try {
			a.join();
			b.join();

			System.out.println("El contador en el main es:"+cont.getValor());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}