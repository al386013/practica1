package controlador;

import modelo.principal.IntervaloFechasIncorrectoException;
import modelo.principal.NifNoExistenteException;
import vista.InterrogaVistaFacturas;
import java.time.LocalDate;

class EmiteFactura extends Accion {
    public void ejecutaAccion() throws NifNoExistenteException, IntervaloFechasIncorrectoException {
        InterrogaVistaFacturas vistaFacturas = vista.getPanelFacturas();
        String nif = vistaFacturas.getNifFac();
        baseDeDatos.compruebaNifExistente(nif);
        LocalDate fechaIni = vistaFacturas.getFechaIniFac();
        LocalDate fechaFin = vistaFacturas.getFechaFinFac();
        baseDeDatos.compruebaFechas(fechaIni, fechaFin);
        baseDeDatos.emitirFactura(fechaIni, fechaFin, nif);

    }
}
