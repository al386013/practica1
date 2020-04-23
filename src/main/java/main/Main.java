package main;

import controlador.ImplementacionControlador;
import modelo.ImplementacionModelo;
import modelo.principal.BaseDeDatos;
import modelo.principal.GestorClientes;
import modelo.principal.GestorFacturas;
import controlador.acciones.SeleccionaOpcionPrincipal;
import vista.ImplementacionVista;
import vista.VistaClientes;

import java.io.Serializable;

public class Main implements Serializable {
    public static void main(String[] args) {
        //creamos los objetos
        GestorClientes gestorClientes = new GestorClientes();
        GestorFacturas gestorFacturas = new GestorFacturas();
        BaseDeDatos baseDeDatos = new BaseDeDatos(gestorClientes, gestorFacturas);

        //Parte del gui
        ImplementacionControlador controlador = new ImplementacionControlador();
        ImplementacionVista vista = new ImplementacionVista();
        VistaClientes vistaClientes = new VistaClientes();
        ImplementacionModelo modelo = new ImplementacionModelo();
        modelo.setVista(vista);
        modelo.setBaseDeDatos(baseDeDatos);
        controlador.setVista(vista);
        controlador.setModelo(modelo);
        controlador.importarDatos();
        vista.setModelo(modelo);
        vista.setControlador(controlador);
        vistaClientes.setModelo(modelo);
        vistaClientes.setControlador(controlador);
        vistaClientes.creaGUI();

        //mostramos el menu de opciones, leemos la opcion y lanzamos el metodo correspondiente
        SeleccionaOpcionPrincipal seleccionaOpcionPrincipal = new SeleccionaOpcionPrincipal(baseDeDatos);
        seleccionaOpcionPrincipal.ejecutaAccion(baseDeDatos);


    }
}