package datos.clientes;

import datos.contrato.Factura;
import datos.contrato.Tarifa;
import datos.ComparadorFechas;
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

    //CONSSTRUCTOR POR DEFECTO
    public Cliente() {
        this.nombre = "";
        this.telf = "";
        this.NIF = "";
        this.direccion = null;
        this.email = "";
        this.fechaDeAlta = null;
        this.tarifa = null;
        this.facturas = new HashSet<Factura>();
        this.llamadas = new HashSet<Llamada>();
        //this.llamadas = new TreeSet<Llamada>(new ComparadorFechas<>());
    }

    public Cliente(final String nombre, final String telefono, final String NIF, final Direccion direccion, final String email, final Tarifa tarifa) {
        this.nombre = nombre;
        this.telf = telefono;
        this.NIF = NIF;
        this.direccion = direccion;
        this.email = email;
        this.fechaDeAlta = LocalDate.now();
        this.tarifa = tarifa;
        this.facturas = new HashSet<Factura>();
        this.llamadas = new HashSet<Llamada>();
        //this.llamadas = new TreeSet<Llamada>(new ComparadorFechas<>());
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
        return fechaDeAlta;
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

    public void cambiarTarifa(float nuevaTarifa) {
        tarifa.setTarifa(nuevaTarifa);
    }

    public void anadirLlamada(Llamada llamada) {
        llamadas.add(llamada);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(nombre);
        sb.append("\n\tNIF: " + NIF);
        sb.append("\n\tTelefono: " + telf);
        sb.append("\n\tDireccion: " + direccion);
        sb.append("\n\tEmail: " + email);
        sb.append("\n\tFecha de alta: " + fechaDeAlta.toString());
        sb.append("\n\tTarifa: " + tarifa);
        return sb.toString();
    }
}