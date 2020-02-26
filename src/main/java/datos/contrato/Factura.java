package datos.contrato;

import datos.clientes.Cliente;
import datos.llamadas.Llamada;
import interfaces.tieneFecha;

public class Factura implements tieneFecha {
    private int codigo;
    private Tarifa tarifa; //la que tenga el cliente en ese momento
    private String fecha_emision; //CAMBIAR, FECHA ACTUAL CON LOCAL DATE
    private PeriodoFacturacion periodoFact;
    private double importe;
    private String nifCliente;

    public Factura(PeriodoFacturacion periodoFact, Cliente cliente) {
        this.codigo = hashCode();
        this.tarifa = cliente.getTarifa();
        this.fecha_emision = "HOLA"; //CAMBIAR CON LOCALDATE
        this.periodoFact = periodoFact;
        this.importe = calcularImporte(cliente);
        this.nifCliente = cliente.getNIF();
    }

    public int getCodigo() {
        return this.codigo;
    }

    @Override
    public String getFecha() {
        return fecha_emision;
    } //CAMBIAR CON LOCALDATE

    private float calcularImporte(Cliente cliente) {
        int segundosTotales = 0;
        for(Llamada llamada : cliente.getLlamadas())  //COMPARAR las fechas! FALTA HACERLO PARA VER SI ESTÁN DENTRO DEL PERIODO DE FACT
            segundosTotales += llamada.getDuracion();
        return segundosTotales * cliente.getTarifa().getTarifa();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("NIF del cliente: " + nifCliente + ", ");
        sb.append("Código: " + codigo + ", ");
        sb.append("Tarifa: " + tarifa + ", ");
        sb.append("Fecha de emisión: " + fecha_emision + ", ");
        sb.append("Período de facturación: " + periodoFact + " días, ");
        sb.append("Importe: " + importe + "€.");
        return sb.toString();
    }
}
