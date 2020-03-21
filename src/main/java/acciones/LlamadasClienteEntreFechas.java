package acciones;

import interfaces.Accion;
import principal.BaseDeDatos;
import principal.IntervaloFechasIncorrectoException;
import principal.TelfNoExistenteException;

import java.time.LocalDate;

public class LlamadasClienteEntreFechas implements Accion {
    @Override
    public void ejecutaAccion(BaseDeDatos baseDeDatos) {
        try {
            System.out.println("\nMOSTRAR LISTADO DE LAS LLAMADAS REALIZADAS ENTRE DOS FECHAS");
            System.out.print("- Introduce el telefono del cliente: ");
            String telf = sc.next();
            baseDeDatos.compruebaTelfExistente(telf);
            System.out.print("- Introduce la fecha de inicio (formato aaaa-mm-dd): ");
            LocalDate fechaIni = LocalDate.parse(sc.next());
            System.out.print("- Introduce la fecha de fin (formato aaaa-mm-dd): ");
            LocalDate fechaFin = LocalDate.parse(sc.next());
            baseDeDatos.compruebaFechas(fechaIni, fechaFin);
            System.out.println(baseDeDatos.listarLlamadasEntreFechas(telf, fechaIni, fechaFin));
        } catch (TelfNoExistenteException | IntervaloFechasIncorrectoException e) {
            e.printStackTrace();
        }
    }
}
