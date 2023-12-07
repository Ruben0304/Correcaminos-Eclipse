package interfaz_grafica;


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
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.UIManager;

import com.formdev.flatlaf.FlatClientProperties;
import com.formdev.flatlaf.FlatLaf;
import com.formdev.flatlaf.fonts.roboto.FlatRobotoFont;
import com.formdev.flatlaf.themes.FlatMacDarkLaf;


import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.TitledBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class LoginTemplate extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	// Atributos de la clase
	 private JPanel pPrincipal;
	 private ImageIcon iCerrar, iMinimizar,iUsuario, iClave, iDimAux;
	 private JButton bEntrar,bCerrar;
	 private JTextField tNombreUsuario;
	 private JPasswordField tClaveUsuario;
	 private JLabel lTituloLogin, lUsuario, lClave;
	 private JCheckBox checkMantenerSesion;
	 private JPanel panelDatos;
	 
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
		
		FlatRobotoFont.install();
		FlatLaf.registerCustomDefaultsSource("app.themes");
		UIManager.put("defaultFont", new Font(FlatRobotoFont.FAMILY,Font.PLAIN,13));
		FlatMacDarkLaf.setup();
		
		UIManager.put( "Component.innerFocusWidth", 1 );
		UIManager.put( "Button.innerFocusWidth", 1 );
		
		crearImagenes();
		this.crearJPanels();
	    this.crearJTextFields();
	    this.crearJButtons();
	    this.crearJCheckBoxes();
	    this.crearJLabels();
		
		this.setLayout(null);
	    setSize(400, 500);
	}
	
	private void crearImagenes() {
	    iCerrar = new ImageIcon("./src/iconos/cerrar_login_blanco.png");
	    iMinimizar = new ImageIcon("./src/imagenes/minimizar.png");
	    iUsuario = new ImageIcon("./src/iconos/user.png");
	    iClave = new ImageIcon("./src/iconos/password1.png");
	}
	
	public void crearJPanels() {
		
		pPrincipal = new JPanel();
		pPrincipal.setLocation(0, 0);
		pPrincipal.setSize(400, 500);
		pPrincipal.setLayout(null);
		add(pPrincipal);
		
		panelDatos = new JPanel();
	    TitledBorder titulo = new TitledBorder(null, "Ingresar Datos", TitledBorder.CENTER, TitledBorder.TOP, null, Color.WHITE);
		titulo.setTitleFont( new Font(FlatRobotoFont.FAMILY,Font.PLAIN,16));
	    panelDatos.setBorder(titulo);
		panelDatos.setBounds(24, 91, 351, 345);
		pPrincipal.add(panelDatos);
		panelDatos.setLayout(null);
		
	}
	
	public void crearJButtons() {
		//Botón CERRAR
		iDimAux = new ImageIcon(
					iCerrar.getImage()
			        .getScaledInstance(30, 30, Image.SCALE_AREA_AVERAGING)
			    );
		bCerrar = new JButton();
		bCerrar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				ImageIcon image = new ImageIcon("./src/iconos/cerrar_login_rojo.png");
				iDimAux = new ImageIcon(
						image.getImage()
				        .getScaledInstance(30, 30, Image.SCALE_AREA_AVERAGING)
				    );
				bCerrar.setIcon(iDimAux);
				
			}
			@Override
			public void mouseExited(MouseEvent arg0) {
				iDimAux = new ImageIcon(
						iCerrar.getImage()
				        .getScaledInstance(30, 30, Image.SCALE_AREA_AVERAGING)
				    );
				bCerrar.setIcon(iDimAux);
			}
		});
		bCerrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		bCerrar.setLocation(350, 10);
		bCerrar.setSize(45, 30);
		bCerrar.setFocusable(false);
		bCerrar.setCursor(new Cursor(Cursor.HAND_CURSOR));
		bCerrar.setIcon(iDimAux);
		bCerrar.setContentAreaFilled(false);
		pPrincipal.add(bCerrar);	
		
		bEntrar = new JButton("Entrar");
		bEntrar.setBounds(66, 209, 234, 37);
		panelDatos.add(bEntrar);
		bEntrar.setBackground(new Color(72, 189, 133));
		bEntrar.setForeground(Color.BLACK);
		bEntrar.setCursor(new Cursor(Cursor.HAND_CURSOR));
		bEntrar.setContentAreaFilled(true);
	}
	
	public void crearJLabels() {
		// Label TituloLogin
		lTituloLogin = new JLabel("Correcaminos");
		lTituloLogin.setBounds(25, 16, 260, 24);
		lTituloLogin.setFont(new Font(FlatRobotoFont.FAMILY_SEMIBOLD,Font.PLAIN,22));
		pPrincipal.add(lTituloLogin);
					
		iDimAux = new ImageIcon(
				iUsuario.getImage()
		        .getScaledInstance(30, 30, Image.SCALE_AREA_AVERAGING)
		    );
		lUsuario = new JLabel();
		lUsuario.setBounds(21, 64, 46, 38);
		lUsuario.setIcon(iDimAux);
		panelDatos.add(lUsuario);
		
		iDimAux = new ImageIcon(
				iClave.getImage()
		        .getScaledInstance(30, 30, Image.SCALE_AREA_AVERAGING)
		    );
		lClave = new JLabel();
		lClave.setBounds(21, 141, 46, 40);
		lClave.setIcon(iDimAux);
		panelDatos.add(lClave);
		
	
	}
	
	public void crearJTextFields() {
		tClaveUsuario = new JPasswordField();
		tClaveUsuario.setBounds(66, 141, 234, 40);
		tClaveUsuario.putClientProperty(FlatClientProperties.STYLE,"" +
				"showRevealButton:true");
		tClaveUsuario.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT,"Introduzca su contraseña");
		panelDatos.add(tClaveUsuario);
		
		tNombreUsuario = new JTextField();
		tNombreUsuario.setBounds(66, 64, 234, 40);
		panelDatos.add(tNombreUsuario);
		tNombreUsuario.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT,"Introduzca su nombre de usuario");
		tNombreUsuario.putClientProperty(FlatClientProperties.STYLE,"" +
				"showClearButton:true");
	}
	
	public void crearJCheckBoxes() {
		
		checkMantenerSesion = new JCheckBox("Mantener sesión iniciada");
		checkMantenerSesion.setBounds(66, 260, 175, 25);
		panelDatos.add(checkMantenerSesion);
	}
}
