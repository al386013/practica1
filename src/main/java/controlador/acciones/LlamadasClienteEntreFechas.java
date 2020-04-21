package controlador.acciones;

import modelo.principal.BaseDeDatos;
import modelo.principal.IntervaloFechasIncorrectoException;
import modelo.principal.TelfNoExistenteException;
import java.time.LocalDate;

public class LlamadasClienteEntreFechas implements Accion {
    @Override
    public void ejecutaAccion(BaseDeDatos baseDeDatos) {
        try {
            entradaSalida.imprimirConSalto("\nMOSTRAR LISTADO DE LAS LLAMADAS REALIZADAS ENTRE DOS FECHAS");
            String telf = entradaSalida.pedirTelf();
            baseDeDatos.compruebaTelfExistente(telf);
            LocalDate fechaIni = entradaSalida.pedirFechaIni();
            LocalDate fechaFin = entradaSalida.pedirFechaFin();
            baseDeDatos.compruebaFechas(fechaIni, fechaFin);
            entradaSalida.imprimirConSalto(baseDeDatos.listarLlamadasEntreFechas(telf, fechaIni, fechaFin));
        } catch (TelfNoExistenteException | IntervaloFechasIncorrectoException e) {
            e.printStackTrace();
        }
    }
}
