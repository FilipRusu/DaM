package pr5;

import javax.swing.JFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class HacerReserva extends JFrame{
	public HacerReserva() {
		setTitle("HACER  RESERVA");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100,100,400,300);
		getContentPane().setLayout(null);
		
		JButton btnH = new JButton("HacerReserva");
		btnH.setBounds(92, 82, 161, 23);
		getContentPane().add(btnH);
		
		btnH.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			Havana h = new Havana();
			h.setVisible(true);
				
			}
		});
		
	setVisible(true);
	setResizable(false);
	}

	private static final long serialVersionUID = 1L;

	public static void main(String[] args) {
		HacerReserva hacerReserva = new HacerReserva();
		

	}
}
