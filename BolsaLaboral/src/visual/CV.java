package visual;

import logico.*;
import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import java.awt.Font;
import java.awt.Color;
import java.awt.Component;

import javax.swing.JLabel;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.JTextPane;

public class CV extends JDialog {

	private final JPanel contenedor = new JPanel();
	public static Object[] row;
	private JTextPane txpGrado;
	private JTextPane txpUbicacion;
	private JTextPane txpContactos;
	private JTextPane txpIdiomas;
	private JTextPane txpDatosFormacion;
	private JPanel pnlResumen;
	private JLabel lblNombre;
	private JLabel lblFechaNac;
	private JTextPane txpDescripcion;
	private JLabel lblDatosAcadmicos;
	private JLabel lblModalidad;
	private JLabel lblJornada;
	private JLabel lblArea;

	/**
	 * Create the dialog.
	 */
	public CV(Candidato solicitante) {
		setTitle(solicitante.getNombres() + " " + solicitante.getApellidos());
		setIconImage(Toolkit.getDefaultToolkit().getImage("recursos/icono.png"));
		setBounds(100, 100, 712, 685);
		setResizable(false);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contenedor.setBorder(new EmptyBorder(5, 5, 5, 5));
		contenedor.setBackground(new Color(228, 228, 228));
		getContentPane().add(contenedor, BorderLayout.CENTER);
		contenedor.setLayout(null);
		{
			JButton btnCancelar = new JButton("Cerrar");
			btnCancelar.setBounds(554, 600, 140, 31);
			contenedor.add(btnCancelar);
			btnCancelar.setFont(new Font("Segoe UI", Font.PLAIN, 16));
			btnCancelar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispose();
				}
			});
			btnCancelar.setActionCommand("Cancel");
		}
		
		pnlResumen = new JPanel();
		pnlResumen.setBackground(new Color(34, 34, 34));
		pnlResumen.setBounds(0, 0, 220, 650);
		contenedor.add(pnlResumen);
		pnlResumen.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel(" Ubicaci\u00F3n");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Consolas", Font.BOLD, 18));
		lblNewLabel_1.setIcon(new ImageIcon("recursos/ubicacion.png"));
		lblNewLabel_1.setBounds(35, 113, 151, 34);
		pnlResumen.add(lblNewLabel_1);
		
		JLabel lblContactos = new JLabel(" Contactos");
		lblContactos.setIcon(new ImageIcon("recursos/contactos.png"));
		lblContactos.setForeground(Color.WHITE);
		lblContactos.setFont(new Font("Consolas", Font.BOLD, 18));
		lblContactos.setBounds(35, 239, 151, 34);
		pnlResumen.add(lblContactos);
		
		JLabel lblIdiomas = new JLabel(" Idiomas");
		lblIdiomas.setIcon(new ImageIcon("recursos/idiomas.png"));
		lblIdiomas.setForeground(Color.WHITE);
		lblIdiomas.setFont(new Font("Consolas", Font.BOLD, 18));
		lblIdiomas.setBounds(35, 403, 151, 34);
		pnlResumen.add(lblIdiomas);
		
		JLabel lblNivelAcadmico = new JLabel(" Formaci\u00F3n");
		lblNivelAcadmico.setIcon(new ImageIcon("recursos/nivel.png"));
		lblNivelAcadmico.setForeground(Color.WHITE);
		lblNivelAcadmico.setFont(new Font("Consolas", Font.BOLD, 18));
		lblNivelAcadmico.setBounds(35, 13, 151, 34);
		pnlResumen.add(lblNivelAcadmico);
		
		txpGrado = new JTextPane();
		txpGrado.setFont(new Font("Consolas", Font.PLAIN, 14));
		txpGrado.setBackground(Color.BLACK);
		txpGrado.setBounds(12, 53, 196, 56);
		pnlResumen.add(txpGrado);
		
		txpUbicacion = new JTextPane();
		txpUbicacion.setFont(new Font("Consolas", Font.PLAIN, 14));
		txpUbicacion.setBackground(Color.BLACK);
		txpUbicacion.setBounds(12, 152, 196, 72);
		pnlResumen.add(txpUbicacion);
		
		txpContactos = new JTextPane();
		txpContactos.setFont(new Font("Consolas", Font.PLAIN, 14));
		txpContactos.setBackground(Color.BLACK);
		txpContactos.setBounds(12, 284, 196, 106);
		pnlResumen.add(txpContactos);
		
		txpIdiomas = new JTextPane();
		txpIdiomas.setFont(new Font("Consolas", Font.PLAIN, 14));
		txpIdiomas.setBackground(Color.BLACK);
		txpIdiomas.setBounds(12, 447, 196, 190);
		pnlResumen.add(txpIdiomas);
		
		lblNombre = new JLabel("NOMBRE");
		lblNombre.setHorizontalAlignment(SwingConstants.LEFT);
		lblNombre.setFont(new Font("Verdana", Font.PLAIN, 30));
		lblNombre.setBounds(234, 13, 460, 70);
		contenedor.add(lblNombre);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(234, 117, 460, 2);
		contenedor.add(separator);
		
		JLabel lblNewLabel = new JLabel("SOBRE MI");
		lblNewLabel.setBounds(234, 122, 460, 54);
		contenedor.add(lblNewLabel);
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setFont(new Font("Consolas", Font.BOLD, 18));
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		
		txpDescripcion = new JTextPane();
		txpDescripcion.setForeground(new Color(0, 0, 0));
		txpDescripcion.setFont(new Font("Consolas", Font.PLAIN, 14));
		txpDescripcion.setText("Descripci\u00F3n ultraepica");
		txpDescripcion.setBounds(234, 165, 460, 126);
		contenedor.add(txpDescripcion);
		
		lblDatosAcadmicos = new JLabel("DATOS ACAD\u00C9MICOS");
		lblDatosAcadmicos.setHorizontalAlignment(SwingConstants.LEFT);
		lblDatosAcadmicos.setForeground(Color.BLACK);
		lblDatosAcadmicos.setFont(new Font("Consolas", Font.BOLD, 18));
		lblDatosAcadmicos.setBounds(234, 292, 460, 54);
		contenedor.add(lblDatosAcadmicos);
		
		txpDatosFormacion = new JTextPane();
		txpDatosFormacion.setText("Detalles de la estudiasao");
		txpDatosFormacion.setForeground(Color.BLACK);
		txpDatosFormacion.setFont(new Font("Consolas", Font.PLAIN, 14));
		txpDatosFormacion.setBounds(234, 341, 460, 126);
		contenedor.add(txpDatosFormacion);
		
		lblFechaNac = new JLabel("Fecha Nac.");
		lblFechaNac.setIcon(new ImageIcon("recursos/calendario.png"));
		lblFechaNac.setHorizontalAlignment(SwingConstants.LEFT);
		lblFechaNac.setForeground(Color.BLACK);
		lblFechaNac.setFont(new Font("Consolas", Font.BOLD, 14));
		lblFechaNac.setBounds(234, 82, 267, 38);
		contenedor.add(lblFechaNac);
		
		JLabel lblPreferenciasLaborales = new JLabel("Preferencias:");
		lblPreferenciasLaborales.setHorizontalAlignment(SwingConstants.LEFT);
		lblPreferenciasLaborales.setForeground(Color.BLACK);
		lblPreferenciasLaborales.setFont(new Font("Consolas", Font.BOLD, 18));
		lblPreferenciasLaborales.setBounds(232, 599, 140, 38);
		contenedor.add(lblPreferenciasLaborales);
		
		lblArea = new JLabel("");
		lblArea.setIcon(new ImageIcon("C:\\Users\\anton\\Downloads\\BolsaLaboral2\\BolsaLaboral2\\recursos\\arte.png"));
		lblArea.setBackground(Color.WHITE);
		lblArea.setBounds(375, 597, 40, 40);
		contenedor.add(lblArea);
		
		lblModalidad = new JLabel("");
		lblModalidad.setIcon(new ImageIcon("C:\\Users\\anton\\Downloads\\BolsaLaboral2\\BolsaLaboral2\\recursos\\atencionalcliente.png"));
		lblModalidad.setBackground(Color.WHITE);
		lblModalidad.setBounds(477, 597, 40, 40);
		contenedor.add(lblModalidad);
		
		lblJornada = new JLabel("");
		lblJornada.setIcon(new ImageIcon("C:\\Users\\anton\\Downloads\\BolsaLaboral2\\BolsaLaboral2\\recursos\\comercio.png"));
		lblJornada.setBackground(Color.WHITE);
		lblJornada.setBounds(427, 597, 40, 40);
		contenedor.add(lblJornada);
		
		cargarCV(solicitante);
		setApariencia(solicitante.getAreaDeInteres());
	}
	
	public void cargarCV(Candidato solicitante) {
		if(solicitante instanceof Universitario) {
			txpGrado.setText(((Universitario) solicitante).getNivelAcademico());
		}
		else if(solicitante instanceof TecnicoSuperior) {
			txpGrado.setText("Técnico");
		}
		else if(solicitante instanceof Obrero) {
			txpGrado.setText("Trabajador");
		}
		lblNombre.setText(solicitante.getNombres() + " " + solicitante.getApellidos());
		lblFechaNac.setText(solicitante.getFechaNacimiento().toString());
		txpContactos.setText(solicitante.getTelefono());
		cargarSobreMi(solicitante);
		cargarFormacion(solicitante);
		cargarArea(solicitante.getAreaDeInteres());
		cargarJornada(solicitante.getJornada());
		cargarModalidad(solicitante.getModalidad());
	}
	
	private void cargarArea(String nombreArea) {
		nombreArea = nombreArea.toLowerCase();
		nombreArea = nombreArea.replace("ó","o");
		nombreArea = nombreArea.replace(" ","");

		lblArea.setIcon(new ImageIcon("recursos/" + nombreArea + ".png"));
	}
	
	private void cargarJornada(String nombreJornada) {
		nombreJornada = nombreJornada.toLowerCase();
		nombreJornada = nombreJornada.replace(" ","");
		lblJornada.setIcon(new ImageIcon("recursos/" + nombreJornada + ".png"));
	}
	
	private void cargarModalidad(String modalidad) {
		String nombreModalidad = modalidad.toLowerCase();
		nombreModalidad = nombreModalidad.replace("í","i");
		lblModalidad.setIcon(new ImageIcon("recursos/" + nombreModalidad + ".png"));
	}
	
	public void cargarSobreMi(Candidato solicitante) {
		
	}
	
	public void cargarFormacion(Candidato solicitante) {
		
	}
	
	public Color getColor(String area) {
		switch (area) {
		case "Finanzas": return new Color(213, 69, 27);	
		case "Recursos Humanos": return new Color(27, 60, 83);
		case "Marketing": return new Color(197, 23, 46);
		case "Limpieza": return new Color(78, 102, 136);
		case "Seguridad": return new Color(10, 64, 12);
		case "TI": return new Color(9, 107, 104);
		case "Operaciones": return new Color(39, 63, 79);
		case "Administración": return new Color(190, 49, 68);
		case "Atención al Cliente": return new Color(130, 17, 49);	
		default: return new Color(57, 62, 7);
		}
	}
	
	public void setApariencia(String area) {
		Color fondo = getColor(area);
		for(Component cmp : pnlResumen.getComponents()) {
			cmp.setBackground(fondo);
		}
	}
}