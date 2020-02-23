package datos.clientes;

public class Empresa extends Cliente {
    //TODOS SUS ATRIBUTOS LOS HEREDA DE CLIENTE

    //CONSTRUCTOR
    public Empresa(final String nombre, final String NIF, final Direccion direccion, final String email) {
        super(nombre, NIF, direccion, email);
    }

}
