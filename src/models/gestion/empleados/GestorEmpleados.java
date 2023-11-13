package models.gestion.empleados;

import java.util.ArrayList;


import models.usuarios.Empleado;

public class GestorEmpleados {
    private static GestorEmpleados gestorEmpleados;
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
}
