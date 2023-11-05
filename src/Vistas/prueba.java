package vistas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controlador.ControladorLogin;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import java.awt.FlowLayout;
import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class prueba extends JFrame {

	private JPanel contentPane;
	private JPanel panel_inicio;
	private JLabel home;
	private JLabel guardar;
	private JLabel account;
	private JLabel gestion;
	private JLabel label_3;
	private JLabel lblInicio;
	private JLabel reportes;
	private JLabel lblCorrecaminosCujae;
	private JTextArea txtrnecesitasSolicitarUna;
	private JLabel lblQueSomos;
	private JPanel panel_lateral;
	private JLabel lblEntrar;
	private JLabel label_6;
	private JLabel home_bg;
	private JLabel gestion_bg;
	private JLabel reportes_bg;
	private JLabel guardar_bg;
	private JLabel account_bg;
	private JLabel label;
	private JLabel lblGestion;
	private JLabel lblReportes;
	private JLabel lblGuardar;
	private JLabel lblCuenta;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					prueba frame = new prueba();
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
	public prueba() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(prueba.class.getResource("/img/usuario_blanco.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1140, 744);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(31, 33, 36));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getPanel_inicio());
		contentPane.add(getPanel_lateral());
	}
	private JPanel getPanel_inicio() {
		if (panel_inicio == null) {
			panel_inicio = new JPanel();
			panel_inicio.setBounds(0, 0, 155, 700);
			panel_inicio.setAlignmentX(Component.LEFT_ALIGNMENT);
			panel_inicio.setBackground(new Color(20, 20, 20));
			panel_inicio.setLayout(null);
			panel_inicio.add(getHome());
			panel_inicio.add(getGuardar());
			panel_inicio.add(getAccount());
			panel_inicio.add(getGestion());
			panel_inicio.add(getReportes());
			panel_inicio.add(getHome_bg());
			panel_inicio.add(getGestion_bg());
			panel_inicio.add(getReportes_bg());
			panel_inicio.add(getGuardar_bg());
			panel_inicio.add(getAccount_bg());
			panel_inicio.add(getLabel());
			panel_inicio.add(getLblGestion());
			panel_inicio.add(getLblReportes());
			panel_inicio.add(getLabel_1_1());
			panel_inicio.add(getLabel_1_2());
		}
		return panel_inicio;
	}
	private JLabel getHome() {
		if (home == null) {
			home = new JLabel("New label");
			home.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			home.setIcon(new ImageIcon(prueba.class.getResource("/img/inicio.png")));
			home.setBounds(19, 114, 33, 28);
			home.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					getHome_bg().setVisible(true);
					getReportes_bg().setVisible(false);
					getAccount_bg().setVisible(false);
					getGestion_bg().setVisible(false);
					getGuardar_bg().setVisible(false);
				}
			});
		}
		return home;
	}
	private JLabel getGuardar() {
		if (guardar == null) {
			guardar = new JLabel("New label");
			guardar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			guardar.setIcon(new ImageIcon(prueba.class.getResource("/img/Updates.png")));
			guardar.setBounds(19, 330, 33, 28);
			guardar.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					getHome_bg().setVisible(false);
					getReportes_bg().setVisible(false);
					getAccount_bg().setVisible(false);
					getGestion_bg().setVisible(false);
					getGuardar_bg().setVisible(true);
				}
			});
		}
		return guardar;
	}
	private JLabel getAccount() {
		if (account == null) {
			account = new JLabel("New label");
			account.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			account.setIcon(new ImageIcon(prueba.class.getResource("/img/account.png")));
			account.setBounds(19, 638, 33, 28);
			account.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					getHome_bg().setVisible(false);
					getReportes_bg().setVisible(false);
					getAccount_bg().setVisible(true);
					getGestion_bg().setVisible(false);
					getGuardar_bg().setVisible(false);
				}
			});
		}
		return account;
	}
	private JLabel getGestion() {
		if (gestion == null) {
			gestion = new JLabel("New label");
			gestion.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					getHome_bg().setVisible(false);
					getReportes_bg().setVisible(false);
					getAccount_bg().setVisible(false);
					getGestion_bg().setVisible(true);
					getGuardar_bg().setVisible(false);
				}
			});
			gestion.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			gestion.setIcon(new ImageIcon(prueba.class.getResource("/img/business.png")));
			gestion.setBounds(19, 186, 33, 28);
		}
		return gestion;
	}
	private JLabel getLabel_3() {
		if (label_3 == null) {
			label_3 = new JLabel("");
			label_3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			label_3.setBounds(123, 46, 33, 28);
			label_3.setIcon(new ImageIcon(prueba.class.getResource("/img/Back Arrow.png")));
		}
		return label_3;
	}
	private JLabel getLblInicio() {
		if (lblInicio == null) {
			lblInicio = new JLabel("Inicio");
			lblInicio.setBounds(162, 44, 89, 30);
			lblInicio.setForeground(new Color(255, 255, 255));
			lblInicio.setFont(new Font("Segoe UI Semibold", Font.BOLD, 23));
		}
		return lblInicio;
	}
	private JLabel getReportes() {
		if (reportes == null) {
			reportes = new JLabel("New label");
			reportes.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			reportes.setIcon(new ImageIcon(prueba.class.getResource("/img/Business Report.png")));
			reportes.setBounds(19, 258, 33, 28);
			reportes.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					getHome_bg().setVisible(false);
					getReportes_bg().setVisible(true);
					getAccount_bg().setVisible(false);
					getGestion_bg().setVisible(false);
					getGuardar_bg().setVisible(false);
				}
			});
		}
		return reportes;
	}
	private JLabel getLblCorrecaminosCujae() {
		if (lblCorrecaminosCujae == null) {
			lblCorrecaminosCujae = new JLabel("Correcaminos");
			lblCorrecaminosCujae.setBounds(364, 117, 352, 67);
			lblCorrecaminosCujae.setForeground(Color.WHITE);
			lblCorrecaminosCujae.setFont(new Font("Segoe UI Semibold", Font.BOLD, 50));
		}
		return lblCorrecaminosCujae;
	}
	private JTextArea getTxtrnecesitasSolicitarUna() {
		if (txtrnecesitasSolicitarUna == null) {
			txtrnecesitasSolicitarUna = new JTextArea();
			txtrnecesitasSolicitarUna.setBounds(106, 349, 734, 292);
			txtrnecesitasSolicitarUna.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 15));
			txtrnecesitasSolicitarUna.setLineWrap(true);
			txtrnecesitasSolicitarUna.setForeground(new Color(255, 255, 255));
			txtrnecesitasSolicitarUna.setBackground(new Color(31, 33, 36));
