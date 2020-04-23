package vista;

import controlador.Controlador;
import controlador.acciones.ImportarDatos;
import controlador.acciones.SeleccionaOpcionClientes;
import controlador.acciones.SeleccionaOpcionFacturas;
import controlador.acciones.SeleccionaOpcionLlamada;
import modelo.InterrogaModelo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ImplementacionVista implements InformaVista, InterrogaVista {
    private Controlador controlador;
    private InterrogaModelo modelo;
    private JTextField jtfNombre;
    private JLabel jlContador;

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
                menuPrincipal();
            }
        });
    }

    private void menuPrincipal() {
        JFrame ventana = new JFrame("Programa");
        Container contenedor = ventana.getContentPane();
        JList opciones = new JList(new String[]{
                "Importar los datos.",
                "Operacion clientes.",
                "Operacion llamadas.",
                "Operacion facturas.",
                "Salir y guardar datos."
        });
        opciones.setVisibleRowCount(5);
        opciones.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JScrollPane scroll = new JScrollPane(opciones);
        contenedor.add(scroll);
        Escuchador escuchador = new Escuchador();
        JPanel jpEntrada = new JPanel();
        JPanel jpContador = new JPanel();
        jtfNombre = new JTextField(20);
        /*
        JButton jbNuevo = new JButton("Nuevo");
        jbNuevo.addActionListener(escuchador);
        JButton jbAtras = new JButton("Atras");
        jbAtras.addActionListener(escuchador);
        JButton jbAdelante = new JButton("Adelante");
        jbAdelante.addActionListener(escuchador);
        //jlContador = new JLabel(infoEstadoEntradas());
        jpEntrada.add(jtfNombre);
        jpEntrada.add(jbNuevo);
        jpEntrada.add(jbAtras);
        jpEntrada.add(jbAdelante);
        jpContador.add(jlContador);
        contenedor.add(jpEntrada, BorderLayout.NORTH);
        contenedor.add(jpContador, BorderLayout.SOUTH);*/
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.pack();
        ventana.setVisible(true);
    }

    private class Escuchador implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            JButton boton = (JButton)e.getSource();
            String texto = boton.getText();
            /*if(texto.equals("Nuevo"))
                //controlador.anyadeEntrada();
            else if(texto.equals("Atras"))
                //controlador.atras();
            else if(texto.equals("Adelante"))
                //controlador.adelante();*/
        }
    }
}
