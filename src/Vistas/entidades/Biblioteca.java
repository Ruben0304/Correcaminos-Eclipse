package Vistas.entidades;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JList;
import javax.swing.JScrollPane;

import controladores.Secretaria;
import modelos.SolicitudLicenciaEstudiante;


public class Biblioteca extends JFrame {

	private JPanel contentPane;
	private JList<String> list;

	

	/**
	 * Create the frame.
	 */
	public Biblioteca() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 714, 490);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(new BorderLayout(0, 0));
		
		DefaultListModel<String> model = new DefaultListModel<>();
		list = new JList<>(model);
		panel.add(new JScrollPane(list), BorderLayout.CENTER);
		
		for(SolicitudLicenciaEstudiante s : Secretaria.getSolicitudesLicencia()){
		model.addElement("Elemento 1");
		}
	}
}
