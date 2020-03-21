package acciones;

import interfaces.Accion;
import principal.BaseDeDatos;
import principal.TelfNoExistenteException;

public class DaAltaLlamada implements Accion {
    @Override
    public void ejecutaAccion(BaseDeDatos baseDeDatos) {
        try {
            System.out.println("\nDAR DE ALTA UNA LLAMADA");
            System.out.print("- Introduce el telefono del cliente: ");
            String telfOrigen = sc.next();
            baseDeDatos.compruebaTelfExistente(telfOrigen);
            System.out.print("- Introduce el telefono de destino: ");
            String telfDest = sc.next();
            System.out.print("- Introduce la duracion de la llamada (en segundos): ");
            int duracion = sc.nextInt();
            baseDeDatos.darDeAltaLlamada(telfOrigen, telfDest, duracion);
            System.out.println("\n\tLlamada del " + telfOrigen + " al " + telfDest + " realizada con exito.\n");
        } catch (TelfNoExistenteException | IllegalArgumentException e ) {
            e.printStackTrace();
        }
    }
}
