package models.gestion.estudiantes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import data.ObtenerSolicitudesBajasEstudiantesAceptadas;
import models.reports.BajasAceptadasPorAnio;
import models.reports.BajasAceptadasPorFacultad;
import models.solicitudes.SolicitudBajaEstudiante;
import models.usuarios.Estudiante;
import utiles.Facultad;

public class GestorSolicitudBajaEstudiantes {
	 private ArrayList<SolicitudBajaEstudiante> solicitudesBajaAceptadas;
	 private ArrayList<SolicitudBajaEstudiante> solicitudesBajaPendientes;
	 
	 private void registrarBajasEstudiantesAceptadas() {
	        solicitudesBajaAceptadas = ObtenerSolicitudesBajasEstudiantesAceptadas.cargarDesdeArchivoB();

     }
	 
	 public boolean verificarEstudianteSolicitaBaja(Estudiante e) {

	        boolean encontrado = false;
	        ArrayList<Estudiante> estudiantes = getEstudianteBajaPendientes();
	        for (int i = 0; i < estudiantes.size() && !encontrado; i++) {
	            if (e.getCi().equals(estudiantes.get(i).getCi())) {
	                encontrado = true;
	            }
	        }

	        return encontrado;

     }
	 
	 public ArrayList<Estudiante> getEstudianteBajaPendientes() {
	        ArrayList<Estudiante> es = new ArrayList<>();
	        for (SolicitudBajaEstudiante s : this.solicitudesBajaPendientes) {
	            es.add(s.getEstudiante());
	        }
	        return es;
     }
	 
	 public void agregarSolicitudDeBaja(Estudiante e, String motivo) {
	        solicitudesBajaPendientes.add(new SolicitudBajaEstudiante(motivo, e));
     }

     public int totalSolicitudesBajaPendientes() {
	        return solicitudesBajaPendientes.size();
     }
     
     // Reportes relacionados a las bajas de los estudiantes


     public ArrayList<BajasAceptadasPorAnio> cantidadDeBajasPorAnio(int anioMinimo) {
         ArrayList<BajasAceptadasPorAnio> solicitudes = new ArrayList<>();

         for (SolicitudBajaEstudiante s : solicitudesBajaAceptadas) {
             boolean encontrado = false;
             if (s.getAnioExpedicion() >= anioMinimo) {
                 for (int i = 0; i < solicitudes.size() && !encontrado; i++) {
                     if (solicitudes.get(i).getAnio() == s.getAnioExpedicion()) {
                         solicitudes.get(i).setCantidad(solicitudes.get(i).getCantidad() + 1);
                         encontrado = true;
                     }
                 }
                 if (!encontrado) {
                     solicitudes.add(new BajasAceptadasPorAnio(s.getAnioExpedicion(), 1));
                 }

             }
         }

         return solicitudes;
     }

     public int cantidadDeBajasDeUnAnio(int anio) {
        
         int total = 0;
         for (SolicitudBajaEstudiante s : solicitudesBajaAceptadas) {
             if (s.getAnioExpedicion() == anio) {
                 total++;
             }
         }

         return total;
     }

     public ArrayList<SolicitudBajaEstudiante> filtrarBajasPendientesPorFacultad(Facultad f) {
         ArrayList<SolicitudBajaEstudiante> solicitudBajasF = new ArrayList<>();

         for (SolicitudBajaEstudiante s : solicitudesBajaPendientes) {
             if (s.getEstudiante().getFacultad().equals(f)) {
                 solicitudBajasF.add(s);
             }
         }

         return solicitudBajasF;
     }

     public ArrayList<SolicitudBajaEstudiante> filtrarBajasAceptadasPorFacultad(Facultad f) {
         ArrayList<SolicitudBajaEstudiante> solicitudBajasF = new ArrayList<>();

         for (SolicitudBajaEstudiante s : solicitudesBajaAceptadas) {
             if (s.getEstudiante().getFacultad().equals(f)) {
                 solicitudBajasF.add(s);
             }
         }

         return solicitudBajasF;
     }

     public ArrayList<SolicitudBajaEstudiante> filtraBajasPorAnio(int anio) {
         ArrayList<SolicitudBajaEstudiante> solicitudes = new ArrayList<>();

         for (SolicitudBajaEstudiante solicitud : solicitudesBajaAceptadas) {
             if (solicitud.getAnioExpedicion() == anio) {
                 solicitudes.add(solicitud);
             }
         }

         return solicitudes;
     }

     public ArrayList<BajasAceptadasPorFacultad> obtenerCantidadBajasAceptadasPorFacultad() {

         ArrayList<BajasAceptadasPorFacultad> bajas = new ArrayList<>();

         for (SolicitudBajaEstudiante s : solicitudesBajaAceptadas) {
             boolean encontrado = false;
             for (int i = 0; i < bajas.size() && !encontrado; i++) {
                 if (bajas.get(i).getFacultad().equals(s.getEstudiante().getFacultad())) {
                     bajas.get(i).setCantidad(bajas.get(i).getCantidad() + 1);
                     encontrado = true;
                 }
             }
             if (!encontrado) {
                 bajas.add(new BajasAceptadasPorFacultad(s.getEstudiante().getFacultad(), 1));
             }
         }
         return bajas;
     }

     public ArrayList<BajasAceptadasPorFacultad> ordenarFacultadesPorCantidadBajasAceptadas() {
         ArrayList<BajasAceptadasPorFacultad> bajasOrdenadas = obtenerCantidadBajasAceptadasPorFacultad();

         Collections.sort(bajasOrdenadas, new Comparator<BajasAceptadasPorFacultad>() {
             @Override
             public int compare(BajasAceptadasPorFacultad b1, BajasAceptadasPorFacultad b2) {
                 return Integer.compare(b1.getCantidad(), b2.getCantidad());
             }
         });

         return bajasOrdenadas;
     }

     // public ArrayList<SolicitudBajaEstudiante> filtrarPorFecha(String anio) {
     // ArrayList<SolicitudBajaEstudiante> solBajasFiltradas = new ArrayList<>();

     // }

     // public ArrayList<Facultad> facultadesConMasBajasAceptadas() {
     // ArrayList<Facultad> ordenada = new ArrayList<>();
     // int max = 0;

     // }
}
