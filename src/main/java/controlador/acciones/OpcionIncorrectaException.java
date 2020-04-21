package controlador.acciones;

public class OpcionIncorrectaException extends Exception {
    public OpcionIncorrectaException() {
        super("Opcion incorrecta.");
    }

    public OpcionIncorrectaException(int max) {
        super("La opcion introducida debe ser un numero entre 0 y " + max);
    }
}
