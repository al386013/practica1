package datos.clientes;

import datos.contrato.Factura;
import datos.contrato.Tarifa;
import datos.llamadas.Llamada;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

public abstract class Cliente {

    private String nombre;
    private String NIF;
    private String telf;
    private Direccion direccion;
    private String email;
    private DateFormat fechaDeAlta;
    private Tarifa tarifa;
    private HashSet<Factura> facturas; //La clave corresponde al codigo de factura
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
        this.fechaDeAlta = new SimpleDateFormat("dd/MM/yyyy");
        this.tarifa = new Tarifa(); //Preguntar si es necesario instanciar
        this.facturas = new HashSet<Factura>();
        //this.llamadasPeriodoFact = new HashSet<Llamada>();
    }

    //public void anadirLlamadaPeriodoFact(Llamada llamada) {
        //llamadasPeriodoFact.add(llamada);
    //}

    //public void clearLlamadasPeriodoFact() {
        //llamadasPeriodoFact = new HashSet<Llamada>();
    //}

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

    public DateFormat getFechaDeAlta() {
        return fechaDeAlta;
    }

    public Tarifa getTarifa() {
        return tarifa;
    }

    public Direccion getDireccion() {
        return direccion;
    }

    public HashSet<Factura> getFacturas() {
        return facturas;
    }

    public void anadirFactura(Factura factura) {
        facturas.add(factura);
    }

    public void cambiarTarifa(Double nuevaTarifa) {
        tarifa.setTarifa(nuevaTarifa);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(nombre + ", ");
        sb.append("NIF: " + NIF + ", ");
        sb.append("Direccion: " + direccion + ", ");
        sb.append("Email: " + email + ", ");
        sb.append("Fecha de alta: " + fechaDeAlta.format(date) + ", ");
        sb.append("Tarifa: " + tarifa + ".");
        return sb.toString();
    }
}