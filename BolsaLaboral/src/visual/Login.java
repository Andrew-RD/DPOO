package visual;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import logico.BolsaLaboral;
import logico.Usuario;

import java.awt.Color;
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField txtUsuario;
	private JPasswordField txtContrasena;
	private boolean visible = false;
	private StringBuilder contrasena = new StringBuilder();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				bolsaIO();
				codigoIO();
				try {
					Login frame = new Login();
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
	public Login() {
		setTitle("Iniciar Sesi\u00F3n");
		setIconImage(Toolkit.getDefaultToolkit().getImage("recursos/icono.png"));
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 749, 540);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(4, 13, 18));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(24, 61, 61));
		panel.setBounds(0, 0, 193, 505);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("recursos/user.png"));
		lblNewLabel.setBounds(31, 167, 128, 128);
		panel.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Iniciar Sesi\u00F3n");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Consolas", Font.BOLD, 28));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(205, 24, 514, 62);
		contentPane.add(lblNewLabel_1);

		JSeparator separator = new JSeparator();
		separator.setForeground(Color.WHITE);
		separator.setBounds(236, 84, 454, 2);
		contentPane.add(separator);

		JLabel lblNombreDeUsuario = new JLabel("Nombre de Usuario:");
		lblNombreDeUsuario.setHorizontalAlignment(SwingConstants.LEFT);
		lblNombreDeUsuario.setForeground(Color.WHITE);
		lblNombreDeUsuario.setFont(new Font("Consolas", Font.PLAIN, 18));
		lblNombreDeUsuario.setBounds(236, 109, 454, 62);
		contentPane.add(lblNombreDeUsuario);

		txtUsuario = new JTextField();
		txtUsuario.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		txtUsuario.setBounds(236, 166, 420, 31);
		contentPane.add(txtUsuario);
		txtUsuario.setColumns(10);

		JLabel lblContrasea = new JLabel("Contrase\u00F1a:");
		lblContrasea.setHorizontalAlignment(SwingConstants.LEFT);
		lblContrasea.setForeground(Color.WHITE);
		lblContrasea.setFont(new Font("Consolas", Font.PLAIN, 18));
		lblContrasea.setBounds(236, 210, 454, 62);
		contentPane.add(lblContrasea);

		txtContrasena = new JPasswordField();
		txtContrasena.setEchoChar('*');
		txtContrasena.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		txtContrasena.setColumns(10);
		txtContrasena.setBounds(236, 267, 420, 31);
		contentPane.add(txtContrasena);

		JLabel lblVisible = new JLabel("");
		lblVisible.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				visible = !visible;
				if (visible) {
					txtContrasena.setEchoChar((char) 0);
					lblVisible.setIcon(new ImageIcon("recursos/visible.png"));
				} else {
					txtContrasena.setEchoChar('*');
					lblVisible.setIcon(new ImageIcon("recursos/novisible.png"));
				}
			}
		});
		lblVisible.setIcon(new ImageIcon("recursos/novisible.png"));
		lblVisible.setBounds(668, 266, 32, 32);
		contentPane.add(lblVisible);

		JButton btnIniciarSesion = new JButton("Iniciar Sesi\u00F3n");
		btnIniciarSesion.setBackground(Color.WHITE);
		btnIniciarSesion.setIcon(new ImageIcon("recursos/iniciarsesion.png"));
		btnIniciarSesion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Principal menu = new Principal();
				menu.setVisible(true);
				dispose();
			}
		});
		btnIniciarSesion.setFont(new Font("Segoe UI", Font.BOLD, 18));
		btnIniciarSesion.setBounds(236, 325, 193, 42);
		contentPane.add(btnIniciarSesion);

		JButton btnCerrar = new JButton("Cerrar");
		btnCerrar.setBackground(Color.WHITE);
		btnCerrar.setIcon(new ImageIcon("recursos/cerrar.png"));
		btnCerrar.setFont(new Font("Segoe UI", Font.BOLD, 18));
		btnCerrar.setBounds(449, 325, 205, 42);
		contentPane.add(btnCerrar);
	}

	private static void bolsaIO() {
		FileInputStream bolsaInput;
		FileOutputStream bolsaOut;
		ObjectInputStream bolsaRead;
		ObjectOutputStream bolsaWrite;
		try {
			bolsaInput = new FileInputStream("bolsa.dat");
			bolsaRead = new ObjectInputStream(bolsaInput);
			BolsaLaboral temp = (BolsaLaboral)bolsaRead.readObject();
			BolsaLaboral.setInstancia(temp);
			bolsaInput.close();
			bolsaRead.close();
		} catch (FileNotFoundException e) {
			try {
				bolsaOut = new FileOutputStream("bolsa.dat");
				bolsaWrite = new ObjectOutputStream(bolsaOut);
				Usuario aux = new Usuario("Administrador", "Admin", "Admin");
				BolsaLaboral.getInstancia().regUsuario(aux);
				bolsaWrite.writeObject(BolsaLaboral.getInstancia());
				bolsaOut.close();
				bolsaWrite.close();
			} catch (IOException ex) {
	            ex.printStackTrace();
	        }
		} catch (IOException | ClassNotFoundException e) {
	        e.printStackTrace();
	    }
	}
	
	private static void codigoIO() {
		FileInputStream codigoInput;
		FileOutputStream codigoOut;
		ObjectInputStream codigoRead;
		ObjectOutputStream codigoWrite;
		
		try {
			codigoInput = new FileInputStream("codigos.dat");
			codigoRead = new ObjectInputStream(codigoInput);

			BolsaLaboral.genCodigoCandidato = codigoRead.readInt();
			BolsaLaboral.genCodigoSolicitud = codigoRead.readInt();
			BolsaLaboral.genCodigoOferta = codigoRead.readInt();
			BolsaLaboral.genCodigoCentro = codigoRead.readInt();
			BolsaLaboral.genCodigoVacanteCompletada = codigoRead.readInt();

			codigoInput.close();
			codigoRead.close();
		} catch (IOException e) {
			try {
				codigoOut = new FileOutputStream("codigos.dat");
				codigoWrite = new ObjectOutputStream(codigoOut);

				codigoWrite.writeInt(BolsaLaboral.genCodigoCandidato);
				codigoWrite.writeInt(BolsaLaboral.genCodigoSolicitud);
				codigoWrite.writeInt(BolsaLaboral.genCodigoOferta);
				codigoWrite.writeInt(BolsaLaboral.genCodigoCentro);
				codigoWrite.writeInt(BolsaLaboral.genCodigoVacanteCompletada);

				codigoWrite.close();
				codigoOut.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
	}
	
}
