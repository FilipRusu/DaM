package ejJavabaseX;

import java.io.ByteArrayInputStream;
import java.nio.charset.StandardCharsets;

import org.basex.api.client.ClientSession;

public class InventarioApp {
	String host="localhost";
	int puerto=1984;
	String usuario="admin";
	String clave="admin";
	String baseDatos="TiendaTech";

	
	
	public void crearbase() {
		try(ClientSession session = new ClientSession(host, puerto, usuario,clave)) {
			session.execute("CREATE "+baseDatos);
			System.out.println("Base de datos creada.....");
			
			String xmlContent="<inventario>\n"
					+ "<producto id=\"P001\" categoria=\"portatil\">\n"
					+ "<nombre>HP Pavilion</nombre>\n"
					+ "<precio moneda=\"EUR\">800</precio>\n"
					+ "<stock>10</stock>\n"
					+ "</producto>\n"
					+ "<producto id=\"P002\" categoria=\"periferico\">\n"
					+ "<nombre>Raton Logitech</nombre>\n"
					+ "<precio moneda=\"EUR\">20</precio>\n"
					+ "<stock>50</stock>\n"
					+ "</producto>\n"
					+ "<producto id=\"P003\" categoria=\"monitor\">\n"
					+ "<nombre>Samsung 24</nombre>\n"
					+ "<precio moneda=\"EUR\">150</precio>\n"
					+ "<stock>5</stock>\n"
					+ "</producto>\n"
					+ "</inventario>";
			
			ByteArrayInputStream stream = new ByteArrayInputStream(xmlContent.getBytes(StandardCharsets.UTF_8));
			
			
			session.execute("OPEN " +baseDatos);
			session.add("stock_2024.xml", stream);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
	
	public static void main(String[] args) {
		
	}
	
}
