package vistas;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controlador.ControladorLogin;
import controlador.ControladorPrincipal;
import modelos.entidades.Admin;
import modelos.entidades.RecursosHumanos;
import modelos.entidades.Secretaria;
import modelos.entidades.Usuario;
import utiles.Colores;

import java.awt.Toolkit;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

import vistas.usuarios.EstudianteTramites;

public class Inicio extends JFrame {

	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public Inicio(final Usuario usuarioAutenticado, final ArrayList<Usuario> usuarios, final Secretaria secretaria, final RecursosHumanos recursosHumanos) {
		setBounds(100, 100, 672, 457);
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(Inicio.class.getResource("/img/correcamino.png")));
		setTitle("Inicio - " + usuarioAutenticado.getNombreUsuario() + " (" + usuarioAutenticado.getClass().getSimpleName() + ")");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);

		JMenuBar menuBar = new JMenuBar();
		menuBar.setBorderPainted(false);
		menuBar.setBackground(Colores.BLANCO);
		menuBar.setBorder(null);
		setJMenuBar(menuBar);

		JMenu mnNewMenu = new JMenu("Opciones");

		menuBar.add(mnNewMenu);

		JMenuItem mntmCerrarSesin = new JMenuItem("Cerrar Sesion");
		mntmCerrarSesin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ControladorLogin.cerrarSesion(usuarios,secretaria,recursosHumanos);
				dispose();
			}
		});
		mnNewMenu.add(mntmCerrarSesin);

		JMenuItem mntmSalir = new JMenuItem("Salir");
		mntmSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		mnNewMenu.add(mntmSalir);

		JMenu mnNewMenu_1 = new JMenu("Gesti\u00F3n");
		menuBar.add(mnNewMenu_1);

		if (usuarioAutenticado instanceof Admin) {
			JMenuItem mntmGestionarBaja = new JMenuItem("Gestionar bajas");
			mntmGestionarBaja.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					
				}
			});
			mnNewMenu_1.add(mntmGestionarBaja);

			JMenuItem mntmGestionarLicencia = new JMenuItem("Gestionar licencias");
			mntmGestionarLicencia.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					
				}
			});
			mnNewMenu_1.add(mntmGestionarLicencia);
		} else {

			JMenuItem mntmSolicitarBaja = new JMenuItem("Solicitar baja");
			mntmSolicitarBaja.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					ControladorPrincipal.mostrarTramites(usuarioAutenticado, usuarios);
					dispose();
				}
			});
			mnNewMenu_1.add(mntmSolicitarBaja);

			JMenuItem mntmSolicitarLicencia = new JMenuItem("Solicitar Licencia");
			mntmSolicitarLicencia.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					
				}
			});
			mnNewMenu_1.add(mntmSolicitarLicencia);

		}

		JMenuItem mntmResultadosSolicitud = new JMenuItem("Resultados Solicitud");
		mnNewMenu_1.add(mntmResultadosSolicitud);

		JMenu mnNewMenu_2 = new JMenu("Reportes");
		menuBar.add(mnNewMenu_2);

		JMenuItem mntmSolicitudesPendientes = new JMenuItem("Solicitudes pendientes");
		mnNewMenu_2.add(mntmSolicitudesPendientes);

		JMenuItem mntmFacultadesConMs = new JMenuItem("Facultades con m\u00E1s bajas estudiantiles");
		mnNewMenu_2.add(mntmFacultadesConMs);

		JMenuItem mntmFacultadesConMs_1 = new JMenuItem("Facultades con m\u00E1s bajas de empleados");
		mnNewMenu_2.add(mntmFacultadesConMs_1);

		JMenuItem mntmSolicitudesAprobadasEn = new JMenuItem("Solicitudes aprobadas en el mes");
		mnNewMenu_2.add(mntmSolicitudesAprobadasEn);

		JMenuItem mntmSolicitudesDenegadasEn = new JMenuItem("Solicitudes denegadas en el mes");
		mnNewMenu_2.add(mntmSolicitudesDenegadasEn);

		JMenu mnNewMenu_3 = new JMenu("Ayuda");
		menuBar.add(mnNewMenu_3);

		JMenuItem mntmAcercaDeLa = new JMenuItem("Acerca de la app");
		mnNewMenu_3.add(mntmAcercaDeLa);

		contentPane = new JPanel() {
			public void paintComponent(Graphics g) {
				Image img = Toolkit.getDefaultToolkit().getImage(Inicio.class.getResource("/img/contract.jpg"));
				g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);

			}
		};

		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		setBounds(100, 100, 672, 457);
		setLocationRelativeTo(null);
	}

}
