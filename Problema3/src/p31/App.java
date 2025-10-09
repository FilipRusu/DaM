package p31;

import javax.swing.JFrame;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.JLabel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JTextPane;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.JPanel;

public class App extends JFrame{

	private static final long serialVersionUID = 1L;

	public App() {
		getContentPane().setBackground(new Color(255, 255, 0));
		setTitle("PRESA");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100,100,450,300);
		
		SpinnerNumberModel model = new SpinnerNumberModel(0, 0, 100, 1);
		SpinnerNumberModel model2 = new SpinnerNumberModel(0, 0, 100, 1);
		SpinnerNumberModel model3 = new SpinnerNumberModel(0, 0, 100, 1);
		getContentPane().setLayout(null);
		
		JSpinner spinner3 = new JSpinner(model3);
		spinner3.setBounds(62, 138, 69, 20);
		getContentPane().add(spinner3);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 0, 0));
		panel.setBounds(0, 0, 448, 75);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JSpinner spinner2 = new JSpinner(model2);
		spinner2.setBounds(65, 23, 69, 20);
		panel.add(spinner2);
		
		JLabel lblCompuerta = new JLabel("compuerta1");
		lblCompuerta.setBounds(152, 25, 94, 15);
		panel.add(lblCompuerta);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 0, 0));
		panel_1.setBounds(0, 177, 448, 88);
		getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JTextPane textPane = new JTextPane();
		textPane.setBounds(69, 42, 305, 34);
		panel_1.add(textPane);
		
		JButton btnActualizarCaudal = new JButton("Actualizar caudal");
		btnActualizarCaudal.setBounds(146, 12, 156, 25);
		panel_1.add(btnActualizarCaudal);
		
		JLabel lblCompuerta_1 = new JLabel("compuerta3");
		lblCompuerta_1.setBounds(149, 140, 94, 15);
		getContentPane().add(lblCompuerta_1);
		
		JLabel lblCompuerta_3 = new JLabel("compuerta2");
		lblCompuerta_3.setBounds(149, 87, 94, 15);
		getContentPane().add(lblCompuerta_3);
		
		JSpinner spinner1 = new JSpinner(model);
		spinner1.setBounds(62, 85, 69, 20);
		getContentPane().add(spinner1);
		
		btnActualizarCaudal.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int comp1=Integer.parseInt(spinner1.getValue().toString());
				int comp2=Integer.parseInt(spinner2.getValue().toString());
				int comp3=Integer.parseInt(spinner3.getValue().toString());
			int resultado=comp1+comp2+comp3;
					if(resultado<100) {
						textPane.setText("Resultado: "+resultado+" mts3/s Nivel de caudal BAJO");
					}
					else if(resultado>200) {
						textPane.setText("Resultado: "+resultado+" mts3/s Nivel de caudal ALTO");
					}
					else {
						textPane.setText("Resultado "+resultado+" mts3/s Nivel de caudal MEDIO");
					}
				
				
			}
		});
		
		
		setVisible(true);
		setResizable(false);
		
		
	}
	public static void main(String[] args) {
		App a = new App();
	}
}
