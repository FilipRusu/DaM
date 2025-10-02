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

public class Vistaej2 extends JFrame{

	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private JTextField textField_1;
	
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
		
		textField = new JTextField();
		textField.setBounds(105, 49, 217, 19);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		
		
		JLabel lblIngreseLaContrasea = new JLabel("Repita contraseña");
		lblIngreseNombreDe.setForeground(Color.blue);
		lblIngreseLaContrasea.setForeground(Color.blue);
		lblIngreseLaContrasea.setFont(UIManager.getFont("ColorChooser.font"));
		lblIngreseLaContrasea.setBounds(148, 95, 156, 15);
		getContentPane().add(lblIngreseLaContrasea);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(105, 116, 217, 19);
		getContentPane().add(textField_1);
		
		
		
		JButton btnAcceptar = new JButton("Añadir Contacto");
		btnAcceptar.setBounds(144, 154, 148, 25);
		getContentPane().add(btnAcceptar);
		
		JTextPane textPane = new JTextPane();
		textPane.setBounds(35, 185, 394, 71);
		getContentPane().add(textPane);
		btnAcceptar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				StyledDocument doc = textPane.getStyledDocument();
				SimpleAttributeSet color = new SimpleAttributeSet();
				if(textField_1.getText().length()<8 || textField.getText().length()<0) {
					textPane.setText("ERROR: contraseña corta:");
					StyleConstants.setForeground(color, Color.RED);
				}
				else if(!textField.getText().equals(textField_1.getText())) {
					textPane.setText("ERROR: contraseñas no coinciden:");
					StyleConstants.setForeground(color, Color.RED);
				}
				else {	
					textPane.setText("CORRECTO");
					StyleConstants.setForeground(color, Color.GREEN);
					
				}
				
			}
		});
	
		setVisible(true);
		setResizable(false);
	}
	
	
	
	public static void main(String[] args) {
	Vistaej2 v1 = new Vistaej2();

	}
}
