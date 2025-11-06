package Vista;

import java.sql.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeListener;

import javax.swing.AbstractAction;
import java.util.Date;
import java.util.Calendar;
import java.text.SimpleDateFormat;

public class Havana extends JFrame {

	private JButton btnAceptar;
	private JButton btnCancelar;
	static Connection connection = null;
	static Statement st = null;
	static ResultSet rs = null;
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

	public Havana(Connection conn) {
		connection = conn;
		setTitle("Reserva - Hotel Havana");
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setSize(ANCHO_MARCO, ALTO_MARCO);
		setLocationRelativeTo(null);

		getContentPane().setLayout(null);

		inicializarComponentes();
		configurarAcciones();
	}
	private void agregarReserva() throws SQLException {
		String sql="insert into reservas(nombre,telefono,fecha,numero_personas,tipo_reserva,tipo_cocina,n_dias,requiere_habitacion) values (?,?,?,?,?,?,?,?)";
		PreparedStatement ps=connection.prepareStatement(sql);
		
				
		
		
		
		
		
		

		
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

		JButton btnMostrarReservas = new JButton("Mostrar Reservas");
		btnMostrarReservas.setBounds(20, 429, 126, 25);
		getContentPane().add(btnMostrarReservas);
		btnMostrarReservas.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				MostrarReservas mr = new MostrarReservas();
				mr.setVisible(true);
			}
		});

	}

	public JButton getBtnAceptar() {
		return btnAceptar;
	}

	public void setBtnAceptar(JButton btnAceptar) {
		this.btnAceptar = btnAceptar;
	}

	public JButton getBtnCancelar() {
		return btnCancelar;
	}

	public void setBtnCancelar(JButton btnCancelar) {
		this.btnCancelar = btnCancelar;
	}

	public static Connection getConnection() {
		return connection;
	}

	public static void setConnection(Connection connection) {
		Havana.connection = connection;
	}

	public static Statement getSt() {
		return st;
	}

	public static void setSt(Statement st) {
		Havana.st = st;
	}

	public static ResultSet getRs() {
		return rs;
	}

	public static void setRs(ResultSet rs) {
		Havana.rs = rs;
	}

	public JCheckBox getChkRequiereHabitaciones() {
		return chkRequiereHabitaciones;
	}

	public void setChkRequiereHabitaciones(JCheckBox chkRequiereHabitaciones) {
		this.chkRequiereHabitaciones = chkRequiereHabitaciones;
	}

	public JComboBox<String> getCmbTipoCocina() {
		return cmbTipoCocina;
	}

	public void setCmbTipoCocina(JComboBox<String> cmbTipoCocina) {
		this.cmbTipoCocina = cmbTipoCocina;
	}

	public ButtonGroup getGrpTipoEvento() {
		return grpTipoEvento;
	}

	public void setGrpTipoEvento(ButtonGroup grpTipoEvento) {
		this.grpTipoEvento = grpTipoEvento;
	}

	public JLabel getLblTituloPrincipal() {
		return lblTituloPrincipal;
	}

	public void setLblTituloPrincipal(JLabel lblTituloPrincipal) {
		this.lblTituloPrincipal = lblTituloPrincipal;
	}

	public JLabel getLblTipoCocina() {
		return lblTipoCocina;
	}

	public void setLblTipoCocina(JLabel lblTipoCocina) {
		this.lblTipoCocina = lblTipoCocina;
	}

	public JLabel getLblNumeroDias() {
		return lblNumeroDias;
	}

	public void setLblNumeroDias(JLabel lblNumeroDias) {
		this.lblNumeroDias = lblNumeroDias;
	}

	public JLabel getLblFecha() {
		return lblFecha;
	}

	public void setLblFecha(JLabel lblFecha) {
		this.lblFecha = lblFecha;
	}

	public JLabel getLblNumeroPersonas() {
		return lblNumeroPersonas;
	}

	public void setLblNumeroPersonas(JLabel lblNumeroPersonas) {
		this.lblNumeroPersonas = lblNumeroPersonas;
	}

	public JLabel getLblNombre() {
		return lblNombre;
	}

	public void setLblNombre(JLabel lblNombre) {
		this.lblNombre = lblNombre;
	}

	public JLabel getLblTelefono() {
		return lblTelefono;
	}

	public void setLblTelefono(JLabel lblTelefono) {
		this.lblTelefono = lblTelefono;
	}

	public JPanel getPnlDatosContacto() {
		return pnlDatosContacto;
	}

	public void setPnlDatosContacto(JPanel pnlDatosContacto) {
		this.pnlDatosContacto = pnlDatosContacto;
	}

	public JPanel getPnlDatosReserva() {
		return pnlDatosReserva;
	}

	public void setPnlDatosReserva(JPanel pnlDatosReserva) {
		this.pnlDatosReserva = pnlDatosReserva;
	}

	public JPanel getPnlTipoEvento() {
		return pnlTipoEvento;
	}

	public void setPnlTipoEvento(JPanel pnlTipoEvento) {
		this.pnlTipoEvento = pnlTipoEvento;
	}

	public JRadioButton getRdbBanquete() {
		return rdbBanquete;
	}

	public void setRdbBanquete(JRadioButton rdbBanquete) {
		this.rdbBanquete = rdbBanquete;
	}

	public JRadioButton getRdbJornada() {
		return rdbJornada;
	}

	public void setRdbJornada(JRadioButton rdbJornada) {
		this.rdbJornada = rdbJornada;
	}

	public JRadioButton getRdbCongreso() {
		return rdbCongreso;
	}

	public void setRdbCongreso(JRadioButton rdbCongreso) {
		this.rdbCongreso = rdbCongreso;
	}

	public JSpinner getSpnNumeroDias() {
		return spnNumeroDias;
	}

	public void setSpnNumeroDias(JSpinner spnNumeroDias) {
		this.spnNumeroDias = spnNumeroDias;
	}

	public JSpinner getSpnFecha() {
		return spnFecha;
	}

	public void setSpnFecha(JSpinner spnFecha) {
		this.spnFecha = spnFecha;
	}

	public JTextField getTxtNumeroPersonas() {
		return txtNumeroPersonas;
	}

	public void setTxtNumeroPersonas(JTextField txtNumeroPersonas) {
		this.txtNumeroPersonas = txtNumeroPersonas;
	}

	public JTextField getTxtNombre() {
		return txtNombre;
	}

	public void setTxtNombre(JTextField txtNombre) {
		this.txtNombre = txtNombre;
	}

	public JTextField getTxtTelefono() {
		return txtTelefono;
	}

	public void setTxtTelefono(JTextField txtTelefono) {
		this.txtTelefono = txtTelefono;
	}

	public int getANCHO_MARCO() {
		return ANCHO_MARCO;
	}

	public int getALTO_MARCO() {
		return ALTO_MARCO;
	}
	
	
}