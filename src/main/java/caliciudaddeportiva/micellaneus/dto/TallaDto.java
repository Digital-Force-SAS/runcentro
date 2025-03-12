package caliciudaddeportiva.micellaneus.dto;

public class TallaDto {

    private String nombre;
    private int cantidadDisponible;

    // Constructor vacío (necesario para BeanPropertyRowMapper)
    public TallaDto() {
    }

    // Constructor con parámetros (si ya existe)
    public TallaDto(String nombre, int cantidadDisponible) {
        this.nombre = nombre;
        this.cantidadDisponible = cantidadDisponible;
    }

    // Getters y Setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCantidadDisponible() {
        return cantidadDisponible;
    }

    public void setCantidadDisponible(int cantidadDisponible) {
        this.cantidadDisponible = cantidadDisponible;
    }
}