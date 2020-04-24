package controlador.acciones;

import modelo.principal.BaseDeDatos;
import modelo.principal.TelfNoExistenteException;
import vista.InterrogaVista;
import vista.InterrogaVistaLlamadas;

public class DaAltaLlamada implements Accion {
    @Override
    public void ejecutaAccion(BaseDeDatos baseDeDatos, InterrogaVista vista) {
        try {
            InterrogaVistaLlamadas vistaLlamadas = vista.getVistaLlamadas();
            String telfOrigen = vistaLlamadas.getTelfOrigen();
            baseDeDatos.compruebaTelfExistente(telfOrigen);
            String telfDest = vistaLlamadas.getTelfDestino();
            int duracion = vistaLlamadas.getDuracion();
            baseDeDatos.darDeAltaLlamada(telfOrigen, telfDest, duracion);
            entradaSalida.imprimirConSalto("\n\tLlamada del " + telfOrigen + " al " + telfDest + " realizada con exito.\n");
        } catch (TelfNoExistenteException | IllegalArgumentException e) {
            e.printStackTrace();
        }
    }
}
