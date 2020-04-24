package vista;

import controlador.Controlador;
import modelo.InterrogaModelo;
import javax.swing.*;
import java.awt.*;

public class ImplementacionVista implements InformaVista, InterrogaVista {
    private Controlador controlador;
    private InterrogaModelo modelo;
    private VistaClientes vistaClientes;
    private VistaLlamadas vistaLlamadas;
    private VistaFacturas vistaFacturas;

    public ImplementacionVista() {
        super();
        vistaClientes = new VistaClientes();
        vistaLlamadas = new VistaLlamadas();
        vistaFacturas = new VistaFacturas();
    }

    public void setModelo(InterrogaModelo modelo) {
        this.modelo = modelo;
        vistaClientes.setModelo(modelo);
        vistaLlamadas.setModelo(modelo);
        vistaFacturas.setModelo(modelo);
    }

    public void setControlador(Controlador controlador) {
        this.controlador = controlador;
        vistaClientes.setControlador(controlador);
        vistaLlamadas.setControlador(controlador);
        vistaFacturas.setControlador(controlador);
    }

    public VistaClientes getVistaClientes() { return vistaClientes; }

    public VistaLlamadas getVistaLlamadas() { return vistaLlamadas; }

    public VistaFacturas getVistaFacturas() { return vistaFacturas; }

    public void creaGUI() {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                ventana();
            }
        });
    }

    private void ventana() {
        JFrame ventana = new JFrame("Programa");
        Container contenedor = ventana.getContentPane();

        JTabbedPane pestanyas = new JTabbedPane();
        contenedor.add(pestanyas);
        pestanyas.add("Clientes", vistaClientes.panel());
        pestanyas.add("Llamadas", vistaLlamadas.panel());
        pestanyas.add("Facturas", vistaFacturas.panel());

        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.pack();
        ventana.setVisible(true);
    }
}
