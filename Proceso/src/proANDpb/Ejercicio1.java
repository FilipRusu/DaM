package proANDpb;

public class Ejercicio1 {
	public static void main(String[] args) {

		int i = Integer.parseInt(args[0]);
		int j = Integer.parseInt(args[1]);
		int suma=0;
		
		while(i<=j) {
		suma+=i;
		i++;
		}
		System.out.println("Los numeros son: "+i +" y "+ j);
		System.out.println("El resultado es: "+suma);
		
		
	}

}
