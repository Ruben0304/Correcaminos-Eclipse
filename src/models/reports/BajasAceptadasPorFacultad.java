package models.reports;

import util.Facultad;

public class BajasAceptadasPorFacultad {
    private Facultad facultad;
    private int cantidad;

    public BajasAceptadasPorFacultad(Facultad facultad, int cantidad) {
        this.facultad = facultad;
        this.cantidad = cantidad;
    }

    public Facultad getFacultad() {
        return facultad;
    }

    public void setFacultad(Facultad facultad) {
        this.facultad = facultad;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    
    
}
