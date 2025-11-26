package ej1;

import java.io.File;

public class MainRedireccionamiento {
	public static void main(String[] args) {
		// CREACION DE PROCCESO AGREGANDO LOS ARGUMENTOS DIRECTAMENTE DENTRO DEL
		// CONSTRUCTOR
		ProcessBuilder pb = new ProcessBuilder("ls", "-l");

		File fOut = new File("listado_inical.log");
		File fErr = new File("log_errores.eer");
		// REDIRECCIONAMIENTO del flujo de salida
		pb.redirectOutput(ProcessBuilder.Redirect.to(fOut));
		//// REDIRECCIONAMIENTO del flujo de error
		pb.redirectError(ProcessBuilder.Redirect.appendTo(fErr));

		try {
			Process proceso = pb.start();
			int salida = proceso.waitFor();
			System.out.println("PROCESO FINALIZADO,CODIGO DE SALIDA:" + salida);

		} catch (Exception e) {

		}

	}

}
