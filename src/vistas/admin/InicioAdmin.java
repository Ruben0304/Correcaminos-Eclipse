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
		lblQuEs.setBounds(95, 209, 481, 67);
		add(lblQuEs);
		
		JTextArea txtrSuMotivoY = new JTextArea();
		txtrSuMotivoY.setText("¡Bienvenido a la aplicación de gestión de casos y pertenencias!\r\n\r\nEsta aplicación te permite llevar un control de los casos que tienes pendientes de resolver y las\r\n pertenencias que debes recoger o entregar.");
		txtrSuMotivoY.setEditable(false);
		txtrSuMotivoY.setLineWrap(true);
		txtrSuMotivoY.setBackground(new Color(30, 30, 30));
		txtrSuMotivoY.setForeground(Color.WHITE);
		txtrSuMotivoY.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 15));
		
		txtrSuMotivoY.setBounds(95, 276, 734, 126);
		add(txtrSuMotivoY);
		
		JLabel lblSolicitarLicencia = new JLabel("¿ Cómo Administrar ?");
		lblSolicitarLicencia.setForeground(Color.WHITE);
		lblSolicitarLicencia.setFont(new Font("Segoe UI Semibold", Font.BOLD, 35));
		lblSolicitarLicencia.setBounds(95, 405, 481, 67);
		add(lblSolicitarLicencia);
		
		JTextArea txtrEntregaDeTodos = new JTextArea();
		txtrEntregaDeTodos.setText("- Accede al menú de casos pendientes y revisa el estado de cada uno.\r\n- Si tienes que recoger o entregar alguna pertenencia, haz clic en el botón de notificar y selecciona la \r\nopción correspondiente.\r\n- La aplicación se encargará de gestionar el servicio de correcaminos para que puedas recoger o entregar\r\n la pertenencia de forma rápida y segura.\r\n- Una vez que hayas completado el caso, marca la casilla de finalizado y la aplicación lo eliminará de la lista de pendientes.");
		txtrEntregaDeTodos.setEditable(false);
		txtrEntregaDeTodos.setLineWrap(true);
		txtrEntregaDeTodos.setForeground(Color.WHITE);
		txtrEntregaDeTodos.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 15));
		txtrEntregaDeTodos.setBackground(new Color(30, 30, 30));
		txtrEntregaDeTodos.setBounds(95, 473, 734, 162);
		add(txtrEntregaDeTodos);
		
		
	}
}
