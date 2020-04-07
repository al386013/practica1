package acciones;

import principal.BaseDeDatos;
import principal.TelfNoExistenteException;

public class DaAltaLlamada implements Accion {
    @Override
    public void ejecutaAccion(BaseDeDatos baseDeDatos) {
        try {
            entradaSalida.imprimirConSalto("\nDAR DE ALTA UNA LLAMADA");
            String telfOrigen = entradaSalida.pedirTelf();
            baseDeDatos.compruebaTelfExistente(telfOrigen);
            String telfDest = entradaSalida.pedirTelfDestino();
            int duracion = entradaSalida.pedirDuracion();
            baseDeDatos.darDeAltaLlamada(telfOrigen, telfDest, duracion);
            entradaSalida.imprimirConSalto("\n\tLlamada del " + telfOrigen + " al " + telfDest + " realizada con exito.\n");
        } catch (TelfNoExistenteException | IllegalArgumentException e) {
            e.printStackTrace();
        }
    }
}
