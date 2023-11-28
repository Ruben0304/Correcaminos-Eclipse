package models.departamentos;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

import interfaces.VerificadorEmpleado;
import interfaces.VerificadorEstudiante;
import models.responsabilidades.ResponsabilidadesEmpleados;
import models.responsabilidades.ResponsabilidadesEstudiantes;
import models.usuarios.Empleado;
import models.usuarios.Estudiante;
import models.usuarios.Persona;
import util.ResponsabilidadesTrabajador;
import util.TiposResponsabilidad;

public class Biblioteca implements VerificadorEstudiante, VerificadorEmpleado {

    private HashMap<Persona, Set<String>> librosPrestados;

    public boolean tieneLibrosPrestados(Persona p) {

        return librosPrestados.containsKey(p);

    }

    

    @Override
    public boolean verificarRequisitos(Estudiante e) {
        return tieneLibrosPrestados(e);
    }

    @Override
    public boolean verificarRequisitos(ResponsabilidadesEmpleados responsabilidadesTrabajador) {
        return tieneLibrosPrestados(responsabilidadesTrabajador);
    }

    public void recogerLibrosPrestados(Estudiante e, ArrayList<ResponsabilidadesEstudiantes> responsabilidades) {
        boolean encontrado = false;
        for (int i = 0; i < responsabilidades.size() && !encontrado; i++) {

            encontrado = responsabilidades.get(i).getEstudiante().equals(e);
            if (encontrado) {
                responsabilidades.get(i).getResponsabilidades().remove(TiposResponsabilidad.LIBROS_BIBLIOTECA);
            }

        }
    }

    public void recogerLibrosPrestados(Empleado e, ArrayList<ResponsabilidadesEmpleados> responsabilidades) {
        boolean encontrado = false;
        for (int i = 0; i < responsabilidades.size() && !encontrado; i++) {

            encontrado = responsabilidades.get(i).getEmpleado().equals(e);
            if (encontrado) {
                responsabilidades.get(i).getResponsabilidades().remove(ResponsabilidadesTrabajador.LIBROS_BIBLIOTECA);
            }

        }
    }

    @Override
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

    @Override
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
