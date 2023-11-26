package data;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import models.solicitudes.SolicitudBaja;
import models.solicitudes.SolicitudBajaEmpleado;
import models.solicitudes.SolicitudLicenciaEmpleado;

public class ObtenerSolicitudesEmpleados {
	
	public static ArrayList<SolicitudBajaEmpleado> cargarDesdeArchivo() {
		
		Gson gson = new Gson();
        ArrayList<SolicitudBajaEmpleado> solicitudes = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader("./solicitudesEmpleados.json"))) {
            Type listType = new TypeToken<ArrayList<SolicitudBaja>>() {
            }.getType();
            solicitudes = gson.fromJson(reader, listType);   
        } catch (IOException e) {
            e.printStackTrace();
        }
        return solicitudes;
	}

    // implementar

    public static ArrayList<SolicitudLicenciaEmpleado> cargarSolicitcitudesLicenciaEmpleados(){


       Gson gson = new Gson();
       ArrayList<SolicitudLicenciaEmpleado> solicitudes = new ArrayList<>();
       
    //    try (BufferedReader reader = new BufferedReader(new FileReader("./solicitudesEmpleados.json"))) {
    //         Type listType = new TypeToken<ArrayList<SolicitudBaja>>() {
    //         }.getType();
    //         solicitudes = gson.fromJson(reader, listType);   
    //     } catch (IOException e) {
    //         e.printStackTrace();
    //     }


       return solicitudes;
       
    }
}