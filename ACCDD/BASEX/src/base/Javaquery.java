package base;

import java.io.ByteArrayInputStream;

import org.basex.api.client.ClientSession;

public class Javaquery {
	String host="localhost";
	int puerto=1984;
	String usuario="admin";
	String clave="admin";
	String baseDatos="Clase1";
	
	
	public void listarlibro() {
		try(ClientSession session=new ClientSession(host, puerto, usuario,clave)){
			System.out.println("¡CONECTADO AL SERVIDOR!");
			// 1. Abrimos la base de datos
			session.execute("OPEN " + baseDatos);
			System.out.println("Base de datos '" + baseDatos + "' abierta.");
			// 2. Consulta XQuery
			System.out.println("Ejecutando consulta...");
			// Aquí pones tu consulta XQuery tal cual
			String query = "for $l in //libro return $l";
			// Ejecutar y obtener respuesta como String
			String resultado = session.execute("XQUERY " + query);
			System.out.println("\n--- RESULTADOS ---");
			System.out.println(resultado.replace("</libro>", "</libro> \n -----------------------------------"));
		}catch (Exception e) {
			}
		
	}
	
	public void insertarlibro() {
		try(ClientSession session=new ClientSession(host, puerto, usuario,clave)){

			String consulta="insert node "+
					"<libro id=\"L009\" categoria=\"ficcion\"> \n\t"
					+ "<titulo idioma=\"es\">Angel in wonderland </titulo> \n\t"
					+ "<autor>Gabriel García Márquez </autor> \n\t"
					+ "<anio>1982</anio> \n\t"
					+ "<precio moneda=\"EUR\">18.90</precio>\n"
					+ "</libro> \n"
					+ "into /biblioteca";			

			session.execute("XQUERY " +consulta);
					
			
			
			//session.add("biblioteca.xml",new ByteArrayInputStream(xml.getBytes()));
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	

	public void consultarconScanner() {
		try (ClientSession session=new ClientSession(host, puerto, usuario,clave)){
			
		} catch (Exception e) {
		
		}
		
	}
	
public static void main(String[] args) {
	
	System.out.println("Connectando");
	Javaquery j=new Javaquery();
	
	j.listarlibro();
	j.insertarlibro();
	System.out.println("++++++++++++++++++++++++++++++++++++++++");
	j.listarlibro();
	
}
			
}
