package menus;

import java.io.Serializable;

public enum MenuClientes implements Serializable {
    DAR_ALTA_CLIENTE("Dar de alta un nuevo cliente."),
    BORRAR_CLIENTE("Borrar un cliente."),
    CAMBIAR_TARIFA("Cambiar la tarifa de un cliente."),
    DATOS_CLIENTE("Recuperar los datos de un cliente a partir de su NIF."),
    LISTAR_CLIENTES("Recuperar el listado de todos los clientes."),
    CLIENTES_ENTRE_FECHAS("Mostrar listado de clientes dados de alta entre dos fechas."),
    VOLVER_MENU_PRINCIPAL("Volver al menu principal."),
    SALIR_GUARDAR("Salir y guardar datos.");

    private String descripcion;

    private MenuClientes(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public static MenuClientes getOpcion(int posicion) {
        return values()[posicion];
    }

    public static String getMenu() {
        StringBuilder sb = new StringBuilder();
        for(MenuClientes opcion: MenuClientes.values()) {
            sb.append(opcion.ordinal());
            sb.append(".- ");
            sb.append(opcion.getDescripcion());
            sb.append("\n");
        }
        return sb.toString();
    }
}
