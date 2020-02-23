package datos.llamadas;

import interfaces.tieneFecha;

import java.util.Calendar;

public class Llamada implements tieneFecha {
    String telf;
    String fecha;
    String hora;
    int duracion; //en minutos??

    //Perdona que te escriba el constructor, pero lo necesito para implementar el metodo efectuar llamada
    public Llamada (String telfDestino, int duracion){
        this.telf = telfDestino;
        //No estoy seguro de que sea así
        Calendar fechaActual = Calendar.getInstance();
        this.fecha = fechaActual.toString();
        this.hora = fechaActual.getTime().toString();
        this.duracion = duracion;
    }

    @Override
    public String getFecha() {
        return fecha;
    }
}
