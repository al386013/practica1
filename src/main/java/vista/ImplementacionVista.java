package vista;

import controlador.Controlador;
import modelo.InterrogaModelo;
import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class ImplementacionVista implements InformaVista, InterrogaVista {
    private Controlador controlador;
    private PanelClientes panelClientes;
    private PanelLlamadas panelLlamadas;
    private PanelFacturas panelFacturas;

    public ImplementacionVista() {
        super();
        panelClientes = new PanelClientes();
        panelClientes.setVista(this);
        panelLlamadas = new PanelLlamadas();
        panelLlamadas.setVista(this);
        panelFacturas = new PanelFacturas();
        panelFacturas.setVista(this);
    }

    public void setModelo(InterrogaModelo modelo) {
        panelClientes.setModelo(modelo);
        panelLlamadas.setModelo(modelo);
        panelFacturas.setModelo(modelo);
    }

    public void setControlador(Controlador controlador) {
        this.controlador = controlador;
        panelClientes.setControlador(controlador);
        panelLlamadas.setControlador(controlador);
        panelFacturas.setControlador(controlador);
    }

    @Override
    public PanelClientes getPanelClientes() {
        return panelClientes;
    }

    @Override
    public PanelLlamadas getPanelLlamadas() {
        return panelLlamadas;
    }

    @Override
    public PanelFacturas getPanelFacturas() {
        return panelFacturas;
    }

    //muestra una ventana informando que la accion se ha realiazado con exito
    @Override
    public void accionCorrecta(String cadena) {
        JOptionPane.showMessageDialog(null, cadena);
    }

    //muestra una ventana de error
    @Override
    public void accionDenegada(String cadena) {
        JOptionPane.showMessageDialog(null, cadena, "Error", JOptionPane.WARNING_MESSAGE);
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

        //anade tres pestanyas a la ventana de la aplicacion
        JTabbedPane pestanyas = new JTabbedPane();
        contenedor.add(pestanyas);
        pestanyas.add("Clientes", panelClientes);
        pestanyas.add("Llamadas", panelLlamadas);
        pestanyas.add("Facturas", panelFacturas);

        //clase interna anonima para abrir y cerrar la ventana
        ventana.addWindowListener(new WindowAdapter() {
            @Override
            public void windowOpened(WindowEvent e) {
                    controlador.importarDatos();
            }

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
