package vista;

import controlador.Controlador;
import modelo.InterrogaModelo;
import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

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

    @Override
    public VistaClientes getVistaClientes() {
        return vistaClientes;
    }

    @Override
    public VistaLlamadas getVistaLlamadas() {
        return vistaLlamadas;
    }

    @Override
    public VistaFacturas getVistaFacturas() {
        return vistaFacturas;
    }

    @Override
    public void importadoCorrectamente() {
        JOptionPane.showMessageDialog(null, "Datos importados correctamente");
    }

    @Override
    public void guardadoCorrectamente() {
        JOptionPane.showMessageDialog(null, "Datos guardados en la base de datos");
    }

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

        ventana.addWindowListener(new WindowAdapter() { //clase interna anonima
            @Override
            public void windowClosing(WindowEvent e) {
                controlador.exportarDatosYSalir();
                System.exit(0);
            }
        });

        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.pack();
        ventana.setVisible(true);
    }
}
