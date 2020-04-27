package controlador.acciones;

import modelo.principal.BaseDeDatos;
import vista.InterrogaVista;
import vista.InterrogaVistaFacturas;

public class DatosFactura implements Accion {
    @Override
    public void ejecutaAccion(BaseDeDatos baseDeDatos, InterrogaVista vista) {
        try {
            InterrogaVistaFacturas vistaFacturas = vista.getVistaFacturas();
            int cod = vistaFacturas.getCodFac();
            //entradaSalida.imprimirConSalto(baseDeDatos.listarDatosFactura(cod) + "\n");
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
    }
}
