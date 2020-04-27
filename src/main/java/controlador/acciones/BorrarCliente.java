package controlador.acciones;

import modelo.principal.BaseDeDatos;
import modelo.principal.TelfNoExistenteException;
import vista.InterrogaVista;
import vista.InterrogaVistaClientes;

public class BorrarCliente implements Accion {
    public void ejecutaAccion(BaseDeDatos baseDeDatos, InterrogaVista vista) throws TelfNoExistenteException {
        InterrogaVistaClientes vistaClientes = vista.getVistaClientes();
        String telf = vistaClientes.getTelfBorrar();
        baseDeDatos.compruebaTelfExistente(telf);
        baseDeDatos.borrarCliente(telf);
    }
}
