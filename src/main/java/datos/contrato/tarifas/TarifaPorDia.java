package datos.contrato.tarifas;

import datos.llamadas.Llamada;
import java.time.DayOfWeek;

public class TarifaPorDia extends TarifaEspecial {

    public TarifaPorDia(Tarifa tarifa, float precioEspecial) {
        super(tarifa, precioEspecial);
    }

    @Override
    public float calcularPrecioLlamada(Llamada llamada) {
        float precioReturn = super.calcularPrecioLlamada(llamada); //llamada recursiva
        //si la llamada cumple la tarifa por dia, calcula el precio de la llamada y se compara
        if(llamada.getFecha().getDayOfWeek() == DayOfWeek.SUNDAY) {
            float precioLlamada = (llamada.getDuracion() / 60.0f) * super.precio;
            if (precioLlamada < precioReturn)
                precioReturn = precioLlamada;
        }
        return precioReturn;
    }

    @Override
    public String descripcion() {
        return super.descripcion() + ", con tarifa especial por dia";
    }
}
