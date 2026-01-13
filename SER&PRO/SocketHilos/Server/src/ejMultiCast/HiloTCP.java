package ejMultiCast;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.Socket;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class HiloTCP extends Thread {
	private Socket socket;
	private DataInputStream dis;
	private DataOutputStream dos;

	public HiloTCP(Socket socket) throws IOException {
		this.socket = socket;
		dis = new DataInputStream(socket.getInputStream());
		dos = new DataOutputStream(socket.getOutputStream());
	}

	public String consulta(String id) {
		try {
			Connection conn = DriverManager.getConnection("jdbc:sqlite:inventario.db");
			String sql = "select * from PRODUCTOS where id=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, Integer.parseInt(id));
			ResultSet rs=ps.executeQuery();
		String mensaje="";
		while(rs.next()) {
		int id1=rs.getInt("ID");
		String nombre=rs.getString("NOMBRE");
		int stock=rs.getInt("STOCK");
		mensaje="ID:"+id1+" NOMBRE:"+nombre+" STOCK:"+stock;
		}
		rs.close();
		ps.close();
		conn.close();
		return mensaje;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}

	}

	@Override
	public void run() {
		try {
			String aux = dis.readUTF();
			String mensajeaenviar=consulta(aux);
			new HiloUDP(mensajeaenviar).start();
			dos.writeUTF(mensajeaenviar);
			dos.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
