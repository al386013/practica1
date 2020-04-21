package modelo.datos.contrato.tarifas;

import modelo.datos.llamadas.Llamada;

public class TarifaBasica extends Tarifa {
    public TarifaBasica(float precio) {
        super(precio);
    }

    @Override
    public float calcularPrecioLlamada(Llamada llamada) {
        return (llamada.getDuracion() / 60.0f) * super.getPrecio();
    }

    @Override
    public String descripcion() {
        return "Tarifa basica";
    }
}
