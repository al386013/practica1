package modelo.datos.contrato;

import modelo.datos.contrato.tarifas.Tarifa;
import modelo.datos.llamadas.Llamada;
import modelo.datos.TieneFecha;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Set;
import static java.lang.String.format;

public class Factura implements TieneFecha, Serializable {
    private LocalDateTime fechaEmision;
    private PeriodoFacturacion periodoFact;
    private float importe;
    private String nifCliente;
    private Set<Llamada> llamadas;

    public Factura() {
        super();
        this.fechaEmision = null;
        this.periodoFact = null;
        this.importe = 0.0f;
        this.nifCliente = null;
        this.llamadas = null;
    }

    public Factura(PeriodoFacturacion periodoFact, String nifCliente, Set<Llamada> llamadas, Tarifa tarifa) {
        super();
        this.fechaEmision = LocalDateTime.now();
        this.periodoFact = periodoFact;
        this.importe = calcularImporte(tarifa, llamadas);
        this.nifCliente = nifCliente;
        this.llamadas = llamadas;
    }

    public int getCodigo() {
        return this.hashCode();
    }

    public float getImporte() {
        return this.importe;
    }

    public PeriodoFacturacion getPeriodoFact() {
        return periodoFact;
    }

    public Set<Llamada> getLlamadas() {
        return llamadas;
    }

    public String getNifCliente() {
        return this.nifCliente;
    }

    @Override
    public LocalDate getFecha() {
        return this.fechaEmision.toLocalDate();
    }

    @Override
    public LocalTime getHora() {
        return this.fechaEmision.toLocalTime();
    }

    private float calcularImporte(Tarifa tarifa, Set<Llamada> llamadas) {
        float importe = 0.00f;
        for (Llamada llamada : llamadas) {
            LocalDate fecha = llamada.getFecha();
            //si esta dentro del periodo de facturacion se pasa cada llamada a la tarifa del cliente y devuelve su importe
            if (fecha.isAfter(periodoFact.getFechaIni()) && fecha.isBefore(periodoFact.getFechaFin()) ||
                    (fecha.isEqual(periodoFact.getFechaIni()) || fecha.isEqual(periodoFact.getFechaFin())))
                importe += tarifa.calcularPrecioLlamada(llamada);
        }
        //codigo para redondear a dos decimales:
        BigDecimal redondeado = new BigDecimal(importe).setScale(2, RoundingMode.HALF_EVEN);
        return redondeado.floatValue();
    }

    @Override
    public String toString() {
        String string = "<h1> Codigo de factura: " + this.hashCode() + ": <br/>";
        string += "<ul><li> NIF: " + nifCliente + "</li>";
        string += "<li> Fecha de emision: " + getFecha().toString() + "</li>";
        string += "<li> Hora de emision: " + format("%02d:%02d", getHora().getHour(), getHora().getMinute()) + "</li>";
        string += "<li> Periodo de facturacion: " + periodoFact + "</li>";
        string += "<li> Importe: " + importe + "€ </li>";
        string += "<li> Lista de llamadas de esta factura: </li>";
        for (Llamada llamada : llamadas)
            string += "<br/>" + llamada;
        return string + "<br/><br/></h1>";
    }
}
