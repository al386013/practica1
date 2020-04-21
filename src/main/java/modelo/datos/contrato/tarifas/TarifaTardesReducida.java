package modelo.datos.contrato.tarifas;

import modelo.datos.llamadas.Llamada;

public class TarifaTardesReducida extends TarifaEspecial {
    public TarifaTardesReducida(Tarifa tarifa, float precioEspecial) {
        super(tarifa, precioEspecial);
    }

    @Override
    public float calcularPrecioLlamada(Llamada llamada) {
        float precioReturn = super.calcularPrecioLlamada(llamada); //llamada recursiva
        //si la llamada cumple la tarifa de tardes, calcula el precio de la llamada y se compara con la recursiva
        if (llamada.getHora().getHour() >= 16 && llamada.getHora().getHour() <= 19) {
            float precioLlamada = (llamada.getDuracion() / 60.0f) * super.getPrecio();
            if (precioLlamada < precioReturn)
                precioReturn = precioLlamada;
        }
        return precioReturn;
    }

    @Override
    public String descripcion() {
        return super.descripcion() + ", con tarifa especial de tardes reducida";
    }
}
