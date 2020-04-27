package controlador.acciones;

import modelo.principal.BaseDeDatos;
import modelo.principal.NifNoExistenteException;
import vista.InterrogaVista;
import vista.InterrogaVistaClientes;

public class ContratarTarifa implements Accion {
    public void ejecutaAccion(BaseDeDatos baseDeDatos, InterrogaVista vista) throws NifNoExistenteException {
        InterrogaVistaClientes vistaClientes = vista.getVistaClientes();
        String nif = vistaClientes.getNifTarifa();
        baseDeDatos.compruebaNifExistente(nif);
        String opcionCambiarTarifa = vistaClientes.getTipoTarifa();
        baseDeDatos.contratarTarifaEspecial(opcionCambiarTarifa, nif);
    }
}
