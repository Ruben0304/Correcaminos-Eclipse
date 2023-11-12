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
import models.usuarios.Persona;

public class GestorPrincipal {
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

    

    public static Persona buscarPersonaporCi(String id) {
        boolean encontrado = false;
        Persona usuarioEncontrado = null;
        for (int i = 0; i < usuarios.size() && !encontrado; i++) {
            encontrado = id.equals(usuarios.get(i).getCi());
            if (encontrado) {
                usuarioEncontrado = usuarios.get(i);
            }
        }
        return usuarioEncontrado;
    }

    public obtenerPersonas(){}

    public void actualizarDatos() {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String jsonAdmins = gson.toJson(gestorUsuarios.getAdmins());
        String jsonEstudiantes = gson.toJson(secretaria.getEstudiantes());
        String jsonSolicitudes = gson.toJson(secretaria.getSolicitudesLicenciaPendientes());
        try {

            FileWriter writerA = new FileWriter("./admins.json");
            FileWriter writerE = new FileWriter("./estudiantes.json");
            FileWriter writerS = new FileWriter("./solicitudes.json");
            writerA.write(jsonAdmins);
            writerE.write(jsonEstudiantes);
            writerS.write(jsonSolicitudes);
            writerA.close();
            writerE.close();
            writerS.close();

            System.out.println("Guardado todo ok.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    

}
