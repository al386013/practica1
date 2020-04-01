package menus;

import acciones.Accion;
import principal.BaseDeDatos;
import acciones.*;

public enum MenuPrincipal {
    CARGAR_DATOS("Importar los datos.", new ImportarDatos()),
    CLIENTES("Operacion clientes.", new SeleccionaOpcionClientes()),
    LLAMADAS("Operacion llamadas.", new SeleccionaOpcionLlamada()),
    FACTURAS("Operacion facturas.", new SeleccionaOpcionFacturas()),
    SALIR_GUARDAR("Salir y guardar datos.", new ExportarDatosYsalir());

    private String textoOpcion;
    private Accion accion;

    private MenuPrincipal(final String textoOpcion, final Accion accion) {
        this.textoOpcion = textoOpcion;
        this.accion = accion;
    }

    public static MenuPrincipal getOpcion(int posicion) {
        return values()[posicion];
    }

    public static String getMenu() {
        StringBuilder sb = new StringBuilder();
        for (MenuPrincipal opcion : MenuPrincipal.values()) {
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