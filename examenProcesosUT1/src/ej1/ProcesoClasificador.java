package ej1;

public class ProcesoClasificador {

	// Esta clase verifica si un numero que le hemos pasado atravez del args es un
	// numero,un numero par o un numero impar
	// Se le han agregado los System.exit correspondintes a cada solucion sin
	// impedir que el programa ejecute normals

	public static void main(String[] args) {

		if (args.length == 0) {
			System.out.println("ERROR: Falta argumento. Finalizando...");
			// SYSTEM.EXIT:ERROR FALTA ARGUMENTO
			System.exit(1);
		}

		String argumento = args[0];
		int numero = 0;

		try {
			numero = Integer.parseInt(argumento);

			if (numero % 2 == 0) {
				System.out.println("Número par clasificado: " + numero);
				System.exit(20); // SYSTEM:EXIT: NUMERO PAR CLASIFICADO
			} else {
				System.out.println("Número impar clasificado: " + numero);
				System.exit(30);// SYSTEM:EXIT: NUMERO IMPAR CLASIFICADO
			}

		} catch (NumberFormatException e) {
			System.out.println("ERROR: Argumento no numérico ('" + argumento + "'). Finalizando.");
			System.exit(10);// SYSTEM.EXIT:ERROR ARGUMENTO NO NUMERICO
		}
	}
}