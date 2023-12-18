package util.modelos;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import javax.swing.table.DefaultTableModel;

import autenticacion.Auth;
import controladores.ControladorPrincipal;
import modelos.chats.Chat;
import modelos.gestion.empleados.GestorEmpleados;
import modelos.gestion.estudiantes.Secretaria;
import modelos.usuarios.Admin;
import modelos.usuarios.Becado;
import modelos.usuarios.Empleado;
import modelos.usuarios.Estudiante;
import modelos.usuarios.Persona;
import util.ResponsabilidadesTrabajador;
import util.TipoDepartamento;
import util.TiposResponsabilidad;

public class ChatModel extends DefaultTableModel {

	private static final long serialVersionUID = 1L;

	Admin admin = (Admin) Auth.usuarioAutenticado();

	public ChatModel(HashMap<Persona, Chat> personas) {

		String[] columnNames = { "CI", "Nombre" };
		this.setColumnIdentifiers(columnNames);

		for (Map.Entry<Persona, Chat> chat : personas.entrySet()) {
			Persona estudiante = chat.getKey();

			Object[] newRow = new Object[] { estudiante.getCi(), estudiante.getNombre() };
			addRow(newRow);
		}

	}

	@Override
	public boolean isCellEditable(int row, int columna) {
		return false;
	}

}
