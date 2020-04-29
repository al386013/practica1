package modelo.principal;

import modelo.datos.TieneFecha;
import modelo.datos.clientes.Cliente;
import modelo.datos.clientes.Direccion;
import modelo.datos.contrato.Factura;
import modelo.datos.contrato.PeriodoFacturacion;
import modelo.datos.llamadas.Llamada;
import vista.InformaVista;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class BaseDeDatos implements Serializable {
    private GestorClientes gestorClientes;
    private GestorFacturas gestorFacturas;
    private InformaVista vista;
    private static FabricaClientes fabricaClientes;
    private static FabricaTarifas fabricaTarifas;

    public BaseDeDatos() {
        super();
        this.gestorClientes = new GestorClientes();
        this.gestorFacturas = new GestorFacturas();
        fabricaClientes = new FabricaClientes();
        fabricaTarifas = new FabricaTarifas();
    }

    public BaseDeDatos(GestorClientes gestorClientes, GestorFacturas gestorFacturas) {
        super();
        this.gestorClientes = gestorClientes;
        this.gestorFacturas = gestorFacturas;
        fabricaClientes = new FabricaClientes();
        fabricaTarifas = new FabricaTarifas();
    }

    public void setVista(InformaVista vista) {
        this.vista = vista;
    }

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
        vista.accionCorrecta("Particular guardado correctamente.");
    }

    public void anadirEmpresa(String nombre, String telf, String nif, Direccion dir, String email) {
        gestorClientes.anadirCliente(fabricaClientes.getEmpresa(nombre, telf, nif, dir, email, fabricaTarifas.getBasica()));
        vista.accionCorrecta("Empresa guardada correctamente.");
    }

    public void borrarCliente(String telf) {
        gestorClientes.borrarCliente(telf);
        vista.accionCorrecta("Cliente borrado con éxito.");
    }

    public void contratarTarifaEspecial(String tipoTarifa, String nif) {
        Cliente cliente = gestorClientes.devuelveCliente(nif);
        gestorClientes.contratarTarifaEspecial(fabricaTarifas.getOferta(tipoTarifa, cliente.getTarifa()), cliente);
        vista.accionCorrecta("Tarifa especial contratada.");
    }

    public void darDeAltaLlamada(String telfOrigen, String telfDestino, int duracion) {
        Llamada nuevaLlamada = new Llamada( telfOrigen,telfDestino, duracion);
        gestorClientes.darDeAltaLlamada(telfOrigen, nuevaLlamada);
        vista.accionCorrecta("Llamada realizada con éxito.");
    }

    public String listarDatosCliente(String NIF) {
        return gestorClientes.listarDatosCliente(NIF);
    }

    public void emitirFactura(LocalDate fechaIni, LocalDate fechaFin, String nif) {
        PeriodoFacturacion periodoFact = new PeriodoFacturacion(fechaIni, fechaFin);
        Cliente cliente = gestorClientes.devuelveCliente(nif);
        Factura nuevaFactura = new Factura(periodoFact, nif, cliente.getLlamadas(), cliente.getTarifa());
        gestorFacturas.emitirFactura(nuevaFactura, cliente.getFacturas());
        vista.accionCorrecta("Factura del cliente emitida con éxito.");
    }

    public String convertirTelfNif(String telf) {
        return gestorClientes.telfNif.get(telf);
    }

    //TODO: Estos tres métodos devolverXXX son usados en la vista para generar datos en las tablas
    public Collection<Cliente> devolverClientes() {
        return gestorClientes.clientes.values();
    }

    public Set<Llamada> devolverLlamadas(String telf) {
        String nif = convertirTelfNif(telf);
        Cliente cliente = gestorClientes.devuelveCliente(nif);
        return cliente.getLlamadas();
    }

    public Set<Factura> devolverFacturas(String nif) {
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
    public <T extends TieneFecha> Collection<T> entreFechas(Collection<T> conjunto, LocalDate fechaIni, LocalDate fechaFin) {
        Collection<T> res = new HashSet<>();
        for (T elem : conjunto) {
            LocalDate fecha = elem.getFecha();
            if (fecha.isAfter(fechaIni) && fecha.isBefore(fechaFin) || (fecha.isEqual(fechaIni) || fecha.isEqual(fechaFin)))
                res.add(elem);
        }
        return res;
    }

    //todo: Desde este metodo solo se usan en los test...

    //Metodo listar: devuelve una cadena para imprimir los elementos de un conjunto
    private <T extends TieneFecha> String listar(Collection<T> conjunto) {
        String string = "<html>";
        for (T elem : conjunto) string += elem.toString() + "<br/>";
        return string + "</html>";
    }

    //Metodo listarClientesEntreFechas: lista los clientes dados de alta entre dos fechas
    public String listarClientesEntreFechas(LocalDate fechaIni, LocalDate fechaFin) {
        Collection<Cliente> conjunto = entreFechas(gestorClientes.clientes.values(), fechaIni, fechaFin);
        return listar(conjunto);
    }

    //Metodo listarLlamadasEntreFechas: lista las llamadas de un cliente realizadas entre dos fechas, dado su telefono
    public String listarLlamadasEntreFechas(String telf, LocalDate fechaIni, LocalDate fechaFin) {
        Collection<Llamada> conjunto = entreFechas(devolverLlamadas(telf), fechaIni, fechaFin);
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
        return listar(devolverLlamadas(telf));
    }

    //Metodo listarFacturasCliente: recupera todas las facturas de un cliente a partir de su nif
    public String listarFacturasCliente(String nif) {
        return listar(devolverFacturas(nif));
    }
}
