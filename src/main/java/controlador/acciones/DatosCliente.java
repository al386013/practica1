package controlador.acciones;

import modelo.principal.BaseDeDatos;
import modelo.principal.NifNoExistenteException;
import vista.InterrogaVista;
import vista.InterrogaVistaClientes;

public class DatosCliente implements Accion {
    @Override
    public void ejecutaAccion(BaseDeDatos baseDeDatos, InterrogaVista vista) {
        try {
            InterrogaVistaClientes vistaClientes = vista.getVistaClientes();
            String nif = vistaClientes.getNifCli();
            baseDeDatos.compruebaNifExistente(nif);
            //entradaSalida.imprimirConSalto(baseDeDatos.listarDatosCliente(nif) + "\n");
        } catch (NifNoExistenteException e) {
            e.printStackTrace();
        }
    }
}
