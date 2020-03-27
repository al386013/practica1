package datos.contrato;

import datos.contrato.tarifas.Tarifa;
import datos.contrato.tarifas.TarifaPorDia;
import datos.contrato.tarifas.TarifaPorHoras;
import datos.llamadas.Llamada;
import interfaces.TieneFecha;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Formatter;
import java.util.Set;

public class Factura implements TieneFecha, Serializable {
    private LocalDateTime fechaEmision;
    private PeriodoFacturacion periodoFact;
    private float importe;
    private String nifCliente;
    private Set<Llamada> llamadas;

    //CONSTRUCTORES

    public Factura() {
        this.fechaEmision = null;
        this.periodoFact = null;
        this.importe = 0.0f;
        this.nifCliente = null;
        this.llamadas = null;
    }

    public Factura(PeriodoFacturacion periodoFact, String nifCliente, Set<Llamada> llamadas, Tarifa tarifa) {
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

    public String getNifCliente() {
        return this.nifCliente;
    }

    @Override
    public LocalDate getFecha() {
        return this.fechaEmision.toLocalDate();
    }

    @Override
    public LocalTime getHora() { return this.fechaEmision.toLocalTime(); }

    private float calcularImporte(Tarifa tarifa, Set<Llamada> llamadas) {
        float importe = 0.00f;
        float precioLlamada;
        for (Llamada llamada : llamadas) {
            LocalDate fecha = llamada.getFecha();
            //si esta dentro del periodo de facturacion
            if (fecha.isAfter(periodoFact.getFechaIni()) && fecha.isBefore(periodoFact.getFechaFin()) ||
                    (fecha.isEqual(periodoFact.getFechaIni()) || fecha.isEqual(periodoFact.getFechaFin()))) {
                precioLlamada = calcularPrecioLlamada(tarifa, llamada);
                importe += (llamada.getDuracion() / 60.0f) * precioLlamada;
            }
        }
        //codigo para redondear a dos decimales:
        BigDecimal redondeado = new BigDecimal(importe).setScale(2, RoundingMode.HALF_EVEN);
        return redondeado.floatValue();
    }

    public float calcularPrecioLlamada(Tarifa tarifa, Llamada llamada) {
        float mejorPrecio = tarifa.getPrecio();
        Tarifa tarifaSuper = tarifa.getTarifa();

        if(tarifaSuper != null) { //si no es la basica
            float precioSuper = calcularPrecioLlamada(tarifaSuper, llamada); //llamada recursiva
            //si tiene la tarifa alguna tarifa especial y la cumple, se compara
            if( (tarifa instanceof TarifaPorDia && llamada.getFecha().getDayOfWeek() == DayOfWeek.SUNDAY) ||
                    (tarifa instanceof TarifaPorHoras && (llamada.getHora().getHour() >= 16 || llamada.getHora().getHour() <= 19)) )
                if(precioSuper < mejorPrecio )
                    mejorPrecio = precioSuper;
        }
        return mejorPrecio;
    }

    @Override
    public String toString() {
        Formatter obj = new Formatter();
        StringBuilder sb = new StringBuilder();
        sb.append("\nCodigo de factura: " + this.hashCode() + ":");
        sb.append("\n\tNIF: " + nifCliente);
        sb.append("\n\tFecha de emision: " + getFecha().toString());
        sb.append("\n\tHora de emision: " + obj.format("%02d:%02d", getHora().getHour(), getHora().getMinute()));
        sb.append("\n\tPeriodo de facturacion: " + periodoFact);
        sb.append("\n\tImporte: " + importe + "€");
        sb.append("\n\tLista de llamadas de esta factura:\n");
        for (Llamada llamada : llamadas) sb.append("\n" + llamada.toString());
        return sb.toString();
    }
}
