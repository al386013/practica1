package menus;

public enum MenuLlamadas {
    DAR_ALTA_LLAMADA("Dar de alta una llamada."),
    LLAMADAS_CLIENTE("Listar todas las llamadas de un cliente."),
    LLAMADAS_ENTRE_FECHAS("Mostrar listado de llamadas de un cliente realizadas entre dos fechas."),
    VOLVER_MENU_PRINCIPAL("Volver al menu principal."),
    SALIR("Salir.");

    private String descripcion;

    private MenuLlamadas(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public static MenuLlamadas getOpcion(int posicion) {
        return values()[posicion];
    }

    public static String getMenu() {
        StringBuilder sb = new StringBuilder();
        for(MenuLlamadas opcion: MenuLlamadas.values()) {
            sb.append(opcion.ordinal());
            sb.append(".- ");
            sb.append(opcion.getDescripcion());
            sb.append("\n");
        }
        return sb.toString();
    }
}
