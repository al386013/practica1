package controlador.acciones;

import modelo.principal.BaseDeDatos;
import modelo.principal.TelfNoExistenteException;
import vista.InterrogaVista;
import vista.InterrogaVistaClientes;

public class BorrarCliente implements Accion {
    @Override
    public void ejecutaAccion(BaseDeDatos baseDeDatos, InterrogaVista vista) {
        try {
            InterrogaVistaClientes vistaClientes = vista.getVistaClientes();
            String telf = vistaClientes.getTelfBorrar();
            baseDeDatos.compruebaTelfExistente(telf);
            baseDeDatos.borrarCliente(telf);
            vistaClientes.clienteBorrado(telf);
        } catch (TelfNoExistenteException e) {
            e.printStackTrace();
        }
    }
}
