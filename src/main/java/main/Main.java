package main;

import excepciones.DuracionNegativaException;
import excepciones.NifRepetidoException;
import principal.Salida;

public class Main {
    public static void main(String[] args) throws NifRepetidoException, DuracionNegativaException {
        //mostramos el menu de opciones
        Salida salida = new Salida();
        System.out.println(salida.mostrarMenu());
        //leemos la opcion
        int op = salida.leerOpcion();
        //lanzamos la opcion correspondiente
        salida.lanzarMetodo(op);
        //pedimos una nueva opcion
        while (op != 11) {
            System.out.println(salida.mostrarMenu());
            op = salida.leerOpcion();
            salida.lanzarMetodo(op);
        }
    }
}
