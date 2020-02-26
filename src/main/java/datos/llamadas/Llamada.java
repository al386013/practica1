package datos.llamadas;

import interfaces.tieneFecha;

import java.time.LocalDate;
import java.time.LocalTime;

public class Llamada implements tieneFecha {
    private String telf;
    private LocalDate fecha;
    private LocalTime hora;
    private int duracion; //en segundos

    public Llamada(String telfDestino, LocalDate fecha, LocalTime hora, int duracion) {
        this.telf = telfDestino;
        this.fecha = fecha;
        this.hora = hora;
        this.duracion = duracion;
    }

    @Override
    public LocalDate getFecha() {
        return fecha;
    }

    public String getTelf() {
        return telf;
    }

    public int getDuracion() {
        return duracion;
    }

    public LocalTime getHora() {
        return hora;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Llamada realizada el " + fecha);
        sb.append(" a las " + hora);
        sb.append(" con una duracion de " + duracion);
        sb.append(" al telefono " + telf);
        return sb.toString();
    }
}
