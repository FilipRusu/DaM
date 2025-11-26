package ej1;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;

public class MainGestor {
	// METODO PARA COMPROBAR EL FLUJO DE SALIDA
	public static void flujoSalida(BufferedReader br, Process proceso) throws IOException {
		br = new BufferedReader(new InputStreamReader(proceso.getInputStream()));
		String linea;
		while ((linea = br.readLine()) != null) { // BREAKPOINT PARA VER QUE SALIDA TIENE LA LINEA;
			System.out.println("[SALIDA HIJO]:" + linea);
		}
	}

	// METODO PARA COMPROBAR EL FLUJO DE ERROR
	public static void flujoError(BufferedReader br, Process proceso) throws IOException {
		String linea;
		br = new BufferedReader(new InputStreamReader(proceso.getErrorStream()));
		while ((linea = br.readLine()) != null) { // AL IGUAL AQUI SITUAMOS UN BREAKPOINT PARA VER SI LINEA
			// TIENE ALGUN ERROR EN SU INTERIOR
			System.out.println("[ERROR]:" + linea);
		}
	}

	public static void main(String[] args) {
		// Creacion del proceso sin parametro
		ProcessBuilder pb = new ProcessBuilder();
		// Usamos un array para ir pasandole los argumentos al procesos usando el
		// pb.comand
		ArrayList<String> lista = new ArrayList<String>();
		File f = new File("./bin");
		lista.add("42");
		lista.add("23");
		lista.add("Hola");

		// Situamos el pb en el directorio ./bin para poder ejecutar el
		// ProcesoClasificador.java
		pb.directory(f);
		// Sacamos el argumento con el foreach
		for (String string : lista) {
			// Aqui se lo agregamos todo los atributos al proceso
			pb.command("java", "ej1.ProcesoClasificador", string);

			try {
				// { DESCOMENTE EL COMANDO DE MAS ABAJO PARA COMPROBAR EL SYSTEM.EXIT SIN
				// PARAMETROS}
				// pb.command("java","ej1.ProcesoClasificador");
				// Lanzamos el proceso
				Process proceso = pb.start();
				BufferedReader br = null;
				// Los dos metodos para Flujo de SALIDA y de ERROR
				flujoSalida(br, proceso);
				flujoError(br, proceso);
				// En esta variable INT recogemos el codigo de salida correspondiente que se ha
				// lanzado del proceso HIJO o del ERROR
				int salida = proceso.waitFor();
				System.out.println("CODIGO DE SALIDA:" + salida);

			} catch (IOException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}

		}

	}
}
