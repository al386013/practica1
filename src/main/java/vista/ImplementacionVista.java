package vista;


import controlador.Controlador;
import controlador.acciones.*;
import modelo.InterrogaModelo;
import modelo.principal.BaseDeDatos;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ImplementacionVista implements InformaVista, InterrogaVista {
    private Accion accion;
    private Controlador controlador;
    private InterrogaModelo modelo;
    private JLabel boton;
    private JList lista;
    private int indice;
    private BaseDeDatos baseDeDatos;

    public ImplementacionVista() {}

    public void setModelo(InterrogaModelo modelo) {
        this.modelo = modelo;
    }

    public void setControlador(Controlador controlador) {
        this.controlador = controlador;
    }


    public void creaGUI() {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                baseDeDatos = modelo.getBaseDeDatos();
                ventana();
            }
        });
    }

    private void ventana() {
        JFrame ventana = new JFrame("Programa");
        Container contenedor = ventana.getContentPane();

        JTabbedPane pestanyas = new JTabbedPane();
        contenedor.add(pestanyas);
        pestanyas.add("Clientes", new VistaClientes().panel());
        pestanyas.add("Llamadas", new VistaLlamadas().panel());
        pestanyas.add("Facturas", new VistaFacturas().panel());

        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.pack();
        ventana.setVisible(true);
    }
}
