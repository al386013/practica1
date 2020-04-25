package controlador.acciones;

import modelo.principal.BaseDeDatos;
import modelo.principal.IntervaloFechasIncorrectoException;
import modelo.principal.NifNoExistenteException;
import vista.InterrogaVista;
import vista.InterrogaVistaFacturas;
import java.time.LocalDate;

public class FacturasCliEntreFechas implements Accion {
    @Override
    public void ejecutaAccion(BaseDeDatos baseDeDatos, InterrogaVista vista) {
        try {
            InterrogaVistaFacturas vistaFacturas = vista.getVistaFacturas();
            String nif = vistaFacturas.getNifFechas();
            baseDeDatos.compruebaNifExistente(nif);
            LocalDate fechaIni = vistaFacturas.getFechaIniFechas();
            LocalDate fechaFin = vistaFacturas.getFechasFinFechas();
            baseDeDatos.compruebaFechas(fechaIni, fechaFin);
            entradaSalida.imprimirConSalto("\nLISTADO DE FACTURAS DEL CLIENTE CON NIF " + nif + " ENTRE " +
                    fechaIni + " Y " + fechaFin);
            entradaSalida.imprimirConSalto(baseDeDatos.listarFacturasEntreFechas(nif, fechaIni, fechaFin));
        } catch (NifNoExistenteException | IntervaloFechasIncorrectoException e) {
            e.printStackTrace();
        }
    }
}
