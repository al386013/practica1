package controlador;

import modelo.principal.NifNoExistenteException;
import vista.InterrogaVistaFacturas;

class FacturasCliente extends Accion {
    public void ejecutaAccion() throws NifNoExistenteException {
        InterrogaVistaFacturas vistaFacturas = vista.getPanelFacturas();
        String nif = vistaFacturas.getNifFacCli();
        baseDeDatos.compruebaNifExistente(nif);
        vista.getPanelFacturas().listadoFacturas(nif);
    }
}
