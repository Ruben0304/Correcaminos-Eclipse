package controllers;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Collections;

import javax.swing.JOptionPane;
import javax.swing.JTextArea;

import models.gestion.estudiantes.Secretaria;
import models.reports.BajasAceptadasPorAnio;
import models.reports.BajasAceptadasPorFacultad;

import util.Facultad;

public abstract class ControladorReportes {

    public static JTextArea crearTextArea(String info) {
        JTextArea textArea = new JTextArea();
        textArea.setEditable(false);
        textArea.append(info);

        return textArea;
    }

    public static void facultadesConMasBajasAceptadas() {
        ArrayList<BajasAceptadasPorFacultad> ordenado = Secretaria.gestorEstudiantes().getGestorSolicitudes()
                .ordenarFacultadesPorCantidadBajasAceptadas();

        Collections.reverse(ordenado);
        ArrayList<Facultad> facMasBajas = new ArrayList<>();

        for (int i = 0; i < ordenado.size(); i++) {

            if (ordenado.get(i).getCantidad() == ordenado.get(0).getCantidad()) {
                facMasBajas.add(ordenado.get(i).getFacultad());
            } else {
                i = ordenado.size();
            }
        }

        String info = "Lista de facultades con mayor cantidad de bajas aceptadas:\n";
        for (Facultad f : facMasBajas) {
            info += "- " + f + "\n";
        }

        JTextArea textArea = crearTextArea(info);

        JOptionPane.showMessageDialog(null, textArea);
    }

    public static void totalBajasAceptadasElAnioAnterior() {
        Calendar calendar = Calendar.getInstance();
        int anioActual = calendar.get(Calendar.YEAR);

        int anioAnterior = anioActual - 1;

        int total = Secretaria.gestorEstudiantes().getGestorSolicitudes().cantidadDeBajasDeUnAnio(anioAnterior);

        String info = "El total de licencias aceptadas el año anterior fue de: " + total;

        JTextArea textArea = crearTextArea(info);

        JOptionPane.showMessageDialog(null, textArea);
       
    }

    public static void anioConMasBajasLicenciasAceptadasEnUltimos10() {
        Calendar calendar = Calendar.getInstance();
        int anioActual = calendar.get(Calendar.YEAR);

        ArrayList<BajasAceptadasPorAnio> solicitudes = Secretaria.gestorEstudiantes().getGestorSolicitudes()
                .cantidadDeBajasPorAnio(anioActual - 10);
        ArrayList<Integer> aniosMasBajas = new ArrayList<>();
        int maxBajas = 0;

        for (BajasAceptadasPorAnio solicitud : solicitudes) {
            int cantidadBajas = solicitud.getCantidad();
            if (cantidadBajas > maxBajas) {
                maxBajas = cantidadBajas;
                aniosMasBajas.clear();
                aniosMasBajas.add(solicitud.getAnio());
            } else if (cantidadBajas == maxBajas) {
                aniosMasBajas.add(solicitud.getAnio());
            }
        }

        String info = "El anio(s) con mayor contidad de bajas y licencias aceptadas fue:\n";
        for (int anio : aniosMasBajas) {
            info =  anio + "\n";
        }

        JTextArea textArea = crearTextArea(info);

        JOptionPane.showMessageDialog(null, textArea);
    }

}
