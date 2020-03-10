package datos.llamadas;

import interfaces.TieneFecha;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

public class Llamada implements TieneFecha, Serializable {
    private String telfDest;
    private LocalDate fecha;
    private LocalTime hora;
    private int duracion; //en segundos

    //CONSTRUCTORES

    public Llamada() {
        this.telfDest = "";
        this.fecha = null;
        this.hora = null;
        this.duracion = 0;
    }

    public Llamada(String telfDest, int duracion) {
        this.telfDest = telfDest;
        this.fecha = LocalDate.now();
        this.hora = LocalTime.now();
        this.duracion = duracion;
    }

    @Override
    public LocalDate getFecha() {
        return fecha;
    }

    public int getDuracion() {
        return duracion;
    }

    public String getTelfDest() {
        return telfDest;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\t- Llamada realizada el " + fecha);
        sb.append(" a las " + hora.getHour() + " horas y " + hora.getMinute() + " minutos");
        sb.append(" con una duracion de " + duracion + " segundos");
        sb.append(" al telefono " + telfDest);
        return sb.toString();
    }
}
