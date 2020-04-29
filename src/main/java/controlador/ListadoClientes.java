package controlador;

public class ListadoClientes extends Accion {
    public void ejecutaAccion() {
        vista.getVistaClientes().listadoClientes();
    }
}
