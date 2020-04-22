package modelo;

import vista.InformaVista;

import java.util.ArrayList;

public class ImplementacionModelo implements CambioModelo, InterrogaModelo {
    private InformaVista vista;

    public ImplementacionModelo(){}

    public void setVista(InformaVista vista) {
        this.vista = vista;
    }
}
