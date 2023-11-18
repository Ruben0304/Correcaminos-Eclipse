package views.admin;

import javax.swing.table.DefaultTableModel;
import util.Facultad;
import models.usuarios.Estudiante;

import java.util.ArrayList;
import java.util.Vector;

public class PendientesEstudiantes extends DefaultTableModel {

	private static final long serialVersionUID = 1L;

	public PendientesEstudiantes() {
		String[] columnNames = {
				"DNI", "Nombre", "Apellido", "Carrera" };
		this.setColumnIdentifiers(columnNames);
	}

	public PendientesEstudiantes(ArrayList<Estudiante> estudiantes) {
		String[] columnNames = {
				"DNI", "Nombre", "Apellido", "Carrera" };
		this.setColumnIdentifiers(columnNames);
		for (Estudiante e : estudiantes) {
			Object[] newRow = new Object[] { e.getCi(), e.getNombre(), e.getApellidos(),
					e.getCarrera() };
			addRow(newRow);
		}

	}

	public void adicionar(String Nombre, String PrimerApellido, String SegundoApellido, Facultad Facultad) {
		Object[] newRow = new Object[] { Nombre, PrimerApellido, SegundoApellido, Facultad };
		addRow(newRow);
	}

	public void eliminar(int pos) {
		removeRow(pos);
	}

	@SuppressWarnings("unchecked")
	public void modificar(int pos, String Nombre, String PrimerApellido, String SegundoApellido, Facultad Facultad) {
		Object[] newRow = new Object[] { Nombre, PrimerApellido, SegundoApellido, Facultad };

		setValueAt(Nombre, pos, 0);
		setValueAt(PrimerApellido, pos, 1);
		setValueAt(SegundoApellido, pos, 2);
		setValueAt(Facultad, pos, 3);

	}
}
