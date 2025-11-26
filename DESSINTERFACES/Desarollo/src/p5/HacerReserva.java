package p5;

import javax.swing.JFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;

public class HacerReserva extends JFrame {
	private static String user = "admin";
	private static String password = "cobaiul4666";
	private static String url = "jdbc:mysql://dbinterfaces.c7oqggma6c0z.us-east-1.rds.amazonaws.com:3306/interfaces";
	static Connection connection =null;
	static Statement st = null;
	static ResultSet rs = null;
	
	
	public static void connectar() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
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
		if (connection != null) {
			connection.close();
		}
		System.out.println("Conexion cerrada");
	}

	public HacerReserva() {
		setTitle("HACER  RESERVA");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 400, 300);
		getContentPane().setLayout(null);

		JButton btnH = new JButton("HacerReserva");
		btnH.setBounds(92, 82, 161, 23);
		getContentPane().add(btnH);

		btnH.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				Havana h = new Havana(connection);
				h.setVisible(true);

			}
		});

		setVisible(true);
		setResizable(false);
	}


	public static void main(String[] args) {
		connectar();
		try {
			HacerReserva hr = new HacerReserva();
		} catch (Exception e) {
		e.printStackTrace();
		}

		
		
	}
	
}
