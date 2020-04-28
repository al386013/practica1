package controlador.acciones;

import modelo.principal.BaseDeDatos;
import modelo.principal.IntervaloFechasIncorrectoException;
import modelo.principal.NifNoExistenteException;
import vista.InterrogaVista;
import vista.InterrogaVistaFacturas;
import java.time.LocalDate;

public class FacturasCliEntreFechas implements Accion {
    public void ejecutaAccion(BaseDeDatos baseDeDatos, InterrogaVista vista) throws NifNoExistenteException, IntervaloFechasIncorrectoException {
        InterrogaVistaFacturas vistaFacturas = vista.getVistaFacturas();
        String nif = vistaFacturas.getNifFechas();
        baseDeDatos.compruebaNifExistente(nif);
        LocalDate fechaIni = vistaFacturas.getFechaIniFechas();
        LocalDate fechaFin = vistaFacturas.getFechasFinFechas();
        baseDeDatos.compruebaFechas(fechaIni, fechaFin);
        vista.getVistaFacturas().listadoFacturasEntreFechas(nif, fechaIni, fechaFin);
    }
}
