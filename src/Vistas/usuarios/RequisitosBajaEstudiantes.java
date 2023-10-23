package vistas.usuarios;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import modelos.entidades.RecursosHumanos;
import modelos.entidades.Secretaria;
import modelos.entidades.Usuario;
import utiles.Colores;

import java.awt.Toolkit;
import java.awt.Color;

import javax.swing.JCheckBox;
import javax.swing.JButton;

import vistas.Inicio;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;


public class RequisitosBajaEstudiantes extends JFrame {

	private JPanel contentPane;

	
	/**
	 * Create the frame.
	 */
	public RequisitosBajaEstudiantes(Usuario usuarioAutenticado, ArrayList<Usuario> usuarios, Secretaria secretaria, RecursosHumanos recursosHumanos) {
		setResizable(false);
		setTitle("Requisitos para obtener baja");
		setIconImage(Toolkit.getDefaultToolkit().getImage(RequisitosBajaEstudiantes.class.getResource("/img/correcamino.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 672, 457);
		contentPane = new JPanel();
		contentPane.setBackground(Colores.BLANCO);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(204, 255, 204));
		panel.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Requisitos para obtener la baja", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(299, 11, 347, 375);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Literatura Docente");
		lblNewLabel.setFont(new Font("Arial Narrow", Font.BOLD, 13));
		lblNewLabel.setBounds(24, 33, 109, 14);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Biblioteca");
		lblNewLabel_1.setFont(new Font("Arial Narrow", Font.BOLD, 13));
		lblNewLabel_1.setBounds(24, 93, 90, 14);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Direcci\u00F3n de Econom\u00EDa");
		lblNewLabel_2.setFont(new Font("Arial Narrow", Font.BOLD, 13));
		lblNewLabel_2.setBounds(24, 135, 129, 14);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Seguridad Inform\u00E1tica");
		lblNewLabel_3.setFont(new Font("Arial Narrow", Font.BOLD, 13));
		lblNewLabel_3.setBounds(24, 218, 129, 14);
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Secretaria Docente");
		lblNewLabel_4.setFont(new Font("Arial Narrow", Font.BOLD, 13));
		lblNewLabel_4.setBounds(24, 250, 109, 14);
		panel.add(lblNewLabel_4);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("Entregar libros prestados");
		chckbxNewCheckBox.setFont(new Font("Arial Narrow", Font.BOLD, 13));
		chckbxNewCheckBox.setBounds(139, 29, 184, 23);
		chckbxNewCheckBox.setSelected(usuarioAutenticado.tieneLibrosDeBiblioteca());
		panel.add(chckbxNewCheckBox);
		
		JCheckBox chckbxNewCheckBox_1 = new JCheckBox("Entregar materiales de apoyo");
		chckbxNewCheckBox_1.setFont(new Font("Arial Narrow", Font.BOLD, 13));
		chckbxNewCheckBox_1.setBounds(139, 54, 184, 23);
		panel.add(chckbxNewCheckBox_1);
		
		JCheckBox chckbxNewCheckBox_2 = new JCheckBox("No pendiente devoluci\u00F3n de libros");
		chckbxNewCheckBox_2.setFont(new Font("Arial Narrow", Font.BOLD, 13));
		chckbxNewCheckBox_2.setBounds(87, 89, 236, 23);
		panel.add(chckbxNewCheckBox_2);
		
		JCheckBox chckbxDevolucinDePrestamos = new JCheckBox("Devoluci\u00F3n de pr\u00E9stamos");
		chckbxDevolucinDePrestamos.setFont(new Font("Arial Narrow", Font.BOLD, 13));
		chckbxDevolucinDePrestamos.setBounds(150, 155, 173, 23);
		panel.add(chckbxDevolucinDePrestamos);
		
		JCheckBox chckbxManejoDeAyuda = new JCheckBox("Ayuda econ\u00F3mica");
		chckbxManejoDeAyuda.setFont(new Font("Arial Narrow", Font.BOLD, 13));
		chckbxManejoDeAyuda.setBounds(150, 179, 173, 23);
		panel.add(chckbxManejoDeAyuda);
		
		JCheckBox chckbxControlDelEstipendio = new JCheckBox("Control del estipendio");
		chckbxControlDelEstipendio.setFont(new Font("Arial Narrow", Font.BOLD, 13));
		chckbxControlDelEstipendio.setBounds(150, 135, 173, 23);
		panel.add(chckbxControlDelEstipendio);
		
		JCheckBox chckbxNewCheckBox_3 = new JCheckBox("Cerrar cuenta de dominio");
		chckbxNewCheckBox_3.setFont(new Font("Arial Narrow", Font.BOLD, 13));
		chckbxNewCheckBox_3.setBounds(146, 214, 177, 23);
		panel.add(chckbxNewCheckBox_3);
		
		JCheckBox chckbxEntregarCarnetEstudiantil = new JCheckBox("Entregar carnet estudiantil");
		chckbxEntregarCarnetEstudiantil.setFont(new Font("Arial Narrow", Font.BOLD, 13));
		chckbxEntregarCarnetEstudiantil.setBounds(139, 248, 184, 23);
		panel.add(chckbxEntregarCarnetEstudiantil);
		
		JLabel lblDireccinDeBecas = new JLabel("Direcci\u00F3n de becas");
		lblDireccinDeBecas.setFont(new Font("Arial Narrow", Font.BOLD, 13));
		lblDireccinDeBecas.setBounds(24, 289, 109, 14);
		panel.add(lblDireccinDeBecas);
		
		JCheckBox chckbxEntregarPertenencias = new JCheckBox("Entregar pertenencias");
		chckbxEntregarPertenencias.setFont(new Font("Arial Narrow", Font.BOLD, 13));
		chckbxEntregarPertenencias.setBounds(139, 286, 184, 23);
		panel.add(chckbxEntregarPertenencias);
		
		JCheckBox chckbxEntregarCarnetDe = new JCheckBox("Entregar carnet de becario");
		chckbxEntregarCarnetDe.setFont(new Font("Arial Narrow", Font.BOLD, 13));
		chckbxEntregarCarnetDe.setBounds(139, 307, 184, 23);
		panel.add(chckbxEntregarCarnetDe);
		
		JButton btnNewButton = new JButton("Enviar confirmaci\u00F3n de requisitos");
		btnNewButton.setBorder(new LineBorder(new Color(0, 0, 0)));
		btnNewButton.setBackground(SystemColor.inactiveCaptionBorder);
		btnNewButton.setFont(new Font("Arial Narrow", Font.BOLD, 11));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnNewButton.setBounds(64, 337, 216, 23);
		panel.add(btnNewButton);
		
		JLabel foto;
		foto = new JLabel("");
		foto.setBorder(null);
		foto.setBackground(new Color(204, 255, 204));
		foto.setFont(new Font("Brush Script MT", Font.PLAIN, 44));
		foto.setBounds(5, 11, 284, 375);
		ImageIcon ico = new ImageIcon(getClass().getResource("/img/requisitos.jpg")); 
		ImageIcon img = new ImageIcon(ico.getImage().getScaledInstance(foto.getWidth(), foto.getHeight(), Image.SCALE_SMOOTH));
		foto.setIcon((img));
		contentPane.add(foto);
		

		JMenuBar menuBar = new JMenuBar();
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
				// Inicio inicio = new Inicio();
				// inicio.setVisible(true);
				// dispose();
			}
		});
		mnNewMenu.add(mntmInicio);
		mnNewMenu.add(mntmSalir);
		
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
	}
}
