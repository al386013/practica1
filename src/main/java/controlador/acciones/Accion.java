package controlador.acciones;

import modelo.principal.BaseDeDatos;
import vista.EntradaSalida;
import vista.InterrogaVista;

public interface Accion {
    EntradaSalida entradaSalida = new EntradaSalida();

    void ejecutaAccion(BaseDeDatos baseDeDatos, InterrogaVista interrogaVista);
}
