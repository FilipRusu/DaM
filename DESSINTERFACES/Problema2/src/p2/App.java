package p2;

import javax.swing.JFrame;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.JTextPane;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;
import javax.swing.JComboBox;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.DefaultComboBoxModel;

public class App extends JFrame {
	private final ButtonGroup buttonGroup = new ButtonGroup();

	public App() {

		setTitle("MAQUINA EXPENDEDORA");
		getContentPane().setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);

		JRadioButton rdbtnA = new JRadioButton("Bebida A");
		buttonGroup.add(rdbtnA);
		rdbtnA.setBounds(20, 19, 149, 23);
		getContentPane().add(rdbtnA);

		JRadioButton rdbtnB = new JRadioButton("Bebida B");
		buttonGroup.add(rdbtnB);
		rdbtnB.setBounds(20, 58, 149, 23);
		getContentPane().add(rdbtnB);

		JRadioButton rdbtnC = new JRadioButton("Bebida C");
		buttonGroup.add(rdbtnC);
		rdbtnC.setBounds(20, 98, 149, 23);
		getContentPane().add(rdbtnC);

		JTextPane textPane = new JTextPane();
		textPane.setBounds(181, 183, 117, 59);
		getContentPane().add(textPane);

		JComboBox comboEuros = new JComboBox();
		comboEuros.setModel(new DefaultComboBoxModel(new Integer[] { 0,1,2,3, 4, 5}));
		comboEuros.setBounds(342, 19, 94, 23);
		getContentPane().add(comboEuros);

		JComboBox comboCentimos = new JComboBox();
		comboCentimos.setModel(
				new DefaultComboBoxModel(new Double[] { 0.0, 0.1, 0.2, 0.3, 0.4, 0.5, 0.6, 0.7, 0.8, 0.9 }));
		comboCentimos.setBounds(342, 75, 94, 23);
		getContentPane().add(comboCentimos);

		JButton btnNewButton = new JButton("Extraer");
		btnNewButton.setBounds(32, 200, 117, 25);
		getContentPane().add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				StyledDocument doc = textPane.getStyledDocument();
				SimpleAttributeSet color = new SimpleAttributeSet();
				int nr1 = (int) comboEuros.getSelectedItem();
				double nr2=(double) comboCentimos.getSelectedItem();
				double suma=nr1+nr2;
				double bebidaA=0.80;
				double bebidaB=1.20;
				double bebidaC=3.10;
				
				if (rdbtnA.isSelected()) {
					if (suma == bebidaA) {
						StyleConstants.setForeground(color, Color.GREEN);
						textPane.setText("CORRECTO:EXPULSANDO BEBIDA");
					}else if(suma > bebidaA){
						StyleConstants.setForeground(color, Color.GREEN); 
						textPane.setText("CORRECTO SOBRAN: " + (suma - bebidaA));
					}else {
						StyleConstants.setForeground(color, Color.RED); 
						textPane.setText("FALTAN: " + (bebidaA - suma));
					}
				}

				else if (rdbtnB.isSelected()) {
					if(suma == bebidaB) {
						StyleConstants.setForeground(color, Color.GREEN); 
						textPane.setText("CORRECTO:EXULSANDO BEBIDA");
					}else if(suma > bebidaB){
						StyleConstants.setForeground(color, Color.GREEN); 
						textPane.setText("CORRECTO SOBRAN: " + (suma - bebidaB));
					}else {
						StyleConstants.setForeground(color, Color.RED); 
						textPane.setText("FALTAN: " + (bebidaB - suma));
					}
				}	
				else if (rdbtnC.isSelected()) {
					if (suma == bebidaC) {
						StyleConstants.setForeground(color, Color.GREEN); 
						textPane.setText("CORRECTO: EXPULSANDO BEBIDA");
					}else if (suma > bebidaC){
						StyleConstants.setForeground(color, Color.GREEN); 
						textPane.setText("CORRECTO SOBRAN: " + (suma - bebidaC));
					}else {
						StyleConstants.setForeground(color, Color.RED); 
						textPane.setText("FALTAN: " + (bebidaC - suma));
					}
					
				} else {
					textPane.setText("NO SE HA SELECIONADO NINGUNA BEBIDA!");
					StyleConstants.setForeground(color, Color.RED);
				}
				doc.setCharacterAttributes(0, doc.getLength(), color, false);
			}
		});

		JLabel lblEuros = new JLabel("Euros");
		lblEuros.setBounds(228, 23, 70, 15);
		getContentPane().add(lblEuros);

		JLabel lblCentimos = new JLabel("Centimos");
		lblCentimos.setBounds(228, 79, 70, 15);
		getContentPane().add(lblCentimos);

		setVisible(true);
		setResizable(false);
	}

	public static void main(String[] args) {
		App p2 = new App();
	}
}
