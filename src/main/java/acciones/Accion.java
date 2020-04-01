package acciones;

import principal.BaseDeDatos;

import java.util.Scanner;

public interface Accion {
    Entrada entrada = new Entrada();
    void ejecutaAccion (BaseDeDatos baseDeDatos) throws OpcionIncorrectaException;
}
