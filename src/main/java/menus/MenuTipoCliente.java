package menus;

public enum MenuTipoCliente {
    PARTICULAR("Anadir un particular"),
    EMPRESA("Anadir una empresa");

    private String textoOpcion;

    private MenuTipoCliente(final String textoOpcion) {
        this.textoOpcion = textoOpcion;
    }

    public static MenuTipoCliente getOpcion(int posicion) {
        return values()[posicion];
    }

    public static String getMenu() {
        StringBuilder sb = new StringBuilder();
        for (MenuTipoCliente opcion : MenuTipoCliente.values()) {
            sb.append(opcion.ordinal());
            sb.append(".- ");
            sb.append(opcion.textoOpcion);
            sb.append("\n");
        }
        return sb.toString();
    }
}
