package ej1_b1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class HttpGET {
	private HttpURLConnection conexion;
	private final File f=new File("navegador.html");

	
	public void saveINfile() throws IOException {
	InputStreamReader lector= new InputStreamReader(conexion.getInputStream(),StandardCharsets.UTF_8);
	BufferedReader br= new BufferedReader(lector);
	BufferedWriter bw =new BufferedWriter(new FileWriter(f));
	
	String linea;
	while((linea =br.readLine()) != null) {
		bw.write(linea);
		bw.newLine();
	}
	bw.close();
	br.close();
	}
	
	public void manageUrl(String surl) throws IOException {
		URL url =URI.create(surl).toURL();
		
		conexion= (HttpURLConnection) url.openConnection();
		
		conexion.setRequestMethod("GET");
		
		conexion.setRequestProperty("User-Agent","MOzilla/5.0");
		
		int codigorespuesta=conexion.getResponseCode();
		
		System.out.println(codigorespuesta);
		saveINfile();
	}
	
	
	public static void main(String[] args) {
		HttpGET httpGET =new HttpGET();
		
		Scanner src =new Scanner(System.in);
		
		System.out.print("Introduzca la url deseada completa:");
		
		String url=src.nextLine();
		
		try {
			httpGET.manageUrl(url);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
}
