package controlador.acciones;

import modelo.principal.BaseDeDatos;
import modelo.principal.IntervaloFechasIncorrectoException;
import modelo.principal.NifNoExistenteException;
import vista.InterrogaVista;
import vista.InterrogaVistaFacturas;

import java.time.LocalDate;

public class EmiteFactura implements Accion {
    @Override
    public void ejecutaAccion(BaseDeDatos baseDeDatos, InterrogaVista vista) {
        try {
            InterrogaVistaFacturas vistaFacturas = vista.getVistaFacturas();
            String nif = vistaFacturas.getNifFac();
            baseDeDatos.compruebaNifExistente(nif);
            LocalDate fechaIni = vistaFacturas.getFechaIniFac();
            LocalDate fechaFin = vistaFacturas.getFechaFinFac();
            baseDeDatos.compruebaFechas(fechaIni, fechaFin);
            baseDeDatos.emitirFactura(fechaIni, fechaFin, nif);
            entradaSalida.imprimirConSalto("\n\tFactura del cliente con NIF " + nif + " emitida con exito.\n");
        } catch (NifNoExistenteException | IntervaloFechasIncorrectoException e) {
            e.printStackTrace();
        }
    }
}
