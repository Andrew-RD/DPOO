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
import javax.swing.JTextField;
import javax.swing.JSeparator;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class RegistroCentro extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private CentroEmpleador centroAct = null;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JComboBox cmbSector;
	private JLabel lblIcono;
	/**
	 * Create the dialog.
	 */
	public RegistroCentro(CentroEmpleador centro) {
		setResizable(false);
		if(centro == null) {
			setTitle("Registrar Centro de Trabajo");
		}
		else {
			setTitle("Modificar Centro de Trabajo");
			centroAct = centro;
		}
		setBounds(100, 100, 560, 527);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(228, 228, 228));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JPanel contenedor = new JPanel();
			contenedor.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0), 1, true), "Datos del Centro Empleador", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
			contentPanel.add(contenedor, BorderLayout.CENTER);
			contenedor.setLayout(null);
			
			JLabel lblNewLabel = new JLabel("C\u00F3digo:");
			lblNewLabel.setFont(new Font("Segoe UI", Font.BOLD, 16));
			lblNewLabel.setBounds(22, 29, 84, 29);
			contenedor.add(lblNewLabel);
			
			textField = new JTextField();
			textField.setFont(new Font("Segoe UI", Font.PLAIN, 14));
			textField.setBounds(116, 29, 305, 22);
			contenedor.add(textField);
			textField.setColumns(10);
			
			JSeparator separator = new JSeparator();
			separator.setForeground(Color.BLACK);
			separator.setBounds(12, 71, 503, 6);
			contenedor.add(separator);
			
			JLabel lblNombre = new JLabel("Nombre:");
			lblNombre.setFont(new Font("Segoe UI", Font.BOLD, 16));
			lblNombre.setBounds(22, 86, 84, 29);
			contenedor.add(lblNombre);
			
			textField_1 = new JTextField();
			textField_1.setFont(new Font("Segoe UI", Font.PLAIN, 14));
			textField_1.setColumns(10);
			textField_1.setBounds(116, 88, 305, 22);
			contenedor.add(textField_1);
			
			JLabel lblSector = new JLabel("Sector:");
			lblSector.setFont(new Font("Segoe UI", Font.BOLD, 16));
			lblSector.setBounds(22, 138, 84, 29);
			contenedor.add(lblSector);
			
			cmbSector = new JComboBox();
			cmbSector.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					cargarSector();
				}
			});
			
			cmbSector.setMaximumRowCount(10);
			cmbSector.setModel(new DefaultComboBoxModel(new String[] {"Turismo", "Tecnolog\u00EDa", "Salud", "Comercio", "Educaci\u00F3n", "Agricultura", "Construcci\u00F3n", "Jur\u00EDdico", "Arte", "Transporte"}));
			cmbSector.setFont(new Font("Segoe UI", Font.PLAIN, 14));
			cmbSector.setBounds(116, 139, 305, 29);
			contenedor.add(cmbSector);
			
			lblIcono = new JLabel("");
			lblIcono.setFont(new Font("Segoe UI", Font.BOLD, 16));
			lblIcono.setBounds(433, 135, 32, 32);
			contenedor.add(lblIcono);
			
			JPanel pnlContactos = new JPanel();
			pnlContactos.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Contactos y Ubicaci\u00F3n", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
			pnlContactos.setBounds(12, 180, 513, 229);
			contenedor.add(pnlContactos);
			pnlContactos.setLayout(null);
			
			JLabel lblTelfono = new JLabel("Tel\u00E9fono:");
			lblTelfono.setFont(new Font("Segoe UI", Font.BOLD, 16));
			lblTelfono.setBounds(12, 28, 84, 29);
			pnlContactos.add(lblTelfono);
			
			textField_2 = new JTextField();
			textField_2.setFont(new Font("Segoe UI", Font.PLAIN, 14));
			textField_2.setColumns(10);
			textField_2.setBounds(108, 35, 305, 22);
			pnlContactos.add(textField_2);
			
			JLabel lblCorreo = new JLabel("Correo:");
			lblCorreo.setFont(new Font("Segoe UI", Font.BOLD, 16));
			lblCorreo.setBounds(12, 78, 84, 29);
			pnlContactos.add(lblCorreo);
			
			textField_3 = new JTextField();
			textField_3.setFont(new Font("Segoe UI", Font.PLAIN, 14));
			textField_3.setColumns(10);
			textField_3.setBounds(108, 81, 305, 22);
			pnlContactos.add(textField_3);
			
			textField_4 = new JTextField();
			textField_4.setFont(new Font("Segoe UI", Font.PLAIN, 14));
			textField_4.setColumns(10);
			textField_4.setBounds(108, 133, 305, 22);
			pnlContactos.add(textField_4);
			
			JLabel lblProvincia = new JLabel("Provincia:");
			lblProvincia.setFont(new Font("Segoe UI", Font.BOLD, 16));
			lblProvincia.setBounds(12, 126, 84, 29);
			pnlContactos.add(lblProvincia);
			
			JLabel lblMunicipio = new JLabel("Municipio:");
			lblMunicipio.setFont(new Font("Segoe UI", Font.BOLD, 16));
			lblMunicipio.setBounds(12, 179, 84, 29);
			pnlContactos.add(lblMunicipio);
			
			textField_5 = new JTextField();
			textField_5.setFont(new Font("Segoe UI", Font.PLAIN, 14));
			textField_5.setColumns(10);
			textField_5.setBounds(108, 182, 305, 22);
			pnlContactos.add(textField_5);
		}
		{
			JPanel pnlInferior = new JPanel();
			pnlInferior.setBackground(new Color(4, 87, 87));
			pnlInferior.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(pnlInferior, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Confimar");
				okButton.setFont(new Font("Segoe UI", Font.PLAIN, 16));
				if(centroAct == null) {
					okButton.setText("Registrar");
					okButton.setIcon(new ImageIcon("recursos/agregarP.png"));
					
				}
				else {
					okButton.setText("Modificar");
					okButton.setIcon(new ImageIcon("recursos/editar.png"));
				}
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
	
	private void cargarDatos() {
		cmbSector.setSelectedIndex(0);
	}
	
	private void cargarSector() {
		String nombreSector = cmbSector.getSelectedItem().toString().toLowerCase();
		nombreSector = nombreSector.replace("í","i");
		nombreSector = nombreSector.replace("ó","o");
		lblIcono.setIcon(new ImageIcon("recursos/" + nombreSector + ".png"));
	}
}
