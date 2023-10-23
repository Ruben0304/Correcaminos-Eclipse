package vistas.admin;

import java.util.ArrayList;

import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

import modelos.entidades.Estudiante;
import modelos.entidades.Persona;
import modelos.entidades.RecursosHumanos;
import modelos.entidades.Secretaria;
import modelos.entidades.SolicitudLicenciaEstudiante;
import modelos.entidades.Usuario;
import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CasosPendientes extends JFrame {

	private DefaultListModel<String> listModel;
    private JList<String> userList;
	/**
	 * Create the frame.
	 */
	public CasosPendientes(final Usuario usuarioAutenticado, final ArrayList<Usuario> usuarios,
			final Secretaria secretaria, final RecursosHumanos recursosHumanos,
			final ArrayList<Persona> usuariosPendientes) {

		setResizable(false);
		setTitle("Casos Pendientes");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(400, 300);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);

		listModel = new DefaultListModel<>();
        userList = new JList<>(listModel);

        JScrollPane scrollPane = new JScrollPane(userList);
        getContentPane().add(scrollPane, BorderLayout.CENTER);

        for (Persona p : usuariosPendientes) {
		listModel.addElement(p.getCi() + " - " + p.getNombre() + " " + p.getApellidos());
        }

       
        JButton confirmButton = new JButton("Confirmar Entrega");
        confirmButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               
                int selectedIndex = userList.getSelectedIndex();
                if (selectedIndex >= 0) {
                    
                    String selectedUser = listModel.get(selectedIndex);
                    System.out.println("Confirmar entrega para: " + selectedUser);
                }
            }
        });

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(confirmButton);
        getContentPane().add(buttonPanel, BorderLayout.SOUTH);
    
		

	

	}
}
