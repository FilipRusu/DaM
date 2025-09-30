package proANDpb;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class EjecutorLeer {

	public static Process leerNombre(String N1, String N2) throws Exception {
		File f = new File("./bin");
		ProcessBuilder pb = new ProcessBuilder("java", "proANDpb.LeerNombre", N1, N2);
		pb.directory(f);

		Process proceso = pb.start();

		BufferedReader br = new BufferedReader(new InputStreamReader(proceso.getInputStream()));
		String linea;

		while ((linea = br.readLine()) != null) {
			System.out.println("Nombre: " + linea);

			// System.exit(1)
//			int salida = proceso.waitFor();
//			System.out.println("Salida del proceso LeerNombre" + salida);
		}
		return proceso;


	}

	public static void main(String[] args) {
		try {
			ArrayList<Process> lista=new ArrayList<Process>();
			lista.add(leerNombre("Andres", "Lozano"));
			lista.add(leerNombre("Amarillo", "Platano"));
			
			for(Process p : lista) {
				System.out.println("Estado proceso:"+p.isAlive());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
