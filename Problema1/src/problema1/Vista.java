package problema1;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Vista extends JFrame{
	int piso=1;
	public Vista() {
		
		setTitle("Ascensor");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100,100,800,500);
		getContentPane().setLayout(null);
		
		JLabel Piso = new JLabel("1");
		Piso.setFont(new Font("Dialog", Font.BOLD, 16));
		Piso.setBounds(505, 84, 42, 23);
		getContentPane().add(Piso);
		
		JLabel Direccion = new JLabel("Quieto");
		Direccion.setBounds(494, 192, 70, 15);
		getContentPane().add(Direccion);
		
		
		JButton btn4 = new JButton("Piso 4");
		btn4.setBounds(54, 29, 117, 64);
		getContentPane().add(btn4);
		btn4.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
			if(piso==4) {
			Direccion.setText("Quieto");	
			}	
			else if(piso<4) {
			Piso.setText("4");
			Direccion.setText("Subiendo");
			}
			piso=4;
			}
		});
		
		
		JButton btn3 = new JButton("Piso 3");
		btn3.setBounds(54, 123, 117, 64);
		getContentPane().add(btn3);
		btn3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(piso==3) {
					Direccion.setText("Quieto");	
					}
				else if(piso<3) {
					Piso.setText("3");
					Direccion.setText("Subiendo");
					}
				else if(piso>3) {
					Piso.setText("3");
					Direccion.setText("Bajando");
					}
				piso=3;
			}
			});
		
		
		JButton btn2 = new JButton("Piso 2");
		btn2.setBounds(54, 225, 117, 64);
		getContentPane().add(btn2);
		btn2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(piso==2) {
					Direccion.setText("Quieto");	
					}
				else if(piso<2) {
					Piso.setText("2");
					Direccion.setText("Subiendo");
					}
				else if(piso>2) {
					Piso.setText("2");
					Direccion.setText("Bajando");
					}
				piso=2;
				
			}
		});
		
		
		JButton btn1 = new JButton("Piso 1");
		btn1.setBounds(54, 324, 117, 64);
		getContentPane().add(btn1);
		btn1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(piso==1) {
					Direccion.setText("Quieto");	
					}	
					else if(piso>1) {
					Piso.setText("1");
					Direccion.setText("Bajando");
					}
					piso=1;
				
			}
		});
		
		
		JLabel lblPiso = new JLabel("piso :");
		lblPiso.setFont(new Font("AlHor", Font.PLAIN, 19));
		lblPiso.setBounds(324, 78, 56, 34);
		getContentPane().add(lblPiso);
		
		JLabel lblDireccion = new JLabel("direccion: ");
		lblDireccion.setFont(new Font("AlHor", Font.PLAIN, 19));
		lblDireccion.setBounds(324, 181, 93, 34);
		getContentPane().add(lblDireccion);
		
		setVisible(true);
		setResizable(true);
	
	}


	public static void main(String[] args) {
		Vista v = new Vista();
	}
}
