package vistas.admin;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JTextArea;

import vistas.componentes.LabelUsuario;

public class InicioAdmin extends JPanel{

	/**
	 * Create the panel.
	 */
	public InicioAdmin() {
		setBounds(178, 0, 944, 700);
		
		setLayout(null);
		
		JLabel label_2 = new JLabel("Correcaminos");
		label_2.setForeground(Color.WHITE);
		label_2.setFont(new Font("Segoe UI Semibold", Font.BOLD, 55));
		label_2.setBounds(280, 102, 352, 67);
		add(label_2);
		
		JLabel lblQuEs = new JLabel("Gestiona tus casos pendientes\r\n");
		lblQuEs.setForeground(Color.WHITE);
		lblQuEs.setFont(new Font("Segoe UI Semibold", Font.BOLD, 35));
		lblQuEs.setBounds(96, 250, 481, 67);
		add(lblQuEs);
		
		JTextArea txtrSuMotivoY = new JTextArea();
		txtrSuMotivoY.setEditable(false);
		txtrSuMotivoY.setLineWrap(true);
		txtrSuMotivoY.setBackground(new Color(30, 30, 30));
		txtrSuMotivoY.setForeground(Color.WHITE);
		txtrSuMotivoY.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 15));
		
		txtrSuMotivoY.setBounds(96, 317, 734, 126);
		add(txtrSuMotivoY);
		
		JLabel lblSolicitarLicencia = new JLabel("¿ Como Administrar ?");
		lblSolicitarLicencia.setForeground(Color.WHITE);
		lblSolicitarLicencia.setFont(new Font("Segoe UI Semibold", Font.BOLD, 35));
		lblSolicitarLicencia.setBounds(96, 446, 481, 67);
		add(lblSolicitarLicencia);
		
		JTextArea txtrEntregaDeTodos = new JTextArea();
		txtrEntregaDeTodos.setEditable(false);
		txtrEntregaDeTodos.setLineWrap(true);
		txtrEntregaDeTodos.setForeground(Color.WHITE);
		txtrEntregaDeTodos.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 15));
		txtrEntregaDeTodos.setBackground(new Color(30, 30, 30));
		txtrEntregaDeTodos.setBounds(96, 514, 734, 110);
		add(txtrEntregaDeTodos);
		
		
	}
}
