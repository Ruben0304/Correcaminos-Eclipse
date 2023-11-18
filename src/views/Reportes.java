package views;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JPanel;
import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;

import javax.swing.JRadioButton;

import controllers.ControladorReportes;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Reportes {

	
	private JPanel panel;
	private JLabel lblReportes;
	private JLabel lblHastaListados;
	private JRadioButton rdbtnNewRadioButton;
	private JRadioButton rdbtnNewRadioButton_1;
	private JRadioButton rdbtnNewRadioButton_2;
	private JLabel lblL;
	private JLabel label;
	private JButton btnCancelar;
	private JButton btnVerReporteSeleccionado;
	private static Reportes instance = null;

    public Reportes(){};
    
    public static Reportes getVista() {
        if (instance == null) {
            instance = new Reportes();
        }
        return instance;
    }

	public JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setBackground(Color.DARK_GRAY);
			panel.setBounds(219, 21, 639, 516);
			panel.setLayout(null);
			panel.add(getLblReportes());
			panel.add(getLblHastaListados());
			panel.add(getRdbtnNewRadioButton());
			panel.add(getRdbtnNewRadioButton_1());
			panel.add(getRdbtnNewRadioButton_2());
			panel.add(getLblL());
			panel.add(getLabel());
			panel.add(getBtnCancelar());
			panel.add(getBtnVerReporteSeleccionado());
		}
		return panel;
	}
	private JLabel getLblReportes() {
		if (lblReportes == null) {
			lblReportes = new JLabel("Reportes");
			lblReportes.setForeground(new Color(0, 153, 0));
			lblReportes.setFont(new Font("Arial Black", Font.BOLD, 18));
			lblReportes.setBounds(280, 29, 334, 36);
		}
		return lblReportes;
	}
	private JLabel getLblHastaListados() {
		if (lblHastaListados == null) {
			lblHastaListados = new JLabel("Seleccione el reporte que desea obtener\r\n");
			lblHastaListados.setForeground(Color.WHITE);
			lblHastaListados.setFont(new Font("Arial Black", Font.BOLD, 15));
			lblHastaListados.setBounds(122, 76, 437, 22);
		}
		return lblHastaListados;
	}
	private JRadioButton getRdbtnNewRadioButton() {
		if (rdbtnNewRadioButton == null) {
			rdbtnNewRadioButton = new JRadioButton("Facultad con mayor cantidad de bajas solicitadas\r\n");
			rdbtnNewRadioButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(rdbtnNewRadioButton.isSelected()){
						rdbtnNewRadioButton_1.setEnabled(false);
						rdbtnNewRadioButton_2.setEnabled(false);}
						else{
							rdbtnNewRadioButton_1.setEnabled(true);
							rdbtnNewRadioButton_2.setEnabled(true);}
				}
			});
			rdbtnNewRadioButton.setBackground(Color.DARK_GRAY);
			rdbtnNewRadioButton.setForeground(Color.WHITE);
			rdbtnNewRadioButton.setFont(new Font("Arial", Font.BOLD, 16));
			rdbtnNewRadioButton.setBounds(168, 161, 446, 44);
		}
		return rdbtnNewRadioButton;
	}
	private JRadioButton getRdbtnNewRadioButton_1() {
		if (rdbtnNewRadioButton_1 == null) {
			rdbtnNewRadioButton_1 = new JRadioButton("Total de licencias aceptadas durante el a\u00F1o anterior\r\n");
			rdbtnNewRadioButton_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(rdbtnNewRadioButton_1.isSelected()){
						rdbtnNewRadioButton_2.setEnabled(false);
						rdbtnNewRadioButton.setEnabled(false);}
						else{
							rdbtnNewRadioButton_2.setEnabled(true);
							rdbtnNewRadioButton.setEnabled(true);}
				}
			});
			rdbtnNewRadioButton_1.setBackground(Color.DARK_GRAY);
			rdbtnNewRadioButton_1.setForeground(Color.WHITE);
			rdbtnNewRadioButton_1.setFont(new Font("Arial", Font.BOLD, 16));
			rdbtnNewRadioButton_1.setBounds(168, 300, 446, 36);
		}
		return rdbtnNewRadioButton_1;
	}
	private JRadioButton getRdbtnNewRadioButton_2() {
		if (rdbtnNewRadioButton_2 == null) {
			rdbtnNewRadioButton_2 = new JRadioButton("A\u00F1o durante el cual se aceptaron m\u00E1s bajasen la \u00FAltima d\u00E9cada");
			rdbtnNewRadioButton_2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(rdbtnNewRadioButton_2.isSelected()){
					rdbtnNewRadioButton_1.setEnabled(false);
					rdbtnNewRadioButton.setEnabled(false);}
					else{
						rdbtnNewRadioButton_1.setEnabled(true);
						rdbtnNewRadioButton.setEnabled(true);}
						
				}
			});
			rdbtnNewRadioButton_2.setBackground(Color.DARK_GRAY);
			rdbtnNewRadioButton_2.setForeground(Color.WHITE);
			rdbtnNewRadioButton_2.setFont(new Font("Arial", Font.BOLD, 16));
			rdbtnNewRadioButton_2.setBounds(32, 404, 601, 36);
		}
		return rdbtnNewRadioButton_2;
	}
	private JLabel getLblL() {
		if (lblL == null) {
			lblL = new JLabel("l");
			lblL.setBounds(45, 138, 118, 92);
			
//			ImageIcon ico = new ImageIcon(getClass().getResource("/pruebasss/161d078eaef4acd47cfbe0f0f401efa7.jpg")); 
//			ImageIcon img = new ImageIcon(ico.getImage().getScaledInstance(lblL.getWidth(), lblL.getHeight(), Image.SCALE_SMOOTH));
//			lblL.setIcon((img));
		}
		return lblL;
	}
	private JLabel getLabel() {
		if (label == null) {
			label = new JLabel("l");
			label.setBounds(44, 273, 118, 92);
//			ImageIcon ico = new ImageIcon(getClass().getResource("/pruebasss/383cdd4f690fe24465250e8432a9a806.jpg")); 
//			ImageIcon img = new ImageIcon(ico.getImage().getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_SMOOTH));
//			label.setIcon((img));
		}
		return label;
	}
	private JButton getBtnCancelar() {
		if (btnCancelar == null) {
			btnCancelar = new JButton("Cancelar");
			btnCancelar.setForeground(Color.WHITE);
			btnCancelar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				}
			});
			btnCancelar.setFont(new Font("Arial Black", Font.BOLD, 15));
			btnCancelar.setBounds(349, 466, 265, 39);
			btnCancelar.setBackground(new Color(42, 100, 56));
		}
		return btnCancelar;
	}
	private JButton getBtnVerReporteSeleccionado() {
		if (btnVerReporteSeleccionado == null) {
			btnVerReporteSeleccionado = new JButton("Ver Reporte Seleccionado");
			btnVerReporteSeleccionado.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				if (rdbtnNewRadioButton.isSelected()) {
					ControladorReportes.facultadesConMasBajasAceptadas();
				}
				else if (rdbtnNewRadioButton_1.isSelected()) {
				ControladorReportes.totalLicenciasAceptadasElAnioAnterior();
					
				}
				else if (rdbtnNewRadioButton_2.isSelected()) {
					ControladorReportes.anioConMasBajasLicenciasAceptadasEnUltimos10();
				}
				else{

				}
				}
			});
			btnVerReporteSeleccionado.setForeground(Color.WHITE);
			btnVerReporteSeleccionado.setFont(new Font("Arial Black", Font.BOLD, 15));
			btnVerReporteSeleccionado.setBounds(32, 466, 286, 39);
			btnVerReporteSeleccionado.setBackground(new Color(42, 100, 56));
		}
		return btnVerReporteSeleccionado;
	}
	
	
	
}

