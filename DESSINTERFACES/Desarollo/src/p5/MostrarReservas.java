package p5;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JTextArea;

public class MostrarReservas extends JFrame {
	static Connection connection = null;
	static Statement st = null;
	static ResultSet rs = null;
	
	public MostrarReservas(Connection conn) {
		connection =conn;
		setTitle("Reservas");

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 700);
		getContentPane().setLayout(null);

		JTextArea textArea = new JTextArea();
		textArea.setBounds(10, 11, 874, 639);
		getContentPane().add(textArea);
		setResizable(false);
		textArea.setText(mostrarReservas());
		
	}
	private String mostrarReservas(){
		String aux="Nombre\tTelefono\tFecha\t\tNr_personas\tTipo_reserva\tCocina\tN_dias\tRequiereHabitacion?\n";
		aux+="_______________________________________________________________________________________________________________________";
		try {
			st=connection.createStatement();
		rs=st.executeQuery("select nombre,telefono,fecha,numero_personas,tipo_reserva,tipo_cocina,n_dias,requiere_habitacion from reservas");
		while(rs.next()) {
		String a=rs.getString(1);
		String b=rs.getString(2);
		String c=rs.getString(3);
		String d=rs.getString(4);
		String e=rs.getString(5);
		String f=rs.getString(6);
		String g=rs.getString(7);
		String h=rs.getString(8);
		aux+="\n "+a+"\t"+b+"\t"+c+"\t"+d+"\t"+e+"\t"+f+"\t"+g+"\t"+h;
		
		}	
		return aux;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "error";
		
		
		
		
	}
	
	
	
	private static final long serialVersionUID = 1L;
}
