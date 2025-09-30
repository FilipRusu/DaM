package ej1;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class Vista extends JFrame{

	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private JTextField textField_1;
	
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
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(232, 77, 172, 19);
		getContentPane().add(textField_1);
		
		JButton btnCancelar = new JButton("cancelar");
		btnCancelar.setBounds(242, 116, 117, 25);
		getContentPane().add(btnCancelar);
		btnCancelar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
			 textField.setText(" ");
			 textField_1.setText(" ");
			 
				
			}
		});
		JButton btnAcceptar = new JButton("acceptar");
		btnAcceptar.setBounds(42, 116, 117, 25);
		getContentPane().add(btnAcceptar);
		
		JTextPane textPane = new JTextPane();
		textPane.setBounds(12, 168, 424, 85);
		getContentPane().add(textPane);
		btnAcceptar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(textField_1.getText().equalsIgnoreCase("Aloha1234")) {
					textPane.setText("CORRECTO");
				}
				else {
					JOptionPane.showMessageDialog(null, "INCORRECTO");
				}
			}
		});
	
		setVisible(true);
		setResizable(false);
	}
	
	public static void main(String[] args) {
		Vista v = new Vista();
	}
}
