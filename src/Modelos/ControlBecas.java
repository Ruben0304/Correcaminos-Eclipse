package Modelos;

import java.util.ArrayList;

public class ControlBecas {
    private ArrayList<String> idEstudiantesEntregaronCarnet;
    private ArrayList<String> ididEstudiantesEntregaronPertenencias;

    public boolean entregoCarnet(String id) {
        boolean encontrado = false;
        for (int i = 0; i < idEstudiantesEntregaronCarnet.size() && !encontrado; i++) {
            encontrado = idEstudiantesEntregaronCarnet.get(i).equals(id);
        }
        return encontrado;
    }

    public boolean entregoPertenencias(String id) {
        boolean encontrado = false;
        for (int i = 0; i < ididEstudiantesEntregaronPertenencias.size() && !encontrado; i++) {
            encontrado = ididEstudiantesEntregaronPertenencias.get(i).equals(id);
        }
        return encontrado;
    }
}
