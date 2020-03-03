package main;

import principal.BaseDeDatos;
import principal.GestorClientes;
import principal.GestorFacturas;
import principal.Salida;

public class Main {
    public static void main(String[] args) {
        //creamos los objetos
        GestorClientes gestorClientes = new GestorClientes();
        GestorFacturas gestorFacturas = new GestorFacturas();
        BaseDeDatos baseDeDatos = new BaseDeDatos(gestorClientes, gestorFacturas);
        Salida salida = new Salida(baseDeDatos);

        //mostramos el menu de opciones y leemos la opcion
        System.out.println(salida.mostrarMenu());
        int op = salida.leerOpcion();

        //lanzamos la opcion correspondiente
        salida.lanzarMetodo(op);

        //mietras no se salga del programa, pedimos una nueva opcion
        while (op != 11) {
            System.out.println(salida.mostrarMenu());
            op = salida.leerOpcion();
            salida.lanzarMetodo(op);
        }
    }
}
