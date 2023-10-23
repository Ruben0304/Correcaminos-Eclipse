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

public class Biblioteca extends JFrame {

	private JPanel contentPane;
	private JList<String> list;
	private DefaultTableModel tableModel;
	private JTable table;
	private JButton button;

	/**
	 * Create the frame.
	 */
	public Biblioteca(final Usuario usuarioAutenticado, final ArrayList<Usuario> usuarios,
			final Secretaria secretaria, final RecursosHumanos recursosHumanos,
			final ArrayList<Persona> usuariosPendientes) {

		setResizable(false);
		setTitle("Biblioteca");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(400, 300);
		setLocationRelativeTo(null);

		Object[][] data = new Object[usuariosPendientes.size()][2];

		for (int i = 0; i < usuariosPendientes.size(); i++) {
			data[i][0] = usuariosPendientes.get(i).getCi();
			data[i][1] = usuariosPendientes.get(i).getNombre();
		}

		// Nombres de las columnas
		String[] columnNames = { "CI", "Nombre", };

		// Crea el modelo de la tabla
		tableModel = new DefaultTableModel(data, columnNames);

		// Crea la tabla con el modelo
		table = new JTable(tableModel);

		// Agrega una columna adicional para los botones
		tableModel.addColumn("Confirmar Entrega");

		
		

		

			}
}
