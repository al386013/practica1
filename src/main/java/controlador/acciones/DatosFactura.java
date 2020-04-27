package controlador.acciones;

import modelo.principal.BaseDeDatos;
import vista.InterrogaVista;
import vista.InterrogaVistaFacturas;

public class DatosFactura implements Accion {
    public void ejecutaAccion(BaseDeDatos baseDeDatos, InterrogaVista vista) throws IllegalArgumentException {
        InterrogaVistaFacturas vistaFacturas = vista.getVistaFacturas();
        int cod = vistaFacturas.getCodFac();
        vistaFacturas.datosFactura(cod);
    }
}
