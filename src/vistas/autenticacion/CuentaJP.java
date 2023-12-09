package vistas.autenticacion;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JLabel;

import java.awt.Font;
import java.awt.Image;

import javax.swing.JCheckBox;
import javax.swing.JButton;
import javax.swing.border.LineBorder;

import com.formdev.flatlaf.FlatLaf;

import autenticacion.Auth;
import controladores.ControladorLogin;
import modelos.usuarios.Admin;
import modelos.usuarios.Persona;
import vistas.template.Pricipal;

import java.awt.Cursor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CuentaJP extends JPanel {

	/**
	 * Create the panel.
	 */
	public CuentaJP() {
		FlatLaf.registerCustomDefaultsSource("app.themes");
		setBounds(178, 0, 944, 700);
		
		setLayout(null);

		JLabel label = new JLabel("Cuenta");
		label.setBounds(372, 68, 181, 41);
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Segoe UI Semibold", Font.BOLD, 45));
		add(label);

		JLabel label_1 = new JLabel("Usuario:");
		label_1.setForeground(Color.WHITE);
		label_1.setFont(new Font("Segoe UI Semibold", Font.BOLD, 26));
		label_1.setBounds(45, 197, 421, 30);
		add(label_1);

		JLabel label_2 = new JLabel(Auth.getNombreUsuario());
		label_2.setForeground(Color.WHITE);
		label_2.setFont(new Font("Segoe UI Semibold", Font.BOLD, 25));
		label_2.setBounds(173, 190, 432, 43);
		add(label_2);

		JLabel label_3 = new JLabel("");
		label_3.setIcon(new ImageIcon(CuentaJP.class.getResource("/img/loginb.png")));
		label_3.setBounds(634, 130, 266, 283);
		add(label_3);
		
		JButton btnCerrarSesin = new JButton("Cerrar Sesión");
		btnCerrarSesin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ControladorLogin.cerrarSesion();
			}
		});
		btnCerrarSesin.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnCerrarSesin.setForeground(Color.WHITE);
		btnCerrarSesin.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 25));
		btnCerrarSesin.setBackground(new Color(72, 189, 133));
		btnCerrarSesin.setBounds(343, 517, 286, 60);
		add(btnCerrarSesin);
		if (Auth.usuarioAutenticado() instanceof Persona) {
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setForeground(Color.WHITE);
		lblNombre.setFont(new Font("Segoe UI Semibold", Font.BOLD, 26));
		lblNombre.setBounds(45, 263, 421, 30);
		add(lblNombre);
		
		JLabel lblApellidos = new JLabel("Apellidos:");
		lblApellidos.setForeground(Color.WHITE);
		lblApellidos.setFont(new Font("Segoe UI Semibold", Font.BOLD, 26));
		lblApellidos.setBounds(45, 320, 421, 41);
		add(lblApellidos);
		
		
			
		
		JLabel label_4 = new JLabel(((Persona)Auth.usuarioAutenticado()).getNombre());
		label_4.setForeground(Color.WHITE);
		label_4.setFont(new Font("Segoe UI Semibold", Font.BOLD, 25));
		label_4.setBounds(173, 260, 432, 43);
		add(label_4);
		
		JLabel label_5 = new JLabel(((Persona)Auth.usuarioAutenticado()).getApellidos());
		label_5.setForeground(Color.WHITE);
		label_5.setFont(new Font("Segoe UI Semibold", Font.BOLD, 25));
		label_5.setBounds(173, 320, 432, 43);
		add(label_5);
		}
		
		
	}
}
