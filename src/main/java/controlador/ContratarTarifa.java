package controlador;

import modelo.principal.NifNoExistenteException;
import vista.InterrogaVistaClientes;

class ContratarTarifa extends Accion {
    public void ejecutaAccion() throws NifNoExistenteException {
        InterrogaVistaClientes vistaClientes = vista.getPanelClientes();
        String nif = vistaClientes.getNifTarifa();
        baseDeDatos.compruebaNifExistente(nif);
        String opcionCambiarTarifa = vistaClientes.getTipoTarifa();
        baseDeDatos.contratarTarifaEspecial(opcionCambiarTarifa, nif);

    }
}
