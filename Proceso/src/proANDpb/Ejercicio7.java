package proANDpb;

import java.util.Iterator;

public class Ejercicio7 {
	
	public static void main(String[] args) {
		if(args.length<2) {
			System.exit(1);
		}
		try {
			int nr1=Integer.parseInt(args[0]);
			int nr2=Integer.parseInt(args[1]);
			
		int suma=0;
		for(int i=nr1;i<=nr2;i++) {
			suma=suma+i;
		}
			
		System.out.println(suma);
			
		} catch (Exception e) {
			System.exit(1);
			
		}
		
	
		
	}
}
