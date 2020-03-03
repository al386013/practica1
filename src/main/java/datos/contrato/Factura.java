package datos.contrato;

import datos.clientes.Cliente;
import datos.llamadas.Llamada;
import interfaces.tieneFecha;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;

public class Factura implements tieneFecha {
    private int codigo;
    private Tarifa tarifa; //la que tenga el cliente en ese momento
    private LocalDate fechaEmision;
    private PeriodoFacturacion periodoFact;
    private float importe;
    private String nifCliente;


    public Factura(PeriodoFacturacion periodoFact, Cliente cliente) {
        this.codigo = hashCode();
        this.tarifa = cliente.getTarifa();
        this.fechaEmision = LocalDate.now();
        this.periodoFact = periodoFact;
        this.importe = calcularImporte(cliente);
        this.nifCliente = cliente.getNIF();
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

    private float calcularImporte(Cliente cliente) {
        int segundosTotales = 0;
        for (Llamada llamada : cliente.getLlamadas()) {
            LocalDate fecha = llamada.getFecha();
            if(fecha.isAfter(periodoFact.getFechaIni()) || fecha.isBefore(periodoFact.getFechaFin()))
                segundosTotales += llamada.getDuracion();
        }
        float importe = (segundosTotales/60.0f) * cliente.getTarifa().getTarifa();
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
