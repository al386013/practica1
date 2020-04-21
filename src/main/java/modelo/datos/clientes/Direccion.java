package modelo.datos.clientes;

import java.io.Serializable;

public class Direccion implements Serializable {
    private String CP;
    private String provincia;
    private String poblacion;

    public Direccion() {
        super();
        this.CP = "";
        this.provincia = "";
        this.poblacion = "";
    }

    public Direccion(final String CP, final String provincia, final String poblacion) {
        super();
        this.CP = CP;
        this.provincia = provincia;
        this.poblacion = poblacion;
    }

    @Override
    public String toString() {
        return this.poblacion + " - " + this.provincia + " - " + this.CP;
    }
}
