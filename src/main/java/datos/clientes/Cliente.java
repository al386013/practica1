package datos.clientes;

import datos.contrato.Factura;
import datos.contrato.Tarifa;
import interfaces.TieneFecha;
import datos.llamadas.Llamada;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.*;

public abstract class Cliente implements TieneFecha, Serializable {

    private String nombre;
    private String NIF;
    private String telf;
    private Direccion direccion;
    private String email;
    private LocalDate fechaDeAlta;
    private Tarifa tarifa;

    private Set<Factura> facturas; //conjunto con todas las facturas del cliente
    private Set<Llamada> llamadas; //conjunto con todas las llamadas del cliente

    //constructor por defecto
    public Cliente() {
        this.nombre = "";
        this.telf = "";
        this.NIF = "";
        this.direccion = null;
        this.email = "";
        this.fechaDeAlta = LocalDate.now();
        this.tarifa = null;
        this.facturas = new HashSet<Factura>();
        this.llamadas = new HashSet<Llamada>();
    }

    public Cliente(final String nombre,final String telefono, final String NIF, final Direccion direccion, final String email) {
        this.nombre = nombre;
        this.telf = telefono;
        this.NIF = NIF;
        this.direccion = direccion;
        this.email = email;
        this.fechaDeAlta = LocalDate.now();
        this.tarifa = new Tarifa();
        this.facturas = new HashSet<Factura>();
        this.llamadas = new HashSet<Llamada>();
    }

    public String getNombre() { return nombre; }

    public String getTelf() { return telf; }

    public String getNIF() {
        return NIF;
    }

    public Direccion getDireccion() { return direccion; }

    public String getEmail() { return email; }


    @Override
    public LocalDate getFecha() { return fechaDeAlta; }

    public Tarifa getTarifa() { return tarifa; }

    public Set<Llamada> getLlamadas() {
        return llamadas;
    }

    public Set<Factura> getFacturas() {
        return facturas;
    }

    public void cambiarTarifa(float nuevaTarifa) {
        tarifa.setTarifa(nuevaTarifa);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(nombre + ", ");
        sb.append("NIF: " + NIF + ", ");
        sb.append("Telf: " + telf + ", ");
        sb.append("Direccion: " + direccion + ", ");
        sb.append("Email: " + email + ", ");
        sb.append("Fecha de alta: " + fechaDeAlta.toString() + ", ");
        sb.append("Tarifa: " + tarifa + ". ");
        return sb.toString();
    }
}