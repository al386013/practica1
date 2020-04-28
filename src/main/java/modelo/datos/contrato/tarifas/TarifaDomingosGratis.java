package modelo.datos.contrato.tarifas;

import modelo.datos.llamadas.Llamada;
import java.time.DayOfWeek;

public class TarifaDomingosGratis extends TarifaEspecial {

    public TarifaDomingosGratis(Tarifa tarifa, float precioEspecial) {
        super(tarifa, precioEspecial);
    }

    @Override
    public float calcularPrecioLlamada(Llamada llamada) {
        if (llamada.getFecha().getDayOfWeek() == DayOfWeek.SUNDAY)
            return 0.00f; //los domingos sale gratis y no puede ser mas barato, no hace falta comparar
        return super.calcularPrecioLlamada(llamada); //llamada recursiva
    }

    @Override
    public String descripcion() {
        return super.descripcion() + " + domingos gratis";
    }
}
