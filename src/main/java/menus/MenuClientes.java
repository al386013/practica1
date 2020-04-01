package menus;

import acciones.*;
import acciones.Accion;
import principal.BaseDeDatos;
import acciones.ExportarDatosYsalir;
import acciones.SeleccionaOpcionPrincipal;
import acciones.OpcionIncorrectaException;

public enum MenuClientes {
    DAR_ALTA_CLIENTE("Dar de alta un nuevo cliente.", new DarAltaCliente()),
    BORRAR_CLIENTE("Borrar un cliente.", new BorrarCliente()),
    CAMBIAR_TARIFA("Contratar tarifa especial para un cliente.", new SeleccionaOpcionCambiarTarifa()),
    DATOS_CLIENTE("Recuperar los datos de un cliente a partir de su NIF.", new DatosCliente()),
    LISTAR_CLIENTES("Recuperar el listado de todos los clientes.", new ListadoClientes()),
    CLIENTES_ENTRE_FECHAS("Mostrar listado de clientes dados de alta entre dos fechas.", new ClientesEntreFechas()),
    VOLVER_MENU_PRINCIPAL("Volver al menu principal.", new SeleccionaOpcionPrincipal()),
    SALIR_GUARDAR("Salir y guardar datos.", new ExportarDatosYsalir());

    private String textoOpcion;
    private Accion accion;

    private MenuClientes(final String textoOpcion, final Accion accion) {
        this.textoOpcion = textoOpcion;
        this.accion = accion;
    }

    public static MenuClientes getOpcion(int posicion) {
        return values()[posicion];
    }

    public static String getMenu() {
        StringBuilder sb = new StringBuilder();
        for (MenuClientes opcion : MenuClientes.values()) {
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
