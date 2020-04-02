package acciones;

import principal.BaseDeDatos;
import principal.IntervaloFechasIncorrectoException;
import principal.TelfNoExistenteException;
import java.time.LocalDate;

public class LlamadasClienteEntreFechas implements Accion {
    @Override
    public void ejecutaAccion(BaseDeDatos baseDeDatos) {
        try {
            entrada.imprimirConSalto("\nMOSTRAR LISTADO DE LAS LLAMADAS REALIZADAS ENTRE DOS FECHAS");
            String telf = entrada.pedirTelf();
            baseDeDatos.compruebaTelfExistente(telf);
            LocalDate fechaIni = entrada.pedirFechaIni();
            LocalDate fechaFin = entrada.pedirFechaFin();
            baseDeDatos.compruebaFechas(fechaIni, fechaFin);
            entrada.imprimirConSalto(baseDeDatos.listarLlamadasEntreFechas(telf, fechaIni, fechaFin));
        } catch (TelfNoExistenteException | IntervaloFechasIncorrectoException e) {
            e.printStackTrace();
        }
    }
}
