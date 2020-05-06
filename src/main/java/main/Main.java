package main;

import controlador.ImplementacionControlador;
import modelo.ImplementacionModelo;
import modelo.principal.BaseDeDatos;
import modelo.principal.GestorClientes;
import modelo.principal.GestorFacturas;
import vista.ImplementacionVista;
import java.io.Serializable;

public class Main implements Serializable {
    public static void main(String[] args) {
        //creamos los objetos
        GestorClientes gestorClientes = new GestorClientes();
        GestorFacturas gestorFacturas = new GestorFacturas();
        BaseDeDatos baseDeDatos = new BaseDeDatos(gestorClientes, gestorFacturas);

        //Parte del GUI
        ImplementacionControlador controlador = new ImplementacionControlador();
        ImplementacionVista vista = new ImplementacionVista();
        ImplementacionModelo modelo = new ImplementacionModelo();
        modelo.setBaseDeDatos(baseDeDatos);
        modelo.setVista(vista);
        controlador.setModelo(modelo);
        controlador.setVista(vista);
        vista.setModelo(modelo);
        vista.setControlador(controlador);
        vista.creaGUI();
    }
}