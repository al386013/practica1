package acciones;

import principal.BaseDeDatos;
import principal.IntervaloFechasIncorrectoException;

import java.time.LocalDate;

public class ClientesEntreFechas implements Accion {
    @Override
    public void ejecutaAccion(BaseDeDatos baseDeDatos) {
        try {

            entrada.imprimir("\nMOSTRAR LISTADO DE LOS CLIENTES DADOS DE ALTA ENTRE DOS FECHAS");
            LocalDate fechaIni = entrada.pedirFecha("- Introduce la fecha de inicio (formato aaaa-mm-dd): ");
            LocalDate fechaFin = entrada.pedirFecha("- Introduce la fecha de fin (formato aaaa-mm-dd): ");
            baseDeDatos.compruebaFechas(fechaIni, fechaFin);
            System.out.println(baseDeDatos.listarClientesEntreFechas(fechaIni, fechaFin));
        } catch (IntervaloFechasIncorrectoException e) {
            e.printStackTrace();
        }
    }
}
