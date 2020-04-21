package controlador.acciones;

import modelo.principal.BaseDeDatos;
import modelo.principal.IntervaloFechasIncorrectoException;
import modelo.principal.NifNoExistenteException;
import java.time.LocalDate;

public class EmiteFactura implements Accion {
    @Override
    public void ejecutaAccion(BaseDeDatos baseDeDatos) {
        try {
            entradaSalida.imprimirConSalto("\nEMITIR FACTURA PARA UN CLIENTE");
            String nif = entradaSalida.pedirNif();
            baseDeDatos.compruebaNifExistente(nif);
            LocalDate fechaIni = entradaSalida.pedirFechaIni();
            LocalDate fechaFin = entradaSalida.pedirFechaFin();
            baseDeDatos.compruebaFechas(fechaIni, fechaFin);
            baseDeDatos.emitirFactura(fechaIni, fechaFin, nif);
            entradaSalida.imprimirConSalto("\n\tFactura del cliente con NIF " + nif + " emitida con exito.\n");
        } catch (NifNoExistenteException | IntervaloFechasIncorrectoException e) {
            e.printStackTrace();
        }
    }
}
