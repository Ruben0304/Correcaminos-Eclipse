package vistas.admin;

import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

import controlador.ControladorAdmin;
import controlador.ControladorLogin;
import modelos.gestion.GestorPrincipal;
import modelos.usuarios.Estudiante;
import modelos.usuarios.Persona;
import modelos.usuarios.Usuario;
import utiles.Colores;

import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import javax.swing.border.LineBorder;

public class SecretariaPendientes extends JFrame {

    private DefaultListModel<String> listModel;
    private JTable table_2;
    private JPanel panel;
    private JLabel lblSSecretaria;
    private JLabel label;
    private JLabel label_1;
    private JLabel label_2;
    private JLabel label_3;
    private JLabel label_4;

    /**
     * Create the frame.
     */
    public SecretariaPendientes(final Usuario usuarioAutenticado,
            final ArrayList<Persona> usuariosPendientes) {
    	getContentPane().setBackground(Colores.BLANCO);

        setResizable(false);
        setTitle("Casos Pendientes");
        setBackground(Colores.BLANCO);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(998, 672);
        setLocationRelativeTo(null);
        getContentPane().setLayout(null);

        // JList<String> userList = new JList<>(new AbstractListModel() {
        // String[] values = new String[] {"ddd", "trt", "u"};
        // public int getSize() {
        // return values.length;
        // }
        // public Object getElementAt(int index) {
        // return values[index];
        // }
        // });
        // userList.setBounds(60, 170, 500, 72);
        // getContentPane().add(userList);

        JButton confirmButton = new JButton("Confirmar Entrega");
        confirmButton.setBounds(765, 565, 137, 25);
        getContentPane().add(confirmButton);

        Object[][] data = new Object[usuariosPendientes.size() + 1][8];
        int i = 1;
         data[0][0] = "Carnet";
         data[0][1] = "Nombre";
         data[0][2] = "Apellidos";
         data[0][3] = "Secretaria";
         data[0][4] = "Biblioteca";
         data[0][5] = "Economia";
         data[0][6] = "A.Libros";
         data[0][7] = "S.Informatica";
        for (Persona p : usuariosPendientes) {
            data[i][0] = p.getCi();
            data[i][1] = p.getNombre();
            data[i][2] = p.getApellidos();
            i++;
        }

        table_2 = new JTable();
        table_2.setBorder(new LineBorder(Colores.NEGRO));
        table_2.setModel(new DefaultTableModel(
                data,
                new String[] {
                        "Carnet", "Nombre", "Apellidos", "S","B","E", "AL", "SI",
                }));
        table_2.setBounds(112, 33, 790, 453);
        getContentPane().add(table_2);

        JButton btnNewButton = new JButton("Ir a login");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                ControladorLogin.cerrarSesion();
                dispose();
            }
        });
        btnNewButton.setBounds(780, 527, 97, 25);
        getContentPane().add(btnNewButton);
        getContentPane().add(getPanel_1());

        confirmButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                int selectedRow = table_2.getSelectedRow();
                if (selectedRow != -1) {
                    String carnet = table_2.getValueAt(selectedRow, 0).toString();

                    // ((Estudiante) GestorPrincipal.buscarUsuarioPorCi(carnet, usuariosPendientes))
                    //         .setLibrosDeBiblioteca(false);
                    // ControladorAdmin.mostrarGestionLicencias();
                    // dispose();
                    DefaultTableModel modelo = (DefaultTableModel) table_2.getModel();

                    modelo.fireTableDataChanged();

                }

            }
        });

    }
	private JPanel getPanel_1() {
		if (panel == null) {
			panel = new JPanel();
			panel.setBorder(new LineBorder(new Color(0, 0, 51), 2, true));
			panel.setBounds(122, 511, 615, 99);
			panel.setLayout(null);
			panel.add(getLblSSecretaria());
			panel.add(getLabel());
			panel.add(getLabel_1());
			panel.add(getLabel_2());
			panel.add(getLabel_3());
			panel.add(getLabel_4());
		}
		return panel;
	}
	private JLabel getLblSSecretaria() {
		if (lblSSecretaria == null) {
			lblSSecretaria = new JLabel("S - Secretaria");
			lblSSecretaria.setBounds(30, 34, 56, 16);
		}
		return lblSSecretaria;
	}
	private JLabel getLabel() {
		if (label == null) {
			label = new JLabel("S - Secretaria");
			label.setBounds(194, 34, 56, 16);
		}
		return label;
	}
	private JLabel getLabel_1() {
		if (label_1 == null) {
			label_1 = new JLabel("S - Secretaria");
			label_1.setBounds(328, 34, 56, 16);
		}
		return label_1;
	}
	private JLabel getLabel_2() {
		if (label_2 == null) {
			label_2 = new JLabel("S - Secretaria");
			label_2.setBounds(451, 34, 56, 16);
		}
		return label_2;
	}
	private JLabel getLabel_3() {
		if (label_3 == null) {
			label_3 = new JLabel("S - Secretaria");
			label_3.setBounds(535, 34, 56, 16);
		}
		return label_3;
	}
	private JLabel getLabel_4() {
		if (label_4 == null) {
			label_4 = new JLabel("S - Secretaria");
			label_4.setBounds(271, 61, 56, 16);
		}
		return label_4;
	}
}
