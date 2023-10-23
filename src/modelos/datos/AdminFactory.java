package modelos.datos;

import java.util.ArrayList;

import modelos.entidades.Departamento;
import utiles.TipoDepartamento;

public class AdminFactory {

    public static ArrayList<Departamento> inicializarAdmins() {
        ArrayList<Departamento> entidades = new ArrayList<>();

        entidades.add(new Departamento("Biblioteca", "biblioteca", TipoDepartamento.Biblioteca));
        entidades.add(new Departamento("Economia", "economia", TipoDepartamento.Economia));
        entidades.add(new Departamento("SeguridadInformatica", "seguridadinformatica", TipoDepartamento.SeguridadInformatica));
        entidades.add(new Departamento("AlmacenLibrosDocentes", "almacenlibrosdocentes", TipoDepartamento.AlmacenLibrosDocentes));
        entidades.add(new Departamento("DireccionBecas", "direccionbecas", TipoDepartamento.DireccionBecas));
        entidades.add(new Departamento("Contabilidad", "contabilidad", TipoDepartamento.Contabilidad));
        entidades.add(new Departamento("Secretaria", "secretaria", TipoDepartamento.Secretaria));
        entidades.add(new Departamento("RecursosHumanos", "recursoshumanos", TipoDepartamento.RecursosHumanos));

        return entidades;
    }
}
