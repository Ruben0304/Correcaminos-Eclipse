package modelos.datos;

import java.util.ArrayList;

import modelos.entidades.Admin;
import utiles.TipoDepartamento;

public class AdminFactory {

    public static ArrayList<Admin> inicializarAdmins() {
        ArrayList<Admin> entidades = new ArrayList<>();

        entidades.add(new Admin("Biblioteca", "biblioteca", TipoDepartamento.Biblioteca));
        entidades.add(new Admin("Economia", "economia", TipoDepartamento.Economia));
        entidades.add(new Admin("SeguridadInformatica", "seguridadinformatica", TipoDepartamento.SeguridadInformatica));
        entidades.add(new Admin("AlmacenLibrosDocentes", "almacenlibrosdocentes", TipoDepartamento.AlmacenLibrosDocentes));
        entidades.add(new Admin("DireccionBecas", "direccionbecas", TipoDepartamento.DireccionBecas));
        entidades.add(new Admin("Contabilidad", "contabilidad", TipoDepartamento.Contabilidad));
        entidades.add(new Admin("Secretaria", "secretaria", TipoDepartamento.Secretaria));
        entidades.add(new Admin("RecursosHumanos", "recursoshumanos", TipoDepartamento.RecursosHumanos));

        return entidades;
    }
}
