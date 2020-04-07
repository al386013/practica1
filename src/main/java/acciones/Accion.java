package acciones;

import principal.BaseDeDatos;

public interface Accion {
    EntradaSalida entradaSalida = new EntradaSalida();

    void ejecutaAccion(BaseDeDatos baseDeDatos) throws OpcionIncorrectaException;
}
