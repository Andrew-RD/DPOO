package visual;

import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JMenuBar;
import javax.swing.JLabel;
import javax.swing.JMenu;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JMenuItem;

import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.LineBorder;

import logico.BolsaLaboral;

public class Principal extends JFrame {

	private JPanel contentPane;
	private Dimension dim;
	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal frame = new Principal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the frame.
	 */
	public Principal() {
		setTitle("Bolsa Laboral");
		setIconImage(Toolkit.getDefaultToolkit().getImage("recursos/icono.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 571, 417);
		dim = super.getToolkit().getScreenSize(); 
		super.setSize(dim.width, dim.height-45);
		setLocationRelativeTo(null);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(Color.WHITE);
		setJMenuBar(menuBar);
		
		JMenu mnCentros = new JMenu("Centros de Trabajo");
		mnCentros.setIcon(new ImageIcon("recursos/empresa.png"));
		mnCentros.setForeground(Color.BLACK);
		mnCentros.setFont(new Font("Segoe UI", Font.BOLD, 20));
		menuBar.add(mnCentros);
		
		JMenuItem mntmCentConsultar = new JMenuItem("  Consultar");
		mntmCentConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ConsultarCentros cons = new ConsultarCentros();
				cons.setModal(true);
				cons.setVisible(true);
			}
		});
		mntmCentConsultar.setIcon(new ImageIcon("recursos/consulta.png"));
		mntmCentConsultar.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		mnCentros.add(mntmCentConsultar);
		
		JMenuItem mntmCentRegistrar = new JMenuItem("  Registrar");
		mntmCentRegistrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RegistroCentro registro = new RegistroCentro(null);
				registro.setModal(true);
				registro.setVisible(true);
			}
		});
		mntmCentRegistrar.setIcon(new ImageIcon("recursos/registro.png"));
		mntmCentRegistrar.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		mnCentros.add(mntmCentRegistrar);
		
		JMenu mnCandidatos = new JMenu("Candidatos");
		mnCandidatos.setIcon(new ImageIcon("recursos/trabajador.png"));
		mnCandidatos.setForeground(Color.BLACK);
		mnCandidatos.setFont(new Font("Segoe UI", Font.BOLD, 20));
		menuBar.add(mnCandidatos);
		
		JMenuItem mntmCandConsultar = new JMenuItem("  Consultar");
		mntmCandConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ConsultarCandidatos cons = new ConsultarCandidatos();
				cons.setModal(true);
				cons.setVisible(true);
			}
		});
		mntmCandConsultar.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		mntmCandConsultar.setIcon(new ImageIcon("recursos/consulta.png"));
		mnCandidatos.add(mntmCandConsultar);
		
		JMenuItem mntmCandRegistrar = new JMenuItem("  Registrar");
		mntmCandRegistrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RegistroCandidato reg = new RegistroCandidato(null);
				reg.setModal(true);
				reg.setVisible(true);
			}
		});
		mntmCandRegistrar.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		mntmCandRegistrar.setIcon(new ImageIcon("recursos/registro.png"));
		mnCandidatos.add(mntmCandRegistrar);
		
		JMenu mnCatlogoDeOfertas = new JMenu("Cat\u00E1logo de Ofertas");
		mnCatlogoDeOfertas.setIcon(new ImageIcon("recursos/conexion.png"));
		mnCatlogoDeOfertas.setForeground(Color.BLACK);
		mnCatlogoDeOfertas.setFont(new Font("Segoe UI", Font.BOLD, 20));
		menuBar.add(mnCatlogoDeOfertas);
		
		JMenuItem mntmCatConsultar = new JMenuItem("  Consultar");
		mntmCatConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ConsultarOfertas cons = new ConsultarOfertas();
				cons.setModal(true);
				cons.setVisible(true);
			}
		});
		mntmCatConsultar.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		mntmCatConsultar.setIcon(new ImageIcon("recursos/consulta.png"));
		mnCatlogoDeOfertas.add(mntmCatConsultar);
		
		JMenuItem mntmCatRegistrar = new JMenuItem("  Registrar");
		mntmCatRegistrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RegistroOfertaLaboral reg = new RegistroOfertaLaboral(null);
				reg.setModal(true);
				reg.setVisible(true);
			}
		});
		mntmCatRegistrar.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		mntmCatRegistrar.setIcon(new ImageIcon("recursos/registro.png"));
		mnCatlogoDeOfertas.add(mntmCatRegistrar);
		
		JMenuItem mntmSolicitudes = new JMenuItem("  Solicitudes");
		mntmSolicitudes.setIcon(new ImageIcon("recursos/solicitud.png"));
		mntmSolicitudes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ConsultarSolicitudes cons = new ConsultarSolicitudes();
				cons.setModal(true);
				cons.setVisible(true);
			}
		});
		mntmSolicitudes.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		mnCatlogoDeOfertas.add(mntmSolicitudes);
		
		JMenu mnGestion = new JMenu("Gesti\u00F3n de Datos");
		mnGestion.setForeground(Color.BLACK);
		mnGestion.setFont(new Font("Segoe UI", Font.BOLD, 20));
		mnGestion.setIcon(new ImageIcon("recursos/gestion.png"));
		menuBar.add(mnGestion);
		
		JMenuItem mntmInformes = new JMenuItem("  Informes");
		mntmInformes.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		mntmInformes.setIcon(new ImageIcon("recursos/informes.png"));
		mnGestion.add(mntmInformes);
		
		JMenuItem mntmRespaldo = new JMenuItem("  Respaldo");
		mntmRespaldo.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		mntmRespaldo.setIcon(new ImageIcon("recursos/respaldo.png"));
		mnGestion.add(mntmRespaldo);
		
		JMenuItem mntmProcesamiento = new JMenuItem("  Procesamiento");
		mntmProcesamiento.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		mntmProcesamiento.setIcon(new ImageIcon("recursos/avanzado.png"));
		mnGestion.add(mntmProcesamiento);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(4, 13, 18));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblFondo = new JLabel("");
		lblFondo.setBounds(0,0, getWidth(),getHeight());
		lblFondo.setIcon(new ImageIcon("recursos/fondo.png"));
		contentPane.add(lblFondo);
		
	}
	
}
