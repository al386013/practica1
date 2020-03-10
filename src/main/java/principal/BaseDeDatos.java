package principal;

import datos.clientes.Cliente;
import datos.clientes.Direccion;
import datos.clientes.Empresa;
import datos.clientes.Particular;
import datos.contrato.Factura;
import datos.contrato.PeriodoFacturacion;
import datos.contrato.Tarifa;
import datos.llamadas.Llamada;
import interfaces.TieneFecha;
import principal.excepciones.DuracionNegativaException;
import principal.excepciones.IntervaloFechasIncorrectoException;
import principal.excepciones.NifRepetidoException;
import principal.excepciones.TelfRepetidoException;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class BaseDeDatos implements Serializable {
    //ATRIBUTOS
    private GestorClientes gestorClientes;
    private GestorFacturas gestorFacturas;

    //CONSTRUCTOR:
    public BaseDeDatos(GestorClientes gestorClientes, GestorFacturas gestorFacturas){
        this.gestorClientes = gestorClientes;
        this.gestorFacturas = gestorFacturas;
    }

    // METODOS
    //BaseDeDatos llama al metodo correspondiente de gestorClientes, gestorFacturas o ambos; es el intermediario

    public void anadirParticular(String nombre, String apellidos, String telf, String nif, Direccion dir, String email)
            throws NifRepetidoException, TelfRepetidoException {
        if (existeCliente(nif)) throw new NifRepetidoException();
        if (existeTelf(telf)) throw new TelfRepetidoException();
        Cliente nuevoParticular = new Particular(nombre, apellidos, telf, nif,dir, email, new Tarifa());
        gestorClientes.anadirCliente(nuevoParticular);
    }

    public void anadirEmpresa(String nombre, String telf, String nif, Direccion dir, String email)
            throws NifRepetidoException, TelfRepetidoException {
        if (existeCliente(nif)) throw new NifRepetidoException();
        if (existeTelf(telf)) throw new TelfRepetidoException();
        Cliente nuevaEmpresa = new Empresa(nombre,telf, nif, dir, email, new Tarifa());
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

    public void emitirFactura(LocalDate fechaIni, LocalDate fechaFin, String nif) throws IntervaloFechasIncorrectoException {
       if(fechaIni.isAfter(fechaFin)) throw new IntervaloFechasIncorrectoException();
        PeriodoFacturacion periodoFact = new PeriodoFacturacion(fechaIni, fechaFin);
        Tarifa tarifa = new Tarifa();
        Factura nuevaFactura = new Factura(periodoFact,nif,devolverLlamadas(nif), tarifa);
        gestorFacturas.emitirFactura(nuevaFactura, devolverFacturas(nif));
    }
    private Set<Llamada> devolverLlamadas(String nif){
        Cliente c = gestorClientes.devuelveCliente(nif);
        return c.getLlamadas();
    }
    private Set<Factura> devolverFacturas(String nif){
        Cliente c = gestorClientes.devuelveCliente(nif);
        return c.getFacturas();
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

    private < T extends TieneFecha> Collection< T > entreFechas(Collection< T > conjunto, LocalDate fechaIni, LocalDate fechaFin)
            throws IntervaloFechasIncorrectoException {
        if(fechaIni.isAfter(fechaFin)) throw new IntervaloFechasIncorrectoException();
        Collection<T> res = new HashSet<>();
        for (T elem : conjunto) {
            LocalDate fecha = elem.getFecha();
            if (fecha.isAfter(fechaIni) && fecha.isBefore(fechaFin) || (fecha.isEqual(fechaIni) || fecha.isEqual(fechaFin)))
                res.add(elem);
        }
        return res;
    }

    //Metodo listar: devuelve una cadena para imprimir los elementos de un conjunto
    public < T extends TieneFecha> String listar(Collection< T > conjunto) {
        StringBuilder sb = new StringBuilder();
        for (T elem : conjunto) {
            sb.append(elem.toString());
            sb.append("\n");
        }
        return sb.toString();
    }

    public String listarClientesEntreFechas(LocalDate fechaIni, LocalDate fechaFin) throws IntervaloFechasIncorrectoException {
        Collection<Cliente> conjunto = entreFechas(gestorClientes.clientes.values(), fechaIni, fechaFin);
        return listar(conjunto);
    }

    public String listarLlamadasEntreFechas(String telf, LocalDate fechaIni, LocalDate fechaFin) throws IntervaloFechasIncorrectoException {
        Collection<Llamada> conjunto = entreFechas(gestorClientes.clientes.get(gestorClientes.telfNif.get(telf)).getLlamadas(), fechaIni, fechaFin);
        return listar(conjunto);
    }

    public String listarFacturasEntreFechas(String nif, LocalDate fechaIni, LocalDate fechaFin) throws IntervaloFechasIncorrectoException {
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
