package datos.clientes;

public class Particular extends Cliente {
    //ATRIBUTOS (EL RESTO LO HEREDA DE CLIENTE)
    private String apellidos;

    //CONSTRUCTOR
    public Particular(final String nombre, final String apellidos, final String NIF, final Direccion direccion, final String email){
        super(nombre, NIF, direccion, email);
        this.apellidos = apellidos;
    }
}
