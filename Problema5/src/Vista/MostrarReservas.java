package Vista;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JTextArea;

public class MostrarReservas extends JFrame {
	
	
	public MostrarReservas() {
		setTitle("Reservas");

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 700);
		getContentPane().setLayout(null);

		JTextArea textArea = new JTextArea();
		textArea.setBounds(10, 11, 764, 639);
		getContentPane().add(textArea);
		setResizable(false);
		
	
	}
	private void mostrarReservas() {
		
	}
	
	
	
	private static final long serialVersionUID = 1L;
}
