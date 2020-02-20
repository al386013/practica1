package datos.clientes;

public class Particular extends Cliente {
    //ATRIBUTO (QUE NO EXTIENDE DE CLIENT)
    String apellidos;

    //CONSTRUCTOR
    Particular(String nombre,String apellidos, String NIF, String direccion, String email){
        super(nombre, NIF, direccion, email);
        this.apellidos = apellidos;
    }
}
