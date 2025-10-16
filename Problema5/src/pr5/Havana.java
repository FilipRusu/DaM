package pr5;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import java.util.Date;
import java.util.Calendar;
import java.text.SimpleDateFormat;

public class Havana extends JFrame {

	private JButton btnAceptar;
	private JButton btnCancelar;
	private JCheckBox chkRequiereHabitaciones;
	private JComboBox<String> cmbTipoCocina;
	private ButtonGroup grpTipoEvento;
	private JLabel lblTituloPrincipal;
	private JLabel lblTipoCocina;
	private JLabel lblNumeroDias;
	private JLabel lblFecha;
	private JLabel lblNumeroPersonas;
	private JLabel lblNombre;
	private JLabel lblTelefono;
	private JPanel pnlDatosContacto;
	private JPanel pnlDatosReserva;
	private JPanel pnlTipoEvento;
	private JRadioButton rdbBanquete;
	private JRadioButton rdbJornada;
	private JRadioButton rdbCongreso;
	private JSpinner spnNumeroDias;
	private JSpinner spnFecha;
	private JTextField txtNumeroPersonas;
	private JTextField txtNombre;
	private JTextField txtTelefono;

	private final int ANCHO_MARCO = 550;
	private final int ALTO_MARCO = 500;

	public Havana() {

		setTitle("Reserva - Hotel Havana");
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setSize(ANCHO_MARCO, ALTO_MARCO);
		setLocationRelativeTo(null);

		getContentPane().setLayout(null);

		inicializarComponentes();
		configurarAcciones();
	}

	private boolean validarEntradas() {

		String nombre = txtNombre.getText().trim();
		if (nombre.isEmpty() || nombre.length() < 3) {
			JOptionPane.showMessageDialog(this,
					"El campo Nombre no puede estar vacío y debe tener al menos 3 caracteres.", "Error de Validación",
					JOptionPane.ERROR_MESSAGE);
			txtNombre.requestFocus();
			return false;
		}

		String telefono = txtTelefono.getText().trim();
		if (!telefono.matches("^\\d{9,10}$")) {
			JOptionPane.showMessageDialog(this, "El Teléfono debe contener exclusivamente 9 o 10 dígitos numéricos.",
					"Error de Validación", JOptionPane.ERROR_MESSAGE);
			txtTelefono.requestFocus();
			return false;
		}

		String personasTexto = txtNumeroPersonas.getText().trim();
		int cantidadPersonas;
		try {
			cantidadPersonas = Integer.parseInt(personasTexto);
			if (cantidadPersonas <= 0) {
				JOptionPane.showMessageDialog(this, "El número de personas debe ser un valor positivo (mayor a cero).",
						"Error de Validación", JOptionPane.ERROR_MESSAGE);
				txtNumeroPersonas.requestFocus();
				return false;
			}
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(this, "El número de personas debe ser un valor numérico entero.",
					"Error de Validación", JOptionPane.ERROR_MESSAGE);
			txtNumeroPersonas.requestFocus();
			return false;
		}

		Date fechaSeleccionada = (Date) spnFecha.getValue();
		Calendar hoy = Calendar.getInstance();

		hoy.set(Calendar.HOUR_OF_DAY, 0);
		hoy.set(Calendar.MINUTE, 0);
		hoy.set(Calendar.SECOND, 0);
		hoy.set(Calendar.MILLISECOND, 0);

		Date fechaMinimaPermitida = hoy.getTime();

		if (fechaSeleccionada.before(fechaMinimaPermitida)) {
			SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
			JOptionPane.showMessageDialog(this,
					"La fecha de la reserva (" + df.format(fechaSeleccionada) + ") no puede ser anterior a hoy ("
							+ df.format(fechaMinimaPermitida) + ").",
							"Error de Validación de Fecha", JOptionPane.ERROR_MESSAGE);
			spnFecha.requestFocus();
			return false;
		}

		return true;
	}

	private class AccionCerrar extends AbstractAction {
		public AccionCerrar(String nombre) {
			super(nombre);
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			dispose();
		}
	}

	private class AccionDesactivarControles extends AbstractAction {
		public AccionDesactivarControles(String nombre) {
			super(nombre);
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			lblNumeroDias.setEnabled(false);
			spnNumeroDias.setEnabled(false);
			chkRequiereHabitaciones.setEnabled(false);
		}
	}

	private class AccionActivarControles extends AbstractAction {
		public AccionActivarControles(String nombre) {
			super(nombre);
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			if (rdbCongreso.isSelected()) {
				lblNumeroDias.setEnabled(true);
				spnNumeroDias.setEnabled(true);
				chkRequiereHabitaciones.setEnabled(true);
			}
		}
	}

	private void configurarAcciones() {
		AccionCerrar accionCerrar = new AccionCerrar("Cancelar");
		AccionDesactivarControles accionDesactivar = new AccionDesactivarControles("Desactivar");
		AccionActivarControles accionActivar = new AccionActivarControles("Activar");

		btnCancelar.setAction(accionCerrar);
		rdbBanquete.setAction(accionDesactivar);
		rdbJornada.setAction(accionDesactivar);
		rdbCongreso.setAction(accionActivar);

		btnCancelar.setText("Cancelar");
		rdbBanquete.setText("Banquete");
		rdbJornada.setText("Jornada");
		rdbCongreso.setText("Congreso");

		btnAceptar.addActionListener(e -> {
			if (validarEntradas()) {
				JOptionPane.showMessageDialog(this, "✅ Reserva Aceptada con Éxito. Todos los datos son válidos.",
						"Éxito", JOptionPane.INFORMATION_MESSAGE);
			}
		});
	}

