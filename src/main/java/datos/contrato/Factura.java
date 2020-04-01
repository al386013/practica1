package datos.contrato;

import datos.contrato.tarifas.Tarifa;
import datos.llamadas.Llamada;
import datos.TieneFecha;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.RoundingMode;
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
        for (Llamada llamada : llamadas) {
            LocalDate fecha = llamada.getFecha();
            //si esta dentro del periodo de facturacion se pasa cada llamada a la tarifa del cliente
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
        Formatter obj = new Formatter();
        StringBuilder sb = new StringBuilder();
        sb.append("\nCodigo de factura: ");
        sb.append(this.hashCode());
        sb.append(":");
        sb.append("\n\tNIF: ");
        sb.append(nifCliente);
        sb.append("\n\tFecha de emision: ");
        sb.append(getFecha().toString());
        sb.append("\n\tHora de emision: ");
        sb.append( obj.format("%02d:%02d", getHora().getHour(), getHora().getMinute()));
        sb.append("\n\tPeriodo de facturacion: ");
        sb.append(periodoFact);
        sb.append("\n\tImporte: ");
        sb.append(importe);
        sb.append("€");
        sb.append("\n\tLista de llamadas de esta factura:\n");
        for (Llamada llamada : llamadas){
            sb.append("\n");
            sb.append(llamada.toString());
        }
        return sb.toString();
    }
}
