package datos.llamadas;

import interfaces.tieneFecha;
import java.util.Scanner;
import java.util.Calendar;

public class Llamada implements tieneFecha {
    private String telf;
    private String fecha;
    private String hora;
    private int duracion; //en minutos??

    //Perdona que te escriba el constructor, pero lo necesito para implementar el metodo efectuar llamada
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

}
