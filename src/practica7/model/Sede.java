package practica7.model;

public class Sede {

    private String nombre;
    private int capacidad;
    private String pais;

    public Sede() {

    }

    public Sede(String nombre, int capacidad, String pais) {
        this.nombre = nombre;
        this.capacidad = capacidad;
        this.pais = pais;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }
}
