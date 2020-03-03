package datos.contrato;

import datos.clientes.Cliente;
import datos.llamadas.Llamada;
import interfaces.tieneFecha;

public class Factura implements tieneFecha {
    private final int codigo;
    private Tarifa tarifa; // €/min, tipo float o double o tarifa
    private final String fecha_emision;
    private final int periodo_fact; //en dias?????
    private final double importe; //float o double??
    private final String nifCliente;

    //todos final?? la fecha de emisión es un parametro?
    public Factura(Tarifa tarifa, String fecha_emision, int periodo_fact, Cliente cliente) {
        this.codigo = hashCode();
        this.tarifa = tarifa;
        this.fecha_emision = fecha_emision;
        this.periodo_fact = periodo_fact;
        this.importe = calcularImporte(cliente, tarifa);
        this.nifCliente = cliente.getNIF();
    }

    public int getCodigo() {
        return codigo;
    }

    public Tarifa getTarifa() {
        return tarifa;
    }

    public String getFecha_emision() {
        return fecha_emision;
    }

    public int getPeriodo_fact() {
        return periodo_fact;
    }

    public double getImporte() {
        return importe;
    }

    public String getNifCliente() {
        return nifCliente;
    }

    @Override
    public String getFecha() {
        return fecha_emision;
    }

    private double calcularImporte(Cliente cliente, Tarifa tarifa) {
        int segundosTotales = 0;
        for(Llamada llamada : cliente.getLlamadasPeriodoFact())
            segundosTotales += llamada.getDuracion();
        return segundosTotales * tarifa.getTarifa();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("NIF del cliente: " + nifCliente + ", ");
        sb.append("Código: " + codigo + ", ");
        sb.append("Tarifa: " + tarifa + ", ");
        sb.append("Fecha de emisión: " + fecha_emision + ", ");
        sb.append("Período de facturación: " + periodo_fact + " días, ");
        sb.append("Importe: " + importe + "€.");
        return sb.toString();
    }
}
