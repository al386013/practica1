package modelo.datos.clientes;

import modelo.datos.contrato.Factura;
import modelo.datos.contrato.tarifas.Tarifa;
import modelo.datos.ComparadorFechaHora;
import modelo.datos.TieneFecha;
import modelo.datos.llamadas.Llamada;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.*;
import static java.lang.String.format;

public abstract class Cliente implements TieneFecha, Serializable {
    private String nombre;
    private String NIF;
    private String telf;
    private Direccion direccion;
    private String email;
    private LocalDateTime fechaDeAlta;
    private Tarifa tarifa;
    private Set<Factura> facturas; //conjunto con todas las facturas del cliente
    private Set<Llamada> llamadas; //conjunto con todas las llamadas del cliente

    //CONSSTRUCTOR POR DEFECTO
    public Cliente() {
        super();
        this.nombre = "";
        this.telf = "";
        this.NIF = "";
        this.direccion = null;
        this.email = "";
        this.fechaDeAlta = null;
        this.tarifa = null;
        ComparadorFechaHora<TieneFecha> comparador = new ComparadorFechaHora<>();
        this.facturas = new TreeSet<>(comparador);
        this.llamadas = new TreeSet<>(comparador);
    }

    public Cliente(final String nombre, final String telefono, final String NIF, final Direccion direccion, final String email, final Tarifa tarifa) {
        super();
        this.nombre = nombre;
        this.telf = telefono;
        this.NIF = NIF;
        this.direccion = direccion;
        this.email = email;
        this.fechaDeAlta = LocalDateTime.now();
        this.tarifa = tarifa;
        ComparadorFechaHora<TieneFecha> comparador = new ComparadorFechaHora<>();
        this.facturas = new TreeSet<>(comparador);
        this.llamadas = new TreeSet<>(comparador);
    }

    public String getNombre() {
        return nombre;
    }

    public String getTelf() {
        return telf;
    }

    public String getNIF() {
        return NIF;
    }

    public Direccion getDireccion() {
        return direccion;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public LocalDate getFecha() {
        return fechaDeAlta.toLocalDate();
    }

    @Override
    public LocalTime getHora() {
        return fechaDeAlta.toLocalTime();
    }

    public Tarifa getTarifa() {
        return tarifa;
    }

    public Set<Llamada> getLlamadas() {
        return llamadas;
    }

    public Set<Factura> getFacturas() {
        return facturas;
    }

    public void setTarifa(Tarifa tarifa) {
        this.tarifa = tarifa;
    }

    public void anadirLlamada(Llamada llamada) {
        llamadas.add(llamada);
    }

    @Override
    public String toString() {
        String string = nombre + "<br/>";
        string += "<ul><li> NIF: " + NIF + "</li>";
        string += "<li> Telefono: " + telf + "</li>";
        string += "<li> Direccion: " + direccion + "</li>";
        string += "<li> Email: " + email + "</li>";
        string += "<li> Fecha de alta: " + getFecha() + "</li>";
        string += "<li> Hora de alta: " + format("%02d:%02d", getHora().getHour(), getHora().getMinute()) + "</li>";
        string += "<li>" + tarifa.descripcion() + "</li></ul>";
        return string;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cliente cliente = (Cliente) o;
        return Objects.equals(NIF, cliente.NIF);
    }

    @Override
    public int hashCode() {
        return Objects.hash(NIF);
    }
}