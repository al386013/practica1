package controlador;

import modelo.principal.NifNoExistenteException;
import vista.InterrogaVistaFacturas;

public class FacturasCliente extends Accion {
    public void ejecutaAccion() throws NifNoExistenteException {
        InterrogaVistaFacturas vistaFacturas = vista.getVistaFacturas();
        String nif = vistaFacturas.getNifFacCli();
        baseDeDatos.compruebaNifExistente(nif);
        vista.getVistaFacturas().listadoFacturas(nif);
    }
}
