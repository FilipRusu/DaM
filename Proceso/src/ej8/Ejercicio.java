package ej8;

public class Ejercicio {
	
	public static void main(String[] args) {
		
	if(args.length>0) {
	String pNormal=args[0];
	StringBuilder sb = new StringBuilder(pNormal);
	String invertida = sb.reverse().toString();
	if(pNormal.equalsIgnoreCase(invertida)){
		System.out.println(invertida);
	}
	else {
		System.out.println(pNormal+"No es igual al reves");
	}	
		System.exit(0);
	}
	else {
		System.exit(1);
	}
	}
}
