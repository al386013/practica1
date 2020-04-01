package menus;

public enum MenuCambiarTarifa {
    TARIFA_DOMINGOS_GRATIS("Tarifa por dias: domingos gratis."),
    TARIFA_TARDES_REDUCIDA("Tarifa por horas: tardes a 0.03 €/min.");

    private String textoOpcion;

    private MenuCambiarTarifa(final String textoOpcion) {
        this.textoOpcion = textoOpcion;
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
}
