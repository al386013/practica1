package modelo.principal;

public class TelfNoExistenteException extends Exception {
    public TelfNoExistenteException() {
        super("Cliente con telefono no existente en la base de modelo.principal.datos.");
    }

    public TelfNoExistenteException(String telf) {
        super("Cliente con telefono " + telf + " no existente en la base de modelo.principal.datos.");
    }
}
