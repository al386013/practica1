package principal.acciones;

import interfaces.Accion;
import principal.excepciones.DuracionNegativaException;

public class DaAltaLlamada implements Accion {
    @Override
    public void ejecutaAccion() {
        try {
            System.out.println("\nDAR DE ALTA UNA LLAMADA");
            String telfOrigen = pedirTelfExistente(); //pedir telfOrigen
            System.out.print("- Introduce el telefono de destino: ");
            String telfDest = sc.next();
            System.out.print("- Introduce la duracion de la llamada (en segundos): ");
            int duracion = sc.nextInt();
            baseDeDatos.darDeAltaLlamada(telfOrigen, telfDest, duracion);
            System.out.println("\n\tLlamada del " + telfOrigen + " al " + telfDest + " realizada con exito.\n");
        } catch (DuracionNegativaException e) {
            e.printStackTrace();
        }
    }
}
