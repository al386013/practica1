package controlador.acciones;

import modelo.principal.BaseDeDatos;
import modelo.principal.IntervaloFechasIncorrectoException;
import modelo.principal.TelfNoExistenteException;
import vista.InterrogaVista;
import vista.InterrogaVistaLlamadas;
import java.time.LocalDate;

public class LlamadasClienteEntreFechas implements Accion {
    public void ejecutaAccion(BaseDeDatos baseDeDatos, InterrogaVista vista)
            throws TelfNoExistenteException, IntervaloFechasIncorrectoException {
        InterrogaVistaLlamadas vistaLlamadas = vista.getVistaLlamadas();
        String telf = vistaLlamadas.getTelfListadoFechas();
        baseDeDatos.compruebaTelfExistente(telf);
        LocalDate fechaIni = vistaLlamadas.getFechaIniListado();
        LocalDate fechaFin = vistaLlamadas.getFechaFinListado();
        baseDeDatos.compruebaFechas(fechaIni, fechaFin);
        vista.getVistaLlamadas().listadoLlamadasEntreFechas(telf, fechaIni, fechaFin);
    }
}
