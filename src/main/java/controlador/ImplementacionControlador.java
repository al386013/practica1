package controlador;

import controlador.acciones.ExportarDatosYsalir;
import controlador.acciones.ImportarDatos;
import modelo.CambioModelo;
import vista.InterrogaVista;

public class ImplementacionControlador implements Controlador {
    private InterrogaVista vista;
    private CambioModelo modelo;

    public ImplementacionControlador() {}

    public void setModelo(CambioModelo modelo) {
        this.modelo = modelo;
    }

    public void setVista(InterrogaVista vista) {
        this.vista = vista;
    }

    @Override
    public void importarDatos() {
        new ImportarDatos().ejecutaAccion(modelo.getBaseDeDatos());
    }

    @Override
    public void exportarDatosYSalir() {
        new ExportarDatosYsalir().ejecutaAccion(modelo.getBaseDeDatos());
    }
}
