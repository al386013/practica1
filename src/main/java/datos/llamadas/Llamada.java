package datos.llamadas;

import interfaces.tieneFecha;

public class Llamada implements tieneFecha {
    private String telf;
    private String fecha;
    private String hora;
    private int duracion; //en minutos???

    @Override
    public String getFecha() {
        return fecha;
    }
}
