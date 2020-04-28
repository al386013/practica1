package controlador;

import controlador.acciones.*;
import modelo.CambioModelo;
import modelo.principal.*;
import vista.InterrogaVista;

import java.time.format.DateTimeParseException;

public class ImplementacionControlador implements Controlador {
    private InterrogaVista vista;
    private CambioModelo modelo;

    public ImplementacionControlador() {
        super();
    }

    public void setModelo(CambioModelo modelo) {
        this.modelo = modelo;
    }

    public void setVista(InterrogaVista vista) {
        this.vista = vista;
    }

    public InterrogaVista getVista() {
        return vista;
    }

    @Override
    public void importarDatos() {
        new ImportarDatos().cargarDatos(vista, modelo);
    }

    @Override
    public void exportarDatosYSalir() {
        new ExportarDatosYsalir().ejecutaAccion(modelo.getBaseDeDatos(), vista);
    }

    @Override
    public void anadirCliente() throws NifRepetidoException, TelfRepetidoException {
        new DarAltaCliente().ejecutaAccion(modelo.getBaseDeDatos(), vista);
        vista.accionCorrecta("Cliente creado correctamente.");
    }

    @Override
    public void borrarCliente() throws TelfNoExistenteException {
        //new BorrarCliente().ejecutaAccion(modelo.getBaseDeDatos(), vista);
        new BorrarCliente().ejecutaAccion(modelo.getBaseDeDatos(), vista);
        vista.accionCorrecta("Cliente borrado con éxito.");
    }

    @Override
    public void contratarTarifa() throws NifNoExistenteException {
        new ContratarTarifa().ejecutaAccion(modelo.getBaseDeDatos(), vista);
        vista.accionCorrecta("Tarifa especial contratada.");
    }

    @Override
    public void datosCliente()throws NifNoExistenteException {
        new DatosCliente().ejecutaAccion(modelo.getBaseDeDatos(), vista);
    }

    @Override
    public void listarClientes() {
        new ListadoClientes().ejecutaAccion(modelo.getBaseDeDatos(), vista);
    }

    @Override
    public void listarCliFechas() throws IntervaloFechasIncorrectoException {
        new ClientesEntreFechas().ejecutaAccion(modelo.getBaseDeDatos(), vista);
    }

    @Override
    public void darAltaLlamada() throws TelfNoExistenteException, IllegalArgumentException {
        new DaAltaLlamada().ejecutaAccion(modelo.getBaseDeDatos(), vista);
        vista.accionCorrecta("Llamada realizada con éxito.");
    }

    @Override
    public void llamadasCli()throws TelfNoExistenteException {
        new LlamadasCliente().ejecutaAccion(modelo.getBaseDeDatos(), vista);
    }

    @Override
    public void llamadasCliFechas() throws TelfNoExistenteException, IntervaloFechasIncorrectoException, DateTimeParseException {
        new LlamadasClienteEntreFechas().ejecutaAccion(modelo.getBaseDeDatos(), vista);
    }

    @Override
    public void emitirFactura() throws NifNoExistenteException, IntervaloFechasIncorrectoException {
        new EmiteFactura().ejecutaAccion(modelo.getBaseDeDatos(), vista);
        vista.accionCorrecta("Factura del cliente emitida con éxito.");
    }

    @Override
    public void datosFactura()throws IllegalArgumentException {
        new DatosFactura().ejecutaAccion(modelo.getBaseDeDatos(), vista);
    }

    @Override
    public void listarFacCli()throws NifNoExistenteException {
        new FacturasCliente().ejecutaAccion(modelo.getBaseDeDatos(), vista);
    }

    @Override
    public void listarFacCliFechas() throws NifNoExistenteException, IntervaloFechasIncorrectoException {
        new FacturasCliEntreFechas().ejecutaAccion(modelo.getBaseDeDatos(), vista);
    }
}
