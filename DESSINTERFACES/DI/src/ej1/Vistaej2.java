package ej1;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.UIManager;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;
import javax.swing.JTextPane;
import javax.swing.JPasswordField;

public class Vistaej2 extends JFrame{

	private static final long serialVersionUID = 1L;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;
	
	public Vistaej2() {
		
		getContentPane().setBackground(UIManager.getColor("CheckBoxMenuItem.acceleratorForeground"));
		setTitle("Reiniciar Contraseña");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100,100,450,300);

		getContentPane().setLayout(null);
		
		JLabel lblIngreseNombreDe = new JLabel("Contreseña:");
		lblIngreseNombreDe.setFont(UIManager.getFont("ColorChooser.font"));
		lblIngreseNombreDe.setBounds(161, 22, 98, 15);
		getContentPane().add(lblIngreseNombreDe);
		
		
		
		JLabel lblIngreseLaContrasea = new JLabel("Repita contraseña");
		lblIngreseNombreDe.setForeground(Color.blue);
		lblIngreseLaContrasea.setForeground(Color.blue);
		lblIngreseLaContrasea.setFont(UIManager.getFont("ColorChooser.font"));
		lblIngreseLaContrasea.setBounds(148, 95, 156, 15);
		getContentPane().add(lblIngreseLaContrasea);
		
		
		
		JButton btnAcceptar = new JButton("Añadir Contacto");
		btnAcceptar.setBounds(144, 154, 148, 25);
		getContentPane().add(btnAcceptar);
		
		JTextPane textPane = new JTextPane();
		textPane.setBounds(35, 185, 394, 71);
		getContentPane().add(textPane);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(130, 49, 148, 25);
		getContentPane().add(passwordField);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(130, 122, 148, 25);
		getContentPane().add(passwordField_1);
		btnAcceptar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				StyledDocument doc = textPane.getStyledDocument();
				SimpleAttributeSet color = new SimpleAttributeSet();
			char[] passchar= passwordField.getPassword();
			String password1= new String(passchar);
			passchar = passwordField_1.getPassword();
			String password2= new String(passchar);
				
				
				if(password1.length()<1 || password2.length()<1) {
					textPane.setText("ERROR:campos vacios");
					StyleConstants.setForeground(color, Color.RED);
				}
				else if(password1.length()<8 || password2.length()<8) {
					textPane.setText("ERROR: contraseña corta");
					StyleConstants.setForeground(color, Color.RED);
				}
				else if(!password1.equalsIgnoreCase(password2)) {
					textPane.setText("ERROR: contraseñas no coinciden");
					StyleConstants.setForeground(color, Color.RED);
				}
				else {	
					textPane.setText("CORRECTO");
					StyleConstants.setForeground(color, Color.GREEN);
					
				}
				doc.setCharacterAttributes(0, doc.getLength(), color, false);
			}
		});
	
		setVisible(true);
		setResizable(false);
	}
	
	
	
	public static void main(String[] args) {
	Vistaej2 v1 = new Vistaej2();

	}
}
