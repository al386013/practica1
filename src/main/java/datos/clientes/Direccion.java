package datos.clientes;

public class Direccion {
    String CP;
    String provincia;
    String poblacion;

    public Direccion(final String CP, final String provincia, final String poblacion) {
        this.CP = CP;
        this.provincia = provincia;
        this.poblacion = poblacion;
    }
}
