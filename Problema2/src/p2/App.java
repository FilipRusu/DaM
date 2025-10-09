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
		comboEuros.setModel(new DefaultComboBoxModel(new String[] { "0", "1", "2", "3", "4", "5" }));
		comboEuros.setBounds(342, 19, 94, 23);
		getContentPane().add(comboEuros);

		JComboBox comboCentimos = new JComboBox();
		comboCentimos.setModel(
				new DefaultComboBoxModel(new String[] { "0", "10", "20", "30", "40", "50", "60", "70", "80", "90" }));
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
				double euros = Double.parseDouble(comboEuros.getSelectedItem().toString())
						+ (Integer.parseInt(comboCentimos.getSelectedItem().toString()) / 100);
				double salida = 0;

				if (rdbtnA.isSelected()) {
					if (euros == 0.80) {
						textPane.setText("CORRECTO: BEBIDA A EXTRAIDA");
						StyleConstants.setForeground(color, Color.GREEN);
					} else if (euros > 0.80) {
						salida = euros - 0.80;
						textPane.setText("CORRECTO: BEBIDA A EXTRAIDA TE SOBRAN: " + salida);
						StyleConstants.setForeground(color, Color.GREEN);
					} else {
						salida = 0.80 - euros;
						textPane.setText("INCORRECTO: EL PRECIO DE LA BEBIDA ES 0,80€ TE FALTAN " + salida);
						StyleConstants.setForeground(color, Color.RED);
					}
				}

				else if (rdbtnB.isSelected()) {
					if (euros == 1.20) {
						textPane.setText("CORRECTO: BEBIDA B EXTRAIDA");
						StyleConstants.setForeground(color, Color.GREEN);
					} 
					else if(euros>1.20){
						salida=euros-1.20;
						textPane.setText("CORRECTO: BEBIDA B EXTRAIDA TE SOBRAN: "+salida);
						StyleConstants.setForeground(color, Color.GREEN);
					}
					else {
						salida=1.20-euros;
						textPane.setText("INCORRECTO: EL PRECIO DE LA BEBIDA ES 1,20€ TE FALTAN"+salida);
						StyleConstants.setForeground(color, Color.RED);
					}
				}

				else if (rdbtnC.isSelected()) {
					if (euros == 3.10) {
						textPane.setText("CORRECTO: BEBIDA C EXTRAIDA");
						StyleConstants.setForeground(color, Color.GREEN);
					} 
					else if(euros>3.10){
						salida=euros-3.10;
						textPane.setText("CORRECTO: BEBIDA C EXTRAIDA TE SOBRAN: "+salida);
						StyleConstants.setForeground(color, Color.GREEN);
					}
					else {
						salida=3.10-euros;
						textPane.setText("INCORRECTO: EL PRECIO DE LA BEBIDA ES 3,10€ TE FALTAN "+salida);
						StyleConstants.setForeground(color, Color.RED);
						
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
