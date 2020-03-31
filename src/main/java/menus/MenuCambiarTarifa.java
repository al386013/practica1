package menus;

import acciones.ContratarTarifaDomingos;
import acciones.ContratarTarifaTardes;
import acciones.OpcionIncorrectaException;
import interfaces.Accion;
import principal.BaseDeDatos;

public enum MenuCambiarTarifa {
    TARIFA_POR_DIA("Tarifa por dias: domingos gratis.", new ContratarTarifaDomingos()),
    TARIFA_POR_HORAS("Tarifa por horas: tardes a 0.03 €/min.", new ContratarTarifaTardes());

    private String textoOpcion;
    private Accion accion;

    private MenuCambiarTarifa(final String textoOpcion, final Accion accion) {
        this.textoOpcion = textoOpcion;
        this.accion = accion;
    }

    public static MenuCambiarTarifa getOpcion(int posicion) {
        return values()[posicion];
    }

    public static String getMenu() {
        StringBuilder sb = new StringBuilder();
        for (MenuCambiarTarifa opcion : MenuCambiarTarifa.values()) {
            sb.append(opcion.ordinal());
            sb.append(".- ");
            sb.append(opcion.textoOpcion);
            sb.append("\n");
        }
        return sb.toString();
    }

    public void ejecutaOpcion(BaseDeDatos baseDeDatos) {
        try {
            accion.ejecutaAccion(baseDeDatos);
        } catch (OpcionIncorrectaException e) {
            e.printStackTrace();
        }
    }
}
