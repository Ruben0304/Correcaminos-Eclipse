package models.gestion;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import models.gestion.empleados.GestorEmpleados;
import models.gestion.estudiantes.GestorEstudiantes;

import models.interfaces.Actualizador;
import models.usuarios.Persona;
import models.usuarios.Usuario;

public class GestorPrincipal implements Actualizador{
    private static GestorPrincipal gestorPrincipal;
    private GestorAdmins gestorAdmins;
    private GestorEstudiantes gestorEstudiantes;
    private GestorEmpleados gestorEmpleados;
    private GestorDepartamentos gestorDepartamentos;

    private GestorPrincipal() {
        gestorEstudiantes = GestorEstudiantes.gestorEstudiantes();
        gestorEmpleados = GestorEmpleados.gestorEmpleados();
        gestorAdmins = GestorAdmins.gestorAdmins();
        gestorDepartamentos = GestorDepartamentos.gestorDepartamentos();
    }

    public static GestorPrincipal getGestorPrincipal() {
        if (gestorPrincipal == null) {
            gestorPrincipal = new GestorPrincipal();
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

    public ArrayList<Usuario> getUsuarios() {
        ArrayList<Usuario> usuarios = new ArrayList<>();
        usuarios.addAll(getPersonas());
        usuarios.addAll(gestorAdmins.getAdmins());
        return usuarios;
    }

    @Override
    public void actualizarDatos() {
        // Gson gson = new GsonBuilder().setPrettyPrinting().create();
        // String jsonAdmins = gson.toJson(gestorAdmins.getAdmins());
        // String jsonEstudiantes = gson.toJson(gestorEstudiantes.getEstudiantes());
        // String jsonSolicitudes = gson.toJson(gest.getSolicitudesLicenciaPendientes());
        // try {

        //     FileWriter writerA = new FileWriter("./admins.json");
        //     FileWriter writerE = new FileWriter("./estudiantes.json");
        //     FileWriter writerS = new FileWriter("./solicitudes.json");
        //     writerA.write(jsonAdmins);
        //     writerE.write(jsonEstudiantes);
        //     writerS.write(jsonSolicitudes);
        //     writerA.close();
        //     writerE.close();
        //     writerS.close();

        //     System.out.println("Guardado todo ok.");
        // } catch (IOException e) {
        //     e.printStackTrace();
        // }
    }

    public GestorAdmins getGestorAdmins() {
        return gestorAdmins;
    }

    public GestorEstudiantes getGestorEstudiantes() {
        return gestorEstudiantes;
    }

    public GestorEmpleados getGestorEmpleados() {
        return gestorEmpleados;
    }

    public GestorDepartamentos getGestorDepartamentos() {
        return gestorDepartamentos;
    }

    

}
