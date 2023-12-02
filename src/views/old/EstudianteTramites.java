package views.old;


import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;


import java.awt.Toolkit;

import javax.swing.border.TitledBorder;
import javax.swing.border.LineBorder;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTextField;

import javax.swing.JButton;

import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import com.toedter.calendar.JDateChooser;

import controllers.ControladorPrincipal;
import models.departamentos.Secretaria;
import models.usuarios.Estudiante;
import util.Colores;



public class EstudianteTramites extends JFrame {

	private JPanel contentPane;
	private JTextField textMotivo;
	

	/**
	 * Create the frame.
	 */

	public EstudianteTramites(final Estudiante usuarioAutenticado ,final Secretaria secretaria) {
		setResizable(false);
		setTitle("Datos Estudiante");
		setIconImage(
				Toolkit.getDefaultToolkit().getImage(EstudianteTramites.class.getResource("/img/correcamino.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 757, 515);
		contentPane = new JPanel();
		contentPane.setBackground(Colores.BLANCO);
		contentPane.setBorder(new LineBorder(Colores.NEGRO));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(204, 255, 204));
		panel.setBorder(new TitledBorder(new LineBorder(Colores.NEGRO), "Datos Personales", TitledBorder.LEADING,
				TitledBorder.TOP, null, null));
		panel.setBounds(299, 11, 428, 432);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel foto;
		foto = new JLabel("");
		foto.setBorder(null);
		foto.setBackground(new Color(204, 255, 204));
		foto.setFont(new Font("Brush Script MT", Font.PLAIN, 44));
		foto.setBounds(10, 11, 279, 432);
		ImageIcon ico = new ImageIcon(getClass().getResource("/img/est.jpg"));
		ImageIcon img = new ImageIcon(
				ico.getImage().getScaledInstance(foto.getWidth(), foto.getHeight(), Image.SCALE_SMOOTH));
		foto.setIcon((img));
		contentPane.add(foto);

		JLabel lblci = new JLabel("Ci: " + usuarioAutenticado.getCi());
		lblci.setFont(new Font("Arial Narrow", Font.BOLD, 13));
		lblci.setBounds(24, 17, 372, 14);
		panel.add(lblci);

		JLabel lblNombre = new JLabel("Nombre: " + usuarioAutenticado.getNombre());
		lblNombre.setFont(new Font("Arial Narrow", Font.BOLD, 13));
		lblNombre.setBounds(24, 39, 372, 14);
		panel.add(lblNombre);

		JLabel lblFacultad = new JLabel("Facultad: " + usuarioAutenticado.getFacultad());
		lblFacultad.setFont(new Font("Arial Narrow", Font.BOLD, 13));
		lblFacultad.setBounds(24, 66, 372, 14);
		panel.add(lblFacultad);

		JLabel lblCarrera = new JLabel("Carrera: " + usuarioAutenticado.getCarrera());
		lblCarrera.setFont(new Font("Arial Narrow", Font.BOLD, 13));
		lblCarrera.setBounds(24, 94, 372, 14);
		panel.add(lblCarrera);

		JLabel lblTipoCurso = new JLabel("Tipo de curso: " + usuarioAutenticado.getTipoCurso());
		lblTipoCurso.setFont(new Font("Arial Narrow", Font.BOLD, 13));
		lblTipoCurso.setBounds(24, 119, 372, 14);
		panel.add(lblTipoCurso);

		JLabel lblCurso = new JLabel("Curso: " + usuarioAutenticado.getCurso());
		lblCurso.setFont(new Font("Arial Narrow", Font.BOLD, 13));
		lblCurso.setBounds(24, 148, 372, 14);
		panel.add(lblCurso);

		JLabel lblGrupo = new JLabel("Grupo: " + usuarioAutenticado.getGrupo());
		lblGrupo.setFont(new Font("Arial Narrow", Font.BOLD, 13));
		lblGrupo.setBounds(24, 175, 372, 14);
		panel.add(lblGrupo);

		JLabel lblTipoEstudiante = new JLabel("Tipo de estudiante: " + usuarioAutenticado.getClass().getSimpleName());
		lblTipoEstudiante.setFont(new Font("Arial Narrow", Font.BOLD, 13));
		lblTipoEstudiante.setBounds(25, 202, 371, 14);
		panel.add(lblTipoEstudiante);

		JMenuBar menuBar = new JMenuBar();
		menuBar.setBorderPainted(false);
		menuBar.setBorder(null);
		menuBar.setBackground(Colores.BLANCO);
		setJMenuBar(menuBar);

		JMenu mnNewMenu = new JMenu("Opciones");
		menuBar.add(mnNewMenu);

		JMenuItem mntmSalir = new JMenuItem("Salir de la aplicaci\u00F3n");
		mntmSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});

		JMenuItem mntmInicio = new JMenuItem("Cancelar y volver a Inicio");
		mntmInicio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

			}
		});
		mnNewMenu.add(mntmInicio);
		mnNewMenu.add(mntmSalir);

		JMenu mnNewMenu_3 = new JMenu("Ayuda");
		menuBar.add(mnNewMenu_3);

		JMenuItem mntmAcercaDeLa = new JMenuItem("Acerca de la app");
		mnNewMenu_3.add(mntmAcercaDeLa);
		contentPane = new JPanel() {
			public void paintComponent(Graphics g) {
				Image img = Toolkit.getDefaultToolkit().getImage(Inicios.class.getResource("/imagenes/img.jpg"));
				g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);

			}
		};

		final JLabel errorMessage = new JLabel("Existen campos vac\u00EDos");
		errorMessage.setVisible(false);
		errorMessage.setForeground(new Color(204, 0, 0));
		errorMessage.setBounds(158, 405, 168, 14);
		panel.add(errorMessage);

		JButton btnEnviarSolicitud = new JButton("Solicitar Baja");
		btnEnviarSolicitud.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// String nombre = textMotivo.getText();

				// Motivos motivo = textMotivo.getText();

				// if(nombre==null|| nombre.isEmpty() || motivo.isEmpty()||motivo==null)
				// errorMessage.setVisible(true);
				// else{
				// RequisitosBajaEstudiantes b=new RequisitosBajaEstudiantes();
				// b.setVisible(true);
				// dispose();

				// }

			}
		});
		btnEnviarSolicitud.setBorder(new LineBorder(Colores.NEGRO));
		btnEnviarSolicitud.setBackground(SystemColor.inactiveCaptionBorder);
		btnEnviarSolicitud.setBounds(88, 373, 121, 31);
		panel.add(btnEnviarSolicitud);

		JButton btnCancelar = new JButton("Solicitar licencia");
		// Declare fechaSalida as a field of the class

		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				Motivos motivo = textMotivo.getText();
				String fechaInicio = "trtrt";
				
				String fechaFin = "ggtg";
				

				if (motivo.isEmpty() || fechaInicio.isEmpty() || fechaFin.isEmpty())
					errorMessage.setVisible(true);
				else {
					usuarioAutenticado.solicitarLicencia(secretaria, motivo, fechaInicio, fechaFin);
					ControladorPrincipal.mostrarRequisitosBajaEstudiantes();
					dispose();
				}

			}
		});
		btnCancelar.setBorder(new LineBorder(Colores.NEGRO));
		btnCancelar.setBackground(SystemColor.inactiveCaptionBorder);
		btnCancelar.setBounds(244, 373, 121, 31);
		panel.add(btnCancelar);

		JLabel label = new JLabel("Motivo:");
		label.setIgnoreRepaint(true);
		label.setFont(new Font("Arial Narrow", Font.BOLD, 13));
		label.setBounds(24, 244, 86, 14);
		panel.add(label);

		textMotivo = new JTextField();
		// textField.setBorder(new LineBorder(__WBP_NO_TYPE_BINDING.NEGRO, 1));
		textMotivo.setBounds(87, 242, 309, 20);
		panel.add(textMotivo);

		JLabel lblFechaSalidalicencia = new JLabel("Fecha Salida (licencia) :");
		lblFechaSalidalicencia.setFont(new Font("Arial Narrow", Font.BOLD, 13));
		lblFechaSalidalicencia.setBounds(24, 291, 173, 14);
		panel.add(lblFechaSalidalicencia);

		JDateChooser fechaSalida = new JDateChooser();
		fechaSalida.setDateFormatString("dd/MM/yyyy");
		fechaSalida.setBounds(209, 285, 187, 20);
		panel.add(fechaSalida);

		JLabel lblFechaRegresolicencia = new JLabel("Fecha Regreso (licencia) :");
		lblFechaRegresolicencia.setFont(new Font("Arial Narrow", Font.BOLD, 13));
		lblFechaRegresolicencia.setBounds(24, 325, 187, 17);
		panel.add(lblFechaRegresolicencia);

		JDateChooser fechaRegreso = new JDateChooser();
		fechaRegreso.setDateFormatString("dd/MM/yyyy");
		fechaRegreso.setBounds(209, 322, 187, 20);
		panel.add(fechaRegreso);

		setLocationRelativeTo(null);

	}

	
}