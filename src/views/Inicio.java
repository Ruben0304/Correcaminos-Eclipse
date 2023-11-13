package views;

import java.awt.BorderLayout;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controllers.ControladorAdmin;
import controllers.ControladorLogin;
import controllers.ControladorPrincipal;
import models.gestion.estudiantes.GestorSolicitudesEstudiante;
import models.usuarios.Admin;
import models.usuarios.Estudiante;
import models.usuarios.Usuario;
import utiles.Colores;

import java.awt.Toolkit;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

import java.awt.event.ActionListener;

import java.awt.event.ActionEvent;

public class Inicio extends JFrame {

	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public Inicio(Usuario usuarioAutenticado,Boolean estudianteSolicitaLicencia) {
		setBounds(100, 100, 672, 457);
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(Inicio.class.getResource("/img/correcamino.png")));
		setTitle("Inicio - " + usuarioAutenticado.getNombreUsuario() + " ("
				+ usuarioAutenticado.getClass().getSimpleName() + ")");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);

		JMenuBar menuBar = new JMenuBar();
		menuBar.setBorderPainted(false);
		menuBar.setBackground(Colores.BLANCO);
		menuBar.setForeground(Colores.TEXTO_GRIS);
		menuBar.setBorder(null);
		setJMenuBar(menuBar);

		JMenu mnNewMenu = new JMenu("Opciones");
		mnNewMenu.setForeground(Colores.TEXTO_OSCURO);

		menuBar.add(mnNewMenu);

		JMenuItem mntmCerrarSesin = new JMenuItem("Cerrar Sesion");
		
		mntmCerrarSesin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ControladorLogin.cerrarSesion();
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
		mnNewMenu_1.setForeground(Colores.TEXTO_OSCURO);
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
					ControladorAdmin.mostrarGestionLicencias();
					dispose();
				}
			});
			mnNewMenu_1.add(mntmGestionarLicencia);
		} else {
			if (estudianteSolicitaLicencia) {
				JMenuItem mntmSolicitarBaja = new JMenuItem("Verificar Estado Solicitud");
				
				mntmSolicitarBaja.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						ControladorPrincipal.mostrarRequisitosBajaEstudiantes();
						dispose();
					}
				});
				mnNewMenu_1.add(mntmSolicitarBaja);
			} else {
				JMenuItem mntmSolicitarBaja = new JMenuItem("Solicitar baja");
				
				mntmSolicitarBaja.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						ControladorPrincipal.mostrarTramites();
						dispose();
					}
				});
				mnNewMenu_1.add(mntmSolicitarBaja);

				JMenuItem mntmSolicitarLicencia = new JMenuItem("Solicitar Licencia");
			
				mntmSolicitarLicencia.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						ControladorPrincipal.mostrarTramites();
						dispose();
					}
				});
				mnNewMenu_1.add(mntmSolicitarLicencia);

			}
		}

		JMenuItem mntmResultadosSolicitud = new JMenuItem("Resultados Solicitud");
		
		mnNewMenu_1.add(mntmResultadosSolicitud);

		JMenu mnNewMenu_2 = new JMenu("Reportes");
		mnNewMenu_2.setForeground(Colores.TEXTO_OSCURO);
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
		mnNewMenu_3.setForeground(Colores.TEXTO_OSCURO);
		menuBar.add(mnNewMenu_3);


		JMenuItem mntmAcercaDeLa = new JMenuItem("Acerca de la app");
		
		mnNewMenu_3.add(mntmAcercaDeLa);
		
		JMenu mnDatos = new JMenu("Datos");
		mnDatos.setForeground(Colores.TEXTO_OSCURO);
		menuBar.add(mnDatos);
		
		JMenuItem mntmGuardar = new JMenuItem("Guardar");
		mntmGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ControladorPrincipal.actualizarDatos();
				dispose();
			}
		});
		mnDatos.add(mntmGuardar);

		

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
