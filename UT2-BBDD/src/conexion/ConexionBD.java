package conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConexionBD {

private static 	String user="C##BIBLIOTECA";
private static	String password="password";
private static	String bd="XE";
private static	String url= "jdbc:oracle:thin:@localhost:1521:"+bd;
	static Connection connection=null;
static	Statement st=null;
static	ResultSet rs=null;

	public static void listarAutores() throws SQLException{
		st=connection.createStatement();
		rs=st.executeQuery("select ID_AUTOR,NOMBRE_AUTOR,NACIONALIDAD from autores");
	while(rs.next()) {
		int id= rs.getInt(1);
		String nombre=rs.getString(2);
		String nacionalidad=rs.getString(3);
		
		System.out.println("ID:"+id+" NOMBRE:"+nombre+" NACIONALIDAD:"+nacionalidad);
	
	}

	}


	public static void connectar(){
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			connection=DriverManager.getConnection(url,user,password);
		if(connection!=null) {
			System.out.println("Conexion realizada correctamente");
		}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public static void cerrar() throws SQLException{
		if(rs!=null) {
			rs.close();
		}
		if(st!=null) {
			st.close();
		}
		if(connection!=null) {
			connection.close();
		}
	}
	
	
	public static void main(String[] args) {
		
		connectar();
		try {
			listarAutores();
			cerrar();
		} catch (Exception e) {
			e.printStackTrace();
		}

	
	
	}

	
}
