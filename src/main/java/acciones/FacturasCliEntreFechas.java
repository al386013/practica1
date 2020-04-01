package acciones;

import principal.BaseDeDatos;
import principal.IntervaloFechasIncorrectoException;
import principal.NifNoExistenteException;
import java.time.LocalDate;

public class FacturasCliEntreFechas implements Accion {
    @Override
    public void ejecutaAccion(BaseDeDatos baseDeDatos) {
        try {
            entrada.imprimir("\nMOSTRAR LISTADO DE LAS FACTURAS DE UN CLIENTE DADAS DE ALTA ENTRE DOS FECHAS");
            String nif = entrada.pedirNif();
            baseDeDatos.compruebaNifExistente(nif);
            LocalDate fechaIni = entrada.pedirFecha("- Introduce la fecha de inicio (formato aaaa-mm-dd): ");
            LocalDate fechaFin = entrada.pedirFecha("- Introduce la fecha de fin (formato aaaa-mm-dd): ");
            baseDeDatos.compruebaFechas(fechaIni, fechaFin);
            entrada.imprimir(baseDeDatos.listarFacturasEntreFechas(nif, fechaIni, fechaFin));
        } catch (NifNoExistenteException | IntervaloFechasIncorrectoException e) {
            e.printStackTrace();
        }
    }
}
