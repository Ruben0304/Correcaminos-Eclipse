package modelos.gestion;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import modelos.gestion.empleados.GestorEmpleados;
import modelos.gestion.estudiantes.Secretaria;
import modelos.usuarios.Persona;


public class Correcaminos{
    private static Correcaminos gestorPrincipal;
    private GestorAdmins gestorAdmins;
    private Secretaria gestorEstudiantes;
    // private GestorEmpleados gestorEmpleados;
    private GestorDepartamentos gestorDepartamentos;

    private Correcaminos() {
        gestorEstudiantes = Secretaria.gestorEstudiantes();
        // gestorEmpleados = GestorEmpleados.gestorEmpleados();
        gestorAdmins = GestorAdmins.gestorAdmins();
        gestorDepartamentos = GestorDepartamentos.gestorDepartamentos();
    }

    public static Correcaminos getGestorPrincipal() {
        if (gestorPrincipal == null) {
            gestorPrincipal = new Correcaminos();
        }
        return gestorPrincipal;
    }

    public Persona buscarPersonaporCi(String id) {
        boolean encontrado = false;
        Persona usuarioEncontrado = null;
        ArrayList<Persona> personas = getPersonas();
        for (int i = 0; i < personas.size() && !encontrado; i++) {
            encontrado = id.equals(personas.get(i).getCi());
            if (encontrado) {
                usuarioEncontrado = personas.get(i);
            }
        }
        return usuarioEncontrado;
    }

    public ArrayList<Persona> getPersonas() {
        ArrayList<Persona> personas = new ArrayList<>();
        personas.addAll(gestorEstudiantes.getEstudiantes());
//        personas.addAll(gestorEmpleados.getEmpleados());
        return personas;
    }

 

   

    public GestorAdmins getGestorAdmins() {
        return gestorAdmins;
    }

    public Secretaria getGestorEstudiantes() {
        return gestorEstudiantes;
    }

    // public GestorEmpleados getGestorEmpleados() {
    //     return gestorEmpleados;
    // }

    public GestorDepartamentos getGestorDepartamentos() {
        return gestorDepartamentos;
    }

    

}
