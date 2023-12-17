package util.modelos;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;
import java.util.TreeSet;

import javax.swing.table.DefaultTableModel;

import autenticacion.Auth;
import controladores.ControladorPrincipal;
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

	public DepartamentoVerificadorLibrosTableModel(Set<String> deudas, String carnet) {
		String[] columnNames = {
				"Deudas", "Carnet Correspondiente" };
		this.setColumnIdentifiers(columnNames);
		for (String e : deudas) {
			Object[] newRow = new Object[] { e, carnet };
			addRow(newRow);
		}

	}

	public DepartamentoVerificadorLibrosTableModel(ArrayList<Persona> personas, boolean Secretario) {
		HashMap<TiposResponsabilidad, Boolean> requisitos = new HashMap<>();
		String[] columnNames = { "Carnet de Identidad", "Nombre", "Apellidos", "B", "AL", "E", "DB", "SI" ,"SC"};
		this.setColumnIdentifiers(columnNames);
		for (Persona e : personas) {
			requisitos = ControladorPrincipal.obtenerRequisitosEstudiante((Estudiante) e);
			Object[] newRow = new Object[] { e.getCi(), e.getNombre(), e.getApellidos(),
					requisitos.get(TiposResponsabilidad.LIBROS_BIBLIOTECA) ? "P" : "A",
					requisitos.get(TiposResponsabilidad.LIBROS_DOCENTES) ? "P" : "A",
					requisitos.get(TiposResponsabilidad.ESTIPENDIO) ? "P" : "A",
					e instanceof Becado ? (requisitos.get(TiposResponsabilidad.PERTENENCIAS_BECA) ? "P" : "A")
							: "A",
					requisitos.get(TiposResponsabilidad.CUENTA_USUARIO) ? "P" : "A",Secretaria.gestorEstudiantes().getGestorSolicitudes().verificarEstudianteSolicitaCancelacion((Estudiante)e) ? "Sí" : "No" };
			addRow(newRow);
		}

	}

	public DepartamentoVerificadorLibrosTableModel(ArrayList<Persona> personas, int rh) {
		HashMap<ResponsabilidadesTrabajador, Boolean> requisitos;
		String[] columnNames = { "Carnet de Identidad", "Nombre", "Apellidos", "B", "C", "SI","SC" };
		this.setColumnIdentifiers(columnNames);
		for (Persona e : personas) {

        requisitos=ControladorPrincipal.obtenerRequisitosEmpleado((Empleado)e);
			Object[] newRow = new Object[] { e.getCi(), e.getNombre(), e.getApellidos(),
					requisitos.get(ResponsabilidadesTrabajador.LIBROS_BIBLIOTECA) ? "P" : "A",
					requisitos.get(ResponsabilidadesTrabajador.DEUDA) ? "P" : "A",
					requisitos.get(ResponsabilidadesTrabajador.CUENTA_USUARIO) ? "P" : "A" , 
				    GestorEmpleados.gestorEmpleados().getGestorSolicitudesEmpleados().verificarEmpleadoSolicitaCancelacion((Empleado)e) ? "Sí" : "No" };
					addRow(newRow);
		}
	}
	@Override
	public boolean isCellEditable(int row, int columna){
        return false;
	}


	// public DepartamentoVerificadorLibrosTableModel(ArrayList<Persona> personas,
	// String encabezado) {
	// String[] columnNames = {
	// "Carnet de Identidad", "Nombre", "Apellidos", encabezado };
	// this.setColumnIdentifiers(columnNames);

	// for (Persona e : personas) {
	// Object[] newRow = new Object[] { e.getCi(), e.getNombre(), e.getApellidos(),
	// "Ver Detalles" };
	// addRow(newRow);
	// }

	// }

}
