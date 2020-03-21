package principal;

public class NifNoExistenteException extends Exception {
    public NifNoExistenteException() {
        super("Cliente con NIF no existente en la base de datos.");
    }

    public NifNoExistenteException(String nif) {
        super("Cliente con NIF " + nif + " no existente en la base de datos.");
    }
}
