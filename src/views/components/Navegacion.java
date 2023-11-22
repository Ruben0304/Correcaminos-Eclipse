package views.components;

import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import models.usuarios.Admin;
import models.usuarios.Estudiante;
import models.usuarios.Persona;
import models.usuarios.Usuario;
import views.ChatPanel;
import views.Pricipal;
import auth.Auth;
import controllers.ControladorAdmin;
import controllers.ControladorLogin;
import controllers.ControladorPrincipal;

public class Navegacion extends JPanel {
	private JPanel panel_inicio;
	private JLabel home;
	private JLabel guardar;
	private JLabel account;
	private JLabel gestion;
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
	private static Navegacion instance = null;
	private final Usuario usuarioAutenticado = Auth.usuarioAutenticado();

	private Navegacion() {
		addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				getBarraNavegacion().setBounds(0, 0, 155, 700);
				label_2.setVisible(false);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				getBarraNavegacion().setBounds(0, 0, 71, 700);
				getLabel_2().setVisible(true);
			}
		});
		setBounds(0, 0, 71, 700);
		setAlignmentX(Component.LEFT_ALIGNMENT);
		setBackground(new Color(20, 20, 20));
		setLayout(null);
		add(getHome());
		if (usuarioAutenticado != null && usuarioAutenticado instanceof Admin) {
			

		}
		else if (usuarioAutenticado != null && usuarioAutenticado instanceof Estudiante) {
			add(getReportes());
			// panel_inicio.add(getGuardar());
			add(getLblReportes());
			// panel_inicio.add(getLabel_1_1());
		}

		add(getAccount());
		add(getGestion());

		add(getHome_bg());

		add(getGestion_bg());
		add(getReportes_bg());
		add(getGuardar_bg());
		add(getAccount_bg());
		add(getLabel());
		add(getLblGestion());

		add(getLabel_1_2());
		add(getLabel_1());
		add(getLabel_2());
	}

	public static JPanel getBarraNavegacion() {
		
		return new Navegacion();
	}

	private JLabel getHome() {
		if (home == null) {
			home = new JLabel("New label");
			home.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			home.setIcon(new ImageIcon(Pricipal.class.getResource("/img/inicio.png")));
			home.setBounds(19, 114, 33, 28);
			home.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					getHome_bg().setVisible(true);
					getReportes_bg().setVisible(false);
					getAccount_bg().setVisible(false);
					getGestion_bg().setVisible(false);
					getGuardar_bg().setVisible(false);

					ControladorPrincipal.mostrarInicio();
				}

				@Override
				public void mouseEntered(MouseEvent e) {
					getBarraNavegacion().setBounds(0, 0, 155, 700);
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
			guardar.setIcon(new ImageIcon(Pricipal.class.getResource("/img/Updates.png")));
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
					getBarraNavegacion().setBounds(0, 0, 155, 700);
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
			account.setIcon(new ImageIcon(Pricipal.class.getResource("/img/account.png")));
			account.setBounds(19, 638, 33, 28);
			account.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					getHome_bg().setVisible(false);
					getReportes_bg().setVisible(false);
					getAccount_bg().setVisible(true);
					getGestion_bg().setVisible(false);
					getGuardar_bg().setVisible(false);

					ControladorLogin.mostrarLogin();
				}

				@Override
				public void mouseEntered(MouseEvent e) {
					getBarraNavegacion().setBounds(0, 0, 155, 700);
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

					if (usuarioAutenticado != null) {
						if (usuarioAutenticado instanceof Estudiante) {
							ControladorPrincipal.mostrarRequisitosBajaEstudiantes();
						} else if (usuarioAutenticado instanceof Admin) {
							ControladorAdmin.mostrarGestionLicencias();
						}
					} else {
						ControladorLogin.mostrarLogin();
					}

				}

				@Override
				public void mouseEntered(MouseEvent e) {
					getBarraNavegacion().setBounds(0, 0, 155, 700);
					label_2.setVisible(false);
				}
			});
			gestion.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			gestion.setIcon(new ImageIcon(Pricipal.class.getResource("/img/business.png")));
			gestion.setBounds(19, 186, 33, 28);
		}
		return gestion;
	}

	private JLabel getReportes() {
		if (reportes == null) {
			reportes = new JLabel("New label");
			reportes.setVisible(true);
			reportes.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			reportes.setIcon(new ImageIcon(Pricipal.class.getResource("/img/chat.png")));
			reportes.setBounds(19, 258, 33, 28);
			reportes.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					getHome_bg().setVisible(false);
					getReportes_bg().setVisible(true);
					getAccount_bg().setVisible(false);
					getGestion_bg().setVisible(false);
					getGuardar_bg().setVisible(false);

					ControladorPrincipal.mostrarChats();

				}

				@Override
				public void mouseEntered(MouseEvent e) {
					getBarraNavegacion().setBounds(0, 0, 155, 700);
					label_2.setVisible(false);
				}

			});
		}
		return reportes;
	}

	private JLabel getHome_bg() {
		if (home_bg == null) {
			home_bg = new JLabel("New label");
			home_bg.setIcon(new ImageIcon(Pricipal.class.getResource("/diagramas/Rounded Square.png")));
			home_bg.setBounds(9, 93, 50, 71);
		}
		return home_bg;
	}

	private JLabel getGestion_bg() {
		if (gestion_bg == null) {
			gestion_bg = new JLabel("New label");
			gestion_bg.setVisible(false);
			gestion_bg.setIcon(new ImageIcon(Pricipal.class.getResource("/diagramas/Rounded Square.png")));
			gestion_bg.setBounds(9, 165, 50, 71);
		}
		return gestion_bg;
	}

	private JLabel getReportes_bg() {
		if (reportes_bg == null) {
			reportes_bg = new JLabel("New label");
			reportes_bg.setVisible(false);
			reportes_bg.setIcon(new ImageIcon(Pricipal.class.getResource("/diagramas/Rounded Square.png")));
			reportes_bg.setBounds(9, 237, 50, 71);
		}
		return reportes_bg;
	}

	private JLabel getGuardar_bg() {
		if (guardar_bg == null) {
			guardar_bg = new JLabel("New label");
			guardar_bg.setVisible(false);
			guardar_bg.setIcon(new ImageIcon(Pricipal.class.getResource("/diagramas/Rounded Square.png")));
			guardar_bg.setBounds(9, 311, 50, 71);
		}
		return guardar_bg;
	}

	private JLabel getAccount_bg() {
		if (account_bg == null) {
			account_bg = new JLabel("New label");
			account_bg.setVisible(false);
			account_bg.setIcon(new ImageIcon(Pricipal.class.getResource("/diagramas/Rounded Square.png")));
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
			lblReportes = new JLabel("Chats");
			lblReportes.setVisible(true);
			lblReportes.setForeground(Color.WHITE);
			lblReportes.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 17));
			lblReportes.setBounds(71, 258, 89, 30);
		}
		return lblReportes;
	}

	private JLabel getLabel_1_1() {
		if (lblGuardar == null) {
			lblGuardar = new JLabel("Reportes");
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
					getBarraNavegacion().setBounds(0, 0, 71, 700);
					getLabel_2().setVisible(true);
				}
			});
			label_1.setIcon(new ImageIcon(Pricipal.class.getResource("/img/Menu.png")));
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
					getBarraNavegacion().setBounds(0, 0, 155, 700);
					label_2.setVisible(false);
				}
			});
			label_2.setIcon(new ImageIcon(Pricipal.class.getResource("/img/Menu.png")));
			label_2.setBounds(31, 13, 21, 28);
		}
		return label_2;
	}
}
