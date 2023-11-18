package controllers;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JOptionPane;
import javax.swing.JTextArea;

import models.gestion.estudiantes.GestorEstudiantes;
import models.reports.BajasAceptadasPorAnio;
import models.reports.BajasAceptadasPorFacultad;
import models.solicitudes.SolicitudLicencia;
import util.Facultad;

public abstract class ControladorReportes {

    public static JTextArea crearTextArea(String info) {
        JTextArea textArea = new JTextArea();
        textArea.setEditable(false);
        textArea.append(info);

        return textArea;
    }

    public static JOptionPane facultadesConMasBajasAceptadas() {
        ArrayList<BajasAceptadasPorFacultad> ordenado = GestorEstudiantes.gestorEstudiantes().getGestorSolicitudes()
                .ordenarFacultadesPorCantidadBajasAceptadas();
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

        JOptionPane optionPane = new JOptionPane(textArea, JOptionPane.INFORMATION_MESSAGE);
        return optionPane;
    }

    public static JOptionPane totalLicenciasAceptadasElAnioAnterior() {
        Calendar calendar = Calendar.getInstance();
        int anioActual = calendar.get(Calendar.YEAR);

        int anioAnterior = anioActual - 1;

        int total = GestorEstudiantes.gestorEstudiantes().getGestorSolicitudes().filtrarLicenciasPorAnio(anioAnterior)
                .size();

        String info = "El total de licencias aceptadas el anio anterior fue de:\n";
        info = " " + total + "\n";

        JTextArea textArea = crearTextArea(info);

        JOptionPane optionPane = new JOptionPane(textArea, JOptionPane.INFORMATION_MESSAGE);
        return optionPane;
    }

    public static JOptionPane anioConMasBajasLicenciasAceptadasEnUltimos10() {
        Calendar calendar = Calendar.getInstance();
        int anioActual = calendar.get(Calendar.YEAR);

        ArrayList<BajasAceptadasPorAnio> solicitudes =  GestorEstudiantes.gestorEstudiantes().getGestorSolicitudes().cantidadDeBajasPorAnio(anioActual - 10);
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
            info = " - " + anio + "\n";
        }

        JTextArea textArea = crearTextArea(info);

        JOptionPane optionPane = new JOptionPane(textArea, JOptionPane.INFORMATION_MESSAGE);
        return optionPane;
    }

}
