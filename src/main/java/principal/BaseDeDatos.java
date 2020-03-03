package principal;

import datos.clientes.Cliente;
import datos.clientes.Direccion;
import datos.clientes.Empresa;
import datos.clientes.Particular;
import datos.contrato.Factura;
import datos.contrato.PeriodoFacturacion;
import datos.llamadas.Llamada;
import excepciones.DuracionNegativaException;
import excepciones.NifRepetidoException;
import interfaces.tieneFecha;

import java.time.LocalDate;
import java.util.Collection;
import java.util.HashSet;

public class BaseDeDatos {
    //ATRIBUTOS
    private GestorClientes gestorClientes;
    private GestorFacturas gestorFacturas;

    //CONSTRUCTOR:
    public BaseDeDatos(){
        this.gestorClientes = new GestorClientes();
        this.gestorFacturas = new GestorFacturas();
    }

    // METODOS
    //BaseDeDatos llama al metodo correspondiente de gestorClientes, gestorFacturas o ambos; es el intermediario

    public void anadirParticular(String nombre, String apellidos, String tlf, String NIF, Direccion dir, String email) throws NifRepetidoException{
        if (existeCliente(NIF)) throw new NifRepetidoException();
        Cliente nuevoParticular = new Particular(nombre, apellidos, tlf, NIF,dir, email);
        gestorClientes.anadirCliente(nuevoParticular);
    }

    public void anadirEmpresa(String nombre, String tlf, String NIF, Direccion dir, String email) throws NifRepetidoException {
        if (existeCliente(NIF)) throw new NifRepetidoException();
        Cliente nuevaEmpresa = new Empresa(nombre,tlf, NIF, dir, email);
        gestorClientes.anadirCliente(nuevaEmpresa);
    }

    public void borrarCliente(String telf) {
        gestorClientes.borrarCliente(telf);
    }

    public Cliente devuelveCliente(String nif) { return gestorClientes.devuelveCliente(nif); }

    public void cambiarTarifa(float tarifa, String NIF) {
        gestorClientes.cambioTarifa(tarifa, NIF);
    }

    public void darDeAltaLlamada(String telfOrigen, String telfDestino, int duracion) throws DuracionNegativaException {
        if(duracion < 0) throw new DuracionNegativaException();
        Llamada nuevaLlamada = new Llamada(telfDestino,duracion);
        gestorClientes.darDeAltaLlamada(telfOrigen, nuevaLlamada);
    }

    public String listarDatosCliente(String NIF) {
        return gestorClientes.listarDatosCliente(NIF);
    }

    public void emitirFactura(LocalDate fechaIni, LocalDate fechaFin, String nif) {
        PeriodoFacturacion periodoFact = new PeriodoFacturacion(fechaIni, fechaFin);
        Cliente cliente = gestorClientes.devuelveCliente(nif);
        Factura nuevaFactura = new Factura(periodoFact,cliente);
        gestorFacturas.emitirFactura(nuevaFactura, cliente);
    }

    public String listarDatosFactura(int cod) {
        return gestorFacturas.listarDatosFactura(cod);
    }

    public boolean existeCliente(String nif) {
        return gestorClientes.existeCliente(nif);
    }

    public boolean existeTelf(String telf) {
        return gestorClientes.existeTelf(telf);
    }

    private < T extends tieneFecha> Collection< T > entreFechas(Collection< T > conjunto, LocalDate fechaIni, LocalDate fechaFin) {
        Collection<T> res = new HashSet<>();
        for (T elem : conjunto) {
            LocalDate fecha = elem.getFecha();
            if (fecha.isAfter(fechaIni) && fecha.isBefore(fechaFin))
                res.add(elem);
        }
        return res;
    }

    //Metodo listar: devuelve una cadena para imprimir los elementos de un conjunto
    public < T extends tieneFecha> String listar(Collection< T > conjunto) {
        StringBuilder sb = new StringBuilder();
        for (T elem : conjunto) {
            sb.append(elem.toString());
            sb.append("\n");
        }
        return sb.toString();
    }

    public String listarClientesEntreFechas(LocalDate fechaIni, LocalDate fechaFin) {
        Collection<Cliente> conjunto = entreFechas(gestorClientes.clientes.values(), fechaIni, fechaFin);
        return listar(conjunto);
    }

    public String listarLlamadasEntreFechas(String telf, LocalDate fechaIni, LocalDate fechaFin) {
        Collection<Llamada> conjunto = entreFechas(gestorClientes.clientes.get(gestorClientes.telfNif.get(telf)).getLlamadas(), fechaIni, fechaFin);
        return listar(conjunto);
    }

    public String listarFacturasEntreFechas(String nif, LocalDate fechaIni, LocalDate fechaFin) {
        Collection<Factura> conjunto = entreFechas(gestorClientes.clientes.get(nif).getFacturas(), fechaIni, fechaFin);
        return listar(conjunto);
    }

    //Metodo listarClientes, lista todos los clientes
    public String listarClientes() {
        return listar(gestorClientes.clientes.values());
    }

    //Metodo listarLlamadasCliente: lista todas las llamadas de un cliente a partir de su telefono
    public String listarLlamadasCliente(String telf) {
        return listar(gestorClientes.clientes.get(gestorClientes.telfNif.get(telf)).getLlamadas());
    }

    //Metodo listarFacturasCliente: recupera todas las facturas de un cliente a partir de su nif
    public String listarFacturasCliente(String nif) {
        return listar(gestorClientes.clientes.get(nif).getFacturas());
    }
}
