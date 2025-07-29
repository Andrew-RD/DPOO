package visual;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import logico.BolsaLaboral;
import logico.CentroEmpleador;
import logico.OfertaLaboral;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class VistaCentro extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JLabel lblIconSec;
	private JLabel lblNombre;
	private JPanel pnlEnfasis;
	private JLabel lblTelefono;
	private JLabel lblCorreo;
	private JTable table;
	private JLabel lblNewLabel;
	
	public static DefaultTableModel modelo = new DefaultTableModel() {
		@Override
        public boolean isCellEditable(int row, int column) {
            return false;
        }
		
		public Class getColumnClass(int column)
        {
            return getValueAt(0, column).getClass();
        }
	};
	public static Object[] row;

	/**
	 * Create the dialog.
	 */
	public VistaCentro(CentroEmpleador centroVista) {
		setBounds(100, 100, 685, 651);
		getContentPane().setLayout(new BorderLayout());
		setTitle("(" + centroVista.getCodigo() + ") " + centroVista.getNombre());
		setResizable(false);
		setLocationRelativeTo(null);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPanel.setBackground(new Color(255,255,255));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		pnlEnfasis = new JPanel();
		pnlEnfasis.setBounds(0, 0, 679, 126);
		contentPanel.add(pnlEnfasis);
		pnlEnfasis.setLayout(null);
		
		lblNombre = new JLabel("Nombre Empresa");
		lblNombre.setForeground(Color.WHITE);
		lblNombre.setFont(new Font("Verdana", Font.BOLD, 26));
		lblNombre.setBounds(61, 13, 595, 46);
		pnlEnfasis.add(lblNombre);
		
		lblIconSec = new JLabel("");
		lblIconSec.setBounds(13, 19, 40, 40);
		pnlEnfasis.add(lblIconSec);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(Color.WHITE);
		separator.setBackground(Color.WHITE);
		separator.setBounds(19, 67, 640, 2);
		pnlEnfasis.add(separator);
		
		lblTelefono = new JLabel("LBL");
		lblTelefono.setIcon(new ImageIcon("recursos/contactos.png"));
		lblTelefono.setHorizontalAlignment(SwingConstants.LEFT);
		lblTelefono.setForeground(Color.WHITE);
		lblTelefono.setFont(new Font("Consolas", Font.PLAIN, 18));
		lblTelefono.setBounds(12, 82, 196, 34);
		pnlEnfasis.add(lblTelefono);
		
		lblCorreo = new JLabel(" <dynamic>");
		lblCorreo.setIcon(new ImageIcon("recursos/correo.png"));
		lblCorreo.setHorizontalAlignment(SwingConstants.LEFT);
		lblCorreo.setForeground(Color.WHITE);
		lblCorreo.setFont(new Font("Consolas", Font.PLAIN, 18));
		lblCorreo.setBounds(220, 82, 436, 34);
		pnlEnfasis.add(lblCorreo);
		
		JButton btnCancelar = new JButton("Cerrar");
		btnCancelar.setIcon(new ImageIcon("recursos/cerrar.png"));
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCancelar.setFont(new Font("Segoe UI", Font.BOLD, 16));
		btnCancelar.setFocusable(false);
		btnCancelar.setBackground(Color.WHITE);
		btnCancelar.setActionCommand("Cancel");
		btnCancelar.setBounds(502, 555, 140, 31);
		contentPanel.add(btnCancelar);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 187, 655, 339);
		contentPanel.add(scrollPane, BorderLayout.CENTER);
		{
			table = new JTable();
			table.setForeground(Color.BLACK);
			table.setFont(new Font("Segoe UI", Font.PLAIN, 16));
			String [] headers = {"C�digo", "Puesto", "�rea", "Estado"};
			modelo.setColumnIdentifiers(headers);
			table.setModel(modelo);
			scrollPane.setViewportView(table);
		}
		
		lblNewLabel = new JLabel("Ofertas Laborales Acutales");
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Consolas", Font.BOLD, 18));
		lblNewLabel.setBounds(157, 143, 352, 31);
		contentPanel.add(lblNewLabel);
		cargarCentro(centroVista);
		cargarOfertas(centroVista);
		table.setRowHeight(36);
		table.getTableHeader().setReorderingAllowed(false);
	}
	
	public void cargarCentro(CentroEmpleador centr) {
		lblNombre.setText(centr.getNombre());
		lblIconSec.setToolTipText(centr.getSector());
		lblTelefono.setText(" " + centr.getTelefono());
		lblTelefono.setToolTipText(centr.getTelefono());
		lblCorreo.setText(centr.getCorreo());
		String nombreSector = centr.getSector().toLowerCase();
		nombreSector = nombreSector.replace("�","i");
		nombreSector = nombreSector.replace("�","o");
		nombreSector = nombreSector.replace(" ","");
		lblIconSec.setIcon(new ImageIcon("recursos/" + nombreSector + ".png"));
		pnlEnfasis.setBackground(getFondo(centr.getSector()));
	}
	
	public Color getFondo(String sector) {
		switch (sector) {
			case "No definido": return new Color(26, 26, 29);
			case "Turismo": return new Color(31, 125, 83);
			case "Tecnolog�a": return new Color(17, 63, 103);
			case "Salud": return new Color(125, 10, 10);
			case "Comercio": return new Color(117, 14, 33);
			case "Educaci�n": return new Color(51, 52, 70);
			case "Construcci�n": return new Color(84, 18, 18);
			case "Agricultura": return new Color(57, 153, 24);
			case "Jur�dico": return new Color(68, 54, 39);
			case "Arte": return new Color(30, 81, 40);
			case "Transporte": return new Color(23, 49, 62);
		}
		return new Color(0,0,0);
	}
	
	private static String getImagen(String area) {
		area = area.replace("�","o");
		area = area.replace(" ","");
		return "recursos/" + area + ".png";
	}
	
	public void cargarOfertas(CentroEmpleador centr) {
		modelo.setRowCount(0);
		row = new Object[table.getColumnCount()];
		for(OfertaLaboral ofr : centr.getOfertasLaborales()) {
			row[0] = ofr.getCodigo();
			row[1] = ofr.getPuesto();
			row[2] = new ImageIcon(getImagen(ofr.getArea().toLowerCase()));
			row[3] = ofr.getEstado();
			modelo.addRow(row);
		}
	}
	
	public String nombreFormato() {
		return null;
	}
}
