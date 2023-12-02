 package models.departamentos;

import java.util.ArrayList;

import interfaces.VerificadorEmpleado;
import interfaces.VerificadorEstudiante;
import models.responsabilidades.ResponsabilidadesEmpleados;
import models.responsabilidades.ResponsabilidadesEstudiantes;
import models.usuarios.Empleado;
import models.usuarios.Estudiante;
import util.ResponsabilidadesTrabajador;
import util.TiposResponsabilidad;

public class SeguridadInformatica implements VerificadorEstudiante, VerificadorEmpleado {

	public boolean tieneCuentaUsuarioAbierta(ResponsabilidadesEmpleados r) {
		return (r.getResponsabilidades().contains(ResponsabilidadesTrabajador.CUENTA_USUARIO));
	}
	
	public boolean tieneCuentaUsuarioAbierta(ResponsabilidadesEstudiantes r) {
		return (r.getResponsabilidades().contains(TiposResponsabilidad.CUENTA_USUARIO));
	}
	
	@Override
	public boolean verificarRequisitos(ResponsabilidadesEmpleados responsabilidadesTrabajador) {
		return tieneCuentaUsuarioAbierta(responsabilidadesTrabajador);
	}

	@Override
	public boolean verificarRequisitos(ResponsabilidadesEstudiantes responsabilidadesEstudiantes) {
		return tieneCuentaUsuarioAbierta(responsabilidadesEstudiantes);
	}
	
	public void cerrarCuenta(Estudiante e, ArrayList<ResponsabilidadesEstudiantes> responsabilidades) {
		boolean encontrado = false;
        for (int i = 0; i < responsabilidades.size() && !encontrado; i++) {

            encontrado = responsabilidades.get(i).getEstudiante().equals(e);
            if (encontrado) {
                responsabilidades.get(i).getResponsabilidades().remove(TiposResponsabilidad.CUENTA_USUARIO);
            }

        }
	}
	
	public void cerrarCuenta(Empleado e, ArrayList<ResponsabilidadesEmpleados> responsabilidades) {
		boolean encontrado = false;
        for (int i = 0; i < responsabilidades.size() && !encontrado; i++) {

            encontrado = responsabilidades.get(i).getEmpleado().equals(e);
            if (encontrado) {
                responsabilidades.get(i).getResponsabilidades().remove(ResponsabilidadesTrabajador.LIBROS_BIBLIOTECA);
            }

        }
	}
	
	 @Override
	 public ArrayList<Empleado> getEmpleadosPendientes(ArrayList<ResponsabilidadesEmpleados> responsabilidades) {
	        ArrayList<Empleado> es = new ArrayList<>();
	        for (ResponsabilidadesEmpleados r : responsabilidades) {
	            if (verificarRequisitos(r)) {
	                es.add(r.getEmpleado());
	            }
	        }
	        return es;
	    }

	@Override
	public ArrayList<Estudiante> getEstudiantesPendientes(ArrayList<ResponsabilidadesEstudiantes> responsabilidades) {
	    ArrayList<Estudiante> es = new ArrayList<>();
        for (ResponsabilidadesEstudiantes r : responsabilidades) {
            if (verificarRequisitos(r)) {
                es.add(r.getEstudiante());
            }
        }
        return es;
	}

}
