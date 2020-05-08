package controlador;

import modelo.principal.*;

public interface Controlador {
    void importarDatos();

    void exportarDatosYSalir();

    void anadirCliente() throws NifRepetidoException, TelfRepetidoException;

    void borrarCliente() throws TelfNoExistenteException;

    void contratarTarifa() throws NifNoExistenteException;

    void datosCliente() throws NifNoExistenteException;

    void listarCliFechas() throws IntervaloFechasIncorrectoException;

    void darAltaLlamada() throws TelfNoExistenteException;

    void llamadasCli() throws TelfNoExistenteException;

    void llamadasCliFechas() throws TelfNoExistenteException, IntervaloFechasIncorrectoException;

    void emitirFactura() throws NifNoExistenteException, IntervaloFechasIncorrectoException;

    void datosFactura();

    void listarFacCli() throws NifNoExistenteException;

    void listarFacCliFechas() throws NifNoExistenteException, IntervaloFechasIncorrectoException ;
}
