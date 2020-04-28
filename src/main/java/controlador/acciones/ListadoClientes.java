package controlador.acciones;

import modelo.principal.BaseDeDatos;
import vista.InterrogaVista;

public class ListadoClientes implements Accion {
    public void ejecutaAccion(BaseDeDatos baseDeDatos, InterrogaVista vista) {
        vista.getVistaClientes().listadoClientes();
    }
}
