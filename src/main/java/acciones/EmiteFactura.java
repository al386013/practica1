package acciones;

import principal.BaseDeDatos;
import principal.IntervaloFechasIncorrectoException;
import principal.NifNoExistenteException;
import java.time.LocalDate;

public class EmiteFactura implements Accion {
    @Override
    public void ejecutaAccion(BaseDeDatos baseDeDatos) {
        try {
            entrada.imprimirConSalto("\nEMITIR FACTURA PARA UN CLIENTE");
            String nif = entrada.pedirNif();
            baseDeDatos.compruebaNifExistente(nif);
            LocalDate fechaIni = entrada.pedirFechaIni();
            LocalDate fechaFin = entrada.pedirFechaFin();
            baseDeDatos.compruebaFechas(fechaIni, fechaFin);
            baseDeDatos.emitirFactura(fechaIni, fechaFin, nif);
            entrada.imprimirConSalto("\n\tFactura del cliente con NIF " + nif + " emitida con exito.\n");
        } catch (NifNoExistenteException | IntervaloFechasIncorrectoException e) {
            e.printStackTrace();
        }
    }
}
