package views.admin;

import javax.swing.table.DefaultTableModel;

import controllers.ControladorFiltrado;
import util.Facultad;
import models.solicitudes.Solicitud;
import models.solicitudes.SolicitudBaja;
import models.usuarios.Empleado;
import models.usuarios.Estudiante;
import models.usuarios.Persona;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.Vector;

public class ModeloFiltrado extends DefaultTableModel {

	private static final long serialVersionUID = 1L;

	public ModeloFiltrado() {
		String[] columnNames = {
				"DNI", "Nombre", "Apellido", "Carrera" };
		this.setColumnIdentifiers(columnNames);
	}

	public ModeloFiltrado(HashMap<Estudiante,Set<Solicitud>> solicitudes) {
		String[] columnNames = {
				"Id","DNI", "Nombre", "Apellido", "Año","Tipo" };
		this.setColumnIdentifiers(columnNames);
		for (Map.Entry<Estudiante, Set<Solicitud>> s : solicitudes.entrySet()) {
            Estudiante p = s.getKey();
			Set<Solicitud> listaSolicitudes = s.getValue();
			for (Solicitud solicitud : listaSolicitudes) {
				Object[] newRow = new Object[] {solicitud.getId(), p.getCi(), p.getNombre(), p.getApellidos(),solicitud.getAnioExpedicion(),solicitud instanceof SolicitudBaja ? "Baja" : "Licencia"
					 };
			addRow(newRow);
			}
			
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
