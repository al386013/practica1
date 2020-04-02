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
            LocalDate fechaIni = entrada.pedirFechaIni();
            LocalDate fechaFin = entrada.pedirFechaFin();
            baseDeDatos.compruebaFechas(fechaIni, fechaFin);
            entrada.imprimir(baseDeDatos.listarFacturasEntreFechas(nif, fechaIni, fechaFin));
        } catch (NifNoExistenteException | IntervaloFechasIncorrectoException e) {
            e.printStackTrace();
        }
    }
}
