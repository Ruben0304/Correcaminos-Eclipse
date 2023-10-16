package Vistas;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Variables.Colores;

import javax.swing.JButton;



public class Interfaz extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Interfaz frame = new Interfaz();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	//crear
	public Interfaz() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Colores.VERDE_CLARO);
		panel.setBounds(5, 5, 359, 243);
		contentPane.add(panel);
		
		JLabel btnNewButton = new JLabel();
		btnNewButton.setText("jjjjj");
		
		
		JPanel panel_1 = new JPanel();
		panel.add(panel_1);
		
		panel.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("New label");
		panel.add(lblNewLabel);
	}
}
