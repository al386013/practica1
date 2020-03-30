package datos.contrato.tarifas;

import datos.llamadas.Llamada;

public abstract class TarifaEspecial extends Tarifa {
    private Tarifa tarifa;

    public TarifaEspecial(Tarifa tarifa, float precio) {
        super(precio);
        this.tarifa = tarifa;
    }

    @Override
    public float calcularPrecioLlamada(Llamada llamada) { return tarifa.calcularPrecioLlamada(llamada); }

    @Override
    public String descripcion() {
        return tarifa.descripcion();
    }

}
