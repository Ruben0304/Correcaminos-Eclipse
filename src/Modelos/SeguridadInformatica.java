package Modelos;

import java.util.ArrayList;

public class SeguridadInformatica {
    private ArrayList<String> idEstudiantesCancelaronCuentas;

public boolean canceloCuenta(String id) {
        boolean encontrado = false;
        for (int i = 0; i < idEstudiantesCancelaronCuentas.size() && !encontrado; i++) {
            encontrado = idEstudiantesCancelaronCuentas.get(i).equals(id);
        }
        return encontrado;
    }
    
}
