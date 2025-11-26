package proANDpb;

public class Ejercicio5 {

	public static void main(String[] args) {
		
		if(args.length<1) {
			System.exit(1);
		}
		try {
		int nr=Integer.parseInt(args[0]);
		if(nr<0) {
			System.exit(3);
		}
		else if(nr>0){
			System.exit(4);
		}
		} catch (Exception e) {
		String cadena = " ";
			if(args[0].getClass().equals(cadena.getClass())){
				System.exit(2);
			}
		}
		System.exit(0);
		
	}
	
}
