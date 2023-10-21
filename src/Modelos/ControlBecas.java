package Modelos;

import java.util.ArrayList;

public class ControlBecas {
    private ArrayList<String> idEstudiantesEntregaronCarnet;
    private ArrayList<String> ididEstudiantesEntregaronPertenencias;


    //verifica si el usuario entrego carnet de becado a partir de recorrer la lista de los estudiantes que lo entregaron
    public boolean entregoCarnet(String id) {
        boolean encontrado = false;
        for (int i = 0; i < idEstudiantesEntregaronCarnet.size() && !encontrado; i++) {
            encontrado = idEstudiantesEntregaronCarnet.get(i).equals(id);
        }
        return encontrado;
    }

    //verifica si el usuario entrego las pertenencias de la beca a partir de recorrer la lista de los estudiantes que las entregaron
    public boolean entregoPertenencias(String id) {
        boolean encontrado = false;
        for (int i = 0; i < ididEstudiantesEntregaronPertenencias.size() && !encontrado; i++) {
            encontrado = ididEstudiantesEntregaronPertenencias.get(i).equals(id);
        }
        return encontrado;
    }
}
