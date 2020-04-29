package controlador;

import modelo.principal.IntervaloFechasIncorrectoException;
import modelo.principal.NifNoExistenteException;
import vista.InterrogaVistaFacturas;
import java.time.LocalDate;

public class FacturasCliEntreFechas extends Accion {
    public void ejecutaAccion() throws NifNoExistenteException, IntervaloFechasIncorrectoException {
        InterrogaVistaFacturas vistaFacturas = vista.getVistaFacturas();
        String nif = vistaFacturas.getNifFechas();
        baseDeDatos.compruebaNifExistente(nif);
        LocalDate fechaIni = vistaFacturas.getFechaIniFechas();
        LocalDate fechaFin = vistaFacturas.getFechasFinFechas();
        baseDeDatos.compruebaFechas(fechaIni, fechaFin);
        vista.getVistaFacturas().listadoFacturasEntreFechas(nif, fechaIni, fechaFin);
    }
}
