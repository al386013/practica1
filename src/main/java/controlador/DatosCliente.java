package controlador;

import modelo.principal.NifNoExistenteException;
import vista.InterrogaVistaClientes;

public class DatosCliente extends Accion {
    public void ejecutaAccion() throws NifNoExistenteException {
        InterrogaVistaClientes vistaClientes = vista.getPanelClientes();
        String nif = vistaClientes.getNifCli();
        baseDeDatos.compruebaNifExistente(nif);
        vistaClientes.datosCliente(nif);
    }
}
