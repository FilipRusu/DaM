package proANDpb;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;

public class Ejecutor {

	public static void main(String[] args) {
		
		try {
			File f=new File("./bin");
			
			ProcessBuilder pb = new ProcessBuilder("java","proANDpb.Ejercicio5","3,12");
//			pb.redirectErrorStream(true);
			pb.directory(f);
		
			Process proceso=pb.start();
			
//			BufferedReader br = new BufferedReader(new InputStreamReader(proceso.getInputStream()));
//			String linea;
			
//			while((linea = br.readLine())!=null){
//				System.out.println("Resultado = "+ linea);
//			}
			
			
			int salida= proceso.waitFor();
			System.out.println("Salida proceso Ejercicio1:"+salida);
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
