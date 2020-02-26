package datos.contrato;

import datos.clientes.Cliente;
import datos.llamadas.Llamada;
import interfaces.tieneFecha;

import java.time.LocalDate;

public class Factura implements tieneFecha {
    private int codigo;
    private Tarifa tarifa; //la que tenga el cliente en ese momento
    private LocalDate fechaEmision;
    private PeriodoFacturacion periodoFact;
    private double importe;
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

    @Override
    public LocalDate getFecha() {
        return fechaEmision;
    }

    private float calcularImporte(Cliente cliente) {
        int segundosTotales = 0;
        for (Llamada llamada : cliente.getLlamadas())  //COMPARAR las fechas! FALTA HACERLO PARA VER SI ESTÁN DENTRO DEL PERIODO DE FACT
            segundosTotales += llamada.getDuracion();
        return segundosTotales * cliente.getTarifa().getTarifa();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("NIF del cliente: " + nifCliente + ", ");
        sb.append("Código: " + codigo + ", ");
        sb.append("Tarifa: " + tarifa + ", ");
        sb.append("Fecha de emisión: " + fechaEmision.toString() + ", ");
        sb.append("Período de facturación: " + periodoFact + " días, ");
        sb.append("Importe: " + importe + "€.");
        return sb.toString();
    }
}
