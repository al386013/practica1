package datos.contrato.tarifas;

import datos.llamadas.Llamada;
import java.io.Serializable;

public abstract class Tarifa implements Serializable {
    private float precio;

    //CONSTRUCTOR
    public Tarifa(float precio) {
        super();
        this.precio = precio;
    }

    //METODOS
    public abstract float calcularPrecioLlamada(Llamada llamada);

    public abstract String descripcion();

    public float getPrecio() {
        return precio;
    }
}
