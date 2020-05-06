package controlador;

import modelo.principal.TelfNoExistenteException;
import vista.InterrogaVistaClientes;

public class BorrarCliente extends Accion {
    public void ejecutaAccion() throws TelfNoExistenteException {
        InterrogaVistaClientes vistaClientes = vista.getPanelClientes();
        String telf = vistaClientes.getTelfBorrar();
        baseDeDatos.compruebaTelfExistente(telf);
        baseDeDatos.borrarCliente(telf);

        vista.accionCorrecta("Cliente borrado con éxito.");
    }
}
