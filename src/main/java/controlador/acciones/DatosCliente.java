package controlador.acciones;

import modelo.principal.BaseDeDatos;
import modelo.principal.NifNoExistenteException;
import vista.InterrogaVista;
import vista.InterrogaVistaClientes;

public class DatosCliente implements Accion {
    public void ejecutaAccion(BaseDeDatos baseDeDatos, InterrogaVista vista) throws NifNoExistenteException {
        InterrogaVistaClientes vistaClientes = vista.getVistaClientes();
        String nif = vistaClientes.getNifCli();
        baseDeDatos.compruebaNifExistente(nif);
        vistaClientes.datosCliente(nif);
    }
}
