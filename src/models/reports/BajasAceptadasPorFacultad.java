package models.reports;

import util.Facultad;

public class BajasAceptadasPorFacultad {
    private Facultad facultad;
    private int cantidadBajas;

    public BajasAceptadasPorFacultad(Facultad facultad, int cantidadBajas) {
        this.facultad = facultad;
        this.cantidadBajas = cantidadBajas;
    }

    public Facultad getFacultad() {
        return facultad;
    }

    public void setFacultad(Facultad facultad) {
        this.facultad = facultad;
    }

    public int getCantidadBajas() {
        return cantidadBajas;
    }

    public void setCantidadBajas(int cantidadBajas) {
        this.cantidadBajas = cantidadBajas;
    }

}
