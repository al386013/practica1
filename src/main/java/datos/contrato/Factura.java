package datos.contrato;

import interfaces.tieneFecha;

public class Factura implements tieneFecha {
    private final int codigo;
    private Tarifa tarifa; // €/min, tipo float o double o tarifa
    private final String fecha_emision;
    private final int periodo_fact; //en dias?????
    private final double importe; //float o double??
    private final String nifCliente;

    //todos final?? la fecha de emisión es un parametro?
    public Factura(int codFac, Tarifa tarifa, String fecha_emision, int periodo_fact, String nifCliente) {
        this.codigo = codFac;
        this.tarifa = tarifa;
        this.fecha_emision = fecha_emision;
        this.periodo_fact = periodo_fact;
        this.importe = calcularImporte(periodo_fact, tarifa);
        this.nifCliente = nifCliente;
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

    private double calcularImporte(int periodo_fact, Tarifa tarifa) {
        return periodo_fact * tarifa.getTarifa();
    }


}
