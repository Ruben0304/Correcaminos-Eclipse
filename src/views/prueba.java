package views;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRootPane;
import javax.swing.border.EmptyBorder;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

import java.awt.Toolkit;
import java.awt.FlowLayout;
import java.awt.Font;

import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.lang.reflect.Array;
import java.util.ArrayList;

import javax.swing.JTable;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import controllers.ControladorLogin;
import views.auth.Entrar;
import views.jpersonalizados.JFoto;
import views.jpersonalizados.JImagen;
import views.usuarios.RequisitosEstudiante;

import java.net.URL;

public class prueba extends JFrame {

	private JPanel contentPane;
	private JPanel panel_inicio;
	private JLabel home;
	private JLabel guardar;
	private JLabel account;
	private JLabel gestion;
	private JPanel panel;

	private JLabel reportes;

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
	private JLabel label_1;
	private JLabel label_2;
	private CardLayout contenedor;
	private static prueba instance = null;
	
	private JPanel panel_2;
	private JLabel lblCasosPendientes;
	private JTable table;
	private JButton btnNewButton;
	private JFoto foto;
	private JFoto foto_1;
	private JFoto foto_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					prueba frame = prueba.getInstancia();
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

	public static prueba getInstancia() {
		if (instance == null) {
			instance = new prueba();
		}
		return instance;
	}

	public void setVista(JPanel panel) {
		contentPane.removeAll();
		contentPane.add(getPanel_inicio());
	    contentPane.add(panel);
		
	}

	public prueba() {
		
		setIconImage(Toolkit.getDefaultToolkit().getImage(prueba.class.getResource("/img/usuario_blanco.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1140, 744);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(31, 33, 36));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		this.setVista(RequisitosEstudiante.getVista().getPanel_RequisitosEstud());
	}

	private JPanel getPanel_inicio() {
		if (panel_inicio == null) {
			panel_inicio = new JPanel();
			panel_inicio.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseEntered(MouseEvent e) {
					getPanel_inicio().setBounds(0, 0, 155, 700);
					label_2.setVisible(false);
				}

				@Override
				public void mouseExited(MouseEvent e) {
					getPanel_inicio().setBounds(0, 0, 71, 700);
					getLabel_2().setVisible(true);
				}
			});
			panel_inicio.setBounds(0, 0, 71, 700);
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
			panel_inicio.add(getLabel_1());
			panel_inicio.add(getLabel_2());

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
		
					ControladorLogin.mostrarInicio();
				}

				@Override
				public void mouseEntered(MouseEvent e) {
					getPanel_inicio().setBounds(0, 0, 155, 700);
					label_2.setVisible(false);
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

				@Override
				public void mouseEntered(MouseEvent e) {
					getPanel_inicio().setBounds(0, 0, 155, 700);
					label_2.setVisible(false);
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

				@Override
				public void mouseEntered(MouseEvent e) {
					getPanel_inicio().setBounds(0, 0, 155, 700);
					label_2.setVisible(false);
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

				@Override
				public void mouseEntered(MouseEvent e) {
					getPanel_inicio().setBounds(0, 0, 155, 700);
					label_2.setVisible(false);
				}
			});
			gestion.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			gestion.setIcon(new ImageIcon(prueba.class.getResource("/img/business.png")));
			gestion.setBounds(19, 186, 33, 28);
		}
		return gestion;
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

				@Override
				public void mouseEntered(MouseEvent e) {
					getPanel_inicio().setBounds(0, 0, 155, 700);
					label_2.setVisible(false);
				}
			});
		}
		return reportes;
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

	private JLabel getLabel_1() {
		if (label_1 == null) {
			label_1 = new JLabel("New label");
			label_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			label_1.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					getPanel_inicio().setBounds(0, 0, 71, 700);
					getLabel_2().setVisible(true);
				}
			});
			label_1.setIcon(new ImageIcon(prueba.class.getResource("/img/Menu.png")));
			label_1.setBounds(122, 13, 33, 28);
		}
		return label_1;
	}

	private JLabel getLabel_2() {
		if (label_2 == null) {
			label_2 = new JLabel("New label");
			label_2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			label_2.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					getPanel_inicio().setBounds(0, 0, 155, 700);
					label_2.setVisible(false);
				}
			});
			label_2.setIcon(new ImageIcon(prueba.class.getResource("/img/Menu.png")));
			label_2.setBounds(31, 13, 21, 28);
		}
		return label_2;
	}

	

	private JPanel getPanel_2() {
		if (panel_2 == null) {
			panel_2 = new JPanel();
			panel_2.setBounds(71, 0, 1051, 700);
			panel_2.setBackground(new Color(31, 33, 36));
			panel_2.setLayout(null);
			panel_2.add(getLblCasosPendientes());
			panel_2.add(getTable());
			panel_2.add(getBtnNewButton());
		}
		return panel_2;
	}

	private JLabel getLblCasosPendientes() {
		if (lblCasosPendientes == null) {
			lblCasosPendientes = new JLabel("Casos pendientes");
			lblCasosPendientes.setForeground(Color.WHITE);
			lblCasosPendientes.setFont(new Font("Segoe UI Semibold", Font.BOLD, 40));
			lblCasosPendientes.setBounds(357, 55, 333, 54);
		}
		return lblCasosPendientes;
	}

	private JTable getTable() {
		if (table == null) {
			table = new JTable();
			table.setFillsViewportHeight(true);
			table.setForeground(Color.WHITE);
			table.setBorder(new LineBorder(new Color(255, 255, 255), 9, true));

			ArrayList<Estudiante> usuariosPendientes = new ArrayList<Estudiante>();
			Object[][] data = new Object[usuariosPendientes.size() + 1][3];
			int i = 1;
			data[0][0] = "Carnet";
			data[0][1] = "Nombre";
			data[0][2] = "Apellidos";
			for (Persona p : usuariosPendientes) {

				data[i][0] = p.getCi();
				data[i][1] = p.getNombre();
				data[i][2] = p.getApellidos();
				i++;
			}

			table.setModel(new DefaultTableModel(
					new Object[][] {
							{ null, null, null },
					},
					new String[] {
							"Carnet", "Nombre", "Apellidos"
					}));
			table.setBounds(112, 33, 587, 476);

		}
		return table;
	}

	private JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("New button");
			btnNewButton.setBounds(826, 593, 97, 25);
		}
		return btnNewButton;
	}
}
