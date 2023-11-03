package modelos.gestion;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import modelos.departamentos.RecursosHumanos;
import modelos.departamentos.Secretaria;
import modelos.fabricas.AdminFactory;
import modelos.solicitudes.SolicitudLicenciaEstudiante;
import modelos.usuarios.Admin;
import modelos.usuarios.Persona;
import modelos.usuarios.Usuario;

public class GestorPrincipal {
    private static GestorPrincipal gestorPrincipal;
    private GestorUsuarios gestorUsuarios;
    private Secretaria secretaria;
    private RecursosHumanos recursosHumanos;

    private GestorPrincipal() {
        ArrayList<Persona> personas = new ArrayList<>();
        secretaria = new Secretaria();
        recursosHumanos = new RecursosHumanos();
        gestorUsuarios = new GestorUsuarios();
        
        personas.addAll(secretaria.registrarEstudiantes()); 
        personas.addAll(recursosHumanos.getEmpleados());
        secretaria.registrarLicenciasEstudiantes();
        gestorUsuarios.registrarUsuarios(personas);
        

    }

    public static GestorPrincipal getGestorPrincipal() {
        if (gestorPrincipal == null) {
            gestorPrincipal = new GestorPrincipal();
        }
        return gestorPrincipal;
    }

    public static Secretaria secretaria() {
        if (gestorPrincipal == null) {
            gestorPrincipal = new GestorPrincipal();
        }
        return gestorPrincipal.getSecretaria();
    }

    public static GestorUsuarios gestorUsuarios() {
        if (gestorPrincipal == null) {
            gestorPrincipal = new GestorPrincipal();
        }
        return gestorPrincipal.getGestorUsuarios();
    }

    public static RecursosHumanos recursosHumanos() {
        if (gestorPrincipal == null) {
            gestorPrincipal = new GestorPrincipal();
        }
        return gestorPrincipal.getRecursosHumanos();
    }

    
    private Secretaria getSecretaria() {
        return secretaria;
    }

    private RecursosHumanos getRecursosHumanos() {
        return recursosHumanos;
    }

    private GestorUsuarios getGestorUsuarios() {
        return gestorUsuarios;
    }

    public static Persona buscarPersonaEnLista(String id, ArrayList<Persona> usuarios) {
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

}
