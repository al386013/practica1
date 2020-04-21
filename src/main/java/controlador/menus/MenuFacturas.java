package controlador.menus;

import controlador.acciones.DatosFactura;
import controlador.acciones.EmiteFactura;
import controlador.acciones.FacturasCliEntreFechas;
import controlador.acciones.FacturasCliente;
import controlador.acciones.Accion;
import modelo.principal.BaseDeDatos;
import controlador.acciones.ExportarDatosYsalir;
import controlador.acciones.SeleccionaOpcionPrincipal;
import controlador.acciones.OpcionIncorrectaException;

public enum MenuFacturas {
    EMITIR_FACTURA("Emitir una factura para un cliente.", new EmiteFactura()),
    DATOS_FACTURA("Recuperar los modelo.principal.datos de una factura a partir de su codigo.", new DatosFactura()),
    FACTURAS_CLIENTE("Recuperar todas las facturas de un cliente.", new FacturasCliente()),
    FACTURAS_ENTRE_FECHAS("Mostrar listado de facturas de un cliente emitidas entre dos fechas", new FacturasCliEntreFechas()),
    VOLVER_MENU_PRINCIPAL("Volver al menu modelo.principal.", new SeleccionaOpcionPrincipal()),
    SALIR_GUARDAR("Salir y guardar modelo.principal.datos.", new ExportarDatosYsalir());

    private String textoOpcion;
    private Accion accion;

    private MenuFacturas(final String textoOpcion, final Accion accion) {
        this.textoOpcion = textoOpcion;
        this.accion = accion;
    }

    public static MenuFacturas getOpcion(int posicion) {
        return values()[posicion];
    }

    public static String getMenu() {
        StringBuilder sb = new StringBuilder();
        for (MenuFacturas opcion : MenuFacturas.values()) {
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
