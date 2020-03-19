package principal.acciones;

import interfaces.Accion;
import principal.BaseDeDatos;
import principal.excepciones.IntervaloFechasIncorrectoException;

import java.time.LocalDate;

public class LlamadasClienteEntreFechas implements Accion {
    @Override
    public void ejecutaAccion(BaseDeDatos baseDeDatos) {
        try {
            System.out.println("\nMOSTRAR LISTADO DE LAS LLAMADAS REALIZADAS ENTRE DOS FECHAS");
            //String telf = pedirTelfExistente();
            String telf = PedirTelfExistente.pedir(baseDeDatos);
            System.out.print("- Introduce la fecha de inicio (formato aaaa-mm-dd): ");
            LocalDate fechaIni = LocalDate.parse(sc.next());
            System.out.print("- Introduce la fecha de fin (formato aaaa-mm-dd): ");
            LocalDate fechaFin = LocalDate.parse(sc.next());
            System.out.println(baseDeDatos.listarLlamadasEntreFechas(telf, fechaIni, fechaFin));
        } catch (IntervaloFechasIncorrectoException e) {
            e.printStackTrace();
        }
    }
}
