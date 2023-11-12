package models.gestion;

import java.io.FileWriter;
import java.io.IOException;

import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import models.departamentos.RecursosHumanos;
import models.departamentos.Secretaria;
import models.gestion.empleados.GestorEmpleados;
import models.gestion.estudiantes.GestorEstudiantes;
import models.gestion.estudiantes.GestorResponsabilidadesEstudiantes;
import models.interfaces.actualizador;
import models.usuarios.Persona;

public class GestorPrincipal implements actualizador{
    private static GestorPrincipal gestorPrincipal;
    private GestorAdmins gestorAdmins;
    private GestorEstudiantes gestorEstudiantes;
    private GestorEmpleados gestorEmpleados;
    private GestorDepartamentos gestorDepartamentos;

    private GestorPrincipal() {
        gestorEstudiantes = new GestorEstudiantes();
        gestorEmpleados = new GestorEmpleados();
        gestorAdmins = new GestorAdmins();
        gestorDepartamentos = new GestorDepartamentos();
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
        ArrayList<Persona> personas = obtenerPersonas();
        for (int i = 0; i < personas.size() && !encontrado; i++) {
            encontrado = id.equals(personas.get(i).getCi());
            if (encontrado) {
                usuarioEncontrado = personas.get(i);
            }
        }
        return usuarioEncontrado;
    }

    public ArrayList<Persona> obtenerPersonas() {
        ArrayList<Persona> personas = new ArrayList<>();
        personas.addAll(gestorEstudiantes.getEstudiantes());
        personas.addAll(gestorEmpleados.getEmpleados());
        return personas;
    }

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
