package controlador.acciones;

import modelo.principal.BaseDeDatos;
import modelo.principal.NifNoExistenteException;
import vista.InterrogaVista;
import vista.InterrogaVistaClientes;

public class ContratarTarifa implements Accion {
    @Override
    public void ejecutaAccion(BaseDeDatos baseDeDatos, InterrogaVista vista) {
        try {
            InterrogaVistaClientes vistaClientes = vista.getVistaClientes();
            String nif = vistaClientes.getNifTarifa();
            baseDeDatos.compruebaNifExistente(nif);
            String opcionCambiarTarifa = vistaClientes.getTipoTarifa();

            baseDeDatos.contratarTarifaEspecial(opcionCambiarTarifa, nif);
            entradaSalida.imprimirConSalto("\n\t--> Tarifa especial contratada.\n");
        } catch (NifNoExistenteException e) {
            e.printStackTrace();
        }
    }
}
