package ej1;

import javax.swing.JFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class VistaEj3 extends JFrame{
	public VistaEj3() {
		setTitle("HacerEncuesta");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100,100,450,300);
		getContentPane().setLayout(null);
		
		JButton btnHacerencuesta = new JButton("HacerEncuesta");
		btnHacerencuesta.setBounds(150, 76, 172, 25);
		getContentPane().add(btnHacerencuesta);
		btnHacerencuesta.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				Part2Ej3 v1 = new Part2Ej3();
				
				
			}
		});
		
		setVisible(true);
		setResizable(false);
	
	}
	public static void main(String[] args) {
		VistaEj3 vista = new VistaEj3();
	}
	
}
