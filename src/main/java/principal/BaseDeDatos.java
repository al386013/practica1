package principal;

import datos.ComparadorFechaHora;
import datos.clientes.Cliente;
import datos.clientes.Direccion;
import datos.contrato.*;
import datos.contrato.PeriodoFacturacion;
import datos.llamadas.Llamada;
import datos.TieneFecha;
import menus.MenuCambiarTarifa;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Collection;
import java.util.Set;
import java.util.TreeSet;

public class BaseDeDatos implements Serializable {
    //ATRIBUTOS
    private GestorClientes gestorClientes;
    private GestorFacturas gestorFacturas;
    private transient FabricaClientes fabricaClientes;
    private transient FabricaTarifas fabricaTarifas;

    //CONSTRUCTORES
    public BaseDeDatos() {
        super();
        this.gestorClientes = new GestorClientes();
        this.gestorFacturas = new GestorFacturas();
        this.fabricaClientes = new FabricaClientes();
        this.fabricaTarifas = new FabricaTarifas();
    }

    public BaseDeDatos(GestorClientes gestorClientes, GestorFacturas gestorFacturas) {
        super();
        this.gestorClientes = gestorClientes;
        this.gestorFacturas = gestorFacturas;
        this.fabricaClientes = new FabricaClientes();
        this.fabricaTarifas = new FabricaTarifas();
    }

    // METODOS
    //BaseDeDatos llama al metodo correspondiente de gestorClientes, gestorFacturas o ambos; es el intermediario

    public void compruebaNifNoExistente(String nif) throws NifRepetidoException {
        if (existeCliente(nif)) throw new NifRepetidoException(nif);
    }

    public void compruebaTelfNoExistente(String telf) throws TelfRepetidoException {
        if (existeTelf(telf)) throw new TelfRepetidoException(telf);
    }

    public void compruebaNifExistente(String nif) throws NifNoExistenteException {
        if (!existeCliente(nif)) throw new NifNoExistenteException(nif);
    }

    public void compruebaTelfExistente(String telf) throws TelfNoExistenteException {
        if (!existeTelf(telf)) throw new TelfNoExistenteException(telf);
    }

    public void anadirParticular(String nombre, String apellidos, String telf, String nif, Direccion dir, String email) {
        gestorClientes.anadirCliente(fabricaClientes.getParticular(nombre, apellidos, telf, nif, dir, email, fabricaTarifas.getBasica()));
    }

    public void anadirEmpresa(String nombre, String telf, String nif, Direccion dir, String email) {
        gestorClientes.anadirCliente(fabricaClientes.getEmpresa(nombre, telf, nif, dir, email, fabricaTarifas.getBasica()));
    }

    public void borrarCliente(String telf) {
        gestorClientes.borrarCliente(telf);
    }

    public void contratarTarifaEspecial(MenuCambiarTarifa elemento, String nif) {
        Cliente cliente = gestorClientes.devuelveCliente(nif);
        gestorClientes.contratarTarifaEspecial(fabricaTarifas.getOferta(elemento, cliente.getTarifa()), cliente);
    }

    public void darDeAltaLlamada(String telfOrigen, String telfDestino, int duracion) throws IllegalArgumentException {
        if (duracion < 0) throw new IllegalArgumentException("La duracion de una llamada no puede ser negativa" +
                " y la introducida ha sido " + duracion);
        Llamada nuevaLlamada = new Llamada(telfDestino, duracion);
        gestorClientes.darDeAltaLlamada(telfOrigen, nuevaLlamada);
    }

    public String listarDatosCliente(String NIF) {
        return gestorClientes.listarDatosCliente(NIF);
    }

    public void emitirFactura(LocalDate fechaIni, LocalDate fechaFin, String nif) {
        PeriodoFacturacion periodoFact = new PeriodoFacturacion(fechaIni, fechaFin);
        Cliente cliente = gestorClientes.devuelveCliente(nif);
        Factura nuevaFactura = new Factura(periodoFact, nif, cliente.getLlamadas(), cliente.getTarifa());
        gestorFacturas.emitirFactura(nuevaFactura, cliente.getFacturas());
    }

    private Set<Llamada> devolverLlamadas(String nif) {
        Cliente cliente = gestorClientes.devuelveCliente(nif);
        return cliente.getLlamadas();
    }

    private Set<Factura> devolverFacturas(String nif) {
        Cliente cliente = gestorClientes.devuelveCliente(nif);
        return cliente.getFacturas();
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

    //comprueba que FechaIni sea anterior o igual a fechaFin
    public void compruebaFechas(LocalDate fechaIni, LocalDate fechaFin) throws IntervaloFechasIncorrectoException {
        if (fechaIni.isAfter(fechaFin)) throw new IntervaloFechasIncorrectoException();
    }

    //Metodo entreFechas: de un conjunto, devuelve un subconjunto con los elementos de fecha entre fechaIni y fechaFin
    private <T extends TieneFecha> Collection<T> entreFechas(Collection<T> conjunto, LocalDate fechaIni, LocalDate fechaFin) {
        Collection<T> res = new TreeSet<>(new ComparadorFechaHora<>());
        for (T elem : conjunto) {
            LocalDate fecha = elem.getFecha();
            if (fecha.isAfter(fechaIni) && fecha.isBefore(fechaFin) || (fecha.isEqual(fechaIni) || fecha.isEqual(fechaFin)))
                res.add(elem);
        }
        return res;
    }

    //Metodo listar: devuelve una cadena para imprimir los elementos de un conjunto
    private <T extends TieneFecha> String listar(Collection<T> conjunto) {
        StringBuilder sb = new StringBuilder();
        for (T elem : conjunto) {
            sb.append(elem.toString());
            sb.append("\n");
        }
        return sb.toString();
    }

    //Metodo listarClientesEntreFechas: lista los clientes dados de alta entre dos fechas
    public String listarClientesEntreFechas(LocalDate fechaIni, LocalDate fechaFin) {
        Collection<Cliente> conjunto = entreFechas(gestorClientes.clientes.values(), fechaIni, fechaFin);
        return listar(conjunto);
    }

    //Metodo listarLlamadasEntreFechas: lista las llamadas de un cliente realizadas entre dos fechas, dado su telefono
    public String listarLlamadasEntreFechas(String telf, LocalDate fechaIni, LocalDate fechaFin) {
        String nif = gestorClientes.telfNif.get(telf);
        Collection<Llamada> conjunto = entreFechas(devolverLlamadas(nif), fechaIni, fechaFin);
        return listar(conjunto);
    }

    //Metodo listarFacturasEntreFechas: lista las facturas de un cliente emitidas entre dos fechas, dado su nif
    public String listarFacturasEntreFechas(String nif, LocalDate fechaIni, LocalDate fechaFin) {
        Collection<Factura> conjunto = entreFechas(devolverFacturas(nif), fechaIni, fechaFin);
        return listar(conjunto);
    }

    //Metodo listarClientes: lista todos los clientes
    public String listarClientes() {
        return listar(gestorClientes.clientes.values());
    }

    //Metodo listarLlamadasCliente: lista todas las llamadas de un cliente a partir de su telefono
    public String listarLlamadasCliente(String telf) {
        String nif = gestorClientes.telfNif.get(telf);
        return listar(devolverLlamadas(nif));
    }

    //Metodo listarFacturasCliente: recupera todas las facturas de un cliente a partir de su nif
    public String listarFacturasCliente(String nif) {
        return listar(devolverFacturas(nif));
    }
}
