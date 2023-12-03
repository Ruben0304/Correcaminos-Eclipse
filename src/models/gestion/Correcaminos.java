package models.gestion;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import interfaces.Actualizador;
import models.gestion.empleados.GestorEmpleados;
import models.gestion.estudiantes.Secretaria;
import models.usuarios.Persona;


public class Correcaminos implements Actualizador{
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
