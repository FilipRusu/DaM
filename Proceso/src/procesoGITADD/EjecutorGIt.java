package procesoGITADD;

import java.io.File;

public class EjecutorGIt {
	
		public static void subiraGITHUB()	throws Exception {
		File f = new File("../");
		ProcessBuilder pb = new ProcessBuilder("git","add",".");
		pb.directory(f);
		
		ProcessBuilder pb1 = new ProcessBuilder("git","commit","-m","01/10/25");
		pb.directory(f);
		
		ProcessBuilder pb2 = new ProcessBuilder("git","push","-u","origin","master");
		pb.directory(f);
		
		
		Process procesoadd=pb.start();
		Process procesocommit=pb1.start();
		Process procesopush=pb2.start();
		
		
		}
		public static void gitCommit() throws Exception{

			
		}	
	
	
	
	public static void main(String[] args) {
			try {
				subiraGITHUB();
			} catch (Exception e) {
			
			}
	}
	
}
