package ej1;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.border.TitledBorder;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JRadioButton;
import javax.swing.JCheckBox;
import javax.swing.JToggleButton;
import javax.swing.JScrollBar;
import javax.swing.JSeparator;

public class Vistaej3 extends JFrame{
	private JTextField textField;
	public Vistaej3() {
		setTitle("Encuesta");
		getContentPane().setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(91, 12, 248, 19);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblProfesion = new JLabel("Profesion:");
		lblProfesion.setBounds(8, 14, 116, 15);
		getContentPane().add(lblProfesion);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Sexo", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(8, 79, 331, 64);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Hombre");
		rdbtnNewRadioButton.setBounds(8, 20, 149, 23);
		panel.add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnFemina = new JRadioButton("Mujer");
		rdbtnFemina.setBounds(161, 20, 149, 23);
		panel.add(rdbtnFemina);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Entre 18 y 30", "Menos de 18", "Mas de       30"}));
		comboBox.setBounds(223, 43, 116, 24);
		getContentPane().add(comboBox);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("¿Practica algun deporte?");
		chckbxNewCheckBox.setBounds(8, 153, 222, 23);
		getContentPane().add(chckbxNewCheckBox);
		
		JLabel lblNewLabel = new JLabel("Hermanos");
		lblNewLabel.setBounds(12, 52, 89, 15);
		getContentPane().add(lblNewLabel);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(123, 334, 200, 0);
		getContentPane().add(separator);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setBounds(135, 43, 70, 15);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblCual = new JLabel("Cual?");
		lblCual.setBounds(234, 157, 70, 15);
		getContentPane().add(lblCual);
	}
}
