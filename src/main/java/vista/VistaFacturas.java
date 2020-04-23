package vista;

import controlador.Controlador;
import modelo.InterrogaModelo;

public class VistaFacturas implements InformaVista, InterrogaVista {
    private Controlador controlador;
    private InterrogaModelo modelo;

    public VistaFacturas() {}

    public void setModelo(InterrogaModelo modelo) {
        this.modelo = modelo;
    }

    public void setControlador(Controlador controlador) {
        this.controlador = controlador;
    }
}
