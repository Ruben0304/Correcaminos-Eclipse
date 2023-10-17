import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Toolkit;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
<<<<<<< Updated upstream
=======
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Component;
>>>>>>> Stashed changes


public class Inicio extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Inicio frame = new Inicio();
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
	public Inicio() {
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(Inicio.class.getResource("/imagenes/correcamino.png")));
		setTitle("Inicio");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBorder(null);
		menuBar.setBackground(Color.WHITE);
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("Opciones");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmCerrarSesin = new JMenuItem("Cerrar sesi\u00F3n");
		mntmCerrarSesin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				PantallaInicial login = new PantallaInicial();
				login.setVisible(true);
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
		
		JMenu mnSolicitar = new JMenu("Solicitar");
		mnNewMenu_1.add(mnSolicitar);
		
		JMenuItem mntmLicencia = new JMenuItem("Licencia");
		mnSolicitar.add(mntmLicencia);
		
		JMenuItem mntmBaja = new JMenuItem("Baja");
		mnSolicitar.add(mntmBaja);
		
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
		contentPane = new JPanel(){
			public void paintComponent(Graphics g){
				Image img = Toolkit.getDefaultToolkit().getImage(Inicio.class.getResource("/imagenes/img.jpg"));
				g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(),this);
				
			}
		};
		contentPane.setAlignmentY(Component.BOTTOM_ALIGNMENT);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
<<<<<<< Updated upstream
		setBounds(100, 100, 663, 438);
=======
		contentPane.setLayout(null);
		setBounds(100, 100, 920, 580);
>>>>>>> Stashed changes
		setLocationRelativeTo(null);
	}

}
