package visual;

import logico.*;
import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Font;
import javax.swing.border.TitledBorder;
import javax.swing.border.LineBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JSeparator;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class RegistrarRepresentante extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtCodigo;
	private JTextField txtNombre;
	private JTextField txtApellido;
	private JTextField txtCorreo;
	private JTextField txtTelefono;
	private JTextField txtDireccion;
	private JTextField txtCargo;
	private Representante repActualizar;
	private JPanel contenedor;

	/**
	 * Create the dialog.
	 */
	public RegistrarRepresentante(Representante rep) {
		if(rep == null) {
			setTitle("Registro de Representante");
		}
		else {
			setTitle("Modificar Representante");
			repActualizar = rep;
		}
		
		setResizable(false);
		setBounds(100, 100, 476, 528);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			contenedor = new JPanel();
			contenedor.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0), 1, true), "Datos del Representante", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
			contenedor.setBackground(Color.WHITE);
			contentPanel.add(contenedor, BorderLayout.CENTER);
			contenedor.setLayout(null);
			
			JLabel lblNewLabel = new JLabel("C\u00F3digo:");
			lblNewLabel.setForeground(Color.BLACK);
			lblNewLabel.setFont(new Font("Segoe UI", Font.PLAIN, 16));
			lblNewLabel.setBounds(22, 35, 84, 22);
			contenedor.add(lblNewLabel);
			
			txtCodigo = new JTextField();
			txtCodigo.setFont(new Font("Tahoma", Font.PLAIN, 16));
			txtCodigo.setText("REP-" + BolsaLaboral.genCodigoRepresentante);
			txtCodigo.setEditable(false);
			txtCodigo.setBounds(113, 35, 309, 22);
			contenedor.add(txtCodigo);
			txtCodigo.setColumns(10);
			
			JSeparator separator = new JSeparator();
			separator.setForeground(Color.BLACK);
			separator.setBounds(22, 72, 400, 2);
			contenedor.add(separator);
			
			JLabel lblNombre = new JLabel("Nombre:");
			lblNombre.setForeground(Color.BLACK);
			lblNombre.setFont(new Font("Segoe UI", Font.PLAIN, 16));
			lblNombre.setBounds(22, 87, 84, 22);
			contenedor.add(lblNombre);
			
			txtNombre = new JTextField();
			txtNombre.setFont(new Font("Tahoma", Font.PLAIN, 16));
			txtNombre.setColumns(10);
			txtNombre.setBounds(113, 87, 309, 22);
			contenedor.add(txtNombre);
			
			JLabel lblApellido = new JLabel("Apellido:");
			lblApellido.setForeground(Color.BLACK);
			lblApellido.setFont(new Font("Segoe UI", Font.PLAIN, 16));
			lblApellido.setBounds(22, 135, 84, 22);
			contenedor.add(lblApellido);
			
			txtApellido = new JTextField();
			txtApellido.setFont(new Font("Tahoma", Font.PLAIN, 16));
			txtApellido.setColumns(10);
			txtApellido.setBounds(113, 135, 309, 22);
			contenedor.add(txtApellido);
			
			JLabel lblCorreo = new JLabel("Correo:");
			lblCorreo.setForeground(Color.BLACK);
			lblCorreo.setFont(new Font("Segoe UI", Font.PLAIN, 16));
			lblCorreo.setBounds(22, 184, 84, 22);
			contenedor.add(lblCorreo);
			
			txtCorreo = new JTextField();
			txtCorreo.setFont(new Font("Tahoma", Font.PLAIN, 16));
			txtCorreo.setColumns(10);
			txtCorreo.setBounds(113, 184, 309, 22);
			contenedor.add(txtCorreo);
			
			JLabel lblTelfono = new JLabel("Tel\u00E9fono:");
			lblTelfono.setForeground(Color.BLACK);
			lblTelfono.setFont(new Font("Segoe UI", Font.PLAIN, 16));
			lblTelfono.setBounds(22, 233, 84, 22);
			contenedor.add(lblTelfono);
			
			txtTelefono = new JTextField();
			txtTelefono.setFont(new Font("Tahoma", Font.PLAIN, 16));
			txtTelefono.setColumns(10);
			txtTelefono.setBounds(113, 233, 309, 22);
			contenedor.add(txtTelefono);
			
			JLabel lblDireccin = new JLabel("Direcci\u00F3n:");
			lblDireccin.setForeground(Color.BLACK);
			lblDireccin.setFont(new Font("Segoe UI", Font.PLAIN, 16));
			lblDireccin.setBounds(22, 281, 84, 22);
			contenedor.add(lblDireccin);
			
			txtDireccion = new JTextField();
			txtDireccion.setFont(new Font("Tahoma", Font.PLAIN, 16));
			txtDireccion.setColumns(10);
			txtDireccion.setBounds(113, 281, 309, 22);
			contenedor.add(txtDireccion);
			
			JLabel lblCargo = new JLabel("Cargo:");
			lblCargo.setForeground(Color.BLACK);
			lblCargo.setFont(new Font("Segoe UI", Font.PLAIN, 16));
			lblCargo.setBounds(22, 329, 84, 22);
			contenedor.add(lblCargo);
			
			txtCargo = new JTextField();
			txtCargo.setFont(new Font("Tahoma", Font.PLAIN, 16));
			txtCargo.setColumns(10);
			txtCargo.setBounds(113, 329, 309, 22);
			contenedor.add(txtCargo);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(new Color(24, 61, 61));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton btnConfirmar = new JButton(" Confirmar");
				if(repActualizar == null) {
					btnConfirmar.setText("Registrar");
					btnConfirmar.setIcon(new ImageIcon("recursos/agregarP.png"));
				}
				else {
					btnConfirmar.setText("Modificar");
					btnConfirmar.setIcon(new ImageIcon("recursos/editar.png"));
				}
				btnConfirmar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(verificarDatos()) {
							if(txtCorreo.getText().contains("@")) {
								if(repActualizar == null) {
									limpiar();
								}
								else {
									
									dispose();
								}
							}
							else {
								JOptionPane.showMessageDialog(null,"El valor del correo no es válido.","Advertencia",JOptionPane.WARNING_MESSAGE);
							}
						}
						else {
							JOptionPane.showMessageDialog(null,"Todos los datos son obligatorios. Complete todos los registros.","Advertencia",JOptionPane.WARNING_MESSAGE);
						}
					}
				});
				btnConfirmar.setFont(new Font("Segoe UI", Font.PLAIN, 16));
				btnConfirmar.setActionCommand("OK");
				buttonPane.add(btnConfirmar);
				getRootPane().setDefaultButton(btnConfirmar);
			}
			{
				JButton cancelButton = new JButton(" Cancelar");
				cancelButton.setIcon(new ImageIcon("recursos/cerrar.png"));
				cancelButton.setFont(new Font("Segoe UI", Font.PLAIN, 16));
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		
		cargarDatos(rep);
	}
	
	private void limpiar() {
		for(Object objeto : contenedor.getComponents()) {
			if(objeto instanceof JTextField) {
				((JTextField) objeto).setText("");
			}
		}
		
		txtCodigo.setText("REP-" + BolsaLaboral.genCodigoRepresentante);
	}
	
	private boolean verificarDatos() {
		if(txtApellido.getText().isEmpty() || txtCargo.getText().isEmpty() || txtCorreo.getText().isEmpty() || txtDireccion.getText().isEmpty() || txtNombre.getText().isEmpty() || txtTelefono.getText().isEmpty()) {
			return false;
		}
		return true;
	}
	
	private void cargarDatos(Representante rep) {
		if(rep != null) {
			txtCodigo.setText(rep.getCodigo());
			txtApellido.setText(rep.getApellidos());
			txtCargo.setText(rep.getCargo());
			txtCorreo.setText(rep.getCorreo());
			txtDireccion.setText(rep.getDireccion());
			txtNombre.setText(rep.getNombres());
			txtTelefono.setText(rep.getTelefono());
		}
	}
}
