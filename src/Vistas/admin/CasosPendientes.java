package vistas.admin;

import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

import controlador.ControladorAdmin;
import controlador.ControladorLogin;
import modelos.entidades.Estudiante;
import modelos.entidades.GestorPrincipal;
import modelos.entidades.Persona;
import modelos.entidades.Usuario;
import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CasosPendientes extends JFrame {

    private DefaultListModel<String> listModel;
    private JTable table;
    private JTable table_2;

    /**
     * Create the frame.
     */
    public CasosPendientes(final Usuario usuarioAutenticado,
            final ArrayList<Persona> usuariosPendientes) {

        setResizable(false);
        setTitle("Casos Pendientes");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(786, 645);
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
        confirmButton.setBounds(589, 517, 137, 25);
        getContentPane().add(confirmButton);

        Object[][] data = new Object[usuariosPendientes.size()][3];
        int i = 0;
        for (Persona p : usuariosPendientes) {
            data[i][0] = p.getCi();
            data[i][1] = p.getNombre();
            data[i][2] = p.getApellidos();
            i++;
        }

        table_2 = new JTable();
        table_2.setModel(new DefaultTableModel(
                data,
                new String[] {
                        "Carnet", "Nombre", "Apellidos"
                }));
        table_2.setBounds(112, 33, 587, 476);
        getContentPane().add(table_2);

        JButton btnNewButton = new JButton("Ir a login");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                ControladorLogin.cerrarSesion();
                dispose();
            }
        });
        btnNewButton.setBounds(457, 517, 97, 25);
        getContentPane().add(btnNewButton);

        confirmButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                int selectedRow = table_2.getSelectedRow();
                if (selectedRow != -1) {
                    String carnet = table_2.getValueAt(selectedRow, 0).toString();

                    ((Estudiante) GestorPrincipal.buscarUsuarioPorCi(carnet, usuariosPendientes))
                            .setLibrosDeBiblioteca(false);
                    // ControladorAdmin.mostrarGestionLicencias();
                    // dispose();
                    DefaultTableModel modelo = (DefaultTableModel) table_2.getModel();

                    modelo.fireTableDataChanged();

                }

            }
        });

    }
}
