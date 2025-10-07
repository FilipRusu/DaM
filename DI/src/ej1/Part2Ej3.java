package ej1;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import java.awt.Button;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.border.TitledBorder;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout.Group;
import javax.swing.JRadioButton;
import javax.swing.JCheckBox;
import javax.swing.JToggleButton;
import javax.swing.SpinnerNumberModel;
import javax.swing.JScrollBar;
import javax.swing.JSeparator;
import javax.swing.JSlider;
import javax.swing.JScrollPane;
import javax.swing.JFormattedTextField;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.AbstractListModel;
import javax.swing.ButtonGroup;
import javax.swing.JProgressBar;
import javax.swing.JSpinner;
import javax.swing.SwingConstants;
import javax.swing.JButton;

public class Part2Ej3 extends JFrame{
	private JTextField textField;
	public Part2Ej3() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100,100,500,800);

		setTitle("Encuesta");
		getContentPane().setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(217, 12, 248, 19);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblProfesion = new JLabel("Profesion:");
		lblProfesion.setBounds(8, 14, 170, 15);
		getContentPane().add(lblProfesion);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Sexo", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(8, 79, 478, 64);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Hombre");
		rdbtnNewRadioButton.setBounds(66, 33, 80, 23);
		panel.add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnFemina = new JRadioButton("Mujer");
		rdbtnFemina.setBounds(279, 33, 149, 23);
		panel.add(rdbtnFemina);
		ButtonGroup grupo =new ButtonGroup();
		grupo.add(rdbtnFemina);
		grupo.add(rdbtnNewRadioButton);
		
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Entre 18 y 30", "Menos de 18", "Mas de       30"}));
		comboBox.setBounds(303, 47, 116, 24);
		getContentPane().add(comboBox);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("¿Practica algun deporte?");
		chckbxNewCheckBox.setBounds(8, 153, 201, 23);
		getContentPane().add(chckbxNewCheckBox);
		
		JLabel lblNewLabel = new JLabel("Hermanos");
		lblNewLabel.setBounds(12, 52, 89, 15);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Edad;");
		lblNewLabel_1.setBounds(256, 52, 70, 15);
		getContentPane().add(lblNewLabel_1);
		
		JSlider slider = new JSlider(JSlider.HORIZONTAL, 1,10,5);
		slider.setMajorTickSpacing(1);
		slider.setBounds(189, 260, 248, 64);
		getContentPane().add(slider);
		slider.setMinorTickSpacing(1);
		slider.setPaintLabels(true);
		slider.setPaintTicks(true);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setViewportBorder(new TitledBorder(null, "Cual?", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		scrollPane.setBounds(233, 151, 253, 71);
		getContentPane().add(scrollPane);
		
		JList list = new JList();
		list.setModel(new AbstractListModel() {
			String[] values = new String[] {"Tenis", "Futbol", "Rugby", "Natacion"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		scrollPane.setViewportView(list);
		SpinnerNumberModel model = new SpinnerNumberModel(0, 0, 10, 1);
		JSpinner spinner = new JSpinner(model);
		spinner.setBounds(99, 47, 29, 20);
		getContentPane().add(spinner);
		
		JLabel lblMarqueDel = new JLabel("Marque del 1 al 10 su grado de aficion a:");
		lblMarqueDel.setBounds(27, 234, 324, 15);
		getContentPane().add(lblMarqueDel);
		
		JLabel lblCompras = new JLabel("Compras:");
		lblCompras.setBounds(59, 272, 70, 15);
		getContentPane().add(lblCompras);
		
		JLabel lblNewLabel_2 = new JLabel("Ver television:");
		lblNewLabel_2.setBounds(27, 412, 117, 15);
		getContentPane().add(lblNewLabel_2);
		
		JLabel lblIrAlCine = new JLabel("Ir al cine:");
		lblIrAlCine.setBounds(59, 550, 70, 15);
		getContentPane().add(lblIrAlCine);
		
		JSlider slider_1 = new JSlider(SwingConstants.HORIZONTAL, 1, 10, 5);
		slider_1.setPaintTicks(true);
		slider_1.setPaintLabels(true);
		slider_1.setMinorTickSpacing(1);
		slider_1.setMajorTickSpacing(1);
		slider_1.setBounds(189, 390, 248, 64);
		getContentPane().add(slider_1);
		
		JSlider slider_2 = new JSlider(SwingConstants.HORIZONTAL, 1, 10, 5);
		slider_2.setPaintTicks(true);
		slider_2.setPaintLabels(true);
		slider_2.setMinorTickSpacing(1);
		slider_2.setMajorTickSpacing(1);
		slider_2.setBounds(189, 534, 248, 64);
		getContentPane().add(slider_2);
		
		JButton btnAceotar = new JButton("Aceptar");
		btnAceotar.setBounds(59, 684, 117, 25);
		getContentPane().add(btnAceotar);
		btnAceotar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(textField.getText().length()<1) {
					JOptionPane.showMessageDialog(null, "INCORRECTO-->Introduzca una profesion");
				}
				else if(!rdbtnNewRadioButton.isSelected() && !rdbtnFemina.isSelected()) {
					JOptionPane.showMessageDialog(null, "INCORRECTO-->Elija un genero");
				}
				else if(!chckbxNewCheckBox.isSelected()) {
					JOptionPane.showMessageDialog(null, "INCORRECTO-->Seleccione la casilla del deporte");
				}
				else if(list.getSelectedValue()==null) {
					JOptionPane.showMessageDialog(null, "INCORRECTO-->Elija un deporte");
				}
				else {
					JOptionPane.showMessageDialog(null, "CORRECTO-->La encuesta se ha guardado con exito");
					setVisible(false);
				}
				
			}
		});
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(282, 684, 117, 25);
		getContentPane().add(btnCancelar);
		btnCancelar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				
			}
		});
		
		
		setVisible(true);
		setResizable(false);
	}
}