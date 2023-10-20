package Modelos;
public class DrcBecas {
    private String nombre;
    private int monto;

    public DrcBecas(String nombre, int monto) {
        this.nombre = nombre;
        this.monto = monto;
    }

    public DrcBecas() {
        this.nombre = "";
        this.monto = 0;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getMonto() {
        return monto;
    }

    public void setMonto(int monto) {
        this.monto = monto;
    }
}
