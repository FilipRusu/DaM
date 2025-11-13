package basededatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.sun.net.httpserver.Authenticator.Result;

public class ejRepaso {

	private static Connection conn = null;

	public static Connection connectar() {
		try {
			String url = "jdbc:sqlite:miBD.db";
			conn = DriverManager.getConnection(url);
			System.out.println("Conexion establecida");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}

	public static void desconectar() {
		try {
			if (conn != null) {
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void crearTablas() {
		String sql = "CREATE TABLE IF NOT EXISTS canciones (\r\n" + "    id INTEGER PRIMARY KEY AUTOINCREMENT, \r\n"
				+ "    titulo TEXT NOT NULL, \r\n" + "    artista TEXT NOT NULL, \r\n"
				+ "    genero TEXT NOT NULL, \r\n" + "    duracion_segundos INTEGER, \r\n"
				+ "    año_lanzamiento INTEGER \r\n" + ")";
		try (Statement stmt = conn.createStatement()) {
			stmt.execute(sql);
			System.out.println("Tabla 'canciones' creada con exito");
		} catch (Exception e) {
			System.out.println("Error tabla");
			e.printStackTrace();
		}
	}

	public static void añadircancion(String titulo, String artista, String genero, int duracion, int año) {
		String sql = "INSERT INTO canciones(titulo,artista,genero,duracion_segundos,año_lanzamiento)\r\n "
				+ "values(?,?,?,?,?)";
		try (PreparedStatement ps = conn.prepareStatement(sql)) {
			ps.setString(1, titulo);
			ps.setString(2, artista);
			ps.setString(3, genero);
			ps.setInt(4, duracion);
			ps.setInt(5, año);
			ps.executeUpdate();
			System.out.println("Se ha insertado en la tabla canciones");
		} catch (Exception e) {
			System.out.println("Error al insertar");
		}
	}

	public static void consultarcanciones() {
		String sql = "select titulo,genero from canciones where genero='MAMBO'";
		try (Statement stmt = conn.createStatement()) {
			ResultSet rs = stmt.executeQuery(sql);

			String titulo = null;
			String genero = null;

			while (rs.next()) {
				titulo = rs.getString(1);
				genero = rs.getString(2);
				System.out.println("TITULO:" + titulo + " GENERO:" + genero);
			}
		} catch (Exception e) {

		}

	}

	public static void actualizarDuracionCancion(int idCancion,int nuevaDuracion) {
		String sql="UPDATE canciones set duracion_segundos=? where id=?";
		try (PreparedStatement pt=conn.prepareStatement(sql)){
		pt.setInt(1, nuevaDuracion);
		pt.setInt(2, idCancion);
		int filas=pt.executeUpdate();
		System.out.println("FILAS AFECTADAS:"+filas);
		} catch (Exception e) {
		e.printStackTrace();	
		}
		
	}
	
	public static void listarcanciones() {
		String sql = "select * from canciones";
		try (Statement stmt = conn.createStatement()) {
			ResultSet rs = stmt.executeQuery(sql);
			int id=0;
			String titulo = null;
			String genero = null;
			String artista= null;
			int año=0;
			int duracion=0;
			while (rs.next()) {
				id=rs.getInt(1);
				titulo = rs.getString(2);
				artista= rs.getString(3);
				genero = rs.getString(4);
				duracion =rs.getInt(5);
				año= rs.getInt(6);
				
				System.out.println(id+" "+titulo+" "+artista+" "+genero+" "+duracion+" "+año);
			}
		} catch (Exception e) {

		}

	}
	

	public static void main(String[] args) {
		connectar();
		listarcanciones();
		desconectar();

	}
}
