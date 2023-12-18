package vistas.componentes;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Set;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;
import javax.swing.border.TitledBorder;

import com.formdev.flatlaf.FlatLaf;
import com.formdev.flatlaf.themes.FlatMacDarkLaf;

import autenticacion.Auth;
import modelos.gestion.GestorDepartamentos;
import modelos.usuarios.Empleado;
import modelos.usuarios.Estudiante;
import modelos.usuarios.Persona;

public class VerDetallesLibrosBiblioteca extends JDialog {

	private static final long serialVersionUID = 1L;
	private JPanel panelPrincipal;
	private JPanel panelBotonOk;
	private JTextArea textAreaLibrosPendientes;
	private JPanel panelDatosLibros;
	private JButton btnOK;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			VerDetallesLibrosBiblioteca dialog = new VerDetallesLibrosBiblioteca();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public VerDetallesLibrosBiblioteca() {
		FlatLaf.registerCustomDefaultsSource("app.themes");
		FlatMacDarkLaf.setup();
		
		
		panelPrincipal = new JPanel();
		panelPrincipal.setBounds(0, 0, 436, 263);
		panelPrincipal.setLayout(null);
		panelPrincipal.setBorder(new MatteBorder(1, 1, 1, 1, new Color(72,189,133)));
		getContentPane().add(panelPrincipal);
		
		panelBotonOk = new JPanel();
		panelBotonOk.setBounds(0, 221, 436, 42);
		panelBotonOk.setBorder(new MatteBorder(0, 1, 1, 1, new Color(72,189,133)));
		panelPrincipal.add(panelBotonOk);
		panelBotonOk.setLayout(null);
		
		btnOK = new JButton("OK");
		btnOK.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnOK.setBounds(337, 0, 89, 29);
		panelBotonOk.add(btnOK);
		
		panelDatosLibros = new JPanel();
		panelDatosLibros.setBorder(new TitledBorder(null, "Libros Pendientes", TitledBorder.LEFT, TitledBorder.TOP, null, null));
		panelDatosLibros.setBounds(24, 28, 385, 166);
		panelPrincipal.add(panelDatosLibros);
		panelDatosLibros.setLayout(null);
		
		textAreaLibrosPendientes = new JTextArea();
		textAreaLibrosPendientes.setEditable(false);
		textAreaLibrosPendientes.setBounds(10, 24, 365, 131);
		Set<String> librosPendientes = GestorDepartamentos.gestorDepartamentos().getBiblioteca().obtenerDeudas(((Persona)Auth.usuarioAutenticado()).getCi());
		for (String libro : librosPendientes) {
			textAreaLibrosPendientes.append("-" + libro + "\n");
		}
		panelDatosLibros.add(textAreaLibrosPendientes);
		
		setBounds(250, 200, 436, 263);
		getContentPane().setLayout(null);
		setUndecorated(true);
		
		
	}

}
