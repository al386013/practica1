package datos.llamadas;

import interfaces.tieneFecha;

public class Llamada implements tieneFecha {
    private String telf;
    private String fecha;
    private String hora;
    private int duracion; //en minutos???

    public Llamada(final String telf, final String fecha, final String hora, final int duracion) {
        this.telf = telf;
        this.fecha = fecha;
        this.hora = hora;
        this.duracion = duracion;
    }

    @Override
    public String getFecha() {
        return fecha;
    }
}
