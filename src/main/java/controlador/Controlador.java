package controlador;

import modelo.principal.NifRepetidoException;
import modelo.principal.TelfRepetidoException;

public interface Controlador {
    void importarDatos();

    void exportarDatosYSalir();

    void anadirCliente() throws NifRepetidoException, TelfRepetidoException;

    void borrarCliente();

    void contratarTarifa();

    void datosCliente();

    void listarClientes();

    void listarCliFechas();

    void darAltaLlamada();

    void llamadasCli();

    void llamadasCliFechas();

    void emitirFactura();

    void datosFactura();

    void listarFacCli();

    void listarFacCliFechas();
}
