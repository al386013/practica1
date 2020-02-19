package data.clients;

public class Individual extends Client {
    //ATRIBUTO (QUE NO EXTIENDE DE CLIENT)
    String apellidos;

    //CONSTRUCTOR
    Individual(String name,String apellidos, String NIF, String direction, String mail){
        super(name, NIF, direction, mail);
        this.apellidos = apellidos;
    }
}
