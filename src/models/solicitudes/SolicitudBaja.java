package models.solicitudes;

import java.util.Calendar;
import java.util.Date;

import util.Estado;
import util.Motivos;

public abstract class SolicitudBaja extends Solicitud {

    public SolicitudBaja(Motivos motivo) {
        super(motivo);

    }

}
