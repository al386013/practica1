package acciones;

import interfaces.Accion;
import principal.BaseDeDatos;
import principal.IntervaloFechasIncorrectoException;
import principal.NifNoExistenteException;

import java.time.LocalDate;

public class FacturasCliEntreFechas implements Accion {
    @Override
    public void ejecutaAccion(BaseDeDatos baseDeDatos) {
        try {
            System.out.println("\nMOSTRAR LISTADO DE LAS FACTURAS DE UN CLIENTE DADAS DE ALTA ENTRE DOS FECHAS");
            System.out.print("- Introduce el NIF del cliente: ");
            String nif = sc.next();
            baseDeDatos.compruebaNifExistente(nif);
            System.out.print("- Introduce la fecha de inicio (formato aaaa-mm-dd): ");
            LocalDate fechaIni = LocalDate.parse(sc.next());
            System.out.print("- Introduce la fecha de fin (formato aaaa-mm-dd): ");
            LocalDate fechaFin = LocalDate.parse(sc.next());
            baseDeDatos.compruebaFechas(fechaIni, fechaFin);
            System.out.println(baseDeDatos.listarFacturasEntreFechas(nif, fechaIni, fechaFin));
        } catch (NifNoExistenteException | IntervaloFechasIncorrectoException e) {
            e.printStackTrace();
        }
    }
}
