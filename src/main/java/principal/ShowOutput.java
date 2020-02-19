package principal;

public class ShowOutput {
    //He pensado tener esta clase para que devuelva a App la salida con la cadena que aparece en la APP

    public static void main(String[] args) {
        new ShowOutput().createOutput();
    }
    public void createOutput(){
        String output = "";
        output += "Escoja una de las siguientes opciones: \n";
        output += "1) Dar de alta un nuevo cliente \n";
        output += "2) Borrar un cliente \n";
        output += "3) Cambiar la tarifa de un cliente \n";
        output += "4) Recuperar los datos de un cliente a partir de su NIF \n";
        output += "5) Recuperar el listado de todos los clientes \n";
        output += "6) Salir \n";

        //Hay que pensar como deshacernos del siguiente print;
        System.out.println(output);

    }
}
