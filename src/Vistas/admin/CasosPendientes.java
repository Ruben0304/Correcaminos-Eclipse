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
    
	/**
	 * Create the frame.
	 */
	public CasosPendientes(final Usuario usuarioAutenticado, final ArrayList<Usuario> usuarios,
			final Secretaria secretaria, final RecursosHumanos recursosHumanos,
			final ArrayList<Persona> usuariosPendientes) {

		setResizable(false);
		setTitle("Casos Pendientes");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(786, 645);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);

		

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(0, 458, 640, -458);
        getContentPane().add(scrollPane, BorderLayout.CENTER);

        
        DefaultListModel<String> listModel = new DefaultListModel<>();

        for (Persona p : usuariosPendientes) {
            listModel.addElement(p.getCi() + " - " + p.getNombre() + " " + p.getApellidos());
        }

        JList<String> userList = new JList<>(listModel);
        userList.setBounds(60, 170, 500, 72);
        getContentPane().add(userList);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(null);
        getContentPane().add(buttonPanel, BorderLayout.SOUTH);
        
               
                JButton confirmButton = new JButton("Confirmar Entrega");
                confirmButton.setBounds(546, 132, 137, 25);
                getContentPane().add(confirmButton);
                confirmButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                       
//                        int selectedIndex = userList.getSelectedIndex();
                        if (selectedIndex >= 0) {
                            
//                            String selectedUser = listModel.get(selectedIndex);
                            
                        }
                    }
                });
    
		

	

	}
}
