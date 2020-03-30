package datos.contrato.tarifas;

import datos.llamadas.Llamada;

public class TarifaPorHoras extends TarifaEspecial {
    public TarifaPorHoras(Tarifa tarifa, float precioEspecial) {
        super(tarifa, precioEspecial);
    }

    @Override
    public float calcularPrecioLlamada(Llamada llamada) {
        float precioReturn = super.calcularPrecioLlamada(llamada); //llamada recursiva
        //si la llamada cumple la tarifa por horas, calcula el precio de la llamada y se compara
        if(llamada.getHora().getHour() >= 16 && llamada.getHora().getHour() <= 19) {
            float precioLlamada = (llamada.getDuracion() / 60.0f) * super.precio;
            if (precioLlamada < precioReturn)
                precioReturn = precioLlamada;
        }
        return precioReturn;
    }

    @Override
    public String descripcion() {
        return super.descripcion() + ", con tarifa especial por horas";
    }
}
