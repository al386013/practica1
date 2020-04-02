package acciones;

import principal.BaseDeDatos;
import principal.TelfNoExistenteException;

public class DaAltaLlamada implements Accion {
    @Override
    public void ejecutaAccion(BaseDeDatos baseDeDatos) {
        try {
            entrada.imprimir("\nDAR DE ALTA UNA LLAMADA");
            String telfOrigen = entrada.pedirTelf();
            baseDeDatos.compruebaTelfExistente(telfOrigen);
            String telfDest = entrada.pedirTelfDestino();
            int duracion = entrada.pedirDuracion();
            baseDeDatos.darDeAltaLlamada(telfOrigen, telfDest, duracion);
            entrada.imprimir("\n\tLlamada del " + telfOrigen + " al " + telfDest + " realizada con exito.\n");
        } catch (TelfNoExistenteException | IllegalArgumentException e) {
            e.printStackTrace();
        }
    }
}
