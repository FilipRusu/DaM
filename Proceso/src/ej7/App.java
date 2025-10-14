package ej7;

public class App {

	public static void main(String[] args) {
		try {
		int nr1=Integer.parseInt(args[0]);
		int nr2=Integer.parseInt(args[1]);
		int suma=0;
		for(int i=nr1;i<=nr2;i++) {
		suma+=i;
		}
		System.out.println(suma);
		System.exit(0);
		} catch (Exception e) {
		System.exit(1);
		}
	}
}
