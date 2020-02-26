package principal;

import datos.clientes.Cliente;
import datos.clientes.Direccion;
import datos.contrato.Factura;
import datos.contrato.PeriodoFacturacion;
import datos.llamadas.Llamada;

import java.util.Calendar;

public class BaseDeDatos {
    //ATRIBUTOS
    private GestorClientes gestorClientes;
    private GestorFacturas gestorFacturas;

    //CONSTRUCTOR:
    public BaseDeDatos(){
        this.gestorClientes = new GestorClientes();
        this.gestorFacturas = new GestorFacturas();
    }

    //METODOS

    public void anadirParticular(String nombre, String apellidos, String tlf, String NIF, Direccion dir, String email)  {
        gestorClientes.anadirParticular(nombre, apellidos, tlf, NIF, dir, email);
    }

    public void anadirEmpresa(String nombre, String tlf, String NIF, Direccion dir, String email)  {
        gestorClientes.anadirEmpresa(nombre, tlf, NIF, dir, email);
    }

    public void borrarCliente(String NIF) {
        gestorClientes.borrarCliente(NIF);
    }

    public void cambiarTarifa(float tarifa, String NIF) {
        gestorClientes.cambioTarifa(tarifa, NIF);
    }

    public void darDeAltaLlamada(String nif, String telfDestino, String fecha, String hora, int duracion) {
        gestorClientes.darDeAltaLlamada(nif, telfDestino, fecha, hora, duracion);
    }

    public String listarDatosCliente(String NIF) {
        return gestorClientes.listarDatosCliente(NIF);
    }

    public String listarClientes() {
        return gestorClientes.listarClientes();
    }

    public String listarLlamadasCliente() {
        return gestorClientes.listarLlamadasCliente();
    }

    public void emitirFactura(String fechaIni, String fechaFin, String nif) {
        PeriodoFacturacion periodoFact = new PeriodoFacturacion(fechaIni, fechaFin);
        Cliente cliente = gestorClientes.devuelveCliente(nif);
        gestorFacturas.emitirFactura(periodoFact, cliente);
    }

    public void listarDatosFactura(int cod) {
        gestorFacturas.listarDatosFactura();
    }

    public String listarFacturasCliente(String nif) {
        gestorClientes.listarFacturasCliente(nif);
    }
}
