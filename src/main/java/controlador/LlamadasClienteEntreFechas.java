package controlador;

import modelo.principal.IntervaloFechasIncorrectoException;
import modelo.principal.TelfNoExistenteException;
import vista.InterrogaVistaLlamadas;
import java.time.LocalDate;

public class LlamadasClienteEntreFechas extends Accion {
    public void ejecutaAccion() throws TelfNoExistenteException, IntervaloFechasIncorrectoException {
        InterrogaVistaLlamadas vistaLlamadas = vista.getPanelLlamadas();
        String telf = vistaLlamadas.getTelfListadoFechas();
        baseDeDatos.compruebaTelfExistente(telf);
        LocalDate fechaIni = vistaLlamadas.getFechaIniListado();
        LocalDate fechaFin = vistaLlamadas.getFechaFinListado();
        baseDeDatos.compruebaFechas(fechaIni, fechaFin);
        vista.getPanelLlamadas().listadoLlamadasEntreFechas(telf, fechaIni, fechaFin);
    }
}
