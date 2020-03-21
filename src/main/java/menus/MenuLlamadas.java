package menus;

import acciones.DaAltaLlamada;
import acciones.LlamadasCliente;
import acciones.LlamadasClienteEntreFechas;
import interfaces.Accion;
import principal.BaseDeDatos;
import acciones.ExportarDatosYsalir;
import acciones.SeleccionaOpcionPrincipal;
import acciones.OpcionIncorrectaException;

public enum MenuLlamadas {
    DAR_ALTA_LLAMADA("Dar de alta una llamada.", new DaAltaLlamada()),
    LLAMADAS_CLIENTE("Listar todas las llamadas de un cliente.", new LlamadasCliente()),
    LLAMADAS_ENTRE_FECHAS("Mostrar listado de llamadas de un cliente realizadas entre dos fechas.", new LlamadasClienteEntreFechas()),
    VOLVER_MENU_PRINCIPAL("Volver al menu principal.", new SeleccionaOpcionPrincipal()),
    SALIR_GUARDAR("Salir y guardar datos.", new ExportarDatosYsalir());

    private String textoOpcion;
    private Accion accion;

    private MenuLlamadas(final String textoOpcion, final Accion accion) {
        this.textoOpcion = textoOpcion;
        this.accion = accion;
    }

    public static MenuLlamadas getOpcion(int posicion) {
        return values()[posicion];
    }

    public static String getMenu() {
        StringBuilder sb = new StringBuilder();
        for (MenuLlamadas opcion : MenuLlamadas.values()) {
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
