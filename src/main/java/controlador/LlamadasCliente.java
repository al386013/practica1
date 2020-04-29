package controlador;

import modelo.principal.TelfNoExistenteException;
import vista.InterrogaVistaLlamadas;

public class LlamadasCliente extends Accion {
    public void ejecutaAccion() throws TelfNoExistenteException {
        InterrogaVistaLlamadas vistaLlamadas = vista.getVistaLlamadas();
        String telf = vistaLlamadas.getTelfListado();
        baseDeDatos.compruebaTelfExistente(telf);
        vista.getVistaLlamadas().listadoLlamadas(telf);
    }
}
