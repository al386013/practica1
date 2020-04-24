package modelo;

import modelo.principal.BaseDeDatos;
import vista.InformaVista;

public class ImplementacionModelo implements CambioModelo, InterrogaModelo {
    private InformaVista vista;
    private BaseDeDatos baseDeDatos;

    public ImplementacionModelo(){}

    public void setVista(InformaVista vista) {
        this.vista = vista;
    }

    @Override
    public void setBaseDeDatos(BaseDeDatos baseDeDatos){
        this.baseDeDatos = baseDeDatos;
    }

    @Override
    public BaseDeDatos getBaseDeDatos() {
        return baseDeDatos;
    }
}
