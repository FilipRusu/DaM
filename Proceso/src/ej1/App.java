package ej1;

public class App {
	
	public static void main(String[] args) {
		try {
			if(args.length>1) {
				int nr1=Integer.parseInt(args[0]);
				int nr2=Integer.parseInt(args[1]);
			int suma=nr1+nr2;
			System.out.println("La suma es: "+suma);
			System.exit(0);
			}
			else {
			System.exit(1);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
