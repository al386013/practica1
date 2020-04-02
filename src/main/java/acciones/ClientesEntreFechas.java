package acciones;

import principal.BaseDeDatos;
import principal.IntervaloFechasIncorrectoException;

import java.time.LocalDate;

public class ClientesEntreFechas implements Accion {
    @Override
    public void ejecutaAccion(BaseDeDatos baseDeDatos) {
        try {
            entrada.imprimirConSalto("\nMOSTRAR LISTADO DE LOS CLIENTES DADOS DE ALTA ENTRE DOS FECHAS");
            LocalDate fechaIni = entrada.pedirFechaIni();
            LocalDate fechaFin = entrada.pedirFechaFin();
            baseDeDatos.compruebaFechas(fechaIni, fechaFin);
            System.out.println(baseDeDatos.listarClientesEntreFechas(fechaIni, fechaFin));
        } catch (IntervaloFechasIncorrectoException e) {
            e.printStackTrace();
        }
    }
}
