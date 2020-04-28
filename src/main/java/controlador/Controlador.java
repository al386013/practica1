package controlador;

import modelo.principal.*;

import java.time.format.DateTimeParseException;

public interface Controlador {
    void importarDatos();

    void exportarDatosYSalir();

    void anadirCliente() throws NifRepetidoException, TelfRepetidoException;

    void borrarCliente() throws TelfNoExistenteException;

    void contratarTarifa() throws NifNoExistenteException;

    void datosCliente() throws NifNoExistenteException;

    void listarClientes();

    void listarCliFechas() throws IntervaloFechasIncorrectoException;

    void darAltaLlamada() throws TelfNoExistenteException, IllegalArgumentException;

    void llamadasCli() throws TelfNoExistenteException;

    void llamadasCliFechas() throws TelfNoExistenteException, IntervaloFechasIncorrectoException, DateTimeParseException;

    void emitirFactura() throws NifNoExistenteException, IntervaloFechasIncorrectoException;

    void datosFactura() throws IllegalArgumentException;

    void listarFacCli() throws NifNoExistenteException;

    void listarFacCliFechas() throws NifNoExistenteException, IntervaloFechasIncorrectoException ;
}
