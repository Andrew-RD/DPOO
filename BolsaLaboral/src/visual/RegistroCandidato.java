package visual;

import java.awt.BorderLayout;
import exception.*;
import logico.*;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JOptionPane;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.Date;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SpinnerDateModel;
import javax.swing.JSeparator;
import javax.swing.JSpinner;
import javax.swing.border.TitledBorder;
import javax.swing.border.LineBorder;
import javax.swing.JRadioButton;
import javax.swing.UIManager;
import javax.swing.JComboBox;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JCheckBox;
import javax.swing.JToggleButton;
import javax.swing.SpinnerNumberModel;

public class RegistroCandidato extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private Candidato candidatoAct = null;
	private JTextField txtCodigo;
	private JTextField txtNombre;
	private JTextField txtApellido;
	private JTextField txtCedula;
	private JTextField txtCorreo;
	private JTextField txtProvincia;
	private JTextField txtMunicipio;
	private JRadioButton rdTecnico;
	private JRadioButton rdUniversitario;
	private JRadioButton rdObrero;
	private JSpinner spnFechaNac;
	private JTextField txtTelefono;
	private JTextField txtUniversidad;
	private JTextField txtAreaTecnica;
	private JPanel pnlTipoCand;
	private JPanel pnlEstudiante;
	private JPanel pnlTecnico;
	private JPanel pnlObrero;
	private JLabel lblIcoModalidad;
	private JLabel lblIcoJornada;
	private JComboBox cmbJornada;
	private JComboBox cmbModalidad;
	private JLabel lblIcoArea;
	private JComboBox cmbArea;
	/**
	 * Create the dialog.
	 */
	public RegistroCandidato(Candidato cand) {
		setIconImage(Toolkit.getDefaultToolkit().getImage("recursos/icono.png"));
		setResizable(false);
		if(cand == null) {
			setTitle("Registrar Candidato");
		}
		else {
			setTitle("Modificar Candidato");
			candidatoAct = cand;
		}
		setBounds(100, 100, 570, 650);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(228, 228, 228));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		
		JTabbedPane contenedor = new JTabbedPane(JTabbedPane.TOP);
		contenedor.setBackground(new Color(153, 204, 204));
		contenedor.setForeground(Color.BLACK);
		contenedor.setFont(new Font("Segoe UI", Font.BOLD, 18));
		contentPanel.add(contenedor, BorderLayout.CENTER);
		
		JPanel pnlPersonal = new JPanel();
		contenedor.addTab("Personal", null, pnlPersonal, null);
		pnlPersonal.setBackground(new Color(228, 228, 228));
		pnlPersonal.setLayout(null);
		
		JLabel label = new JLabel("C\u00F3digo:");
		label.setFont(new Font("Segoe UI", Font.BOLD, 16));
		label.setBounds(12, 9, 84, 29);
		pnlPersonal.add(label);
		
		txtCodigo = new JTextField();
		txtCodigo.setText("CAN-" + BolsaLaboral.genCodigoCandidato);
		txtCodigo.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		txtCodigo.setEditable(false);
		txtCodigo.setColumns(10);
		txtCodigo.setBounds(106, 13, 305, 22);
		pnlPersonal.add(txtCodigo);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(Color.BLACK);
		separator.setBounds(12, 55, 503, 6);
		pnlPersonal.add(separator);
		
		JLabel lblNombres = new JLabel("Nombres:");
		lblNombres.setFont(new Font("Segoe UI", Font.BOLD, 16));
		lblNombres.setBounds(12, 69, 84, 29);
		pnlPersonal.add(lblNombres);
		
		txtNombre = new JTextField();
		txtNombre.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		txtNombre.setColumns(10);
		txtNombre.setBounds(106, 71, 305, 22);
		pnlPersonal.add(txtNombre);
		
		JLabel lblApellido = new JLabel("Apellidos:");
		lblApellido.setFont(new Font("Segoe UI", Font.BOLD, 16));
		lblApellido.setBounds(12, 121, 84, 29);
		pnlPersonal.add(lblApellido);
		
		txtApellido = new JTextField();
		txtApellido.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		txtApellido.setColumns(10);
		txtApellido.setBounds(106, 123, 305, 22);
		pnlPersonal.add(txtApellido);
		
		JLabel lblCdula = new JLabel("C\u00E9dula:");
		lblCdula.setFont(new Font("Segoe UI", Font.BOLD, 16));
		lblCdula.setBounds(12, 175, 84, 29);
		pnlPersonal.add(lblCdula);
		
		txtCedula = new JTextField();
		txtCedula.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		txtCedula.setColumns(10);
		txtCedula.setBounds(106, 177, 305, 22);
		pnlPersonal.add(txtCedula);
		
		JLabel lblFechaDeNacimiento = new JLabel("Fecha de Nacimiento:");
		lblFechaDeNacimiento.setFont(new Font("Segoe UI", Font.BOLD, 16));
		lblFechaDeNacimiento.setBounds(12, 229, 173, 29);
		pnlPersonal.add(lblFechaDeNacimiento);
		
		spnFechaNac = new JSpinner();
		spnFechaNac.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		spnFechaNac.setBounds(191, 234, 221, 22);
		spnFechaNac.setModel(new SpinnerDateModel(new Date(1751169600000L), new Date(1751169600000L), null, Calendar.DAY_OF_YEAR));
		JSpinner.DateEditor de_spnFechaNac = new JSpinner.DateEditor(spnFechaNac,"dd/MM/yyyy");
		spnFechaNac.setEditor(de_spnFechaNac);
		pnlPersonal.add(spnFechaNac);
		
		JPanel pnlContactos = new JPanel();
		pnlContactos.setLayout(null);
		pnlContactos.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Contactos y Ubicaci\u00F3n", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		pnlContactos.setBackground(new Color(228, 228, 228));
		pnlContactos.setBounds(12, 269, 513, 229);
		pnlPersonal.add(pnlContactos);
		
		JLabel label_1 = new JLabel("Tel\u00E9fono:");
		label_1.setFont(new Font("Segoe UI", Font.BOLD, 16));
		label_1.setBounds(12, 28, 84, 29);
		pnlContactos.add(label_1);
		
		txtTelefono = new JTextField();
		txtTelefono.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		txtTelefono.setColumns(10);
		txtTelefono.setBounds(108, 35, 305, 22);
		pnlContactos.add(txtTelefono);
		
		JLabel label_2 = new JLabel("Correo:");
		label_2.setFont(new Font("Segoe UI", Font.BOLD, 16));
		label_2.setBounds(12, 78, 84, 29);
		pnlContactos.add(label_2);
		
		txtCorreo = new JTextField();
		txtCorreo.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		txtCorreo.setColumns(10);
		txtCorreo.setBounds(108, 81, 305, 22);
		pnlContactos.add(txtCorreo);
		
		txtProvincia = new JTextField();
		txtProvincia.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		txtProvincia.setColumns(10);
		txtProvincia.setBounds(108, 133, 305, 22);
		pnlContactos.add(txtProvincia);
		
		JLabel label_3 = new JLabel("Provincia:");
		label_3.setFont(new Font("Segoe UI", Font.BOLD, 16));
		label_3.setBounds(12, 126, 84, 29);
		pnlContactos.add(label_3);
		
		JLabel label_4 = new JLabel("Municipio:");
		label_4.setFont(new Font("Segoe UI", Font.BOLD, 16));
		label_4.setBounds(12, 179, 84, 29);
		pnlContactos.add(label_4);
		
		txtMunicipio = new JTextField();
		txtMunicipio.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		txtMunicipio.setColumns(10);
		txtMunicipio.setBounds(108, 182, 305, 22);
		pnlContactos.add(txtMunicipio);
		
		JPanel pnlEspecializacion = new JPanel();
		contenedor.addTab("Especializaciones", null, pnlEspecializacion, null);
		pnlEspecializacion.setLayout(null);
		pnlEspecializacion.setBackground(new Color(228, 228, 228));
		
		pnlObrero = new JPanel();
		pnlObrero.setLayout(null);
		pnlObrero.setBorder(new TitledBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)), "Habilidades del Obrero", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		pnlObrero.setBackground(new Color(228, 228, 228));
		pnlObrero.setBounds(12, 97, 510, 210);
		pnlEspecializacion.add(pnlObrero);
		
		JCheckBox chkPlomeria = new JCheckBox("Plomer\u00EDa");
		chkPlomeria.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		chkPlomeria.setBackground(new Color(228, 228, 228));
		chkPlomeria.setBounds(8, 24, 113, 25);
		pnlObrero.add(chkPlomeria);
		
		JCheckBox chkCarpintero = new JCheckBox("Carpinter\u00EDa");
		chkCarpintero.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		chkCarpintero.setBackground(new Color(228, 228, 228));
		chkCarpintero.setBounds(8, 61, 113, 25);
		pnlObrero.add(chkCarpintero);
		
		JCheckBox chkCajero = new JCheckBox("Gesti\u00F3n Financiera");
		chkCajero.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		chkCajero.setBackground(new Color(228, 228, 228));
		chkCajero.setBounds(8, 101, 147, 25);
		pnlObrero.add(chkCajero);
		
		JCheckBox chkSoldadura = new JCheckBox("Soldadura");
		chkSoldadura.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		chkSoldadura.setBackground(new Color(228, 228, 228));
		chkSoldadura.setBounds(8, 143, 113, 25);
		pnlObrero.add(chkSoldadura);
		
		JCheckBox chkElctrica = new JCheckBox("Instalaci\u00F3n El\u00E9ctrica");
		chkElctrica.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		chkElctrica.setBackground(new Color(228, 228, 228));
		chkElctrica.setBounds(8, 181, 147, 25);
		pnlObrero.add(chkElctrica);
		
		JCheckBox chkMecnica = new JCheckBox("Mec\u00E1nica");
		chkMecnica.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		chkMecnica.setBackground(new Color(228, 228, 228));
		chkMecnica.setBounds(181, 25, 113, 25);
		pnlObrero.add(chkMecnica);
		
		JCheckBox chkAlbailera = new JCheckBox("Alba\u00F1iler\u00EDa");
		chkAlbailera.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		chkAlbailera.setBackground(new Color(228, 228, 228));
		chkAlbailera.setBounds(181, 62, 113, 25);
		pnlObrero.add(chkAlbailera);
		
		JCheckBox chkRedes = new JCheckBox("Redes Sociales");
		chkRedes.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		chkRedes.setBackground(new Color(228, 228, 228));
		chkRedes.setBounds(181, 101, 135, 25);
		pnlObrero.add(chkRedes);
		
		JCheckBox chkConduccin = new JCheckBox("Conducci\u00F3n");
		chkConduccin.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		chkConduccin.setBackground(new Color(228, 228, 228));
		chkConduccin.setBounds(181, 143, 113, 25);
		pnlObrero.add(chkConduccin);
		
		JCheckBox chkReparacin = new JCheckBox("Reparaci\u00F3n de Electr\u00F3nicos");
		chkReparacin.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		chkReparacin.setBackground(new Color(228, 228, 228));
		chkReparacin.setBounds(181, 182, 199, 25);
		pnlObrero.add(chkReparacin);
		
		JCheckBox chkVentas = new JCheckBox("Ventas");
		chkVentas.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		chkVentas.setBackground(new Color(228, 228, 228));
		chkVentas.setBounds(389, 25, 113, 25);
		pnlObrero.add(chkVentas);
		
		JCheckBox chkFotografa = new JCheckBox("Fotograf\u00EDa");
		chkFotografa.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		chkFotografa.setBackground(new Color(228, 228, 228));
		chkFotografa.setBounds(389, 62, 113, 25);
		pnlObrero.add(chkFotografa);
		
		JCheckBox chkCocina = new JCheckBox("Cocina");
		chkCocina.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		chkCocina.setBackground(new Color(228, 228, 228));
		chkCocina.setBounds(389, 102, 113, 25);
		pnlObrero.add(chkCocina);
		
		JCheckBox chkLimpieza = new JCheckBox("Limpieza");
		chkLimpieza.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		chkLimpieza.setBackground(new Color(228, 228, 228));
		chkLimpieza.setBounds(389, 144, 113, 25);
		pnlObrero.add(chkLimpieza);
		
		JCheckBox chkPintura = new JCheckBox("Pintura");
		chkPintura.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		chkPintura.setBackground(new Color(228, 228, 228));
		chkPintura.setBounds(389, 182, 113, 25);
		pnlObrero.add(chkPintura);
		
		pnlTipoCand = new JPanel();
		pnlTipoCand.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Tipo de Candidato", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pnlTipoCand.setBackground(new Color(228, 228, 228));
		pnlTipoCand.setBounds(12, 13, 510, 71);
		pnlEspecializacion.add(pnlTipoCand);
		pnlTipoCand.setLayout(null);
		
		rdUniversitario = new JRadioButton("Estudiante Universitario");
		rdUniversitario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cambiarEspecializacion("Estudiante Universitario");
			}
		});
		rdUniversitario.setSelected(true);
		rdUniversitario.setBackground(new Color(228, 228, 228));
		rdUniversitario.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		rdUniversitario.setBounds(29, 26, 182, 25);
		pnlTipoCand.add(rdUniversitario);
		
		rdTecnico = new JRadioButton("Estudiante T\u00E9cnico");
		rdTecnico.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cambiarEspecializacion("Estudiante Tecnico");
			}
		});
		rdTecnico.setBackground(new Color(228, 228, 228));
		rdTecnico.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		rdTecnico.setBounds(215, 26, 149, 25);
		pnlTipoCand.add(rdTecnico);
		
		rdObrero = new JRadioButton("Obrero");
		rdObrero.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cambiarEspecializacion("Obrero");
			}
		});
		rdObrero.setBackground(new Color(228, 228, 228));
		rdObrero.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		rdObrero.setBounds(368, 26, 134, 25);
		pnlTipoCand.add(rdObrero);
		
		ButtonGroup grupo = new ButtonGroup();
		grupo.add(rdObrero);
		grupo.add(rdUniversitario);
		grupo.add(rdTecnico);
		
		pnlEstudiante = new JPanel();
		pnlEstudiante.setBorder(new TitledBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)), "Estudiante Universitario", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		pnlEstudiante.setBounds(12, 97, 510, 210);
		pnlEstudiante.setBackground(new Color(228, 228, 228));
		pnlEspecializacion.add(pnlEstudiante);
		pnlEstudiante.setLayout(null);
		
		JLabel lblCarrera = new JLabel("Carrera:");
		lblCarrera.setFont(new Font("Segoe UI", Font.BOLD, 16));
		lblCarrera.setBounds(12, 25, 84, 29);
		pnlEstudiante.add(lblCarrera);
		
		JLabel lblUniversidad = new JLabel("Universidad:");
		lblUniversidad.setFont(new Font("Segoe UI", Font.BOLD, 16));
		lblUniversidad.setBounds(12, 82, 106, 29);
		pnlEstudiante.add(lblUniversidad);
		
		txtUniversidad = new JTextField();
		txtUniversidad.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		txtUniversidad.setColumns(10);
		txtUniversidad.setBounds(116, 86, 305, 22);
		pnlEstudiante.add(txtUniversidad);
		
		JLabel lblNivelAcadmico = new JLabel("Nivel Acad\u00E9mico:");
		lblNivelAcadmico.setFont(new Font("Segoe UI", Font.BOLD, 16));
		lblNivelAcadmico.setBounds(12, 144, 146, 29);
		pnlEstudiante.add(lblNivelAcadmico);
		
		JComboBox cmbNivel = new JComboBox();
		cmbNivel.setModel(new DefaultComboBoxModel(new String[] {"Grado", "Postgrado", "Doctorado"}));
		cmbNivel.setSelectedIndex(0);
		cmbNivel.setMaximumRowCount(11);
		cmbNivel.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		cmbNivel.setBounds(158, 145, 263, 29);
		pnlEstudiante.add(cmbNivel);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Arquitectura", "Ingenier\u00EDa Civil", "Ingenier\u00EDa El\u00E9ctrica", "Ingenier\u00EDa Telem\u00E1tica", "Ingenier\u00EDa Industrial", "Ingenier\u00EDa Agron\u00F3mica", "Ingenier\u00EDa de Sistemas", "Educaci\u00F3n", "Psicolog\u00EDa", "Comunicaci\u00F3n", "Derecho", "Contabilidad", "Hoteler\u00EDa", "Medicina", "Econom\u00EDa", "Direcci\u00F3n Empresarial"}));
		comboBox.setSelectedIndex(0);
		comboBox.setMaximumRowCount(11);
		comboBox.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		comboBox.setBounds(116, 30, 305, 29);
		pnlEstudiante.add(comboBox);
		
		pnlTecnico = new JPanel();
		pnlTecnico.setBounds(12, 97, 510, 210);
		pnlEspecializacion.add(pnlTecnico);
		pnlTecnico.setLayout(null);
		pnlTecnico.setBorder(new TitledBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)), "Estudiante T\u00E9cnico", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		pnlTecnico.setBackground(new Color(228, 228, 228));
		
		JLabel lblreaTcnica = new JLabel("\u00C1rea T\u00E9cnica:");
		lblreaTcnica.setFont(new Font("Segoe UI", Font.BOLD, 16));
		lblreaTcnica.setBounds(12, 25, 106, 29);
		pnlTecnico.add(lblreaTcnica);
		
		txtAreaTecnica = new JTextField();
		txtAreaTecnica.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		txtAreaTecnica.setColumns(10);
		txtAreaTecnica.setBounds(130, 29, 305, 22);
		pnlTecnico.add(txtAreaTecnica);
		
		JLabel lblAosDeExperiencia = new JLabel("A\u00F1os de Experiencia:");
		lblAosDeExperiencia.setFont(new Font("Segoe UI", Font.BOLD, 16));
		lblAosDeExperiencia.setBounds(12, 82, 168, 29);
		pnlTecnico.add(lblAosDeExperiencia);
		
		JSpinner spnAniosExp = new JSpinner();
		spnAniosExp.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		spnAniosExp.setBounds(177, 86, 258, 22);
		pnlTecnico.add(spnAniosExp);
		
		JPanel pnlIdiomas = new JPanel();
		pnlIdiomas.setLayout(null);
		pnlIdiomas.setBorder(new TitledBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)), "Idiomas", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		pnlIdiomas.setBackground(new Color(228, 228, 228));
		pnlIdiomas.setBounds(12, 317, 510, 145);
		pnlEspecializacion.add(pnlIdiomas);
		
		JCheckBox chckbxIngls = new JCheckBox("Ingl\u00E9s");
		chckbxIngls.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		chckbxIngls.setBackground(new Color(228, 228, 228));
		chckbxIngls.setBounds(8, 24, 113, 25);
		pnlIdiomas.add(chckbxIngls);
		
		JCheckBox chckbxItaliano = new JCheckBox("Italiano");
		chckbxItaliano.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		chckbxItaliano.setBackground(new Color(228, 228, 228));
		chckbxItaliano.setBounds(8, 61, 113, 25);
		pnlIdiomas.add(chckbxItaliano);
		
		JCheckBox chckbxEspaol = new JCheckBox("Espa\u00F1ol");
		chckbxEspaol.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		chckbxEspaol.setBackground(new Color(228, 228, 228));
		chckbxEspaol.setBounds(8, 101, 113, 25);
		pnlIdiomas.add(chckbxEspaol);
		
		JCheckBox chckbxFrancs = new JCheckBox("Franc\u00E9s");
		chckbxFrancs.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		chckbxFrancs.setBackground(new Color(228, 228, 228));
		chckbxFrancs.setBounds(181, 101, 113, 25);
		pnlIdiomas.add(chckbxFrancs);
		
		JCheckBox chckbxPortugus = new JCheckBox("Portugu\u00E9s");
		chckbxPortugus.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		chckbxPortugus.setBackground(new Color(228, 228, 228));
		chckbxPortugus.setBounds(181, 25, 113, 25);
		pnlIdiomas.add(chckbxPortugus);
		
		JCheckBox chckbxAlemn = new JCheckBox("Alem\u00E1n");
		chckbxAlemn.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		chckbxAlemn.setBackground(new Color(228, 228, 228));
		chckbxAlemn.setBounds(181, 62, 113, 25);
		pnlIdiomas.add(chckbxAlemn);
		
		JCheckBox chckbxMandarn = new JCheckBox("Chino");
		chckbxMandarn.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		chckbxMandarn.setBackground(new Color(228, 228, 228));
		chckbxMandarn.setBounds(389, 25, 113, 25);
		pnlIdiomas.add(chckbxMandarn);
		
		JCheckBox chckbxCoreano = new JCheckBox("Coreano");
		chckbxCoreano.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		chckbxCoreano.setBackground(new Color(228, 228, 228));
		chckbxCoreano.setBounds(389, 62, 113, 25);
		pnlIdiomas.add(chckbxCoreano);
		
		JCheckBox chckbxJapons = new JCheckBox("Japon\u00E9s");
		chckbxJapons.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		chckbxJapons.setBackground(new Color(228, 228, 228));
		chckbxJapons.setBounds(389, 101, 113, 25);
		pnlIdiomas.add(chckbxJapons);
		
		JLabel lbltieneLicenciaDe = new JLabel("\u00BFTiene licencia de conducir?");
		lbltieneLicenciaDe.setFont(new Font("Segoe UI", Font.BOLD, 16));
		lbltieneLicenciaDe.setBounds(12, 475, 219, 29);
		pnlEspecializacion.add(lbltieneLicenciaDe);
		
		JCheckBox checkBox = new JCheckBox("");
		checkBox.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		checkBox.setBackground(new Color(228, 228, 228));
		checkBox.setBounds(239, 478, 39, 25);
		pnlEspecializacion.add(checkBox);
		
		JPanel pnlPreferencias = new JPanel();
		pnlPreferencias.setBackground(new Color(228, 228, 228));
		contenedor.addTab("Preferencias", null, pnlPreferencias, null);
		pnlPreferencias.setLayout(null);
		
		JLabel lblModalidad = new JLabel("Modalidad:");
		lblModalidad.setFont(new Font("Segoe UI", Font.BOLD, 16));
		lblModalidad.setBounds(12, 17, 106, 29);
		pnlPreferencias.add(lblModalidad);
		
		cmbModalidad = new JComboBox();
		cmbModalidad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cargarModalidad();
			}
		});
		cmbModalidad.setModel(new DefaultComboBoxModel(new String[] {"Presencial", "Remoto", "H\u00EDbrido"}));
		cmbModalidad.setMaximumRowCount(11);
		cmbModalidad.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		cmbModalidad.setBounds(111, 18, 305, 29);
		pnlPreferencias.add(cmbModalidad);
		
		lblIcoModalidad = new JLabel("");
		lblIcoModalidad.setFont(new Font("Segoe UI", Font.BOLD, 16));
		lblIcoModalidad.setBounds(433, 17, 32, 32);
		pnlPreferencias.add(lblIcoModalidad);
		
		JLabel lblJornada = new JLabel("Jornada:");
		lblJornada.setFont(new Font("Segoe UI", Font.BOLD, 16));
		lblJornada.setBounds(12, 71, 106, 29);
		pnlPreferencias.add(lblJornada);
		
		cmbJornada = new JComboBox();
		cmbJornada.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cargarJornada();
			}
		});
		cmbJornada.setModel(new DefaultComboBoxModel(new String[] {"Tiempo Completo", "Medio Tiempo", "Jornada Nocturna", "Jornada Rotativa"}));
		
		cmbJornada.setMaximumRowCount(11);
		cmbJornada.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		cmbJornada.setBounds(111, 72, 305, 29);
		pnlPreferencias.add(cmbJornada);
		
		lblIcoJornada = new JLabel("");
		lblIcoJornada.setFont(new Font("Segoe UI", Font.BOLD, 16));
		lblIcoJornada.setBounds(433, 69, 32, 32);
		pnlPreferencias.add(lblIcoJornada);
		
		JLabel lblrea = new JLabel("\u00C1rea:");
		lblrea.setFont(new Font("Segoe UI", Font.BOLD, 16));
		lblrea.setBounds(12, 127, 106, 29);
		pnlPreferencias.add(lblrea);
		
		cmbArea = new JComboBox();
		cmbArea.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cargarArea();
			}
		});
		cmbArea.setModel(new DefaultComboBoxModel(new String[] {"No definido", "Finanzas", "Recursos Humanos", "Marketing", "Limpieza", "Seguridad", "TI", "Operaciones", "Administraci\u00F3n", "Atenci\u00F3n al Cliente"}));
		cmbArea.setMaximumRowCount(11);
		cmbArea.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		cmbArea.setBounds(111, 128, 305, 29);
		pnlPreferencias.add(cmbArea);
		
		lblIcoArea = new JLabel("");
		lblIcoArea.setFont(new Font("Segoe UI", Font.BOLD, 16));
		lblIcoArea.setBounds(428, 127, 32, 32);
		pnlPreferencias.add(lblIcoArea);
		
		JLabel lblSalarioEsperado = new JLabel("Salario Esperado:");
		lblSalarioEsperado.setFont(new Font("Segoe UI", Font.BOLD, 16));
		lblSalarioEsperado.setBounds(12, 195, 144, 29);
		pnlPreferencias.add(lblSalarioEsperado);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setForeground(Color.BLACK);
		separator_1.setBounds(12, 176, 503, 6);
		pnlPreferencias.add(separator_1);
		
		JLabel lblestaraDispuestoA = new JLabel("\u00BFEstar\u00EDa dispuesto a mudarse si es requerido?");
		lblestaraDispuestoA.setFont(new Font("Segoe UI", Font.BOLD, 16));
		lblestaraDispuestoA.setBounds(12, 248, 359, 29);
		pnlPreferencias.add(lblestaraDispuestoA);
		{
			JPanel pnlInferior = new JPanel();
			pnlInferior.setBackground(new Color(92, 131, 116));
			pnlInferior.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(pnlInferior, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Confimar");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						try {
							if(verificar()) {
								
							}
							else {
								JOptionPane.showMessageDialog(null,"Todos los registros son obligatorios.","Advertencia",JOptionPane.WARNING_MESSAGE);
							}
						} catch (FormatException ex) {
							JOptionPane.showMessageDialog(null,ex.getMessage(),"Advertencia",JOptionPane.WARNING_MESSAGE);
						}
					}
				});
				okButton.setFont(new Font("Segoe UI", Font.PLAIN, 16));
				if(candidatoAct == null) {
					okButton.setText("Registrar");
					okButton.setIcon(new ImageIcon("recursos/agregarP.png"));
					
				}
				else {
					okButton.setText("Modificar");
					okButton.setIcon(new ImageIcon("recursos/editar.png"));
				}
				
				JButton btnLimpiar = new JButton("Limpiar");
				btnLimpiar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						limpiar();
					}
				});
				btnLimpiar.setFont(new Font("Segoe UI", Font.PLAIN, 16));
				btnLimpiar.setActionCommand("OK");
				pnlInferior.add(btnLimpiar);
				okButton.setActionCommand("OK");
				pnlInferior.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancelar");
				cancelButton.setFont(new Font("Segoe UI", Font.PLAIN, 16));
				cancelButton.setIcon(new ImageIcon("recursos/cerrar.png"));
				cancelButton.setActionCommand("Cancel");
				pnlInferior.add(cancelButton);
			}
		}
		cmbJornada.setSelectedIndex(0);
		cmbArea.setSelectedIndex(0);
		cmbModalidad.setSelectedIndex(0);
		
		JSpinner spnSalarioEsperado = new JSpinner();
		spnSalarioEsperado.setModel(new SpinnerNumberModel(new Float(12000), new Float(12000), null, new Float(1)));
		spnSalarioEsperado.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		spnSalarioEsperado.setBounds(154, 200, 262, 22);
		pnlPreferencias.add(spnSalarioEsperado);
		
		JCheckBox checkBox_1 = new JCheckBox("");
		checkBox_1.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		checkBox_1.setBackground(new Color(228, 228, 228));
		checkBox_1.setBounds(359, 252, 39, 25);
		pnlPreferencias.add(checkBox_1);
		
		JLabel lblposeeTrabajoActualmente = new JLabel("\u00BFPosee trabajo actualmente?");
		lblposeeTrabajoActualmente.setFont(new Font("Segoe UI", Font.BOLD, 16));
		lblposeeTrabajoActualmente.setBounds(12, 296, 232, 29);
		pnlPreferencias.add(lblposeeTrabajoActualmente);
		
		JCheckBox chkTrabajo = new JCheckBox("");
		chkTrabajo.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		chkTrabajo.setBackground(new Color(228, 228, 228));
		chkTrabajo.setBounds(240, 300, 39, 25);
		pnlPreferencias.add(chkTrabajo);
		cargarDatos();
		cambiarEspecializacion("Estudiante Universitario");
	}
	
	private void cambiarEspecializacion(String especializacion) {
		if(especializacion.equalsIgnoreCase("Obrero")) {
			pnlEstudiante.setVisible(false);
			pnlTecnico.setVisible(false);
			pnlObrero.setVisible(true);
		}
		else if(especializacion.equalsIgnoreCase("Estudiante Universitario")) {
			pnlObrero.setVisible(false);
			pnlTecnico.setVisible(false);
			pnlEstudiante.setVisible(true);
		}
		else if(especializacion.equalsIgnoreCase("Estudiante Tecnico")) {
			pnlEstudiante.setVisible(false);
			pnlObrero.setVisible(false);
			pnlTecnico.setVisible(true);
		}
	}
	
	private void cargarArea() {
		String nombreArea = cmbArea.getSelectedItem().toString().toLowerCase();
		nombreArea = nombreArea.replace("ó","o");
		nombreArea = nombreArea.replace(" ","");

		lblIcoArea.setIcon(new ImageIcon("recursos/" + nombreArea + ".png"));
	}
	
	private void cargarJornada() {
		String nombreJornada = cmbJornada.getSelectedItem().toString().toLowerCase();
		nombreJornada = nombreJornada.replace(" ","");
		lblIcoJornada.setIcon(new ImageIcon("recursos/" + nombreJornada + ".png"));
	}
	
	private void cargarModalidad() {
		String nombreModalidad = cmbModalidad.getSelectedItem().toString().toLowerCase();
		nombreModalidad = nombreModalidad.replace("í","i");
		lblIcoModalidad.setIcon(new ImageIcon("recursos/" + nombreModalidad + ".png"));
	}
	
	private void cargarDatos() {
		
	}
	
	private void limpiar() {
		
	}
	
	private boolean verificar() throws FormatException{
		return true;
	}
}
