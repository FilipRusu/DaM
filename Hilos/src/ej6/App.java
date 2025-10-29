package ej6;

import java.lang.reflect.Array;
import java.lang.runtime.SwitchBootstraps;
import java.util.ArrayList;
import java.util.Scanner;

public class App {

	public static void main(String[] args) {
		Scanner src = new Scanner(System.in);
		ArrayList<String> lista = new ArrayList<String>();
		lista.add("Junio");
		lista.add("Julio");
		lista.add("Agosto");
		Estacion Verano = new Estacion(lista);
		lista = new ArrayList<String>();
		lista.add("Septiembre");
		lista.add("Octubre");
		lista.add("Noviembre");
		Estacion Otño = new Estacion(lista);
		lista = new ArrayList<String>();
		lista.add("Diciembre");
		lista.add("Enero");
		lista.add("Febrero");
		Estacion Invierno = new Estacion(lista);
		lista = new ArrayList<String>();
		lista.add("Marzo");
		lista.add("Abril");
		lista.add("Mayo");
		Estacion Primavera = new Estacion(lista);

		System.out.println("Primavera");
		System.out.println("Otoño");
		System.out.println("Invierno");
		System.out.println("Verano");
		System.out.println("************************");
		System.out.println("Ingrese el nombre de la estacion en minusuculas");
		String estacion = src.nextLine();
		Thread h1;

		switch (estacion) {
		case "verano":
			h1 = new Thread(Verano);
			h1.start();
			break;
		case "invierno":
			h1 = new Thread(Invierno);
			h1.start();
			break;
		case "primavera":
			h1 = new Thread(Verano);
			h1.start();
			break;
		case "otoño":
			h1 = new Thread(Verano);
			h1.start();	
			break;
		default:

			break;
		}

	}
}
