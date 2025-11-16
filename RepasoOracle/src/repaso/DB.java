package repaso;

import java.sql.Connection;
import java.sql.DriverManager;

public class DB {
	private static String user = "C##BIBLIOTECA";
	private static String password = "password";
	private static String bd = "XE";
	private static String url = "jdbc:oracle:thin:@localhost:1521:" + bd;
	
	public static Connection conectar() {
		Connection conn=null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(url, user, password);
		if (conn !=null) {
			System.out.println("Conexion realizada con exito");
		}
		} catch (Exception e) {
			System.out.println("Error al connectar");
			e.printStackTrace();
		}
		return conn;
	}

}
