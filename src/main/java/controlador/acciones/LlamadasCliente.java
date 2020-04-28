package controlador.acciones;

import modelo.principal.BaseDeDatos;
import modelo.principal.TelfNoExistenteException;
import vista.InterrogaVista;
import vista.InterrogaVistaLlamadas;

public class LlamadasCliente implements Accion {
    public void ejecutaAccion(BaseDeDatos baseDeDatos, InterrogaVista vista) throws TelfNoExistenteException {
        InterrogaVistaLlamadas vistaLlamadas = vista.getVistaLlamadas();
        String telf = vistaLlamadas.getTelfListado();
        baseDeDatos.compruebaTelfExistente(telf);
        vista.getVistaLlamadas().listadoLlamadas(telf);

    }
}
