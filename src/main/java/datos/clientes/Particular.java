package datos.clientes;

public class Particular extends Cliente {
    //ATRIBUTO (QUE NO EXTIENDE DE CLIENT)
    String apellidos;

    //CONSTRUCTOR
    public Particular(final String nombre, final String apellidos, final String NIF, final String direccion, final String email){
        super(nombre, NIF, direccion, email);
        this.apellidos = apellidos;
    }
}
