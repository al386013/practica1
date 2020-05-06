package controlador;

import modelo.CambioModelo;
import modelo.principal.*;
import vista.InterrogaVista;

public class ImplementacionControlador implements Controlador {
    private InterrogaVista vista;
    private CambioModelo modelo;

    public ImplementacionControlador() {
        super();
    }

    public void setModelo(CambioModelo modelo) {
        this.modelo = modelo;
        Accion.baseDeDatos = modelo.getBaseDeDatos();
    }

    public void setVista(InterrogaVista vista) {
        this.vista = vista;
        Accion.vista = vista;
    }

    public InterrogaVista getVista() {
        return vista;
    }

    @Override
    public void importarDatos() {
        new ImportarDatos().cargarDatos(modelo);
    }

    @Override
    public void exportarDatosYSalir() {
        new ExportarDatosYsalir().guardarDatos(modelo.getBaseDeDatos());
    }

    @Override
    public void anadirCliente() throws NifRepetidoException, TelfRepetidoException {
        new DarAltaCliente().ejecutaAccion();
    }

    @Override
    public void borrarCliente() throws TelfNoExistenteException {
        new BorrarCliente().ejecutaAccion();
    }

    @Override
    public void contratarTarifa() throws NifNoExistenteException {
        new ContratarTarifa().ejecutaAccion();
    }

    @Override
    public void datosCliente() throws NifNoExistenteException {
        new DatosCliente().ejecutaAccion();
    }

    @Override
    public void listarClientes() {
        new ListadoClientes().ejecutaAccion();
    }

    @Override
    public void listarCliFechas() throws IntervaloFechasIncorrectoException {
        new ClientesEntreFechas().ejecutaAccion();
    }

    @Override
    public void darAltaLlamada() throws TelfNoExistenteException {
        new DaAltaLlamada().ejecutaAccion();
    }

    @Override
    public void llamadasCli() throws TelfNoExistenteException {
        new LlamadasCliente().ejecutaAccion();
    }

    @Override
    public void llamadasCliFechas() throws TelfNoExistenteException, IntervaloFechasIncorrectoException {
        new LlamadasClienteEntreFechas().ejecutaAccion();
    }

    @Override
    public void emitirFactura() throws NifNoExistenteException, IntervaloFechasIncorrectoException {
        new EmiteFactura().ejecutaAccion();
    }

    @Override
    public void datosFactura() {
        new DatosFactura().ejecutaAccion();
    }

    @Override
    public void listarFacCli() throws NifNoExistenteException {
        new FacturasCliente().ejecutaAccion();
    }

    @Override
    public void listarFacCliFechas() throws NifNoExistenteException, IntervaloFechasIncorrectoException {
        new FacturasCliEntreFechas().ejecutaAccion();
    }
}
