package modelos.solicitudes;

import java.util.Calendar;
import java.util.Date;

import util.Estado;
import util.MotivoBaja;
import util.Motivos;

public class SolicitudBaja extends Solicitud {
    private MotivoBaja motivo;

    public SolicitudBaja(long id, MotivoBaja motivo) {
        super(id);
        this.motivo = motivo;
    }

    public MotivoBaja getMotivo() {
        return motivo;
    }

}
