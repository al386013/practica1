package principal;

import datos.clientes.Cliente;
import datos.clientes.Direccion;
import datos.contrato.PeriodoFacturacion;

import java.time.LocalDate;
import java.time.LocalTime;

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

    public void anadirParticular(String nombre, String apellidos, String tlf, String NIF, Direccion dir, String email) {
        gestorClientes.anadirParticular(nombre, apellidos, tlf, NIF, dir, email);
    }

    public void anadirEmpresa(String nombre, String tlf, String NIF, Direccion dir, String email) {
        gestorClientes.anadirEmpresa(nombre, tlf, NIF, dir, email);
    }

    public void borrarCliente(String NIF) {
        gestorClientes.borrarCliente(NIF);
    }

    public void cambiarTarifa(float tarifa, String NIF) {
        gestorClientes.cambioTarifa(tarifa, NIF);
    }

    public void darDeAltaLlamada(String telfOrigen, String telfDestino, LocalDate fecha, LocalTime hora, int duracion) {
        gestorClientes.darDeAltaLlamada(telfOrigen, telfDestino, fecha, hora, duracion);
    }

    public String listarDatosCliente(String NIF) {
        return gestorClientes.listarDatosCliente(NIF);
    }

    public String listarClientes() {
        return gestorClientes.listarClientes();
    }

    public String listarLlamadasCliente(String nif) {
        return gestorClientes.listarLlamadasCliente(nif);
    }

    public void emitirFactura(LocalDate fechaIni, LocalDate fechaFin, String nif) {
        PeriodoFacturacion periodoFact = new PeriodoFacturacion(fechaIni, fechaFin);
        Cliente cliente = gestorClientes.devuelveCliente(nif);
        gestorFacturas.emitirFactura(periodoFact, cliente);
    }

    public String listarDatosFactura(int cod) {
        return gestorFacturas.listarDatosFactura(cod);
    }

    public String listarFacturasCliente(String nif) {
        return gestorClientes.listarFacturasCliente(nif);
    }

    public boolean existeCliente(String nif) {
        return gestorClientes.existeCliente(nif);
    }

    public boolean existeTelf(String telf) {
        return gestorClientes.existeCliente(telf);
    }
}
