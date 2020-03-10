package main;

import principal.*;
import java.io.Serializable;

public class Main implements Serializable {
    public static void main(String[] args) {

        //creamos los objetos
        GestorClientes gestorClientes = new GestorClientes();
        GestorFacturas gestorFacturas = new GestorFacturas();
        BaseDeDatos baseDeDatos = new BaseDeDatos(gestorClientes, gestorFacturas);
        Salida salida = new Salida(baseDeDatos);

        //mostramos el menu de opciones, leemos la opcion y lanzamos el metodo correspondiente
        salida.menuYopcion();
    }
}