	private void inicializarComponentes() {

		grpTipoEvento = new ButtonGroup();
		lblTituloPrincipal = new JLabel("RESERVAS HOTEL HAVANA");
		lblTituloPrincipal.setFont(new Font("Tahoma", 1, 18));

		pnlDatosContacto = new JPanel();
		pnlDatosContacto.setLayout(null);
		pnlDatosContacto.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)),
				"Datos de Contacto", Font.BOLD, 0, new Font("Tahoma", 1, 12), new Color(0, 51, 153)));

		lblNombre = new JLabel("Nombre:");
		lblTelefono = new JLabel("Teléfono:");
		txtNombre = new JTextField();
		txtTelefono = new JTextField();

		pnlDatosReserva = new JPanel();
		pnlDatosReserva.setLayout(null);
		pnlDatosReserva.setBorder(
				BorderFactory.createTitledBorder(null, "Datos de Reserva", Font.BOLD, 0, new Font("Tahoma", 1, 12)));

		lblFecha = new JLabel("Fecha:");
		lblNumeroPersonas = new JLabel("Nº Personas:");
		txtNumeroPersonas = new JTextField();
		chkRequiereHabitaciones = new JCheckBox("Requiere Habitaciones");
		chkRequiereHabitaciones.setEnabled(false);

		pnlTipoEvento = new JPanel();
		pnlTipoEvento.setLayout(null);
		pnlTipoEvento
		.setBorder(BorderFactory.createTitledBorder(null, "Tipo", Font.BOLD, 0, new Font("Tahoma", 1, 12)));

		rdbBanquete = new JRadioButton();
		rdbJornada = new JRadioButton();
		rdbCongreso = new JRadioButton();
		grpTipoEvento.add(rdbBanquete);
		grpTipoEvento.add(rdbJornada);
		grpTipoEvento.add(rdbCongreso);
		rdbBanquete.setSelected(true);

		spnNumeroDias = new JSpinner(new SpinnerNumberModel(1, 1, 365, 1));
		spnNumeroDias.setEnabled(false);
		lblNumeroDias = new JLabel("Nº Días:");
		lblNumeroDias.setEnabled(false);

		Calendar cal = Calendar.getInstance();
		Date hoy = cal.getTime();
		cal.add(Calendar.YEAR, 5);
		Date cincoAniosMas = cal.getTime();
		SpinnerDateModel modeloFecha = new SpinnerDateModel(hoy, hoy, cincoAniosMas, Calendar.DAY_OF_YEAR);
		spnFecha = new JSpinner(modeloFecha);
		JSpinner.DateEditor editorFecha = new JSpinner.DateEditor(spnFecha, "dd/MM/yyyy");
		spnFecha.setEditor(editorFecha);

		lblTipoCocina = new JLabel("Tipo de Cocina:");
		cmbTipoCocina = new JComboBox<>(
				new String[] { "Buffet libre", "Carta", "Pedir cita con el chef", "No precisa" });
		btnAceptar = new JButton("Aceptar");
		btnCancelar = new JButton("Cancelar");

		getContentPane().add(lblTituloPrincipal);
		lblTituloPrincipal.setBounds(10, 10, 300, 25);

		getContentPane().add(pnlDatosContacto);
		pnlDatosContacto.setBounds(10, 40, 350, 100);

		lblNombre.setBounds(15, 25, 60, 20);
		txtNombre.setBounds(80, 25, 250, 25);
		lblTelefono.setBounds(15, 60, 60, 20);
		txtTelefono.setBounds(80, 60, 120, 25);

		pnlDatosContacto.add(lblNombre);
		pnlDatosContacto.add(txtNombre);
		pnlDatosContacto.add(lblTelefono);
		pnlDatosContacto.add(txtTelefono);

		getContentPane().add(pnlDatosReserva);
		pnlDatosReserva.setBounds(10, 150, 520, 270);

		lblFecha.setBounds(15, 30, 80, 20);
		spnFecha.setBounds(15, 55, 120, 25);

		lblNumeroPersonas.setBounds(150, 30, 80, 20);
		txtNumeroPersonas.setBounds(150, 55, 100, 25);

		pnlDatosReserva.add(lblFecha);
		pnlDatosReserva.add(spnFecha);
		pnlDatosReserva.add(lblNumeroPersonas);
		pnlDatosReserva.add(txtNumeroPersonas);

		pnlDatosReserva.add(pnlTipoEvento);
		pnlTipoEvento.setBounds(15, 100, 150, 130);

		rdbBanquete.setBounds(10, 25, 120, 25);
		rdbJornada.setBounds(10, 55, 120, 25);
		rdbCongreso.setBounds(10, 85, 120, 25);

		pnlTipoEvento.add(rdbBanquete);
		pnlTipoEvento.add(rdbJornada);
		pnlTipoEvento.add(rdbCongreso);

		lblTipoCocina.setBounds(180, 120, 100, 20);
		cmbTipoCocina.setBounds(285, 120, 150, 25);

		lblNumeroDias.setBounds(180, 170, 60, 20);
		spnNumeroDias.setBounds(245, 170, 60, 25);
		chkRequiereHabitaciones.setBounds(330, 170, 180, 25);

		pnlDatosReserva.add(lblTipoCocina);
		pnlDatosReserva.add(cmbTipoCocina);
		pnlDatosReserva.add(lblNumeroDias);
		pnlDatosReserva.add(spnNumeroDias);
		pnlDatosReserva.add(chkRequiereHabitaciones);

		getContentPane().add(btnAceptar);
		getContentPane().add(btnCancelar);

		int posicionYBotones = 430;
		btnAceptar.setBounds(300, posicionYBotones, 100, 25);
		btnCancelar.setBounds(410, posicionYBotones, 100, 25);
	}

}