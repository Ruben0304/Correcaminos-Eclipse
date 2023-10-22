package vistas.auth;

import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.ImageIcon;

import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

import javax.swing.border.MatteBorder;

import controlador.ControladorLogin;
import modelos.entidades.Usuario;

import javax.swing.SwingConstants;
import javax.swing.JPasswordField;

import utiles.Colores;

import java.awt.Cursor;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField txtUsuario;
	private JPasswordField passwordField;

	/**
	 * Create the frame.
	 */
	public Login(final ArrayList<Usuario> usuariosdePrueba) {

		setType(Type.POPUP);
		setResizable(false);
		setFont(new Font("Arial Narrow", Font.BOLD, 12));
		setIconImage(Toolkit.getDefaultToolkit().getImage(Login.class.getResource("/img/correcamino.png")));
		setTitle("CorrecaminosCujae");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 864, 576);
		setLocationRelativeTo(null);

		contentPane = new JPanel();
		contentPane.setBorder(null);
		contentPane.setBackground(Colores.BLANCO);
		contentPane.setForeground(new Color(0, 0, 0));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBorder(null);
		lblNewLabel.setBackground(new Color(204, 255, 204));
		lblNewLabel.setFont(new Font("Brush Script MT", Font.PLAIN, 44));
		lblNewLabel.setBounds(0, 0, 506, 541);
		ImageIcon ico = new ImageIcon(getClass().getResource("/img/licencia.jpg"));
		ImageIcon img = new ImageIcon(
				ico.getImage().getScaledInstance(lblNewLabel.getWidth(), lblNewLabel.getHeight(), Image.SCALE_SMOOTH));
		lblNewLabel.setIcon(img);
		contentPane.add(lblNewLabel);

		txtUsuario = new JTextField();
		txtUsuario.setBackground(Color.WHITE);
		txtUsuario.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 0, 0)));
		txtUsuario.setBounds(603, 246, 179, 25);
		contentPane.add(txtUsuario);
		txtUsuario.setColumns(10);

		final JLabel ErrorMessages = new JLabel("Datos err\u00F3neos, intente nuevamente");
		ErrorMessages.setVisible(false);
		ErrorMessages.setForeground(new Color(204, 51, 0));
		ErrorMessages.setFont(new Font("Arial Narrow", Font.BOLD, 14));
		ErrorMessages.setBounds(573, 331, 204, 25);
		contentPane.add(ErrorMessages);

		JButton btnLogin = new JButton("Iniciar sesi\u00F3n");
		btnLogin.setBackground(new Color(51, 153, 102));
		btnLogin.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnLogin.setForeground(new Color(255, 255, 255));
		btnLogin.setBorder(null);
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				char[] passwordChars = passwordField.getPassword();
				String contrasena = new String(passwordChars);
				ControladorLogin.autenticar(txtUsuario.getText(), contrasena, usuariosdePrueba);
			}
		});
		btnLogin.setFont(new Font("Arial Narrow", Font.PLAIN, 16));
		btnLogin.setBounds(603, 395, 159, 43);
		contentPane.add(btnLogin);

		JButton btnNewButton_1 = new JButton("Crear cuenta");
		btnNewButton_1.setBackground(Color.WHITE);
		btnNewButton_1.setBorderPainted(false);
		btnNewButton_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton_1.setForeground(new Color(51, 102, 204));
		btnNewButton_1.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		btnNewButton_1.setFont(new Font("Arial Narrow", Font.PLAIN, 16));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CrearCuenta p = new CrearCuenta();
				p.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setBounds(639, 487, 94, 25);
		contentPane.add(btnNewButton_1);

		JLabel lblNewLabel_1 = new JLabel("Usuario");
		lblNewLabel_1.setForeground(new Color(0, 0, 0));
		lblNewLabel_1.setFont(new Font("Arial Narrow", Font.BOLD, 18));
		lblNewLabel_1.setBounds(640, 216, 60, 43);
		contentPane.add(lblNewLabel_1);

		JLabel lblContrasea = new JLabel("Contrase\u00F1a");
		lblContrasea.setForeground(new Color(0, 0, 0));
		lblContrasea.setFont(new Font("Arial Narrow", Font.BOLD, 18));
		lblContrasea.setBounds(625, 275, 124, 35);
		contentPane.add(lblContrasea);

		passwordField = new JPasswordField();
		passwordField.setBackground(Color.WHITE);
		passwordField.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 0, 0)));
		passwordField.setBounds(603, 302, 179, 25);
		passwordField.setColumns(10);
		contentPane.add(passwordField);

		JLabel lblInicioSesin = new JLabel("Inicio  Sesi\u00F3n");
		lblInicioSesin.setForeground(new Color(0, 0, 0));
		lblInicioSesin.setBackground(new Color(255, 255, 255));
		lblInicioSesin.setFont(new Font("Arial Narrow", Font.BOLD, 24));
		lblInicioSesin.setBounds(603, 44, 130, 43);
		contentPane.add(lblInicioSesin);

		JLabel lblEsNuevoa = new JLabel("\u00BFEs nuevo(a)?");
		lblEsNuevoa.setHorizontalAlignment(SwingConstants.CENTER);
		lblEsNuevoa.setForeground(new Color(0, 0, 0));
		lblEsNuevoa.setFont(new Font("Arial Narrow", Font.BOLD, 18));
		lblEsNuevoa.setBounds(603, 455, 159, 25);
		contentPane.add(lblEsNuevoa);

		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setBorder(null);
		lblNewLabel_2.setBounds(540, 228, 48, 43);
		ImageIcon icono = new ImageIcon(Login.class.getResource("/img/usuario.png"));
		ImageIcon imga = new ImageIcon(icono.getImage().getScaledInstance(lblNewLabel_2.getWidth(),
				lblNewLabel_2.getHeight(), Image.SCALE_SMOOTH));
		lblNewLabel_2.setIcon(imga);
		contentPane.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setBounds(627, 100, 94, 86);
		ImageIcon icon = new ImageIcon(getClass().getResource("/img/correcamino.png"));
		ImageIcon imgan = new ImageIcon(icon.getImage().getScaledInstance(lblNewLabel_3.getWidth(),
				lblNewLabel_3.getHeight(), Image.SCALE_SMOOTH));
		lblNewLabel_3.setIcon((imgan));
		contentPane.add(lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setHorizontalTextPosition(SwingConstants.CENTER);
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setBorder(null);
		lblNewLabel_4.setBounds(540, 282, 48, 43);
		ImageIcon iconito = new ImageIcon(getClass().getResource("/img/contrasena.png"));
		ImageIcon imgen = new ImageIcon(iconito.getImage().getScaledInstance(lblNewLabel_4.getWidth(),
				lblNewLabel_4.getHeight(), Image.SCALE_SMOOTH));
		lblNewLabel_4.setIcon(imgen);
		contentPane.add(lblNewLabel_4);

	}
}
