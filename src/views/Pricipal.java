package views;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRootPane;
import javax.swing.border.EmptyBorder;

import java.awt.Color;

import java.awt.Toolkit;

import views.components.Navegacion;

import views.usuarios.RequisitosEstudiante;

import java.net.URL;

public class Pricipal extends JFrame {

	private JPanel contentPane;

	private static Pricipal instance = null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Pricipal frame = Pricipal.getInstancia();
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

	public static Pricipal getInstancia() {
		if (instance == null) {
			instance = new Pricipal();
		}
		return instance;
	}

	public void setVista(JPanel panel) {
		
		contentPane.removeAll();
		contentPane.add(Navegacion.getVista().getBarraNavegacion());
		contentPane.add(panel);

	}

	public Pricipal() {

		setIconImage(Toolkit.getDefaultToolkit().getImage(Pricipal.class.getResource("/img/usuario_blanco.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1140, 744);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(31, 33, 36));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		this.setVista(Inicio.getVista().getPanel_lateral());
	}
}
