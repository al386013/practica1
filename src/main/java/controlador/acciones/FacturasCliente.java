package controlador.acciones;

import modelo.principal.BaseDeDatos;
import modelo.principal.NifNoExistenteException;
import vista.InterrogaVista;
import vista.InterrogaVistaFacturas;

public class FacturasCliente implements Accion {
    @Override
    public void ejecutaAccion(BaseDeDatos baseDeDatos, InterrogaVista vista) {
        try {
            InterrogaVistaFacturas vistaFacturas = vista.getVistaFacturas();
            String nif = vistaFacturas.getNifFacCli();
            baseDeDatos.compruebaNifExistente(nif);
            entradaSalida.imprimirConSalto("\nLISTADO DE FACTURAS DEL CLIENTE CON NIF " + nif);
            entradaSalida.imprimirConSalto(baseDeDatos.listarFacturasCliente(nif));
        } catch (NifNoExistenteException e) {
            e.printStackTrace();
        }
    }
}
