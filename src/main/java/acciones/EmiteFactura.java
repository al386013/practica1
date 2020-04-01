package acciones;

import principal.BaseDeDatos;
import principal.IntervaloFechasIncorrectoException;
import principal.NifNoExistenteException;

import java.time.LocalDate;

public class EmiteFactura implements Accion {
    @Override
    public void ejecutaAccion(BaseDeDatos baseDeDatos) {
        try {
            entrada.imprimir("\nEMITIR FACTURA PARA UN CLIENTE");
            String nif = entrada.pedirNif();
            baseDeDatos.compruebaNifExistente(nif);
            LocalDate fechaIni = entrada.pedirFecha("- Introduce la fecha de inicio de la factura (formato aaaa-mm-dd): ");
            LocalDate fechaFin = entrada.pedirFecha("- Introduce la fecha de fin de la factura (formato aaaa-mm-dd): ");
            baseDeDatos.compruebaFechas(fechaIni, fechaFin);
            baseDeDatos.emitirFactura(fechaIni, fechaFin, nif);
            entrada.imprimir("\n\tFactura del cliente con NIF " + nif + " emitida con exito.\n");
        } catch (NifNoExistenteException | IntervaloFechasIncorrectoException e) {
            e.printStackTrace();
        }
    }
}
