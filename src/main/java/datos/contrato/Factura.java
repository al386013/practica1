package datos.contrato;

import datos.llamadas.Llamada;
import interfaces.TieneFecha;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.util.Set;

public class Factura implements TieneFecha, Serializable {
    private int codigo;
    private Tarifa tarifa; //la que tenga el cliente en ese momento
    private LocalDate fechaEmision;
    private PeriodoFacturacion periodoFact;
    private float importe;
    private String nifCliente;

    public Factura(PeriodoFacturacion periodoFact, String nifCliente, Set<Llamada> llamadas, Tarifa tarifa) {
        this.codigo = hashCode();
        this.tarifa = tarifa;
        this.fechaEmision = LocalDate.now();
        this.periodoFact = periodoFact;
        this.importe = calcularImporte(tarifa, llamadas);
        this.nifCliente = nifCliente;
    }

    public int getCodigo() {
        return this.codigo;
    }

    public Tarifa getTarifa() { return this.tarifa; }

    public float getImporte() { return this.importe; }

    public String getNifCliente() { return this.nifCliente; }

    @Override
    public LocalDate getFecha() {
        return this.fechaEmision;
    }

    private float calcularImporte(Tarifa tarifa, Set<Llamada> llamadas) {
        int segundosTotales = 0;
        for (Llamada llamada : llamadas) {
            LocalDate fecha = llamada.getFecha();
            if(fecha.isAfter(periodoFact.getFechaIni()) && fecha.isBefore(periodoFact.getFechaFin()) ||
                    (fecha.isEqual(periodoFact.getFechaIni()) || fecha.isEqual(periodoFact.getFechaFin())))
                segundosTotales += llamada.getDuracion();
        }
        float importe = (segundosTotales/60.0f) * tarifa.getTarifa();
        //codigo para redondear a dos decimales:
        BigDecimal redondeado = new BigDecimal(importe).setScale(2, RoundingMode.HALF_EVEN);
        return redondeado.floatValue();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("NIF: " + nifCliente + ", ");
        sb.append("Codigo: " + codigo + ", ");
        sb.append("Tarifa: " + tarifa + ", ");
        sb.append("Fecha de emision: " + fechaEmision.toString() + ", ");
        sb.append("Periodo de facturacion: " + periodoFact + ", ");
        sb.append("Importe: " + importe + "€.");
        return sb.toString();
    }
}
