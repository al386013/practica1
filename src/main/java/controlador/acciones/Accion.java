package controlador.acciones;

import modelo.principal.BaseDeDatos;
import vista.EntradaSalida;

public interface Accion {
    EntradaSalida entradaSalida = new EntradaSalida();

    void ejecutaAccion(BaseDeDatos baseDeDatos) throws OpcionIncorrectaException;
}
