package controlador;

import vista.InterrogaVistaFacturas;

class DatosFactura extends Accion {
    public void ejecutaAccion() {
        InterrogaVistaFacturas vistaFacturas = vista.getPanelFacturas();
        int cod = vistaFacturas.getCodFac();
        vistaFacturas.datosFactura(cod);
    }
}
