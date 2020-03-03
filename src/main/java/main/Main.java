package main;

import excepciones.DuracionNegativaException;
import excepciones.NifRepetidoException;
import principal.Salida;

public class Main {
    public static void main(String[] args) throws NifRepetidoException, DuracionNegativaException {
        //mostramos el menu de opciones y leemos la opcion
        Salida salida = new Salida();
        System.out.println(salida.mostrarMenu());
        int op = salida.leerOpcion();
        //lanzamos la opcion correspondiente
        salida.lanzarMetodo(op);
        //mietras no se salga, pedimos una nueva opcion
        while (op != 11) {
            System.out.println(salida.mostrarMenu());
            op = salida.leerOpcion();
            salida.lanzarMetodo(op);
        }
    }
}
