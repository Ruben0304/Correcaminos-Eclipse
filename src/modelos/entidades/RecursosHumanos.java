package modelos.entidades;

import java.util.ArrayList;



public class RecursosHumanos {
    ArrayList<Empleado> empleados;

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
