package controlador;

import modelo.principal.TelfNoExistenteException;
import vista.InterrogaVistaLlamadas;

class DaAltaLlamada extends Accion {
    public void ejecutaAccion() throws TelfNoExistenteException {
        InterrogaVistaLlamadas vistaLlamadas = vista.getPanelLlamadas();
        String telfOrigen = vistaLlamadas.getTelfOrigen();
        baseDeDatos.compruebaTelfExistente(telfOrigen);
        String telfDest = vistaLlamadas.getTelfDestino();
        int duracion = vistaLlamadas.getDuracion();
        baseDeDatos.darDeAltaLlamada(telfOrigen, telfDest, duracion);
    }
}
