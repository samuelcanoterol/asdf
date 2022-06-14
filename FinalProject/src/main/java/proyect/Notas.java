package proyect;

import java.time.LocalDate;
import java.util.Date;

public class Notas {
    private String name;
    private String descripcion;
    private LocalDate fecha;

    public Notas(String name, String descripcion, LocalDate fecha) {
        this.name = name;
        this.descripcion = descripcion;
        this.fecha = fecha;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    @Override
    public String toString() {
        return name + ";" + descripcion + ";" + fecha;
    }
}
