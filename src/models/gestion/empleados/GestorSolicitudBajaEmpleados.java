package models.gestion.empleados;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import data.ObtenerSolicitudesBajaEmpleados;
import data.ObtenerSolicitudesBajasEmpleadosAceptadas;
import models.reports.BajasAceptadasPorAnio;
import models.reports.BajasAceptadasPorFacultad;
import models.solicitudes.SolicitudBajaEmpleado;
import models.usuarios.Empleado;
import utiles.Facultad;

public class GestorSolicitudBajaEmpleados {
	
	private ArrayList<SolicitudBajaEmpleado> solicitudesBajaAceptadas;
	 private ArrayList<SolicitudBajaEmpleado> solicitudesBajaPendientes;
	 
	 public GestorSolicitudBajaEmpleados() {
		 solicitudesBajaAceptadas = new ArrayList<SolicitudBajaEmpleado>();
		 solicitudesBajaPendientes = new ArrayList<SolicitudBajaEmpleado>();
		 registrarBajasEmpleadosAceptadas();
		 registrarBajasEmpleadosPendientes();
	 }
	 
	 private void registrarBajasEmpleadosAceptadas() {
        solicitudesBajaAceptadas = ObtenerSolicitudesBajasEmpleadosAceptadas.cargarDesdeArchivo();
    }
	 
	private void registrarBajasEmpleadosPendientes() {
		solicitudesBajaPendientes = ObtenerSolicitudesBajaEmpleados.cargarDesdeArchivo();
	}
	 
	 public boolean verificarEstudianteSolicitaBaja(Empleado e) {

	        boolean encontrado = false;
	        ArrayList<Empleado> empleados = getEmpleadoBajaPendientes();
	        for (int i = 0; i < empleados.size() && !encontrado; i++) {
	            if (e.getCi().equals(empleados.get(i).getCi())) {
	                encontrado = true;
	            }
	        }

	        return encontrado;

    }
	 
	 public ArrayList<Empleado> getEmpleadoBajaPendientes() {
	        ArrayList<Empleado> es = new ArrayList<>();
	        for (SolicitudBajaEmpleado s : this.solicitudesBajaPendientes) {
	            es.add(s.getEmpleado());
	        }
	        return es;
    }
	 
	 public void agregarSolicitudDeBaja(Empleado e, String motivo) {
	        solicitudesBajaPendientes.add(new SolicitudBajaEmpleado(motivo, e));
    }

    public int totalSolicitudesBajaPendientes() {
	        return solicitudesBajaPendientes.size();
    }
    
    // Reportes relacionados a las bajas de los estudiantes


    public ArrayList<BajasAceptadasPorAnio> cantidadDeBajasPorAnio(int anioMinimo) {
        ArrayList<BajasAceptadasPorAnio> solicitudes = new ArrayList<>();

        for (SolicitudBajaEmpleado s : solicitudesBajaAceptadas) {
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
        for (SolicitudBajaEmpleado s : solicitudesBajaAceptadas) {
            if (s.getAnioExpedicion() == anio) {
                total++;
            }
        }

        return total;
    }

    public ArrayList<SolicitudBajaEmpleado> filtrarBajasPendientesPorFacultad(Facultad f) {
        ArrayList<SolicitudBajaEmpleado> solicitudBajasF = new ArrayList<>();

        for (SolicitudBajaEmpleado s : solicitudesBajaPendientes) {
            if (s.getEmpleado().getFacultad().equals(f)) {
                solicitudBajasF.add(s);
            }
        }

        return solicitudBajasF;
    }

    public ArrayList<SolicitudBajaEmpleado> filtrarBajasAceptadasPorFacultad(Facultad f) {
        ArrayList<SolicitudBajaEmpleado> solicitudBajasF = new ArrayList<>();

        for (SolicitudBajaEmpleado s : solicitudesBajaAceptadas) {
            if (s.getEmpleado().getFacultad().equals(f)) {
                solicitudBajasF.add(s);
            }
        }

        return solicitudBajasF;
    }

    public ArrayList<SolicitudBajaEmpleado> filtraBajasPorAnio(int anio) {
        ArrayList<SolicitudBajaEmpleado> solicitudes = new ArrayList<>();

        for (SolicitudBajaEmpleado solicitud : solicitudesBajaAceptadas) {
            if (solicitud.getAnioExpedicion() == anio) {
                solicitudes.add(solicitud);
            }
        }

        return solicitudes;
    }

    public ArrayList<BajasAceptadasPorFacultad> obtenerCantidadBajasAceptadasPorFacultad() {

        ArrayList<BajasAceptadasPorFacultad> bajas = new ArrayList<>();

        for (SolicitudBajaEmpleado s : solicitudesBajaAceptadas) {
            boolean encontrado = false;
            for (int i = 0; i < bajas.size() && !encontrado; i++) {
                if (bajas.get(i).getFacultad().equals(s.getEmpleado().getFacultad())) {
                    bajas.get(i).setCantidad(bajas.get(i).getCantidad() + 1);
                    encontrado = true;
                }
            }
            if (!encontrado) {
                bajas.add(new BajasAceptadasPorFacultad(s.getEmpleado().getFacultad(), 1));
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
}
