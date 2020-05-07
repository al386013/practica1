package controlador;

import modelo.principal.TelfNoExistenteException;
import vista.InterrogaVistaLlamadas;

class LlamadasCliente extends Accion {
    public void ejecutaAccion() throws TelfNoExistenteException {
        InterrogaVistaLlamadas vistaLlamadas = vista.getPanelLlamadas();
        String telf = vistaLlamadas.getTelfListado();
        baseDeDatos.compruebaTelfExistente(telf);
        vista.getPanelLlamadas().listadoLlamadas(telf);
    }
}
