package datos.contrato.tarifas;

import datos.llamadas.Llamada;

public class TarifaBasica extends Tarifa {
    public TarifaBasica(float precio) {
        super(precio);
    }

    @Override
    public float calcularPrecioLlamada(Llamada llamada) {
        return (llamada.getDuracion() / 60.0f) * super.precio;
    }

    @Override
    public String descripcion() {
        return "Tarifa basica";
    }
}
