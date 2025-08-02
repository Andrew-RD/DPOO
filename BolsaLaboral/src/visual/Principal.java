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

import javax.print.attribute.UnmodifiableSetException;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.LineBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.print.Printable;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

import logico.BolsaLaboral;
import logico.Usuario;
import server.Servidor;

public class Principal extends JFrame {

	private JPanel contentPane;
	private Dimension dim;
	private JMenu mnGestion;
	private JMenu mnCatlogoDeOfertas;
	private JMenu mnCentros;
	private JMenu mnCandidatos;
	private static Socket sfd = null;
	private static DataInputStream EntradaSocket;
	private static DataOutputStream SalidaSocket;
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

		Servidor servidor = new Servidor(7000);
		servidor.start();

		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				saveBolsa();
				saveCodigos();
			}
		});

		setTitle("Bolsa Laboral");
		setIconImage(Toolkit.getDefaultToolkit().getImage("recursos/icono.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setBounds(100, 100, 571, 417);
		dim = super.getToolkit().getScreenSize(); 
		super.setSize(dim.width, dim.height-45);
		setLocationRelativeTo(null);

		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(Color.WHITE);
		setJMenuBar(menuBar);

		mnCentros = new JMenu("Centros de Trabajo");
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

		mnCandidatos = new JMenu("Candidatos");
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

		mnCatlogoDeOfertas = new JMenu("Cat\u00E1logo de Ofertas");
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

		mnGestion = new JMenu("Gesti\u00F3n de Datos");
		mnGestion.setForeground(Color.BLACK);
		mnGestion.setFont(new Font("Segoe UI", Font.BOLD, 20));
		mnGestion.setIcon(new ImageIcon("recursos/gestion.png"));
		menuBar.add(mnGestion);

		JMenuItem mntmRespaldo = new JMenuItem("  Respaldo");
		mntmRespaldo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				saveBolsa();
				saveCodigos();
				
				enviarArchivo("bolsa", "bolsa.dat");
				enviarArchivo("codigos", "codigos.dat");

				JOptionPane.showMessageDialog(null, 
						"Respaldo enviado exitosamente al servidor", 
						"Respaldo Completado", JOptionPane.INFORMATION_MESSAGE);
				
			}
		});
		
		JMenuItem mntmCargarRespaldo = new JMenuItem("  Cargar Respaldo");
		mntmCargarRespaldo.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        cargarRespaldo();
		    }
		});

		JMenuItem mntmProcesamiento = new JMenuItem("  Procesamiento");
		mntmProcesamiento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ProcesamientoAvanzado pros = new ProcesamientoAvanzado();
				pros.setModal(true);
				pros.setVisible(true);
			}
		});
		mntmProcesamiento.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		mntmProcesamiento.setIcon(new ImageIcon("recursos/avanzado.png"));
		mnGestion.add(mntmProcesamiento);
		mntmRespaldo.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		mntmRespaldo.setIcon(new ImageIcon("recursos/respaldo.png"));
		mnGestion.add(mntmRespaldo);
		mntmCargarRespaldo.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		mntmCargarRespaldo.setIcon(new ImageIcon("recursos/respaldo.png"));
		mnGestion.add(mntmCargarRespaldo);
		JMenuItem mntmInformes = new JMenuItem("  Informe");
		mnGestion.add(mntmInformes);
		mntmInformes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InformeGeneral inf = new InformeGeneral();
				inf.setModal(true);
				inf.setVisible(true);
			}
		});
		mntmInformes.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		mntmInformes.setIcon(new ImageIcon("recursos/informes.png"));
		contentPane = new JPanel();
		contentPane.setBackground(new Color(4, 13, 18));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblFondo = new JLabel("");
		lblFondo.setBounds(0,0, getWidth(),getHeight());
		lblFondo.setIcon(new ImageIcon("recursos/fondo.png"));
		contentPane.add(lblFondo);

		userUI();

	}

	private static void saveBolsa() {
		FileOutputStream bolsaOut;
		ObjectOutputStream bolsaWrite;
		try {
			bolsaOut = new FileOutputStream("bolsa.dat");
			bolsaWrite = new ObjectOutputStream(bolsaOut);
			bolsaWrite.writeObject(BolsaLaboral.getInstancia());
			bolsaOut.close();
			bolsaWrite.close();
		} catch (FileNotFoundException ex) {
			ex.printStackTrace();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}

	private static void saveCodigos() {
		try {
			FileOutputStream fileOut = new FileOutputStream("codigos.dat");
			ObjectOutputStream out = new ObjectOutputStream(fileOut);

			out.writeInt(BolsaLaboral.genCodigoCandidato);
			out.writeInt(BolsaLaboral.genCodigoSolicitud);
			out.writeInt(BolsaLaboral.genCodigoOferta);
			out.writeInt(BolsaLaboral.genCodigoCentro);
			out.writeInt(BolsaLaboral.genCodigoVacanteCompletada);

			out.close();
			fileOut.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void userUI() {
		if(!BolsaLaboral.getInstancia().getUsuarioActual().getTipo().equals("Admin")) {
			mnGestion.setEnabled(false);
		}
	}

	private void enviarArchivo(String tipo, String nombreArchivo){
		
		try {
			sfd = new Socket("127.0.0.1", 7000);

			File archivo = new File(nombreArchivo);
			if (!archivo.exists()) {
				JOptionPane.showMessageDialog(null, "Archivo " +  nombreArchivo + " no encontrado", 
						"Error", JOptionPane.ERROR_MESSAGE);
				return;
			}

			EntradaSocket = new DataInputStream(new FileInputStream(archivo));
			SalidaSocket = new DataOutputStream(sfd.getOutputStream());
			
			SalidaSocket.writeUTF(tipo);

			int unByte;

			while ((unByte = EntradaSocket.read()) != -1) {
				SalidaSocket.write(unByte);
			}

			SalidaSocket.flush();
		} catch (UnknownHostException uhe) {
			JOptionPane.showMessageDialog(null, 
					"No se puede acceder al servidor: " + uhe.getMessage(),
					"Error de Conexión", JOptionPane.ERROR_MESSAGE);
		} catch (IOException ioe) {
			JOptionPane.showMessageDialog(null, 
					"Error durante la transferencia: " + ioe.getMessage(), 
					"Error de Comunicación", JOptionPane.ERROR_MESSAGE);
		} finally {
			try {
				if (EntradaSocket != null) {
					EntradaSocket.close();
				}
				if (SalidaSocket != null) {
					SalidaSocket.close();
				}
				if (sfd != null) {
					sfd.close();
				}
			} catch (IOException e1) {
				System.out.println("Error al cerrar recursos: " + e1.getMessage());
			}
		}
	}
	
	private void cargarRespaldo() {
	    JFileChooser fileChooser = new JFileChooser(new File("."));
	    fileChooser.setDialogTitle("Seleccionar archivo de respaldo de la bolsa");
	    fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
	    FileNameExtensionFilter filtroDat = new FileNameExtensionFilter("Archivos de respaldo (.dat)", "dat");
	    fileChooser.setFileFilter(filtroDat);
	    fileChooser.setAcceptAllFileFilterUsed(false);

	    int resultado = fileChooser.showOpenDialog(null);
	    if (resultado != JFileChooser.APPROVE_OPTION) {
	        return;
	    }

	    File archivoBolsa = fileChooser.getSelectedFile();
	    String nombre = archivoBolsa.getName();

	    if (!nombre.startsWith("bolsa_respaldo_") || !nombre.endsWith(".dat")) {
	        JOptionPane.showMessageDialog(null, 
	            "Archivo inválido. Debe ser un respaldo tipo 'bolsa_respaldo_#.dat'", 
	            "Error", JOptionPane.ERROR_MESSAGE);
	        return;
	    }

	    String numero = nombre.replace("bolsa_respaldo_", "").replace(".dat", "");

	    File archivoCodigos = new File("codigos_respaldo_" + numero + ".dat");
	    if (!archivoCodigos.exists()) {
	        JOptionPane.showMessageDialog(null, 
	            "No se encontró el archivo de códigos correspondiente: " + archivoCodigos.getName(), 
	            "Error", JOptionPane.ERROR_MESSAGE);
	        return;
	    }

	    int confirm = JOptionPane.showConfirmDialog(null,
	        "¿Deseas restaurar la bolsa y los códigos desde el respaldo #" + numero + "?",
	        "Confirmar Restauración",
	        JOptionPane.YES_NO_OPTION);

	    if (confirm != JOptionPane.YES_OPTION) return;
	    
	    File archivo = fileChooser.getSelectedFile();
	    if (!archivo.getName().endsWith(".dat")) {
	        JOptionPane.showMessageDialog(null, "El archivo debe tener extensión .dat", "Error", JOptionPane.ERROR_MESSAGE);
	        return;
	    }


	    try (ObjectInputStream bolsaIn = new ObjectInputStream(new FileInputStream(archivoBolsa))) {
	        BolsaLaboral instancia = (BolsaLaboral) bolsaIn.readObject();
	        BolsaLaboral.setInstancia(instancia);
	    } catch (IOException | ClassNotFoundException ex) {
	        ex.printStackTrace();
	        JOptionPane.showMessageDialog(null, 
	            "Error al cargar archivo de bolsa: " + ex.getMessage(), 
	            "Error", JOptionPane.ERROR_MESSAGE);
	        return;
	    }

	    try (DataInputStream codIn = new DataInputStream(new FileInputStream(archivoCodigos))) {
	        BolsaLaboral.genCodigoCandidato = codIn.readInt();
	        BolsaLaboral.genCodigoSolicitud = codIn.readInt();
	        BolsaLaboral.genCodigoOferta = codIn.readInt();
	        BolsaLaboral.genCodigoCentro = codIn.readInt();
	        BolsaLaboral.genCodigoVacanteCompletada = codIn.readInt();
	    } catch (IOException ex) {
	        ex.printStackTrace();
	        JOptionPane.showMessageDialog(null, 
	            "Error al cargar archivo de códigos: " + ex.getMessage(), 
	            "Error", JOptionPane.ERROR_MESSAGE);
	        return;
	    }

	    JOptionPane.showMessageDialog(null, 
	        "Respaldo #" + numero + " restaurado exitosamente.",
	        "Restauración completada", JOptionPane.INFORMATION_MESSAGE);
	}


}
