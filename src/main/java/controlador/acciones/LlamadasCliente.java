package controlador.acciones;

import modelo.principal.BaseDeDatos;
import modelo.principal.TelfNoExistenteException;
import vista.InterrogaVista;
import vista.InterrogaVistaLlamadas;

public class LlamadasCliente implements Accion {
    @Override
    public void ejecutaAccion(BaseDeDatos baseDeDatos, InterrogaVista vista) {
        try {
            InterrogaVistaLlamadas vistaLlamadas = vista.getVistaLlamadas();
            String telf = vistaLlamadas.getTelfListado();
            baseDeDatos.compruebaTelfExistente(telf);
            entradaSalida.imprimirConSalto("\nLLAMADAS DEL CLIENTE CON TELEFONO " + telf);
            entradaSalida.imprimirConSalto(baseDeDatos.listarLlamadasCliente(telf));
        } catch (TelfNoExistenteException e) {
            e.printStackTrace();
        }
    }
}
