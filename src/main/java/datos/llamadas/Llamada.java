package datos.llamadas;

import interfaces.tieneFecha;
import java.time.LocalDate;
import java.time.LocalTime;

public class Llamada implements tieneFecha {
    private String telf;
    private LocalDate fecha;
    private LocalTime hora;
    private int duracion; //en segundos

    public Llamada(String telfDestino, int duracion) {
        this.telf = telfDestino;
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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Llamada realizada el " + fecha);
        sb.append(" a las " + hora.getHour() + ":" + hora.getMinute());
        sb.append(" con una duracion de " + duracion + " segundos");
        sb.append(" al telefono " + telf);
        return sb.toString();
    }
}
