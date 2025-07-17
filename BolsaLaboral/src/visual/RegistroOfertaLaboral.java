package visual;

import java.awt.BorderLayout;
import logico.*;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JSeparator;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import javax.swing.JTextArea;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

public class RegistroOfertaLaboral extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private OfertaLaboral ofertaAct = null;
	private JTextField txtCodigo;
	private JTextField txtNombre;
	private JComboBox cmbArea;
	private JLabel lblIcono;
	/**
	 * Create the dialog.
	 */
	public RegistroOfertaLaboral(OfertaLaboral oferta) {
		setIconImage(Toolkit.getDefaultToolkit().getImage("recursos/icono.png"));
		setResizable(false);
		if(oferta == null) {
			setTitle("Registrar Oferta Laboral");
		}
		else {
			setTitle("Modificar Oferta Laboral");
			ofertaAct = oferta;
		}
		setBounds(100, 100, 560, 720);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(228, 228, 228));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JPanel contenedor = new JPanel();
			contenedor.setBackground(new Color(228, 228, 228));
			contenedor.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0), 1, true), "Datos del Centro Empleador", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
			contentPanel.add(contenedor, BorderLayout.CENTER);
			contenedor.setLayout(null);
			
			JLabel lblNewLabel = new JLabel("C\u00F3digo:");
			lblNewLabel.setFont(new Font("Segoe UI", Font.BOLD, 16));
			lblNewLabel.setBounds(22, 29, 84, 29);
			contenedor.add(lblNewLabel);
			
			txtCodigo = new JTextField();
			txtCodigo.setEditable(false);
			txtCodigo.setFont(new Font("Segoe UI", Font.PLAIN, 14));
			txtCodigo.setBounds(126, 33, 305, 22);
			contenedor.add(txtCodigo);
			txtCodigo.setColumns(10);
			
			JSeparator separator = new JSeparator();
			separator.setForeground(Color.BLACK);
			separator.setBounds(12, 71, 503, 6);
			contenedor.add(separator);
			
			JPanel panel = new JPanel();
			panel.setBackground(new Color(228, 228, 228));
			panel.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Generalidades", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
			panel.setBounds(12, 138, 503, 265);
			contenedor.add(panel);
			panel.setLayout(null);
			
			JLabel lblNombre = new JLabel("Puesto:");
			lblNombre.setBounds(12, 25, 84, 29);
			panel.add(lblNombre);
			lblNombre.setFont(new Font("Segoe UI", Font.BOLD, 16));
			
			txtNombre = new JTextField();
			txtNombre.setBounds(117, 29, 305, 22);
			panel.add(txtNombre);
			txtNombre.setFont(new Font("Segoe UI", Font.PLAIN, 14));
			txtNombre.setColumns(10);
			
			JLabel lblDescripcin = new JLabel("Descripci\u00F3n:");
			lblDescripcin.setFont(new Font("Segoe UI", Font.BOLD, 16));
			lblDescripcin.setBounds(12, 67, 100, 29);
			panel.add(lblDescripcin);
			
			JTextArea textArea = new JTextArea();
			textArea.setBounds(116, 72, 306, 80);
			panel.add(textArea);
			
			JLabel lblrea = new JLabel("\u00C1rea:");
			lblrea.setFont(new Font("Segoe UI", Font.BOLD, 16));
			lblrea.setBounds(12, 165, 53, 29);
			panel.add(lblrea);
			
			cmbArea = new JComboBox();
			cmbArea.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					cargarArea();
				}
			});
			cmbArea.setModel(new DefaultComboBoxModel(new String[] {"No definido", "Finanzas", "Recursos Humanos", "Marketing", "Limpieza", "Seguridad", "TI", "Operaciones", "Administraci\u00F3n", "Atenci\u00F3n al Cliente"}));
			cmbArea.setMaximumRowCount(10);
			cmbArea.setFont(new Font("Segoe UI", Font.PLAIN, 14));
			cmbArea.setBounds(116, 165, 306, 29);
			panel.add(cmbArea);
			
			lblIcono = new JLabel("");
			lblIcono.setFont(new Font("Segoe UI", Font.BOLD, 16));
			lblIcono.setBounds(430, 165, 32, 32);
			panel.add(lblIcono);
			
			JLabel lblSalario = new JLabel("Salario:");
			lblSalario.setFont(new Font("Segoe UI", Font.BOLD, 16));
			lblSalario.setBounds(12, 209, 100, 29);
			panel.add(lblSalario);
			
			JSpinner spinner = new JSpinner();
			spinner.setModel(new SpinnerNumberModel(new Float(12000), new Float(12000), null, new Float(1000)));
			spinner.setFont(new Font("Segoe UI", Font.PLAIN, 14));
			spinner.setBounds(117, 214, 305, 22);
			panel.add(spinner);
			
			JLabel lblCentroOfertador = new JLabel("Centro Ofertador:");
			lblCentroOfertador.setBounds(22, 90, 148, 29);
			contenedor.add(lblCentroOfertador);
			lblCentroOfertador.setFont(new Font("Segoe UI", Font.BOLD, 16));
			
			JComboBox comboBox = new JComboBox();
			comboBox.setBounds(168, 91, 263, 29);
			contenedor.add(comboBox);
			comboBox.setModel(new DefaultComboBoxModel(new String[] {"<Seleccione una opci\u00F3n>"}));
			comboBox.setSelectedIndex(0);
			comboBox.setMaximumRowCount(10);
			comboBox.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		}
		{
			JPanel pnlInferior = new JPanel();
			pnlInferior.setBackground(new Color(24, 61, 61));
			pnlInferior.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(pnlInferior, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Confimar");
				okButton.setFont(new Font("Segoe UI", Font.PLAIN, 16));
				if(ofertaAct == null) {
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
		cargarDatos();
		
	}
	
	private void limpiar() {

	}
	
	private void cargarArea() {
		String nombreArea = cmbArea.getSelectedItem().toString().toLowerCase();
		nombreArea = nombreArea.replace("ó","o");
		nombreArea = nombreArea.replace(" ","");

		lblIcono.setIcon(new ImageIcon("recursos/" + nombreArea + ".png"));
	}
	
	private void cargarDatos() {
		cmbArea.setSelectedIndex(0);
	}
}
