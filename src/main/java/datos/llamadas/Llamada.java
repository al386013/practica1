package datos.llamadas;

import interfaces.tieneFecha;
import java.util.Scanner;
import java.util.Calendar;

public class Llamada implements tieneFecha {
    private String telf;
    private String fecha;
    private String hora;
    private int duracion; //en minutos??

    public Llamada (String telfDestino, int duracion){
        this.telf = telfDestino;
        Calendar fechaActual = Calendar.getInstance();
        this.fecha = fechaActual.getTime().toString();
        this.hora = fechaActual.getTime().toString();
        this.duracion = duracion;
    }


    @Override
    public String getFecha() {
        return fecha;
    }

    public String getTelf() {
        return telf;
    }

    public int getDuracion() {
        return duracion;
    }

    public String getHora() {
        return hora;
    }

    @Override
    public String toString() {
        return "Llamada realizada el " + fecha +
                " a las " + hora +
                " con una duracion de " + duracion +
                " al telefono " + telf + "\n";
    }
}
