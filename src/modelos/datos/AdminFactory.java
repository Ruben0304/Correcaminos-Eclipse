package modelos.datos;

import java.util.ArrayList;

import modelos.entidades.Departamento;
import utiles.Administradores;

public class AdminFactory {

    public static ArrayList<Departamento> inicializarAdmins() {
        ArrayList<Departamento> entidades = new ArrayList<>();

        entidades.add(new Departamento("Biblioteca", "biblioteca", Administradores.Biblioteca.toString()));
        entidades.add(new Departamento("Economia", "economia", Administradores.Economia.toString()));
        entidades.add(new Departamento("SeguridadInformatica", "seguridadinformatica", Administradores.SeguridadInformatica.toString()));
        entidades.add(new Departamento("AlmacenLibrosDocentes", "almacenlibrosdocentes", Administradores.AlmacenLibrosDocentes.toString()));
        entidades.add(new Departamento("DireccionBecas", "direccionbecas", Administradores.DireccionBecas.toString()));
        entidades.add(new Departamento("Contabilidad", "contabilidad", Administradores.Contabilidad.toString()));
        entidades.add(new Departamento("Secretaria", "secretaria", Administradores.Secretaria.toString()));
        entidades.add(new Departamento("RecursosHumanos", "recursoshumanos", Administradores.RecursosHumanos.toString()));

        return entidades;
    }
}
