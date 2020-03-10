package menus;

import interfaces.DescripcionMenu;

import java.io.Serializable;

public enum MenuFacturas implements DescripcionMenu {
    EMITIR_FACTURA("Emitir una factura para un cliente."),
    DATOS_FACTURA("Recuperar los datos de una factura a partir de su codigo."),
    FACTURAS_CLIENTE("Recuperar todas las facturas de un cliente."),
    FACTURAS_ENTRE_FECHAS("Mostrar listado de facturas de un cliente emitidas entre dos fechas"),
    VOLVER_MENU_PRINCIPAL("Volver al menu principal."),
    SALIR_GUARDAR("Salir y guardar datos.");

    private String descripcion;

    private MenuFacturas(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public static MenuFacturas getOpcion(int posicion) {
        return values()[posicion];
    }

    public static String getMenu() {
        StringBuilder sb = new StringBuilder();
        for(MenuFacturas opcion: MenuFacturas.values()) {
            sb.append(opcion.ordinal());
            sb.append(".- ");
            sb.append(opcion.getDescripcion());
            sb.append("\n");
        }
        return sb.toString();
    }
}
