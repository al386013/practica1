package vista;

import controlador.Controlador;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class VentanaAdaptadora extends WindowAdapter {
    private Controlador controlador;

    public void setControlador(Controlador controlador) {
        this.controlador = controlador;
    }

    @Override
    public void windowClosing(WindowEvent e) {
        controlador.exportarDatosYSalir();
        System.exit(0);
    }
    
}
