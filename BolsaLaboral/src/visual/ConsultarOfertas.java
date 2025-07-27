package visual;

import logico.*;
import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import exception.NotRemovableException;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.UIManager;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class ConsultarOfertas extends JDialog {

	private final JPanel contentPanel = new JPanel();
	public static JTable table;
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
	private OfertaLaboral seleccionado = null;
	private JButton btnUpdate;
	private JButton btnDelete;
	private JTextField txtFiltro;
	private JButton btnVincular;
	
	/**
	 * Create the dialog.
	 */
	public ConsultarOfertas() {
		setTitle("Listado de Ofertas Laborales");
		setIconImage(Toolkit.getDefaultToolkit().getImage("recursos/icono.png"));
		setBounds(100, 100, 665, 606);
		setResizable(false);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPanel.setBackground(new Color(228,228,228));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JPanel panel = new JPanel();
			panel.setBackground(SystemColor.desktop);
			panel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			contentPanel.add(panel, BorderLayout.CENTER);
			panel.setLayout(new BorderLayout(0, 0));
			{
				JScrollPane scrollPane = new JScrollPane();
				panel.add(scrollPane, BorderLayout.CENTER);
				{
					table = new JTable();
					table.setForeground(Color.BLACK);
					table.setFont(new Font("Segoe UI", Font.PLAIN, 14));
					table.addMouseListener(new MouseAdapter() {
						@Override
						public void mouseClicked(MouseEvent e) {
							int index = table.getSelectedRow();
							if(index >= 0) {
								seleccionado = BolsaLaboral.getInstancia().buscarOfertaByCodigo(table.getValueAt(index, 0).toString());
								btnDelete.setEnabled(true);
								btnUpdate.setEnabled(true);
								btnVincular.setEnabled(true);
							}
						}
					});
					String [] headers = {"C�digo", "Puesto", "Ofertador", "�rea", "Estado"};
					modelo.setColumnIdentifiers(headers);
					table.setModel(modelo);
					scrollPane.setViewportView(table);
				}
			}
		}
		{
			JPanel pnlFiltro = new JPanel();
			pnlFiltro.setBackground(new Color(228, 228, 228));
			contentPanel.add(pnlFiltro, BorderLayout.NORTH);
			{
				JLabel lblIconFiltrar = new JLabel("");
				lblIconFiltrar.setIcon(new ImageIcon("recursos/filtrar.png"));
				pnlFiltro.add(lblIconFiltrar);
				
			}
			{
				JLabel lblNewLabel = new JLabel("Criterio del Filtro: ");
				lblNewLabel.setForeground(Color.BLACK);
				lblNewLabel.setFont(new Font("Segoe UI", Font.BOLD, 16));
				pnlFiltro.add(lblNewLabel);
			}
			{
				txtFiltro = new JTextField();
				txtFiltro.setFont(new Font("Segoe UI", Font.PLAIN, 14));
				txtFiltro.addKeyListener(new KeyAdapter() {
					@Override
					public void keyReleased(KeyEvent e) {
						filtrar();
					}
				});
				pnlFiltro.add(txtFiltro);
				txtFiltro.setColumns(16);
			}
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(new Color(4, 87, 87));
			buttonPane.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				btnUpdate = new JButton("Modificar");
				btnUpdate.setBackground(Color.WHITE);
				btnUpdate.setIcon(new ImageIcon("recursos/modificar.png"));
				btnUpdate.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						btnDelete.setEnabled(true);
						btnUpdate.setEnabled(true);
						btnVincular.setEnabled(true);
						RegistroOfertaLaboral registro = new RegistroOfertaLaboral(seleccionado);
						registro.setVisible(true);
					}
				});
				{
					btnVincular = new JButton("Vincular");
					btnVincular.setIcon(new ImageIcon("recursos/vincular.png"));
					btnVincular.setBackground(Color.WHITE);
					btnVincular.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							ResultadosVinculacion res = new ResultadosVinculacion(seleccionado);
							ResultadosVinculacion.cargarResultados(seleccionado);
							res.setModal(true);
							res.setVisible(true);
							
						}
					});
					btnVincular.setFont(new Font("Segoe UI", Font.BOLD, 16));
					btnVincular.setEnabled(false);
					btnVincular.setActionCommand("OK");
					buttonPane.add(btnVincular);
				}
				btnUpdate.setFont(new Font("Segoe UI", Font.BOLD, 16));
				btnUpdate.setEnabled(false);
				btnUpdate.setActionCommand("OK");
				buttonPane.add(btnUpdate);
				getRootPane().setDefaultButton(btnUpdate);
			}
			{
				btnDelete = new JButton("Eliminar");
				btnDelete.setBackground(Color.WHITE);
				btnDelete.setIcon(new ImageIcon("recursos/eliminar.png"));
				btnDelete.setFont(new Font("Segoe UI", Font.BOLD, 16));
				btnDelete.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(seleccionado != null) {
							int option = JOptionPane.showConfirmDialog(null, "�Esta seguro que desea eliminar la oferta al puesto de " + seleccionado.getPuesto() + " que posee el ID: "+seleccionado.getCodigo()+"?", "Eliminar", JOptionPane.WARNING_MESSAGE);
							if(option == JOptionPane.OK_OPTION){
								btnDelete.setEnabled(true);
								btnUpdate.setEnabled(true);
								try {
									btnDelete.setEnabled(true);
									btnUpdate.setEnabled(true);
									BolsaLaboral.getInstancia().eliminarOfertaTrabajo(seleccionado);
									cargarOfertas();
								}
								catch (NotRemovableException ex) {
									JOptionPane.showMessageDialog(null,ex.getMessage(),"Advertencia",JOptionPane.ERROR_MESSAGE);
								}	
							}
						}
					}
				});
				btnDelete.setEnabled(false);
				buttonPane.add(btnDelete);
			}
			{
				JButton btnCancelar = new JButton("Cancelar");
				btnCancelar.setBackground(Color.WHITE);
				btnCancelar.setIcon(new ImageIcon("recursos/cerrar.png"));
				btnCancelar.setFont(new Font("Segoe UI", Font.BOLD, 16));
				btnCancelar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				btnCancelar.setActionCommand("Cancel");
				buttonPane.add(btnCancelar);
			}
		}

		cargarOfertas();
		table.setRowHeight(36);
		table.getTableHeader().setReorderingAllowed(false);
		table.setBackground(new Color(228, 228, 228));
	}
	
	public void filtrar() {
	    String filtro = txtFiltro.getText().toLowerCase();
	    modelo.setRowCount(0);
	    row = new Object[table.getColumnCount()];
	    
	    seleccionado = null;
	    btnDelete.setEnabled(false);
	    btnUpdate.setEnabled(false);
	    btnVincular.setEnabled(false);
	    
	    for (OfertaLaboral aux : BolsaLaboral.getInstancia().getOfertas()) {
	        boolean coincide = 
	            aux.getCodigo().toLowerCase().contains(filtro) ||
	            aux.getOfertador().getNombre().toLowerCase().contains(filtro) ||
	            aux.getPuesto().toLowerCase().contains(filtro) ||
	            aux.getArea().toLowerCase().contains(filtro) ||
	            aux.getEstado().toLowerCase().contains(filtro);
	        
	        if (coincide) {
	            row[0] = aux.getCodigo();
	            row[1] = aux.getPuesto();
	            row[2] = aux.getOfertador().getNombre();
	            row[3] = new ImageIcon(getImagen(aux.getArea()));
	            row[4] = aux.getEstado();
	            modelo.addRow(row);
	        }
	    }
	}
	
	private static String getImagen(String area) {
		area = area.replace("�","o");
		area = area.replace(" ","");
		return "recursos/" + area + ".png";
	}

	public static void cargarOfertas() {
		modelo.setRowCount(0);
		row = new Object[table.getColumnCount()];
		for (OfertaLaboral aux : BolsaLaboral.getInstancia().getOfertas()) {
            row[0] = aux.getCodigo();
            row[1] = aux.getPuesto();
            row[2] = aux.getOfertador().getNombre();
            row[3] = new ImageIcon(getImagen(aux.getArea()));
            row[4] = aux.getEstado();
			modelo.addRow(row);
		}
	}

}
