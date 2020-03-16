package principal.acciones;

import interfaces.Accion;
import principal.excepciones.IntervaloFechasIncorrectoException;

import java.time.LocalDate;

public class FacturasCliEntreFechas implements Accion {
    @Override
    public void ejecutaAccion() {
        try {
            System.out.println("\nMOSTRAR LISTADO DE LAS FACTURAS DADAS DE ALTA ENTRE DOS FECHAS");
            String nif = pedirNifExistente();
            System.out.print("- Introduce la fecha de inicio (formato aaaa-mm-dd): ");
            LocalDate fechaIni = LocalDate.parse(sc.next());
            System.out.print("- Introduce la fecha de fin (formato aaaa-mm-dd): ");
            LocalDate fechaFin = LocalDate.parse(sc.next());
            System.out.println(baseDeDatos.listarFacturasEntreFechas(nif, fechaIni, fechaFin));
        } catch (IntervaloFechasIncorrectoException e) {
            e.printStackTrace();
        }
    }
}
