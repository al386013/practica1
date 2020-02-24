package datos.contrato;

import interfaces.tieneFecha;

public class Factura implements tieneFecha {
    private static int codigo;
    private Tarifa tarifa; // €/min, tipo float o double o tarifa
    private String fecha_emision;
    private int periodo_fact; //en dias?????
    private double importe; //float o double??

    //todos final?? la fecha de emisión es un parametro?
    public Factura(final Tarifa tarifa, final String fecha_emision, final int periodo_fact) {
        this.codigo = codigo++;
        this.tarifa = tarifa;
        this.fecha_emision = fecha_emision;
        this.periodo_fact = periodo_fact;
        this.importe = calcularImporte(periodo_fact, tarifa);
    }

    @Override
    public String getFecha() {
        return fecha_emision;
    }

    private double calcularImporte(int periodo_fact, Tarifa tarifa) {
        return periodo_fact * tarifa.getTarifa();
    }


}
