package pb4;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JTextPane;
import javax.swing.DefaultComboBoxModel;

public class App extends JFrame {
	int saldo = 3000;

	public App() {

		setTitle("CAJERO");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 350);

		getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("Dinero a extraer");
		lblNewLabel.setBounds(24, 86, 133, 15);
		getContentPane().add(lblNewLabel);

		JComboBox comboDINERO = new JComboBox();
		comboDINERO.setModel(new DefaultComboBoxModel(
				new String[] { "0", "50", "100", "150", "200", "250", "300", "350", "400", "450", "500" }));
		comboDINERO.setBounds(24, 102, 133, 24);
		getContentPane().add(comboDINERO);

		JLabel lblNewLabel_1 = new JLabel("Tipo de cuenta");
		lblNewLabel_1.setBounds(24, 12, 236, 15);
		getContentPane().add(lblNewLabel_1);

		JComboBox comboCUENTA = new JComboBox();
		comboCUENTA.setModel(new DefaultComboBoxModel(new String[] { "Cuenta Corriente", "Caja de Ahorro" }));
		comboCUENTA.setBounds(24, 27, 196, 24);
		getContentPane().add(comboCUENTA);

		JButton btnNewButton = new JButton("Extraer");
		btnNewButton.setBounds(40, 249, 117, 25);
		getContentPane().add(btnNewButton);

		JLabel lblResultado = new JLabel("resultado");
		lblResultado.setBounds(175, 254, 90, 15);
		getContentPane().add(lblResultado);

		JTextPane txtPaneSaldo = new JTextPane();
		txtPaneSaldo.setBounds(283, 39, 70, 24);
		getContentPane().add(txtPaneSaldo);

		JLabel lblSaldo = new JLabel("Saldo");
		lblSaldo.setBounds(283, 12, 70, 15);
		getContentPane().add(lblSaldo);

		JTextPane textPaneResultado = new JTextPane();
		textPaneResultado.setBounds(271, 225, 215, 61);
		getContentPane().add(textPaneResultado);
		txtPaneSaldo.setText("" + saldo);

		btnNewButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int dineroEXTRA = Integer.parseInt(comboDINERO.getSelectedItem().toString());
				if (saldo >= dineroEXTRA) {
					if (comboCUENTA.getSelectedItem().toString().equalsIgnoreCase("Cuenta Corriente")) {
						saldo = saldo - dineroEXTRA;
						txtPaneSaldo.setText("" + saldo);
						textPaneResultado.setText("SACANDO:" + dineroEXTRA);
					} else {
						if (dineroEXTRA <= 200) {
							saldo = saldo - dineroEXTRA;
							txtPaneSaldo.setText(""+saldo);
							textPaneResultado.setText("SACANDO"+ dineroEXTRA);
						} else {
							textPaneResultado.setText("ERROR: no puede sacar mas de 200 con este tipo de cuenta");
						}
					}

				} else {
					textPaneResultado.setText("ERROR: SALDO INSUFICIENTE");
				}
			}

		});

		setVisible(true);
		setResizable(false);
	}
	
	public static void main(String[] args) {
		App v = new App();
	}
}
