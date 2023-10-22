package modelos.datos;

import java.util.ArrayList;

import modelos.entidades.Admin;
import utiles.Administradores;

public class AdminFactory {

    public static ArrayList<Admin> inicializarAdmins() {
        ArrayList<Admin> entidades = new ArrayList<>();

        entidades.add(new Admin("Biblioteca", "biblioteca", Administradores.Biblioteca.toString()));
        entidades.add(new Admin("Economia", "economia", Administradores.Economia.toString()));
        entidades.add(new Admin("SeguridadInformatica", "seguridadinformatica", Administradores.SeguridadInformatica.toString()));
        entidades.add(new Admin("AlmacenLibrosDocentes", "almacenlibrosdocentes", Administradores.AlmacenLibrosDocentes.toString()));
        entidades.add(new Admin("DireccionBecas", "direccionbecas", Administradores.DireccionBecas.toString()));
        entidades.add(new Admin("Contabilidad", "contabilidad", Administradores.Contabilidad.toString()));
        entidades.add(new Admin("Secretaria", "secretaria", Administradores.Secretaria.toString()));
        entidades.add(new Admin("RecursosHumanos", "recursoshumanos", Administradores.RecursosHumanos.toString()));

        return entidades;
    }
}
