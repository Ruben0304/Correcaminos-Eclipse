package models.departamentos;

import java.util.ArrayList;

import models.solicitudes.SolicitudBajaEmpleados;
import models.solicitudes.SolicitudLicenciaEmpleado;
import models.usuarios.Empleado;



public class RecursosHumanos {
    ArrayList<Empleado> empleados;
    ArrayList<SolicitudBajaEmpleados> solicitudesBajaEmpleados;
    ArrayList<SolicitudLicenciaEmpleado> solicitudesLicenciaEmpleados;

    public RecursosHumanos() {
        this.empleados = new ArrayList<>();
    }
    
    public RecursosHumanos(ArrayList<Empleado> empleados) {
        this.empleados = empleados;
    }

    public ArrayList<Empleado> getEmpleados() {
        return empleados;
    }

    public void setEmpleados(ArrayList<Empleado> empleados) {
        this.empleados = empleados;
    }
    

   
}
