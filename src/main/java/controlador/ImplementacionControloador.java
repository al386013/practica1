package controlador;

import modelo.CambioModelo;
import vista.InterrogaVista;

public class ImplementacionControloador implements Controlador {
    private InterrogaVista vista;
    private CambioModelo modelo;

    public ImplementacionControloador() {}

    public void setModelo(CambioModelo modelo) {
        this.modelo = modelo;
    }

    public void setVista(InterrogaVista vista) {
        this.vista = vista;
    }

}
