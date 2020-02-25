package main;

import datos.clientes.Direccion;
import es.uji.www.GeneradorDatosINE;
import principal.GestorClientes;
import principal.GestorFacturas;
import principal.GestorLlamadas;
import principal.Salida;

public class Main {
    public static void main(String[] args) {
        //Instanciamos los Gestores:
        GestorClientes gestorClientes = new GestorClientes();
        GestorLlamadas gestorLlamadas = new GestorLlamadas();
        GestorFacturas gestorFacturas = new GestorFacturas();

        //cargar la base de datos de la empresa con algunos datos
        GeneradorDatosINE generadorDatosINE = new GeneradorDatosINE();
        for (int i = 0; i < 100; i++) {
            String nif = generadorDatosINE.getNIF();
            String nombre = generadorDatosINE.getNombre();
            String email = nombre.toLowerCase() + nif + "@gmail.com";
            String provincia = generadorDatosINE.getProvincia();
            String poblacion = generadorDatosINE.getPoblacion(provincia);
            Direccion dir = new Direccion("cp", provincia, poblacion);
            if (i < 5) {
                String apellidos = generadorDatosINE.getApellido();
                gestorClientes.anadirParticular(nombre, apellidos, "xxxxxxxxx", nif, dir, email);
            } else
                gestorClientes.anadirEmpresa(nombre, "xxxxxxxxx", nif, dir, email);
        }

        //mostramos el menu de opciones, leemos la opcion y lanzamos el metodo correspondiente
        Salida salida = new Salida(gestorClientes, gestorLlamadas, gestorFacturas);
        System.out.println(salida.mostrarMenu());
        int op = salida.leerOpcion();
        salida.lanzarMetodo(op);
        while (op != 11) {
            op = salida.leerOpcion();
            salida.lanzarMetodo(op);
        }
    }
}
