package views.modelos;

import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.table.DefaultTableModel;

import auth.Auth;
import models.usuarios.Admin;
import models.usuarios.Persona;
import util.TipoDepartamento;

public class DepartamentoVerificadorLibrosTableModel extends DefaultTableModel {

	private static final long serialVersionUID = 1L;

	Admin admin = (Admin) Auth.usuarioAutenticado();

	public DepartamentoVerificadorLibrosTableModel(ArrayList<Persona> personas) {
		String[] columnNames = {
				"Carnet de Identidad", "Nombre", "Apellidos",
				admin.getTipoDepartamento().equals(TipoDepartamento.Biblioteca)
						|| admin.getTipoDepartamento().equals(TipoDepartamento.AlmacenLibrosDocentes)
						|| admin.getTipoDepartamento().equals(TipoDepartamento.DireccionBecas) ? "Deudas" : null };
		this.setColumnIdentifiers(columnNames);
	}
}
