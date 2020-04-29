package controlador;

import modelo.principal.IntervaloFechasIncorrectoException;
import modelo.principal.NifNoExistenteException;
import vista.InterrogaVistaFacturas;
import java.time.LocalDate;

public class FacturasCliEntreFechas extends Accion {
    public void ejecutaAccion() throws NifNoExistenteException, IntervaloFechasIncorrectoException {
        InterrogaVistaFacturas vistaFacturas = vista.getPanelFacturas();
        String nif = vistaFacturas.getNifFechas();
        baseDeDatos.compruebaNifExistente(nif);
        LocalDate fechaIni = vistaFacturas.getFechaIniFechas();
        LocalDate fechaFin = vistaFacturas.getFechasFinFechas();
        baseDeDatos.compruebaFechas(fechaIni, fechaFin);
        vista.getPanelFacturas().listadoFacturasEntreFechas(nif, fechaIni, fechaFin);
    }
}
