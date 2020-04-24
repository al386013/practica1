package controlador;

import controlador.acciones.*;
import modelo.CambioModelo;
import vista.InterrogaVista;

public class ImplementacionControlador implements Controlador {
    private InterrogaVista vista;
    private CambioModelo modelo;

    public ImplementacionControlador() {}

    public void setModelo(CambioModelo modelo) {
        this.modelo = modelo;
    }

    public void setVista(InterrogaVista vista) {
        this.vista = vista;
    }

    public InterrogaVista getVista() { return vista; }

    //OJO IMPORTAR Y EXPORTAR NO NECESITAN VISTA, ESTO ESTA FATAL!!!!!!!!!!!!!!!!!!!!!!!!!!!!
    @Override
    public void importarDatos() {
        new ImportarDatos().cargarDatos(modelo);
        //new ImportarDatos().ejecutaAccion(modelo.getBaseDeDatos(), vista);
    }

    @Override
    public void exportarDatosYSalir() {
        new ExportarDatosYsalir().ejecutaAccion(modelo.getBaseDeDatos(), vista);
    }

    @Override
    public void anadirCliente() {
        new DarAltaCliente().ejecutaAccion(modelo.getBaseDeDatos(), vista);
    }

    @Override
    public void borrarCliente() {
        new BorrarCliente().ejecutaAccion(modelo.getBaseDeDatos(), vista);
    }

    @Override
    public void contratarTarifa() {
        new ContratarTarifa().ejecutaAccion(modelo.getBaseDeDatos(), vista);
    }

    @Override
    public void datosCliente() {
        new DatosCliente().ejecutaAccion(modelo.getBaseDeDatos(), vista);
    }

    @Override
    public void listarClientes() {
        new ListadoClientes().ejecutaAccion(modelo.getBaseDeDatos(), vista);
    }

    @Override
    public void listarCliFechas() {
        new ClientesEntreFechas().ejecutaAccion(modelo.getBaseDeDatos(), vista);
    }

    @Override
    public void darAltaLlamada() {
        new DaAltaLlamada().ejecutaAccion(modelo.getBaseDeDatos(), vista);
    }

    @Override
    public void llamadasCli() {
        new LlamadasCliente().ejecutaAccion(modelo.getBaseDeDatos(), vista);
    }

    @Override
    public void llamadasCliFechas() {
        new LlamadasClienteEntreFechas().ejecutaAccion(modelo.getBaseDeDatos(), vista);
    }

    @Override
    public void emitirFactura() {
        new EmiteFactura().ejecutaAccion(modelo.getBaseDeDatos(), vista);
    }

    @Override
    public void datosFactura() {
        new DatosFactura().ejecutaAccion(modelo.getBaseDeDatos(), vista);
    }

    @Override
    public void listarFacCli() {
        new FacturasCliente().ejecutaAccion(modelo.getBaseDeDatos(), vista);
    }

    @Override
    public void listarFacCliFechas() {
        new FacturasCliEntreFechas().ejecutaAccion(modelo.getBaseDeDatos(), vista);
    }
}
