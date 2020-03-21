package interfaces;

import principal.BaseDeDatos;
import acciones.OpcionIncorrectaException;

import java.util.Scanner;

public interface Accion {
    Scanner sc = new Scanner(System.in);
    void ejecutaAccion (BaseDeDatos baseDeDatos) throws OpcionIncorrectaException;
}
