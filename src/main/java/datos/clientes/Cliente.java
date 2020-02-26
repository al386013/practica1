package datos.clientes;

import datos.contrato.Factura;
import datos.contrato.Tarifa;
import datos.llamadas.Llamada;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.*;

public abstract class Cliente {

    private String nombre;
    private String NIF;
    private String telf;
    private Direccion direccion;
    private String email;
    private LocalDate fechaDeAlta;
    private Tarifa tarifa;
    private HashSet<Factura> facturas; //conjunto con todas las facturas del cliente
    private HashSet<Llamada> llamadas; //conjunto con todas las llamadas del cliente
    private Date date;

    public Cliente(final String nombre,final String telefono, final String NIF, final Direccion direccion, final String email){
        this.nombre = nombre;
        this.telf = telefono;
        this.NIF = NIF;
        this.direccion = direccion;
        this.email = email;
        //Preguntar si las siguentes sentencias corresponde a la fecha actual del sistema:
        //Calendar fechaActual = Calendar.getInstance();
        this.date = new Date();
        this.fechaDeAlta = LocalDate.now();
        this.tarifa = new Tarifa(); //Preguntar si es necesario instanciar
        this.facturas = new HashSet<Factura>();
        //this.llamadasPeriodoFact = new HashSet<Llamada>();
    }

    public String getNombre() {
        return nombre;
    }

    public String getNIF() {
        return NIF;
    }

    public String getTelf() {
        return telf;
    }

    public String getEmail() {
        return email;
    }

    public LocalDate getFechaDeAlta() {
        return fechaDeAlta;
    }

    public Tarifa getTarifa() {
        return tarifa;
    }

    public Direccion getDireccion() {
        return direccion;
    }

    public Date getDate() {
        return date;
    }

    public HashSet<Llamada> getLlamadas() {
        return llamadas;
    }

    public HashSet<Factura> getFacturas() {
        return facturas;
    }

    public void anadirLlamada(Llamada llamada) {
        llamadas.add(llamada);
    }

    public void anadirFactura(Factura factura) {
        facturas.add(factura);
    }

    public void cambiarTarifa(float nuevaTarifa) {
        tarifa.setTarifa(nuevaTarifa);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(nombre + ", ");
        sb.append("NIF: " + NIF + ", ");
        sb.append("Direccion: " + direccion + ", ");
        sb.append("Email: " + email + ", ");
        sb.append("Fecha de alta: " + fechaDeAlta.toString() + ", ");
        sb.append("Tarifa: " + tarifa + ".");
        return sb.toString();
    }
}