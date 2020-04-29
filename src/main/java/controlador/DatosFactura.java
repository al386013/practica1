package controlador;

import vista.InterrogaVistaFacturas;

public class DatosFactura extends Accion {
    public void ejecutaAccion() {
        InterrogaVistaFacturas vistaFacturas = vista.getVistaFacturas();
        int cod = vistaFacturas.getCodFac();
        vistaFacturas.datosFactura(cod);
    }
}
