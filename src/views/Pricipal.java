package views;

import java.awt.EventQueue;
import utiles.Colores;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRootPane;
import javax.swing.border.EmptyBorder;

import java.awt.Color;

import java.awt.Toolkit;

import views.components.Navegacion;

import views.usuarios.RequisitosEstudiante;

import java.net.URL;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

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
		if (contentPane.getComponentCount()>1) {
			contentPane.remove(1);
		}
		

		contentPane.add(panel);

	}

	public Pricipal() {
		setTitle("CorreCaminosCujae");

		setIconImage(Toolkit.getDefaultToolkit().getImage(Pricipal.class.getResource("/img/usuario_blanco.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 600);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(31, 33, 36));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(Navegacion.getVista().getBarraNavegacion());
		this.setVista(Inicio.getVista().getPanel_lateral());
	}
	
}
