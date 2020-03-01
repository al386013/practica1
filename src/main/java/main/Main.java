package main;

import principal.BaseDeDatos;
import principal.Salida;

public class Main {
    public static void main(String[] args) {
        //Creamos una base de datos
        BaseDeDatos baseDeDatos = new BaseDeDatos();

        //mostramos el menu de opciones
        Salida salida = new Salida(baseDeDatos);
        System.out.println(salida.mostrarMenu());
        //leemos la opcion
        int op = salida.leerOpcion();
        //lanzamos la opcion correspondiente
        salida.lanzarMetodo(op);
        //pedimos una nueva opcion
        while (op != 11) {
            op = salida.leerOpcion();
            salida.lanzarMetodo(op);
        }
    }
}
