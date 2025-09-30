package proANDpb;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Ejecutor {

	public static void main(String[] args) {
		
		try {
			ProcessBuilder pb = new ProcessBuilder("java","Ejercicio1","3","8");
			pb.redirectErrorStream(true);
		
			Process proceso=pb.start();
			
			BufferedReader br = new BufferedReader(new InputStreamReader(proceso.getInputStream()));
			String linea;
			
			while((linea = br.readLine())!=null){
				System.out.println("Resultado = "+ linea);
			}
			
			proceso.waitFor();
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
