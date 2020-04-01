package acciones;

import principal.BaseDeDatos;

public interface Accion {
    Entrada entrada = new Entrada();

    void ejecutaAccion(BaseDeDatos baseDeDatos) throws OpcionIncorrectaException;
}
