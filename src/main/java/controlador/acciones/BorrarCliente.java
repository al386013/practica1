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
            entradaSalida.imprimirConSalto("\n\tCliente con numero " + telf + " borrado con exito.\n");
        } catch (TelfNoExistenteException e) {
            e.printStackTrace();
        }
    }
}
