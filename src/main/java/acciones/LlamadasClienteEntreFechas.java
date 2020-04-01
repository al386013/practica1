package acciones;

import principal.BaseDeDatos;
import principal.IntervaloFechasIncorrectoException;
import principal.TelfNoExistenteException;
import java.time.LocalDate;

public class LlamadasClienteEntreFechas implements Accion {
    @Override
    public void ejecutaAccion(BaseDeDatos baseDeDatos) {
        try {
            entrada.imprimir("\nMOSTRAR LISTADO DE LAS LLAMADAS REALIZADAS ENTRE DOS FECHAS");
            String telf = entrada.pedirTelf("- Introduce el telefono del cliente: ");
            baseDeDatos.compruebaTelfExistente(telf);
            LocalDate fechaIni = entrada.pedirFecha("- Introduce la fecha de inicio (formato aaaa-mm-dd): ");
            LocalDate fechaFin = entrada.pedirFecha("- Introduce la fecha de fin (formato aaaa-mm-dd): ");
            baseDeDatos.compruebaFechas(fechaIni, fechaFin);
            entrada.imprimir(baseDeDatos.listarLlamadasEntreFechas(telf, fechaIni, fechaFin));
        } catch (TelfNoExistenteException | IntervaloFechasIncorrectoException e) {
            e.printStackTrace();
        }
    }
}
