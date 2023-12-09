package modelos.gestion.empleados;

import java.util.ArrayList;
import java.util.Map;
import java.util.Set;

import datos.ObtenerEmpleados;
import modelos.solicitudes.Solicitud;
import modelos.usuarios.Empleado;
import modelos.usuarios.Estudiante;
import util.Estado;

public class GestorEmpleados {
    private static GestorEmpleados gestorEmpleados;
    private GestorSolicitudesEmpleados gestorSolicitudesEmpleados;
    private ArrayList<Empleado> empleados;

    public ArrayList<Empleado> getEmpleados() {
        return empleados;
    }

    public static GestorEmpleados gestorEmpleados() {
        if (gestorEmpleados == null) {
            gestorEmpleados = new GestorEmpleados();
        }
        return gestorEmpleados;
    }

    private GestorEmpleados() {
        empleados = new ArrayList<Empleado>();
        registrarEmpleados();
        gestorSolicitudesEmpleados = new GestorSolicitudesEmpleados();
    }

    public Empleado buscarEmpleadoPorCi(String id) {
        boolean encontrado = false;
        Empleado estudianteEncontrado = null;
        for (int i = 0; i < this.empleados.size() && !encontrado; i++) {
            encontrado = id.equals(this.empleados.get(i).getCi());
            if (encontrado) {
                estudianteEncontrado = this.empleados.get(i);
            }
        }
        return estudianteEncontrado;
    }

    private void registrarEmpleados() {
        empleados = ObtenerEmpleados.cargarDesdeArchivo();
    }

    public GestorSolicitudesEmpleados getGestorSolicitudesEmpleados() {
        return gestorSolicitudesEmpleados;
    }

}
