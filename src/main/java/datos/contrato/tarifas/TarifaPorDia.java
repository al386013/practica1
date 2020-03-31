package datos.contrato.tarifas;

import datos.llamadas.Llamada;
import java.time.DayOfWeek;

public class TarifaPorDia extends TarifaEspecial {

    public TarifaPorDia(Tarifa tarifa, float precioEspecial) {
        super(tarifa, precioEspecial);
    }

    @Override
    public float calcularPrecioLlamada(Llamada llamada) {
        if(llamada.getFecha().getDayOfWeek() == DayOfWeek.SUNDAY)
            return 0.00f; //los domingos sale gratis
        return super.calcularPrecioLlamada(llamada); //llamada recursiva
    }

    @Override
    public String descripcion() {
        return super.descripcion() + ", con tarifa especial por dia";
    }
}
