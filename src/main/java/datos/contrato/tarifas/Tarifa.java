package datos.contrato.tarifas;

import datos.llamadas.Llamada;
import java.io.Serializable;

public abstract class Tarifa implements Serializable {
    float precio;

    //CONSTRUCTOR
    public Tarifa(float precio) {
        this.precio = precio;
    }

    //METODOS
    public abstract float calcularPrecioLlamada(Llamada llamada);

    public abstract String descripcion();

    @Override
    public String toString() {
        return precio + " €/min";
    }
}
