package ej1;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPasswordField;

public class Vista extends JFrame{

	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private JPasswordField passwordField;
	
	public Vista() {
		setTitle("Iniciar Session");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100,100,450,300);

		getContentPane().setLayout(null);
		
		JLabel lblIngreseNombreDe = new JLabel("Ingrese nombre de usuario:");
		lblIngreseNombreDe.setBounds(12, 12, 211, 15);
		getContentPane().add(lblIngreseNombreDe);
		
		textField = new JTextField();
		textField.setBounds(232, 10, 172, 19);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblIngreseLaContrasea = new JLabel("Ingrese la contraseña:");
		lblIngreseLaContrasea.setBounds(12, 79, 211, 15);
		getContentPane().add(lblIngreseLaContrasea);
		
		JButton btnCancelar = new JButton("cancelar");
		btnCancelar.setBounds(242, 116, 117, 25);
		getContentPane().add(btnCancelar);
		btnCancelar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
			 textField.setText(" ");
			 passwordField.setText("");
			 
				
			}
		});
		JButton btnAcceptar = new JButton("acceptar");
		btnAcceptar.setBounds(42, 116, 117, 25);
		getContentPane().add(btnAcceptar);
		
		JTextPane textPane = new JTextPane();
		textPane.setBounds(12, 168, 424, 85);
		getContentPane().add(textPane);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(232, 73, 172, 21);
		getContentPane().add(passwordField);
		btnAcceptar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				StyledDocument doc = textPane.getStyledDocument();
				SimpleAttributeSet color = new SimpleAttributeSet();
				
				char[] passwordChars =passwordField.getPassword();
				String password= new String(passwordChars);
				if(password.equalsIgnoreCase("Aloha1234")) {
					
					textPane.setText("CORRECTO");
					StyleConstants.setForeground(color, Color.GREEN);
				}
				else {
					textPane.setText("INCORRECTO");
					StyleConstants.setForeground(color, Color.RED);
				}
				doc.setCharacterAttributes(0, doc.getLength(), color, false);
			}
		});
	
		setVisible(true);
		setResizable(false);
	}
	
	public static void main(String[] args) {
		Vista v = new Vista();
	}
}