//			new Color()
			txtrnecesitasSolicitarUna.setText("\r\n. Correcamino: una app para gestionar bajas y licencias universitarias.\r\n\r\n.\u00BFNecesitas una baja o una licencia? Correcamino te ayuda a solicitarlas y a conocer los requisitos.\r\n\r\n.Correcamino te permite enviar tu solicitud electr\u00F3nicamente, recibir notificaciones, descargar documentos y contactar con el personal.\r\n\r\n.Correcamino es segura, r\u00E1pida y f\u00E1cil de usar. Desc\u00E1rgala y disfruta de sus ventajas.");
		}
		return txtrnecesitasSolicitarUna;
	}
	private JLabel getLblQueSomos() {
		if (lblQueSomos == null) {
			lblQueSomos = new JLabel("Qu\u00E9 somos ?");
			lblQueSomos.setBounds(122, 269, 481, 67);
			lblQueSomos.setForeground(Color.WHITE);
			lblQueSomos.setFont(new Font("Segoe UI Semibold", Font.BOLD, 35));
		}
		return lblQueSomos;
	}
	private JPanel getPanel_lateral() {
		if (panel_lateral == null) {
			panel_lateral = new JPanel();
			panel_lateral.setAlignmentX(Component.LEFT_ALIGNMENT);
			panel_lateral.setBackground(new Color(31, 33, 36));
			panel_lateral.setBounds(70, 0, 1052, 700);
			panel_lateral.setLayout(null);
			panel_lateral.add(getLabel_3());
			panel_lateral.add(getLblInicio());
			panel_lateral.add(getLblCorrecaminosCujae());
			panel_lateral.add(getTxtrnecesitasSolicitarUna());
			panel_lateral.add(getLblQueSomos());
			panel_lateral.add(getLblEntrar());
			panel_lateral.add(getLabel_6());
		}
		return panel_lateral;
	}
	private JLabel getLblEntrar() {
		if (lblEntrar == null) {
			lblEntrar = new JLabel("Entrar");
			lblEntrar.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					ControladorLogin.mostrarLogin();
				}
			});
			lblEntrar.setForeground(Color.WHITE);
			lblEntrar.setFont(new Font("Segoe UI Semibold", Font.BOLD, 20));
			lblEntrar.setBounds(921, 37, 89, 30);
		}
		return lblEntrar;
	}
	private JLabel getLabel_6() {
		if (label_6 == null) {
			label_6 = new JLabel("");
			label_6.setIcon(new ImageIcon(prueba.class.getResource("/img/Accountc.png")));
			label_6.setBounds(879, 37, 40, 37);
		}
		return label_6;
	}
	private JLabel getHome_bg() {
		if (home_bg == null) {
			home_bg = new JLabel("New label");
			home_bg.setIcon(new ImageIcon(prueba.class.getResource("/diagramas/Rounded Square.png")));
			home_bg.setBounds(9, 93, 50, 71);
		}
		return home_bg;
	}
	private JLabel getGestion_bg() {
		if (gestion_bg == null) {
			gestion_bg = new JLabel("New label");
			gestion_bg.setVisible(false);
			gestion_bg.setIcon(new ImageIcon(prueba.class.getResource("/diagramas/Rounded Square.png")));
			gestion_bg.setBounds(9, 165, 50, 71);
		}
		return gestion_bg;
	}
	private JLabel getReportes_bg() {
		if (reportes_bg == null) {
			reportes_bg = new JLabel("New label");
			reportes_bg.setVisible(false);
			reportes_bg.setIcon(new ImageIcon(prueba.class.getResource("/diagramas/Rounded Square.png")));
			reportes_bg.setBounds(9, 237, 50, 71);
		}
		return reportes_bg;
	}
	private JLabel getGuardar_bg() {
		if (guardar_bg == null) {
			guardar_bg = new JLabel("New label");
			guardar_bg.setVisible(false);
			guardar_bg.setIcon(new ImageIcon(prueba.class.getResource("/diagramas/Rounded Square.png")));
			guardar_bg.setBounds(9, 311, 50, 71);
		}
		return guardar_bg;
	}
	private JLabel getAccount_bg() {
		if (account_bg == null) {
			account_bg = new JLabel("New label");
			account_bg.setVisible(false);
			account_bg.setIcon(new ImageIcon(prueba.class.getResource("/diagramas/Rounded Square.png")));
			account_bg.setBounds(9, 617, 50, 71);
		}
		return account_bg;
	}
	private JLabel getLabel() {
		if (label == null) {
			label = new JLabel("Inicio");
			label.setForeground(Color.WHITE);
			label.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 17));
			label.setBounds(71, 112, 89, 30);
		}
		return label;
	}
	private JLabel getLblGestion() {
		if (lblGestion == null) {
			lblGestion = new JLabel("Gestion");
			lblGestion.setForeground(Color.WHITE);
			lblGestion.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 17));
			lblGestion.setBounds(71, 184, 89, 30);
		}
		return lblGestion;
	}
	private JLabel getLblReportes() {
		if (lblReportes == null) {
			lblReportes = new JLabel("Reportes");
			lblReportes.setForeground(Color.WHITE);
			lblReportes.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 17));
			lblReportes.setBounds(71, 258, 89, 30);
		}
		return lblReportes;
	}
	private JLabel getLabel_1_1() {
		if (lblGuardar == null) {
			lblGuardar = new JLabel("Guardar");
			lblGuardar.setForeground(Color.WHITE);
			lblGuardar.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 17));
			lblGuardar.setBounds(71, 327, 89, 30);
		}
		return lblGuardar;
	}
	private JLabel getLabel_1_2() {
		if (lblCuenta == null) {
			lblCuenta = new JLabel("Cuenta");
			lblCuenta.setForeground(Color.WHITE);
			lblCuenta.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 17));
			lblCuenta.setBounds(71, 636, 89, 30);
		}
		return lblCuenta;
	}
}
