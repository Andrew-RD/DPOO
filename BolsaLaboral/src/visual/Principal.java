package visual;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JLabel;
import javax.swing.JMenu;
import java.awt.Font;
import java.awt.Color;

import javax.imageio.spi.RegisterableService;
import javax.swing.ImageIcon;
import javax.swing.JMenuItem;
import java.awt.FlowLayout;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Principal extends JFrame {

	private JPanel contentPane;
	private Dimension dim;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
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
	}

	/**
	 * Create the frame.
	 */
	public Principal() {
		setTitle("Bolsa Laboral");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 571, 417);
		dim = super.getToolkit().getScreenSize(); 
		super.setSize(dim.width, dim.height-100);
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
		mntmCentConsultar.setIcon(new ImageIcon("recursos/consulta.png"));
		mntmCentConsultar.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		mnCentros.add(mntmCentConsultar);
		
		JMenuItem mntmCentRegistrar = new JMenuItem("  Registrar");
		mntmCentRegistrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RegistrarRepresentante registro = new RegistrarRepresentante(null);
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
		mntmCandConsultar.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		mntmCandConsultar.setIcon(new ImageIcon("recursos/consulta.png"));
		mnCandidatos.add(mntmCandConsultar);
		
		JMenuItem mntmCandRegistrar = new JMenuItem("  Registrar");
		mntmCandRegistrar.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		mntmCandRegistrar.setIcon(new ImageIcon("recursos/registro.png"));
		mnCandidatos.add(mntmCandRegistrar);
		
		JMenu mnCatlogoDeOfertas = new JMenu("Cat\u00E1logo de Ofertas");
		mnCatlogoDeOfertas.setIcon(new ImageIcon("recursos/conexion.png"));
		mnCatlogoDeOfertas.setForeground(Color.BLACK);
		mnCatlogoDeOfertas.setFont(new Font("Segoe UI", Font.BOLD, 20));
		menuBar.add(mnCatlogoDeOfertas);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(4, 13, 18));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
	}

}
