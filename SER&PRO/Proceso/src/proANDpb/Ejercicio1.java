package proANDpb;

public class Ejercicio1 {
	public static void main(String[] args) {
		
		if(args.length<2) {
			System.out.println("Introduce 2 numeros");
		return;
		}

		int num1=Integer.parseInt(args[0]);
		int num2=Integer.parseInt(args[1]);
		int suma=0;
		
		
		for (int i = num1; i <= num2; i++) {
			suma+=i;
		}
		
		
		System.out.println(suma);
	}

}
