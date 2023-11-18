package models.reports;

public class BajasAceptadasPorAnio {
    private int anio;
    private int cantidad;
    public BajasAceptadasPorAnio(int anio, int cantidad) {
        this.anio = anio;
        this.cantidad = cantidad;
    }
    public int getAnio() {
        return anio;
    }
    public void setAnio(int anio) {
        this.anio = anio;
    }
    public int getCantidad() {
        return cantidad;
    }
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    
}
