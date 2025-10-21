package ejemplo;

import java.util.Scanner;

public class App {

	public static void main(String[] args) {
try {
	Scanner src = new Scanner(System.in);
System.out.println("Ingrese el nombre del empleado:");
String nombre=src.nextLine();
System.out.println("Ingrese el dia:");
String dia=src.nextLine();
System.out.println("Ingrese la hora:");
int hora=src.nextInt();
src.nextLine();
PrimerHilo ph= new PrimerHilo(hora, nombre, dia);
ph.start();

System.out.println("Ingrese el nombre del empleado:");
nombre=src.nextLine();
System.out.println("Ingrese el dia:");
dia=src.nextLine();
System.out.println("Ingrese la hora:");
hora=src.nextInt();
src.nextLine();
PrimerHilo ph2= new PrimerHilo(hora, nombre, dia);
ph2.start();
} catch (Exception e) {
	e.printStackTrace();
}

	}
}
