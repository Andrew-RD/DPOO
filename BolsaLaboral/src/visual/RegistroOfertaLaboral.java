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
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JSeparator;
import javax.swing.JSpinner;
import javax.swing.border.TitledBorder;
import javax.swing.border.LineBorder;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JCheckBox;
import javax.swing.SpinnerNumberModel;
import javax.swing.JTextArea;

public class RegistroOfertaLaboral extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private OfertaLaboral ofertaAct = null;
	private ArrayList<String> ofertadores = null;
	private JTextField txtCodigo;
	private JTextField txtPuesto;
	private JRadioButton rdTecnico;
	private JRadioButton rdUniversitario;
	private JRadioButton rdObrero;
	private JPanel pnlTipoCand;
	private JLabel lblIcoModalidad;
	private JLabel lblIcoJornada;
	private JComboBox cmbJornada;
	private JComboBox cmbModalidad;
	private JComboBox cmbArea;
	private JLabel lblIcoArea;
	private JPanel pnlTecnico;
	private JPanel pnlCarreras;
	private JPanel pnlObrero;
	private JComboBox cmbOfertador;
	private JSpinner spnSalario;
	private JTextArea txtDescripcion;
	private JSpinner spnVacantes;
	private JComboBox cmbHabilidad;

	private JCheckBox chckbxIngls, chckbxPortugus, chckbxItaliano, chckbxAlemn,
	chckbxMandarn, chckbxCoreano, chckbxEspaol, chckbxFrancs, chckbxJapons;

	private JCheckBox chkbxMayor;
	private JCheckBox chkReubicacion;

	private JCheckBox chkARQ, chkICV, chkIEL, chkDER, chkIST, chkIT,
	chkMKT, chkCTB, chkCOM, chkMED, chkEDU, chkPSI,
	chkII, chkHOT, chkNUT, chkDE, chkECO, chkIAG;

	private JCheckBox[] checkIdiomas, checkHabilidades;
	private JComboBox cmbAreaTecnica;
	private JSpinner spnAniosExp;

	/**
	 * Create the dialog.
	 * @wbp.parser.constructor
	 */
	public RegistroOfertaLaboral(JDialog parent, OfertaLaboral oferta) {
		super(parent, true);
		setIconImage(Toolkit.getDefaultToolkit().getImage("recursos/icono.png"));
		setResizable(false);
		if(oferta == null) {
			setTitle("Registrar Oferta Laboral");
		}
		else {
			setTitle("Modificar Oferta Laboral");
			ofertaAct = oferta;
		}
		setBounds(100, 100, 570, 662);
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

		JPanel pnlGeneralidades = new JPanel();
		contenedor.addTab("Generalidades", null, pnlGeneralidades, null);
		pnlGeneralidades.setBackground(new Color(228, 228, 228));
		pnlGeneralidades.setLayout(null);

		JLabel label = new JLabel("C\u00F3digo:");
		label.setFont(new Font("Segoe UI", Font.BOLD, 16));
		label.setBounds(12, 9, 84, 29);
		pnlGeneralidades.add(label);

		txtCodigo = new JTextField();
		txtCodigo.setText("OFR-" + BolsaLaboral.genCodigoOferta);
		txtCodigo.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		txtCodigo.setEditable(false);
		txtCodigo.setColumns(10);
		txtCodigo.setBounds(127, 15, 305, 22);
		pnlGeneralidades.add(txtCodigo);

		JSeparator separator = new JSeparator();
		separator.setForeground(Color.BLACK);
		separator.setBounds(12, 55, 503, 6);
		pnlGeneralidades.add(separator);

		JLabel lblNombres = new JLabel("Puesto:");
		lblNombres.setFont(new Font("Segoe UI", Font.BOLD, 16));
		lblNombres.setBounds(12, 69, 84, 29);
		pnlGeneralidades.add(lblNombres);

		txtPuesto = new JTextField();
		txtPuesto.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		txtPuesto.setColumns(10);
		txtPuesto.setBounds(127, 73, 305, 22);
		pnlGeneralidades.add(txtPuesto);

		JLabel lblApellido = new JLabel("Ofertador:");
		lblApellido.setFont(new Font("Segoe UI", Font.BOLD, 16));
		lblApellido.setBounds(12, 121, 84, 29);
		pnlGeneralidades.add(lblApellido);

		JLabel lblCdula = new JLabel("Salario:");
		lblCdula.setFont(new Font("Segoe UI", Font.BOLD, 16));
		lblCdula.setBounds(12, 175, 84, 29);
		pnlGeneralidades.add(lblCdula);

		cmbOfertador = new JComboBox();
		DefaultComboBoxModel<String> modelo = new DefaultComboBoxModel<>();
		modelo.addElement("<Seleccione un ofertador>");

		for(CentroEmpleador centro : BolsaLaboral.getInstancia().getCentros()) {
			modelo.addElement(centro.getCodigo() + " : " + centro.getNombre());
		}

		cmbOfertador.setModel(modelo);
		cmbOfertador.setSelectedIndex(0);
		cmbOfertador.setMaximumRowCount(modelo.getSize());
		cmbOfertador.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		cmbOfertador.setBounds(127, 124, 305, 29);
		pnlGeneralidades.add(cmbOfertador);

		spnSalario = new JSpinner();
		spnSalario.setModel(new SpinnerNumberModel(new Float(12000), new Float(12000), null, new Float(1)));
		spnSalario.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		spnSalario.setBounds(127, 182, 305, 22);
		pnlGeneralidades.add(spnSalario);

		JLabel lblDescripcin = new JLabel("Descripci\u00F3n:");
		lblDescripcin.setFont(new Font("Segoe UI", Font.BOLD, 16));
		lblDescripcin.setBounds(12, 230, 108, 29);
		pnlGeneralidades.add(lblDescripcin);

		txtDescripcion = new JTextArea();
		txtDescripcion.setBounds(127, 235, 305, 107);
		pnlGeneralidades.add(txtDescripcion);

		JLabel lblCantVacantes = new JLabel("Vacantes:");
		lblCantVacantes.setFont(new Font("Segoe UI", Font.BOLD, 16));
		lblCantVacantes.setBounds(12, 367, 108, 29);
		pnlGeneralidades.add(lblCantVacantes);

		spnVacantes = new JSpinner();
		spnVacantes.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), null, new Integer(1)));
		spnVacantes.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		spnVacantes.setBounds(127, 371, 305, 22);
		pnlGeneralidades.add(spnVacantes);

		JLabel label_1 = new JLabel("\u00C1rea:");
		label_1.setFont(new Font("Segoe UI", Font.BOLD, 16));
		label_1.setBounds(12, 419, 106, 29);
		pnlGeneralidades.add(label_1);

		cmbArea = new JComboBox();
		cmbArea.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cargarArea();
			}
		});
		cmbArea.setModel(new DefaultComboBoxModel(new String[] {"No definido", "Finanzas", "Recursos Humanos", "Marketing", "Limpieza", "Seguridad", "TI", "Salud", "Operaciones", "Administraci\u00F3n", "Atenci\u00F3n al Cliente", "Educaci\u00F3n"}));
		cmbArea.setMaximumRowCount(12);
		cmbArea.setMaximumRowCount(11);
		cmbArea.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		cmbArea.setBounds(127, 417, 305, 29);
		pnlGeneralidades.add(cmbArea);

		lblIcoArea = new JLabel("");
		lblIcoArea.setFont(new Font("Segoe UI", Font.BOLD, 16));
		lblIcoArea.setBounds(444, 416, 32, 32);
		pnlGeneralidades.add(lblIcoArea);

		JPanel pnlEspecializacion = new JPanel();
		contenedor.addTab("Requerimientos", null, pnlEspecializacion, null);
		pnlEspecializacion.setLayout(null);
		pnlEspecializacion.setBackground(new Color(228, 228, 228));

		pnlTecnico = new JPanel();
		pnlTecnico.setLayout(null);
		pnlTecnico.setBorder(new TitledBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)), "Requerimientos T\u00E9cnicos", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		pnlTecnico.setBackground(new Color(228, 228, 228));
		pnlTecnico.setBounds(12, 97, 510, 265);
		pnlEspecializacion.add(pnlTecnico);

		cmbAreaTecnica = new JComboBox();
		cmbAreaTecnica.setModel(new DefaultComboBoxModel(new String[] {"Gesti\u00F3n de Talento Humano", "Impuestos y Contabilidad", "Publicidad", "Gesti\u00F3n Comercial", "Higiene y Seguridad Industrial", "Mantenimiento de Instalaciones", "Protecci\u00F3n Civil", "Protecci\u00F3n Industrial", "Redes de Datos", "Desarrollo de Software", "Log\u00EDstica Industrial", "Gesti\u00F3n Empresarial", "Atenci\u00F3n Comercial", "Automatizaci\u00F3n", "Dise\u00F1o Gr\u00E1fico", "Ciberseguridad", "Rob\u00F3tica", "Medios Digitales"}));
		cmbAreaTecnica.setSelectedIndex(0);
		cmbAreaTecnica.setMaximumRowCount(11);
		cmbAreaTecnica.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		cmbAreaTecnica.setBounds(150, 34, 305, 29);
		pnlTecnico.add(cmbAreaTecnica);

		JLabel lblreaRequerida = new JLabel("\u00C1rea requerida:");
		lblreaRequerida.setFont(new Font("Segoe UI", Font.BOLD, 16));
		lblreaRequerida.setBounds(12, 33, 123, 29);
		pnlTecnico.add(lblreaRequerida);

		spnAniosExp = new JSpinner();
		spnAniosExp.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		spnAniosExp.setBounds(181, 89, 274, 22);
		pnlTecnico.add(spnAniosExp);

		JLabel lblMnimoDeExperiencia = new JLabel("A\u00F1os de experiencia:");
		lblMnimoDeExperiencia.setFont(new Font("Segoe UI", Font.BOLD, 16));
		lblMnimoDeExperiencia.setBounds(12, 85, 171, 29);
		pnlTecnico.add(lblMnimoDeExperiencia);

		pnlObrero = new JPanel();
		pnlObrero.setLayout(null);
		pnlObrero.setBorder(new TitledBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)), "Requerimientos del Obrero", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		pnlObrero.setBackground(new Color(228, 228, 228));
		pnlObrero.setBounds(12, 97, 510, 265);
		pnlEspecializacion.add(pnlObrero);

		cmbHabilidad = new JComboBox();
		cmbHabilidad.setModel(new DefaultComboBoxModel(new String[] {"Plomer\u00EDa", "Carpinter\u00EDa", "Gesti\u00F3n Financiera", "Instalaci\u00F3n El\u00E9ctrica", "Soldadura", "Mec\u00E1nica", "Alba\u00F1iler\u00EDa", "Redes Sociales", "Conducci\u00F3n", "Reparaci\u00F3n de Electr\u00F3nicos", "Ventas", "Fotograf\u00EDa", "Cocina", "Limpieza", "Pintura"}));
		cmbHabilidad.setSelectedIndex(0);
		cmbHabilidad.setMaximumRowCount(11);
		cmbHabilidad.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		cmbHabilidad.setBounds(181, 34, 274, 29);
		pnlObrero.add(cmbHabilidad);

		JLabel lblHabilidadRequerida = new JLabel("Habilidad requerida:");
		lblHabilidadRequerida.setFont(new Font("Segoe UI", Font.BOLD, 16));
		lblHabilidadRequerida.setBounds(12, 33, 171, 29);
		pnlObrero.add(lblHabilidadRequerida);

		pnlTipoCand = new JPanel();
		pnlTipoCand.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Nivel Acad\u00E9mico Requerido", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
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

		JPanel pnlIdiomas = new JPanel();
		pnlIdiomas.setBounds(12, 375, 510, 145);
		pnlEspecializacion.add(pnlIdiomas);
		pnlIdiomas.setLayout(null);
		pnlIdiomas.setBorder(new TitledBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)), "Idiomas Requeridos", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		pnlIdiomas.setBackground(new Color(228, 228, 228));

		chckbxIngls = new JCheckBox("Ingl\u00E9s");
		chckbxIngls.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		chckbxIngls.setBackground(new Color(228, 228, 228));
		chckbxIngls.setBounds(8, 24, 113, 25);
		pnlIdiomas.add(chckbxIngls);

		chckbxItaliano = new JCheckBox("Italiano");
		chckbxItaliano.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		chckbxItaliano.setBackground(new Color(228, 228, 228));
		chckbxItaliano.setBounds(8, 61, 113, 25);
		pnlIdiomas.add(chckbxItaliano);

		chckbxEspaol = new JCheckBox("Espa\u00F1ol");
		chckbxEspaol.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		chckbxEspaol.setBackground(new Color(228, 228, 228));
		chckbxEspaol.setBounds(8, 101, 113, 25);
		pnlIdiomas.add(chckbxEspaol);

		chckbxFrancs = new JCheckBox("Franc\u00E9s");
		chckbxFrancs.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		chckbxFrancs.setBackground(new Color(228, 228, 228));
		chckbxFrancs.setBounds(181, 101, 113, 25);
		pnlIdiomas.add(chckbxFrancs);

		chckbxPortugus = new JCheckBox("Portugu\u00E9s");
		chckbxPortugus.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		chckbxPortugus.setBackground(new Color(228, 228, 228));
		chckbxPortugus.setBounds(181, 25, 113, 25);
		pnlIdiomas.add(chckbxPortugus);

		chckbxAlemn = new JCheckBox("Alem\u00E1n");
		chckbxAlemn.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		chckbxAlemn.setBackground(new Color(228, 228, 228));
		chckbxAlemn.setBounds(181, 62, 113, 25);
		pnlIdiomas.add(chckbxAlemn);

		chckbxMandarn = new JCheckBox("Chino");
		chckbxMandarn.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		chckbxMandarn.setBackground(new Color(228, 228, 228));
		chckbxMandarn.setBounds(389, 25, 113, 25);
		pnlIdiomas.add(chckbxMandarn);

		chckbxCoreano = new JCheckBox("Coreano");
		chckbxCoreano.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		chckbxCoreano.setBackground(new Color(228, 228, 228));
		chckbxCoreano.setBounds(389, 62, 113, 25);
		pnlIdiomas.add(chckbxCoreano);

		chckbxJapons = new JCheckBox("Japon\u00E9s");
		chckbxJapons.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		chckbxJapons.setBackground(new Color(228, 228, 228));
		chckbxJapons.setBounds(389, 101, 113, 25);
		pnlIdiomas.add(chckbxJapons);

		pnlCarreras = new JPanel();
		pnlCarreras.setLayout(null);
		pnlCarreras.setBorder(new TitledBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)), "Carreras Permitidas", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		pnlCarreras.setBackground(new Color(228, 228, 228));
		pnlCarreras.setBounds(12, 97, 510, 265);
		pnlEspecializacion.add(pnlCarreras);

		chkARQ = new JCheckBox("Arquitectura");
		chkARQ.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		chkARQ.setBackground(new Color(228, 228, 228));
		chkARQ.setBounds(8, 25, 113, 25);
		pnlCarreras.add(chkARQ);

		chkICV = new JCheckBox("Ingenier\u00EDa Civil");
		chkICV.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		chkICV.setBackground(new Color(228, 228, 228));
		chkICV.setBounds(8, 66, 123, 25);
		pnlCarreras.add(chkICV);

		chkIEL = new JCheckBox("Ingenier\u00EDa El\u00E9ctrica");
		chkIEL.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		chkIEL.setBackground(new Color(228, 228, 228));
		chkIEL.setBounds(8, 107, 148, 25);
		pnlCarreras.add(chkIEL);

		chkDER = new JCheckBox("Derecho");
		chkDER.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		chkDER.setBackground(new Color(228, 228, 228));
		chkDER.setBounds(182, 25, 92, 25);
		pnlCarreras.add(chkDER);

		chkIST = new JCheckBox("Ingenier\u00EDa de Sistemas");
		chkIST.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		chkIST.setBackground(new Color(228, 228, 228));
		chkIST.setBounds(8, 150, 171, 25);
		pnlCarreras.add(chkIST);

		chkIT = new JCheckBox("Ingenier\u00EDa Telem\u00E1tica");
		chkIT.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		chkIT.setBackground(new Color(228, 228, 228));
		chkIT.setBounds(8, 192, 171, 25);
		pnlCarreras.add(chkIT);

		chkMKT = new JCheckBox("Marketing");
		chkMKT.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		chkMKT.setBackground(new Color(228, 228, 228));
		chkMKT.setBounds(182, 67, 148, 25);
		pnlCarreras.add(chkMKT);

		chkCTB = new JCheckBox("Contabilidad");
		chkCTB.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		chkCTB.setBackground(new Color(228, 228, 228));
		chkCTB.setBounds(182, 108, 148, 25);
		pnlCarreras.add(chkCTB);

		chkCOM = new JCheckBox("Comunicaci\u00F3n");
		chkCOM.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		chkCOM.setBackground(new Color(228, 228, 228));
		chkCOM.setBounds(182, 151, 148, 25);
		pnlCarreras.add(chkCOM);

		chkMED = new JCheckBox("Medicina");
		chkMED.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		chkMED.setBackground(new Color(228, 228, 228));
		chkMED.setBounds(182, 193, 148, 25);
		pnlCarreras.add(chkMED);

		chkEDU = new JCheckBox("Educaci\u00F3n");
		chkEDU.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		chkEDU.setBackground(new Color(228, 228, 228));
		chkEDU.setBounds(8, 231, 171, 25);
		pnlCarreras.add(chkEDU);

		chkPSI = new JCheckBox("Psicolog\u00EDa");
		chkPSI.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		chkPSI.setBackground(new Color(228, 228, 228));
		chkPSI.setBounds(182, 232, 148, 25);
		pnlCarreras.add(chkPSI);

		chkII = new JCheckBox("Ingenier\u00EDa Industrial");
		chkII.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		chkII.setBackground(new Color(228, 228, 228));
		chkII.setBounds(331, 26, 171, 25);
		pnlCarreras.add(chkII);

		chkHOT = new JCheckBox("Hoteler\u00EDa");
		chkHOT.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		chkHOT.setBackground(new Color(228, 228, 228));
		chkHOT.setBounds(331, 67, 171, 25);
		pnlCarreras.add(chkHOT);

		chkDE = new JCheckBox("Direcci\u00F3n Empresarial");
		chkDE.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		chkDE.setBackground(new Color(228, 228, 228));
		chkDE.setBounds(331, 108, 171, 25);
		pnlCarreras.add(chkDE);

		chkNUT = new JCheckBox("Nutrici\u00F3n");
		chkNUT.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		chkNUT.setBackground(new Color(228, 228, 228));
		chkNUT.setBounds(331, 151, 171, 25);
		pnlCarreras.add(chkNUT);

		chkECO = new JCheckBox("Econom\u00EDa");
		chkECO.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		chkECO.setBackground(new Color(228, 228, 228));
		chkECO.setBounds(331, 193, 171, 25);
		pnlCarreras.add(chkECO);

		chkIAG = new JCheckBox("Ingenier\u00EDa Agron\u00F3mica");
		chkIAG.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		chkIAG.setBackground(new Color(228, 228, 228));
		chkIAG.setBounds(331, 231, 171, 25);
		pnlCarreras.add(chkIAG);

		JPanel pnlCondiciones = new JPanel();
		pnlCondiciones.setBackground(new Color(228, 228, 228));
		contenedor.addTab("Laboral", null, pnlCondiciones, null);
		pnlCondiciones.setLayout(null);

		JLabel lblModalidad = new JLabel("Modalidad:");
		lblModalidad.setFont(new Font("Segoe UI", Font.BOLD, 16));
		lblModalidad.setBounds(12, 17, 106, 29);
		pnlCondiciones.add(lblModalidad);

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
		pnlCondiciones.add(cmbModalidad);

		lblIcoModalidad = new JLabel("");
		lblIcoModalidad.setFont(new Font("Segoe UI", Font.BOLD, 16));
		lblIcoModalidad.setBounds(433, 17, 32, 32);
		pnlCondiciones.add(lblIcoModalidad);

		JLabel lblJornada = new JLabel("Jornada:");
		lblJornada.setFont(new Font("Segoe UI", Font.BOLD, 16));
		lblJornada.setBounds(12, 71, 106, 29);
		pnlCondiciones.add(lblJornada);

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
		pnlCondiciones.add(cmbJornada);

		lblIcoJornada = new JLabel("");
		lblIcoJornada.setFont(new Font("Segoe UI", Font.BOLD, 16));
		lblIcoJornada.setBounds(433, 69, 32, 32);
		pnlCondiciones.add(lblIcoJornada);

		JLabel lblestaraDispuestoA = new JLabel("\u00BFOfrece reubicaci\u00F3n?");
		lblestaraDispuestoA.setFont(new Font("Segoe UI", Font.BOLD, 16));
		lblestaraDispuestoA.setBounds(12, 185, 175, 29);
		pnlCondiciones.add(lblestaraDispuestoA);
		cmbJornada.setSelectedIndex(0);
		cmbModalidad.setSelectedIndex(0);

		chkReubicacion = new JCheckBox("");
		chkReubicacion.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		chkReubicacion.setBackground(new Color(228, 228, 228));
		chkReubicacion.setBounds(182, 189, 39, 25);
		pnlCondiciones.add(chkReubicacion);

		JSeparator separator_1 = new JSeparator();
		separator_1.setForeground(Color.BLACK);
		separator_1.setBounds(12, 132, 503, 6);
		pnlCondiciones.add(separator_1);

		JLabel lblesObligatorioSer = new JLabel("\u00BFEs obligatorio ser mayor de edad?");
		lblesObligatorioSer.setFont(new Font("Segoe UI", Font.BOLD, 16));
		lblesObligatorioSer.setBounds(12, 147, 269, 29);
		pnlCondiciones.add(lblesObligatorioSer);

		chkbxMayor = new JCheckBox("");
		chkbxMayor.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		chkbxMayor.setBackground(new Color(228, 228, 228));
		chkbxMayor.setBounds(289, 151, 39, 25);
		pnlCondiciones.add(chkbxMayor);

		JPanel pnlInferior = new JPanel();
		pnlInferior.setBackground(new Color(24, 61, 61));
		pnlInferior.setLayout(new FlowLayout(FlowLayout.RIGHT));
		getContentPane().add(pnlInferior, BorderLayout.SOUTH);
		{
			JButton okButton = new JButton("Confimar");
			okButton.setBackground(Color.WHITE);
			okButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try {
						if(verificar()) {
							if(ofertaAct != null) {
								ofertaAct.setPuesto(txtPuesto.getText());
								ofertaAct.setDescripcion(txtDescripcion.getText());
								ofertaAct.setSalario((float)spnSalario.getValue());
								ofertaAct.setVacantes((int)spnVacantes.getValue());
								ofertaAct.setOfertador(BolsaLaboral.getInstancia().getCentros().get(cmbOfertador.getSelectedIndex() - 1));
								ofertaAct.setArea((String)cmbArea.getSelectedItem());
								ofertaAct.setModalidad((String)cmbModalidad.getSelectedItem());
								ofertaAct.setJornada((String)cmbJornada.getSelectedItem());
								ofertaAct.setObligatorioMayorDeEdad(chkbxMayor.isSelected());
								ofertaAct.setOfreceReubicacion(chkReubicacion.isSelected());

								for(JCheckBox cbIdioma : checkIdiomas) {
									if(cbIdioma.isSelected()) {
										ofertaAct.agregarIdioma(cbIdioma.getText());
									}
								}

								if(rdUniversitario.isSelected()) {
									ofertaAct.setNivelAcademico(rdUniversitario.getText());
									for(JCheckBox cbCarrera : checkHabilidades) {
										if(cbCarrera.isSelected()) {
											ofertaAct.agregarRequisito(cbCarrera.getText());
										}
									}
								} else if(rdTecnico.isSelected()) {
									ofertaAct.setNivelAcademico(rdTecnico.getText());
									ofertaAct.setExperienciaMinima((int)spnAniosExp.getValue());
									// Agregar area requerida 

								} else if(rdObrero.isSelected()) {
									ofertaAct.setNivelAcademico(rdObrero.getText());
									ofertaAct.agregarRequisito((String)cmbHabilidad.getSelectedItem());;
								}

								if(BolsaLaboral.getInstancia().modificarOfertaLaboral(ofertaAct)) {
									JOptionPane.showMessageDialog(null,"La oferta: " + txtPuesto.getText() + " ha sido modificada exitosamente.","Información",JOptionPane.INFORMATION_MESSAGE);
								}
								else {
									JOptionPane.showMessageDialog(null,"La oferta " + txtPuesto.getText() + " no logró ser modificada.");
								}
							}
							else {

								ArrayList<String> requisitos = new ArrayList<>();
								ArrayList<String> idiomas = new ArrayList<>();
								String nivelAcademico = "";

								for(JCheckBox cbIdioma : checkIdiomas) {
									if(cbIdioma.isSelected()) {
										idiomas.add(cbIdioma.getText());
									}
								}

								if(rdUniversitario.isSelected()) {
									nivelAcademico = rdUniversitario.getText();
									for(JCheckBox cbCarrera : checkHabilidades) {
										if(cbCarrera.isSelected()) {
											requisitos.add(cbCarrera.getText());
										}
									}
								} else if(rdObrero.isSelected()) {
									nivelAcademico = rdObrero.getText();
								} else if(rdTecnico.isSelected()) {
									nivelAcademico = rdTecnico.getText();
								}

								OfertaLaboral nuevaOferta = new OfertaLaboral(txtCodigo.getText(), txtPuesto.getText(), txtDescripcion.getText(), 
										cmbArea.getSelectedItem().toString(), cmbModalidad.getSelectedItem().toString(), 
										cmbJornada.getSelectedItem().toString(), "Activa", ((Number)spnSalario.getValue()).floatValue(),
										((Number)spnAniosExp.getValue()).intValue(), ((Number)spnVacantes.getValue()).intValue(), BolsaLaboral.getInstancia().getCentros().get(cmbOfertador.getSelectedIndex()-1),
										chkReubicacion.isSelected(), chkbxMayor.isSelected(), nivelAcademico, requisitos, idiomas);
								BolsaLaboral.getInstancia().registrarOfertaLaboral(nuevaOferta);
								JOptionPane.showMessageDialog(null,"La oferta laboral ha sido agregado correctamente.","Inforamción",JOptionPane.INFORMATION_MESSAGE);
								txtCodigo.setText("OFR-" + BolsaLaboral.genCodigoOferta);
								limpiar();
							}
						}
						else {
							JOptionPane.showMessageDialog(null,"Todos los registros son obligatorios.","Advertencia",JOptionPane.WARNING_MESSAGE);
						}
					} catch (FormatException ex) {
						JOptionPane.showMessageDialog(null,ex.getMessage(),"Advertencia",JOptionPane.WARNING_MESSAGE);
					}
				}
			});
			okButton.setFont(new Font("Segoe UI", Font.BOLD, 16));
			if(ofertaAct == null) {
				okButton.setText("Registrar");
				okButton.setIcon(new ImageIcon("recursos/agregarP.png"));

			}
			else {
				okButton.setText("Modificar");
				okButton.setIcon(new ImageIcon("recursos/modificar.png"));
			}

			JButton btnLimpiar = new JButton("Limpiar");
			btnLimpiar.setBackground(Color.WHITE);
			btnLimpiar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					limpiar();
				}
			});
			btnLimpiar.setFont(new Font("Segoe UI", Font.BOLD, 16));
			btnLimpiar.setActionCommand("OK");
			pnlInferior.add(btnLimpiar);
			okButton.setActionCommand("OK");
			pnlInferior.add(okButton);
			getRootPane().setDefaultButton(okButton);
		}
		{
			JButton cancelButton = new JButton("Cancelar");
			cancelButton.setBackground(Color.WHITE);
			cancelButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispose();
				}
			});
			cancelButton.setFont(new Font("Segoe UI", Font.BOLD, 16));
			cancelButton.setIcon(new ImageIcon("recursos/cerrar.png"));
			cancelButton.setActionCommand("Cancel");
			pnlInferior.add(cancelButton);
		}
		cmbArea.setSelectedIndex(0);
		cambiarEspecializacion("Estudiante Universitario");
		cargarDatos();
	}

	public RegistroOfertaLaboral(OfertaLaboral oferta) {
		this(null, oferta);
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

	private void cargarArea() {
		String nombreArea = cmbArea.getSelectedItem().toString().toLowerCase();
		nombreArea = nombreArea.replace("ó","o");
		nombreArea = nombreArea.replace(" ","");

		lblIcoArea.setIcon(new ImageIcon("recursos/" + nombreArea + ".png"));
	}

	private void cambiarEspecializacion(String especializacion) {
		if(especializacion.equalsIgnoreCase("Obrero")) {
			pnlCarreras.setVisible(false);
			pnlTecnico.setVisible(false);
			pnlObrero.setVisible(true);
		}
		else if(especializacion.equalsIgnoreCase("Estudiante Universitario")) {
			pnlObrero.setVisible(false);
			pnlTecnico.setVisible(false);
			pnlCarreras.setVisible(true);
		}
		else if(especializacion.equalsIgnoreCase("Estudiante Tecnico")) {
			pnlCarreras.setVisible(false);
			pnlObrero.setVisible(false);
			pnlTecnico.setVisible(true);
		}
	}

	private boolean idiomaSeleccionado() {
		boolean aux = false;
		for(JCheckBox cb : checkIdiomas) {
			if(cb.isSelected()) {
				aux = true;
			}
		}
		return aux;
	}

	private boolean carreraSeleccionada() {
		boolean aux = false;
		for(JCheckBox cb : checkHabilidades) {
			if(cb.isSelected()) {
				aux = true;
			}
		}
		return aux;
	}

	private void cargarDatos() {
		checkIdiomas = new JCheckBox[] {
				chckbxIngls, chckbxPortugus, chckbxItaliano,
				chckbxAlemn, chckbxMandarn, chckbxCoreano,
				chckbxEspaol, chckbxFrancs, chckbxJapons
		};

		checkHabilidades = new JCheckBox[] {
				chkARQ, chkICV, chkIEL, chkDER, chkIST,
				chkIT, chkMKT, chkCTB, chkCOM, chkMED,
				chkEDU, chkPSI, chkII, chkHOT, chkNUT,
				chkDE, chkECO, chkIAG
		};

		if(ofertaAct != null) {
			txtCodigo.setText(ofertaAct.getCodigo());
			txtPuesto.setText(ofertaAct.getPuesto());
			cmbOfertador.setSelectedIndex(BolsaLaboral.getInstancia().buscarIndiceCentroByCodigo(ofertaAct.getOfertador().getCodigo()) + 1);
			spnSalario.setValue(ofertaAct.getSalario());
			txtDescripcion.setText(ofertaAct.getDescripcion());
			spnVacantes.setValue(ofertaAct.getVacantes());
			cmbArea.setSelectedItem(ofertaAct.getArea());
			cmbModalidad.setSelectedItem(ofertaAct.getModalidad());
			cmbJornada.setSelectedItem(ofertaAct.getJornada());
			cmbAreaTecnica.setSelectedItem(ofertaAct.getArea());
			spnAniosExp.setValue(ofertaAct.getExperienciaMinima());
			chkbxMayor.setSelected(ofertaAct.isObligatorioMayorDeEdad());
			chkReubicacion.setSelected(ofertaAct.isOfreceReubicacion());

			for(JCheckBox cbIdioma : checkIdiomas) {
				if(ofertaAct.getIdiomasRequeridas().contains(cbIdioma.getText())) {
					cbIdioma.setSelected(true);
				}
			}

			if(ofertaAct.getNivelAcademico().equals(rdUniversitario.getText())) {
				rdUniversitario.setSelected(true);
				cambiarEspecializacion("Estudiante Universitario");
				for(JCheckBox cbCarrera : checkHabilidades) {
					if(ofertaAct.getRequisitos().contains(cbCarrera.getText())) {
						cbCarrera.setSelected(true);
					}
				}
			} else if(ofertaAct.getNivelAcademico().equals(rdObrero.getText())){
				rdObrero.setSelected(true);
				cambiarEspecializacion("Obrero");
			} else if(ofertaAct.getNivelAcademico().equals(rdTecnico.getText())) {
				rdTecnico.setSelected(true);
				cambiarEspecializacion("Estudiante Tecnico");
				cmbHabilidad.setSelectedItem(ofertaAct.getRequisitos().get(0));
			}

		}

	}

	private void limpiar() {
		txtPuesto.setText("");
		cmbOfertador.setSelectedIndex(0);
		spnSalario.setValue(12000);
		txtDescripcion.setText("");
		spnVacantes.setValue(1);
		cmbArea.setSelectedIndex(0);
		cmbModalidad.setSelectedIndex(0);
		cmbJornada.setSelectedIndex(0);
		cmbHabilidad.setSelectedIndex(0);
		cmbAreaTecnica.setSelectedIndex(0);
		spnAniosExp.setValue(0);

		for (JCheckBox cb : checkIdiomas) {
			cb.setSelected(false);
		}

		chkbxMayor.setSelected(false);
		chkReubicacion.setSelected(false);

		for (JCheckBox cb : checkHabilidades) {
			cb.setSelected(false);
		}
		rdUniversitario.setSelected(true);
		cambiarEspecializacion("Estudiante Universitario");
	}

	private boolean verificar() throws FormatException {
		if (cmbOfertador.getSelectedIndex() == 0) {
			throw new FormatException("Debe seleccionar un centro empleador válido.");
		}
		if (txtPuesto.getText().trim().isEmpty()) {
			throw new FormatException("Debe ingresar un título para el puesto.");
		}
		if (txtDescripcion.getText().trim().isEmpty()) {
			throw new FormatException("Debe ingresar una descripción para la oferta.");
		}
		if (!idiomaSeleccionado()) {
			throw new FormatException("Debe seleccionar por lo menos un idioma requerido.");
		}
		if (rdUniversitario.isSelected() && !carreraSeleccionada()) {
			throw new FormatException("Debe seleccionar por lo menos una carrera permitida.");
		}
		if (cmbArea.getSelectedIndex() == 0) {
			throw new FormatException("Debe seleccionar un area.");
		}

		return true;
	}

}
