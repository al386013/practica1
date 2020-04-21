package modelo.principal;

public class TelfRepetidoException extends Exception {
    public TelfRepetidoException() {
        super("No se puede insertar un cliente con un telefono ya existente en la base de modelo.principal.datos.");
    }

    public TelfRepetidoException(String telf) {
        super("Cliente con telefono " + telf + " ya existente en la base de modelo.principal.datos.");
    }
}
