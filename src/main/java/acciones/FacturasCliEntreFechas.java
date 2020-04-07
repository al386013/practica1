package acciones;

import principal.BaseDeDatos;
import principal.IntervaloFechasIncorrectoException;
import principal.NifNoExistenteException;
import java.time.LocalDate;

public class FacturasCliEntreFechas implements Accion {
    @Override
    public void ejecutaAccion(BaseDeDatos baseDeDatos) {
        try {
            entradaSalida.imprimirConSalto("\nMOSTRAR LISTADO DE LAS FACTURAS DE UN CLIENTE DADAS DE ALTA ENTRE DOS FECHAS");
            String nif = entradaSalida.pedirNif();
            baseDeDatos.compruebaNifExistente(nif);
            LocalDate fechaIni = entradaSalida.pedirFechaIni();
            LocalDate fechaFin = entradaSalida.pedirFechaFin();
            baseDeDatos.compruebaFechas(fechaIni, fechaFin);
            entradaSalida.imprimirConSalto(baseDeDatos.listarFacturasEntreFechas(nif, fechaIni, fechaFin));
        } catch (NifNoExistenteException | IntervaloFechasIncorrectoException e) {
            e.printStackTrace();
        }
    }
}
