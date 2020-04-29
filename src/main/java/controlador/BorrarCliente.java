package controlador;

import modelo.principal.TelfNoExistenteException;
import vista.InterrogaVistaClientes;

public class BorrarCliente extends Accion {
    public void ejecutaAccion() throws TelfNoExistenteException {
        InterrogaVistaClientes vistaClientes = vista.getVistaClientes();
        String telf = vistaClientes.getTelfBorrar();
        baseDeDatos.compruebaTelfExistente(telf);
        baseDeDatos.borrarCliente(telf);
    }
}
