package models.departamentos;

import java.util.ArrayList;

import models.interfaces.VerificadorEmpleado;
import models.interfaces.VerificadorEstudiante;
import models.responsabilidades.ResponsabilidadesEmpleados;
import models.responsabilidades.ResponsabilidadesEstudiantes;
import models.usuarios.Empleado;
import models.usuarios.Estudiante;
import utiles.ResponsabilidadesTrabajador;
import utiles.TiposResponsabilidad;

public class Biblioteca implements VerificadorEstudiante, VerificadorEmpleado {

    public boolean tieneLibrosPrestados(ResponsabilidadesEstudiantes r){
        return r.getResponsabilidades().contains(TiposResponsabilidad.LIBROS_BIBLIOTECA);
        
    }
    
    public boolean tieneLibrosPrestados(ResponsabilidadesEmpleados r){
        return r.getResponsabilidades().contains(ResponsabilidadesTrabajador.LIBROS_BIBLIOTECA);
        
    }
    
    @Override
    public boolean verificarRequisitos(ResponsabilidadesEstudiantes responsabilidadesEstudiantes) {
        return tieneLibrosPrestados(responsabilidadesEstudiantes);
    }
    
    @Override
	public boolean verificarRequisitos(ResponsabilidadesEmpleados responsabilidadesTrabajador) {
		return tieneLibrosPrestados(responsabilidadesTrabajador);
	}

    public void quitarLibrosPrestados(Estudiante e, ArrayList<ResponsabilidadesEstudiantes> responsabilidades) {
        boolean encontrado = false;
        for (int i = 0; i < responsabilidades.size() && !encontrado; i++) {

            encontrado = responsabilidades.get(i).getEstudiante().equals(e);
            if (encontrado) {
                responsabilidades.get(i).getResponsabilidades().remove(TiposResponsabilidad.LIBROS_BIBLIOTECA);
            }

        }
    }

    public ArrayList<Estudiante> getEstudiantesPendientes(
            ArrayList<ResponsabilidadesEstudiantes> responsabilidades) {
        ArrayList<Estudiante> es = new ArrayList<>();
        for (ResponsabilidadesEstudiantes r : responsabilidades) {
            if (verificarRequisitos(r)) {
                es.add(r.getEstudiante());
            }
        }
        return es;
    }
    
    public ArrayList<Empleado> getEmpleadosPendientes(
            ArrayList<ResponsabilidadesEmpleados> responsabilidades) {
        ArrayList<Empleado> es = new ArrayList<>();
        for (ResponsabilidadesEmpleados r : responsabilidades) {
            if (verificarRequisitos(r)) {
                es.add(r.getEmpleado());
            }
        }
        return es;
    }
    

	

	

	

	

   

}
