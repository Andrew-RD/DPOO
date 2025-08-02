package visual;

import java.awt.BorderLayout;
import exception.*;
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

public class RegistroCentro extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private CentroEmpleador centroAct = null;
	private JTextField txtCodigo;
	private JTextField txtNombre;
	private JTextField txtTelefono;
	private JTextField txtCorreo;
	private JTextField txtProvincia;
	private JTextField txtMunicipio;
	private JComboBox cmbSector;
	private JLabel lblIcono;
	private JTextField txtRNC;
	/**
	 * Create the dialog.
	 */
	public RegistroCentro(CentroEmpleador centro) {
		setIconImage(Toolkit.getDefaultToolkit().getImage("recursos/icono.png"));
		setResizable(false);
		if(centro == null) {
			setTitle("Registrar Centro de Trabajo");
		}
		else {
			setTitle("Modificar Centro de Trabajo");
			centroAct = centro;
		}
		setBounds(100, 100, 560, 567);
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
			txtCodigo.setFocusable(false);
			txtCodigo.setText("CEN-" + BolsaLaboral.genCodigoCentro);
			txtCodigo.setFont(new Font("Segoe UI", Font.PLAIN, 14));
			txtCodigo.setBounds(116, 29, 305, 22);
			contenedor.add(txtCodigo);
			txtCodigo.setColumns(10);

			JSeparator separator = new JSeparator();
			separator.setForeground(Color.BLACK);
			separator.setBounds(12, 71, 503, 6);
			contenedor.add(separator);

			JLabel lblNombre = new JLabel("Nombre:");
			lblNombre.setFont(new Font("Segoe UI", Font.BOLD, 16));
			lblNombre.setBounds(22, 86, 84, 29);
			contenedor.add(lblNombre);

			txtNombre = new JTextField();
			txtNombre.setFont(new Font("Segoe UI", Font.PLAIN, 14));
			txtNombre.setColumns(10);
			txtNombre.setBounds(116, 88, 305, 22);
			contenedor.add(txtNombre);

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

			cmbSector.setMaximumRowCount(11);
			cmbSector.setModel(new DefaultComboBoxModel(new String[] {"No definido", "Turismo", "Tecnolog\u00EDa", "Salud", "Comercio", "Educaci\u00F3n", "Agricultura", "Construcci\u00F3n", "Jur\u00EDdico", "Arte", "Transporte"}));
			cmbSector.setFont(new Font("Segoe UI", Font.PLAIN, 14));
			cmbSector.setBounds(116, 139, 305, 29);
			contenedor.add(cmbSector);

			lblIcono = new JLabel("");
			lblIcono.setFont(new Font("Segoe UI", Font.BOLD, 16));
			lblIcono.setBounds(433, 135, 32, 32);
			contenedor.add(lblIcono);

			JPanel pnlContactos = new JPanel();
			pnlContactos.setBackground(new Color(228, 228, 228));
			pnlContactos.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Contactos y Ubicaci\u00F3n", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
			pnlContactos.setBounds(12, 226, 513, 229);
			contenedor.add(pnlContactos);
			pnlContactos.setLayout(null);

			JLabel lblTelfono = new JLabel("Tel\u00E9fono:");
			lblTelfono.setFont(new Font("Segoe UI", Font.BOLD, 16));
			lblTelfono.setBounds(12, 28, 84, 29);
			pnlContactos.add(lblTelfono);

			txtTelefono = new JTextField();
			txtTelefono.setFont(new Font("Segoe UI", Font.PLAIN, 14));
			txtTelefono.setColumns(10);
			txtTelefono.setBounds(108, 35, 305, 22);
			pnlContactos.add(txtTelefono);

			JLabel lblCorreo = new JLabel("Correo:");
			lblCorreo.setFont(new Font("Segoe UI", Font.BOLD, 16));
			lblCorreo.setBounds(12, 78, 84, 29);
			pnlContactos.add(lblCorreo);

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

			JLabel lblProvincia = new JLabel("Provincia:");
			lblProvincia.setFont(new Font("Segoe UI", Font.BOLD, 16));
			lblProvincia.setBounds(12, 126, 84, 29);
			pnlContactos.add(lblProvincia);

			JLabel lblMunicipio = new JLabel("Municipio:");
			lblMunicipio.setFont(new Font("Segoe UI", Font.BOLD, 16));
			lblMunicipio.setBounds(12, 179, 84, 29);
			pnlContactos.add(lblMunicipio);

			txtMunicipio = new JTextField();
			txtMunicipio.setFont(new Font("Segoe UI", Font.PLAIN, 14));
			txtMunicipio.setColumns(10);
			txtMunicipio.setBounds(108, 182, 305, 22);
			pnlContactos.add(txtMunicipio);

			JLabel lblRnc = new JLabel("RNC:");
			lblRnc.setFont(new Font("Segoe UI", Font.BOLD, 16));
			lblRnc.setBounds(22, 191, 84, 29);
			contenedor.add(lblRnc);

			txtRNC = new JTextField();
			txtRNC.setFont(new Font("Segoe UI", Font.PLAIN, 14));
			txtRNC.setColumns(10);
			txtRNC.setBounds(116, 193, 305, 22);
			contenedor.add(txtRNC);
		}
		{
			JPanel pnlInferior = new JPanel();
			pnlInferior.setBackground(new Color(4, 87, 87));
			pnlInferior.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(pnlInferior, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Confimar");
				okButton.setBackground(Color.WHITE);
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						try {
							if(verificar()) {
								if(centroAct != null) {
									centroAct.setCorreo(txtCorreo.getText());
									centroAct.setMunicipio(txtMunicipio.getText());
									centroAct.setNombre(txtNombre.getText());
									centroAct.setProvincia(txtProvincia.getText());
									centroAct.setRnc(txtRNC.getText());
									centroAct.setSector(cmbSector.getSelectedItem().toString());
									centroAct.setTelefono(txtTelefono.getText());
									if(BolsaLaboral.getInstancia().modificarCentroTrabajo(centroAct)) {
										ConsultarCentros.cargarCentros();
										JOptionPane.showMessageDialog(null,"El centro " + txtNombre.getText() + " ha sido modificado exitosamente.","Información",JOptionPane.INFORMATION_MESSAGE);
										dispose();
									}
									else {
										JOptionPane.showMessageDialog(null,"El centro " + txtNombre.getText() + " no logró ser modificado.");
									}
								}
								else {
									CentroEmpleador nuevoCentro = new CentroEmpleador(txtCodigo.getText(),txtNombre.getText(),cmbSector.getSelectedItem().toString(),txtProvincia.getText(),txtMunicipio.getText(),txtTelefono.getText(),txtCorreo.getText(),txtRNC.getText());
									BolsaLaboral.getInstancia().registrarCentroTrabajo(nuevoCentro);
									JOptionPane.showMessageDialog(null,"El centro de trabajo ha sido agregado correctamente.","Inforamción",JOptionPane.INFORMATION_MESSAGE);
									txtCodigo.setText("CEN-" + BolsaLaboral.genCodigoCentro);
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
				if(centroAct == null) {
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
		}
		cargarDatos();

	}

	private boolean verificar() throws FormatException {
		if(txtNombre.getText().isEmpty()) {
			throw new FormatException("El nombre no puede estar vacío.");
		}
		else if(txtRNC.getText().isEmpty()) {
			throw new FormatException("El RNC no puede estar vacío.");
		}
		else if(txtCorreo.getText().isEmpty()) {
			throw new FormatException("El correo no puede estar vacío.");
		}
		else if(!txtCorreo.getText().contains("@") || !txtCorreo.getText().contains(".")) {
			throw new FormatException("Formato del correo inválido. Ejemplo: usuario@dominio.com");
		}
		else if(txtTelefono.getText().isEmpty()) {
			throw new FormatException("El teléfono no puede estar vacío.");
		}
		else if(!txtTelefono.getText().matches("\\d{10}")) {
			throw new FormatException("El teléfono debe contener exactamente 10 dígitos numéricos.");
		}
		else if(txtMunicipio.getText().isEmpty()) {
			throw new FormatException("El municipio no puede estar vacío.");
		}
		else if(txtProvincia.getText().isEmpty()) {
			throw new FormatException("La provincia no puede estar vacía.");
		}

		return true;
	}


	private void limpiar() {
		txtCorreo.setText("");
		txtMunicipio.setText("");
		txtNombre.setText("");
		txtProvincia.setText("");
		txtRNC.setText("");
		txtTelefono.setText("");
		cmbSector.setSelectedIndex(0);
	}

	private void cargarDatos() {
		cmbSector.setSelectedIndex(0);
		if(centroAct != null) {
			cmbSector.setSelectedItem(centroAct.getSector());
			txtCodigo.setText(centroAct.getCodigo());
			txtCorreo.setText(centroAct.getCorreo());
			txtMunicipio.setText(centroAct.getMunicipio());
			txtNombre.setText(centroAct.getNombre());
			txtProvincia.setText(centroAct.getProvincia());
			txtRNC.setText(centroAct.getRnc());
			txtTelefono.setText(centroAct.getTelefono());
		}
	}

	private void cargarSector() {
		String nombreSector = cmbSector.getSelectedItem().toString().toLowerCase();
		nombreSector = nombreSector.replace("í","i");
		nombreSector = nombreSector.replace("ó","o");
		nombreSector = nombreSector.replace(" ","");
		lblIcono.setIcon(new ImageIcon("recursos/" + nombreSector + ".png"));
	}
}
