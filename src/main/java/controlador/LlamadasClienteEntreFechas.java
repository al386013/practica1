package controlador;

import modelo.principal.IntervaloFechasIncorrectoException;
import modelo.principal.TelfNoExistenteException;
import vista.InterrogaVistaLlamadas;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;

public class LlamadasClienteEntreFechas extends Accion {
    public void ejecutaAccion() throws TelfNoExistenteException, IntervaloFechasIncorrectoException {
        InterrogaVistaLlamadas vistaLlamadas = vista.getVistaLlamadas();
        String telf = vistaLlamadas.getTelfListadoFechas();
        baseDeDatos.compruebaTelfExistente(telf);
        LocalDate fechaIni = vistaLlamadas.getFechaIniListado();
        LocalDate fechaFin = vistaLlamadas.getFechaFinListado();
        baseDeDatos.compruebaFechas(fechaIni, fechaFin);
        vista.getVistaLlamadas().listadoLlamadasEntreFechas(telf, fechaIni, fechaFin);
    }
}
