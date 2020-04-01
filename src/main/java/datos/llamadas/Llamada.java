package datos.llamadas;

import datos.TieneFecha;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import static java.lang.String.format;

public class Llamada implements TieneFecha, Serializable {
    private String telfDest;
    private LocalDate fecha;
    private LocalTime hora;
    private int duracion; //en segundos

    //CONSTRUCTORES

    public Llamada() {
        super();
        this.telfDest = "";
        this.fecha = null;
        this.hora = null;
        this.duracion = 0;
    }

    public Llamada(String telfDest, int duracion) {
        super();
        this.telfDest = telfDest;
        this.fecha = LocalDate.now();
        this.hora = LocalTime.now();
        this.duracion = duracion;
    }

    public void setFecha(LocalDate fecha) { this.fecha = fecha; }

    public void setHora(LocalTime hora) { this.hora = hora; }

    @Override
    public LocalDate getFecha() {
        return fecha;
    }

    @Override
    public LocalTime getHora() { return hora; }

    public int getDuracion() {
        return duracion;
    }

    public String getTelfDest() {
        return telfDest;
    }

    @Override
    public String toString() {
        String string = "\t- Llamada realizada el " + fecha;
        string += " a las " + format("%02d:%02d", hora.getHour(), hora.getMinute());
        string += " con una duracion de " + duracion + " segundos";
        string += " al telefono " + telfDest;
        return string;
    }
}
