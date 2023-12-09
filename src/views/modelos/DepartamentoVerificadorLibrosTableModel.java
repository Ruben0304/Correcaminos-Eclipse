package views.modelos;

import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.table.DefaultTableModel;

import auth.Auth;
import models.usuarios.Admin;
import models.usuarios.Estudiante;
import models.usuarios.Persona;
import util.TipoDepartamento;

public class DepartamentoVerificadorLibrosTableModel extends DefaultTableModel {

	private static final long serialVersionUID = 1L;

	Admin admin = (Admin) Auth.usuarioAutenticado();

	public DepartamentoVerificadorLibrosTableModel(ArrayList<Persona> personas) {
		String[] columnNames = {
				"Carnet de Identidad", "Nombre", "Apellidos" };
		this.setColumnIdentifiers(columnNames);
		for (Persona e : personas) {
			Object[] newRow = new Object[] { e.getCi(), e.getNombre(), e.getApellidos() };
			addRow(newRow);
		}

	}

	public DepartamentoVerificadorLibrosTableModel(ArrayList<Persona> personas, String encabezado) {
		String[] columnNames = {
				"Carnet de Identidad", "Nombre", "Apellidos", encabezado };
		this.setColumnIdentifiers(columnNames);

		for (Persona e : personas) {
			Object[] newRow = new Object[] { e.getCi(), e.getNombre(), e.getApellidos(), "Ver Detalles" };
			addRow(newRow);
		}

	}
}
