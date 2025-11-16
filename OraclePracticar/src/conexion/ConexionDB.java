package conexion;


import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;

public class ConexionDB {

	private static String user = "C##BIBLIOTECA";
	private static String password = "password";
	private static String bd = "XE";
	private static String url = "jdbc:oracle:thin:@localhost:1521:" + bd;
	static Connection connection = null;
	static Statement st = null;
	static ResultSet rs = null;
	static PreparedStatement pt = null;
	static CallableStatement cs = null;
	public static void listarAutores() throws SQLException {
		st = connection.createStatement();
		rs = st.executeQuery("select ID_LECTOR,NOMBRE,EMAIL from lectores");
		while (rs.next()) {
			int id = rs.getInt(1);
			String nombre = rs.getString(2);
			String nacionalidad = rs.getString(3);

			System.out.println("ID:" + id + " NOMBRE:" + nombre + " NACIONALIDAD:" + nacionalidad);

		}

	}

	public static void insertarAutores() throws SQLException {
		String id = "105";
		String nombre = "Andres Sanchez";
		String nacionalidad = "Peruana";

		st = connection.createStatement();
		st.executeUpdate("insert into autores (ID_AUTOR,NOMBRE_AUTOR,NACIONALIDAD) VALUES(" + id + ",'" + nombre + "','"
				+ nacionalidad + "')");
	}

	public static void actualizarEmail(int id, String email) throws SQLException {
		String sql = "update lectores set EMAIL='" + email + "' where ID_LECTOR=" + id;
		st = connection.createStatement();
		int filas = st.executeUpdate(sql);
		System.out.println("Filas editadas=" + filas);

	}

	public static void borrarAutores(int id) throws SQLException {
		String sql = "delete from autores where id_autor=" + id;
		st = connection.createStatement();
		int filas = st.executeUpdate(sql);
		System.out.println("Filas borradas" + filas);

	}

	public static void buscarLibroPorAnio(int anio0) throws SQLException {
		pt = connection.prepareStatement("select TITULO,ANIO_PUBLICACION from LIBROS where anio_publicacion=?");
		pt.setString(1, "" + anio0);

		rs = pt.executeQuery();
		while (rs.next()) {
			String titulo = rs.getString(1);
			int anio = rs.getInt(2);
			System.out.println("Libro:" + titulo + " año-publicacion:" + anio);
		}
	}

	public static void registraraNuevoAutorPS(int id, String nombre, String nacionalidad) throws SQLException {
		pt = connection.prepareStatement("insert into autores(ID_AUTOR, NOMBRE_AUTOR, NACIONALIDAD) VALUES( ?, ?, ?)");
		pt.setInt(1, id);
		pt.setString(2, nombre);
		pt.setString(3, nacionalidad);
		int filas = pt.executeUpdate();
		System.out.println("Filas=" + filas);

	}

	public static void cambiarCopiasDisponibles(String isbn, int nuevasCopias) throws SQLException {
		pt = connection.prepareStatement("update libros set num_copias_disp=? where ISBN=?"); 
		pt.setString(2, isbn);
		pt.setInt(1, nuevasCopias);
		int filas = pt.executeUpdate();
		System.out.println("Filas=" + filas);

	}

	public static void listarLibrosDeAutor(String nombreAutor) throws SQLException {
	pt=connection.prepareStatement("select l.TITULO,a.NOMBRE_AUTOR from LIBROS l join AUTORES a on l.id_autor=a.id_autor"
			+ "where a.nombre_autor=? group by l.TITULO");
	pt.setString(1, nombreAutor);
	rs=pt.executeQuery();
	while(rs.next()) {
	String nombreL=rs.getString(1);
	String nombreA=rs.getString(2);
	System.out.println("Autor: "+nombreA+" Libro: "+nombreL);
	}
	
	
	}
	
	public static void procesarDevolucion() throws SQLException{
		cs = connection.prepareCall("{call REGISTRAR_DEVOLUCION(?,?)}");
		cs.registerOutParameter(2,Types.VARCHAR);
		cs.setInt(1,2);
		cs.execute();
		
		System.out.println("Nombre:"+cs.getString(2));
	}
	
	public static void aplicarMulta(int idLector,double montoAdicional) throws SQLException{
		cs=connection.prepareCall("{call ACTUALIZAR_MULTA_INOUT(?,?)}");
		cs.setInt(1, idLector);
		
		cs.registerOutParameter(2, Types.DOUBLE);
		cs.setDouble(2, montoAdicional);
		
		cs.execute();
		
		System.out.println("Nueva multa:"+cs.getDouble(2));
		
	}
	
	public static void registrarPrestamoSeguro(int idLector,String isbn) throws SQLException{
		try {
			connection.setAutoCommit(false);
			registraraNuevoAutorPS(idLector,"Andres" ,"Peruano");

			connection.commit();
		} catch (Exception e) {
			connection.rollback();
		}

		
		
		
	}
	
	public static void obtenerMulta(int idLector) throws SQLException{
		cs=connection.prepareCall("? = call  CALCULAR_MULTA_LECTOR(?)");
		cs.registerOutParameter(1, Types.DOUBLE);
		cs.setInt(2, idLector);
		
		cs.execute();
		
		System.out.println("Resultado"+cs.getDouble(1));
		
	}
	
	
	public static void connectar() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			connection = DriverManager.getConnection(url, user, password);
			if (connection != null) {
				System.out.println("Conexion realizada correctamente");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void cerrar() throws SQLException {
		if (rs != null) {
			rs.close();
		}
		if (st != null) {
			st.close();
		}
		if (pt != null) {
			pt.close();
		}
		if(cs!=null) {
			cs.close();
		}
		if (connection != null) {
			connection.close();
		}
		System.out.println("Conexion acabada");
	}
	

	public static void main(String[] args) {

		connectar();
		try {
			buscarLibroPorAnio(1949);
			cerrar();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
