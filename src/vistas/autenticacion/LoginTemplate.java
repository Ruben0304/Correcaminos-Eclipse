package vistas.autenticacion;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.UIManager;

import com.formdev.flatlaf.FlatClientProperties;
import com.formdev.flatlaf.FlatLaf;
import com.formdev.flatlaf.extras.FlatSVGIcon;
import com.formdev.flatlaf.fonts.roboto.FlatRobotoFont;
import com.formdev.flatlaf.themes.FlatMacDarkLaf;
import com.formdev.flatlaf.themes.FlatMacLightLaf;
import com.formdev.flatlaf.util.ScaledImageIcon;

import controladores.ControladorLogin;
import controladores.ControladorPrincipal;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.TitledBorder;
import javax.swing.border.MatteBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.awt.SystemColor;
import java.awt.Toolkit;

public class LoginTemplate extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// Atributos de la clase
	private JPanel pPrincipal, pIzquierda;
	private ImageIcon iCerrar, iMinimizar, iFondo, iUsuario, iClave, iDimAux, iLogo;
	private JButton bEntrar, bCerrar;
	private JTextField tNombreUsuario;
	private JPasswordField tClaveUsuario;
	private JLabel lEslogan, lTituloLogin, lFondo, lMantenerSesion, lUsuario, lClave;
	private JCheckBox checkMantenerSesion;
	private JTextField textField;
	private JPasswordField passwordField;
	private JPanel panel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginTemplate frame = new LoginTemplate();
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
	public LoginTemplate() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(LoginTemplate.class.getResource("/img/spotillo2.png")));

		// FlatRobotoFont.install();
		// UIManager.put("defaultFont", new Font(FlatLaf.S,Font.PLAIN,13));

		FlatLaf.registerCustomDefaultsSource("app.themes");
		FlatMacDarkLaf.setup();
		
		
		UIManager.put("defaultFont", new Font("Segoe UI", Font.PLAIN, 14));

		UIManager.put("Component.innerFocusWidth", 1);
		UIManager.put("Button.innerFocusWidth", 1);

		crearImagenes();
		this.crearJPanels();
		this.crearJTextFields();
		this.crearJButtons();
		this.crearJCheckBoxes();
		this.crearJLabels();

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		setSize(562, 682);
		setLocationRelativeTo(this);
		setUndecorated(true);

	}

	private void crearImagenes() {
		iCerrar = new ImageIcon(LoginTemplate.class.getResource("/img/cerrar_login_blanco.png"));
		// iMinimizar = new
		// ImageIcon(LoginTemplate.class.getResource("/img/minimizar.png"));
		iFondo = new ImageIcon(LoginTemplate.class.getResource("/img/login.jpg"));
		iUsuario = new ImageIcon(LoginTemplate.class.getResource("/img/user.png"));
		iClave = new ImageIcon(LoginTemplate.class.getResource("/img/password1.png"));
		iLogo = new ImageIcon(LoginTemplate.class.getResource("/img/spotillo2.png"));
	}

	public void crearJPanels() {

		pPrincipal = new JPanel();
		pPrincipal.setLocation(0, 0);
		pPrincipal.setSize(562, 682);
		pPrincipal.setLayout(null);
		// pDerecha.setBackground(Color.WHITE);
		getContentPane().add(pPrincipal);

		panel = new JPanel();
		TitledBorder titulo = new TitledBorder(null, "Ingresar Datos", TitledBorder.CENTER, TitledBorder.TOP, null,
				Color.WHITE);
		titulo.setTitleFont(new Font(FlatRobotoFont.FAMILY, Font.PLAIN, 16));
		panel.setBorder(titulo);
		panel.setBounds(49, 99, 473, 530);
		pPrincipal.add(panel);
		panel.setLayout(null);

	}

	public void crearJButtons() {
		// Bot�n CERRAR
		iDimAux = new ImageIcon(
				iCerrar.getImage()
						.getScaledInstance(30, 30, Image.SCALE_AREA_AVERAGING));
		bCerrar = new JButton();
		bCerrar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				ImageIcon image = new ImageIcon(LoginTemplate.class.getResource("/img/cerrar_login_rojo.png"));
				iDimAux = new ImageIcon(
						image.getImage()
								.getScaledInstance(30, 30, Image.SCALE_AREA_AVERAGING));
				bCerrar.setIcon(iDimAux);

			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				iDimAux = new ImageIcon(
						iCerrar.getImage()
								.getScaledInstance(30, 30, Image.SCALE_AREA_AVERAGING));
				bCerrar.setIcon(iDimAux);
			}
		});
		bCerrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		bCerrar.setLocation(505, 16);
		bCerrar.setSize(45, 30);
		bCerrar.setFocusable(false);
		bCerrar.setCursor(new Cursor(Cursor.HAND_CURSOR));
		bCerrar.setIcon(new ImageIcon(LoginTemplate.class.getResource("/img/cerrar_login_blanco.png")));
		bCerrar.setContentAreaFilled(false);
		pPrincipal.add(bCerrar);

		bEntrar = new JButton("Entrar");
		bEntrar.setBounds(118, 347, 234, 37);
		panel.add(bEntrar);
		bEntrar.setBackground(new Color(72, 189, 133));
		bEntrar.setForeground(SystemColor.textHighlightText);
		bEntrar.setCursor(new Cursor(Cursor.HAND_CURSOR));
		bEntrar.setContentAreaFilled(true);

		bEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				char[] passwordChars = tClaveUsuario.getPassword();
				String contrasena = new String(passwordChars);
				String user = tNombreUsuario.getText();

				if (ControladorLogin.intentarAutenticar(user, contrasena, checkMantenerSesion.isSelected())) {
					ControladorPrincipal.mostrarInicio();
					dispose();

				} else {
					JOptionPane.showMessageDialog(null, "Credenciales incorrectas", "Error de autenticación",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});
	}

	public void crearJLabels() {
		// Label TituloLogin
		lTituloLogin = new JLabel("Correcaminos");
		lTituloLogin.setBounds(100, 16, 185, 43);
		lTituloLogin.setFont(new Font("Segoe UI", Font.PLAIN, 22));
		pPrincipal.add(lTituloLogin);

		iDimAux = new ImageIcon(
				iUsuario.getImage()
						.getScaledInstance(30, 30, Image.SCALE_AREA_AVERAGING));
		lUsuario = new JLabel();
		lUsuario.setBounds(37, 104, 46, 56);
		lUsuario.setIcon(iDimAux);
		panel.add(lUsuario);

		iDimAux = new ImageIcon(
				iClave.getImage()
						.getScaledInstance(30, 30, Image.SCALE_AREA_AVERAGING));
		lClave = new JLabel();
		lClave.setBounds(37, 229, 46, 50);
		lClave.setIcon(iDimAux);
		panel.add(lClave);

		JLabel logo = new JLabel();
		iDimAux = new ImageIcon(
				iLogo.getImage()
						.getScaledInstance(30, 30, Image.SCALE_AREA_AVERAGING));
		logo.setIcon(iDimAux);
		logo.setBounds(49, 16, 39, 43);
		pPrincipal.add(logo);

	}

	public void crearJTextFields() {
		tClaveUsuario = new JPasswordField();
		tClaveUsuario.setBounds(82, 229, 335, 56);
		tClaveUsuario.putClientProperty(FlatClientProperties.STYLE, "" +
				"showRevealButton:true");

		tClaveUsuario.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Introduzca su contraseña");
		tClaveUsuario.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		panel.add(tClaveUsuario);

		tNombreUsuario = new JTextField();
		tNombreUsuario.setBounds(82, 104, 335, 56);
		panel.add(tNombreUsuario);
		tNombreUsuario.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Introduzca su nombre de usuario");
		tNombreUsuario.putClientProperty(FlatClientProperties.STYLE, "" +
				"showClearButton:true");
		

		

	
		tNombreUsuario.setFont(new Font("Segoe UI", Font.PLAIN, 20));
	}

	public void crearJCheckBoxes() {

		checkMantenerSesion = new JCheckBox("Mantener sesi\u00F3n iniciada");
		checkMantenerSesion.setBounds(118, 424, 265, 25);
		checkMantenerSesion.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		panel.add(checkMantenerSesion);
	}
}
