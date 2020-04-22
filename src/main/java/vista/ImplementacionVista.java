package vista;

import com.sun.org.apache.xalan.internal.xsltc.compiler.util.StringStack;
import controlador.Controlador;
import modelo.InterrogaModelo;

import javax.swing.*;
import java.awt.*;

public class ImplementacionVista {
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

    private void MenuPrincipal() {
        JFrame ventana = new JFrame("Programa");
        Container contenedor = ventana.getContentPane();
        JPanel jpEntrada = new JPanel();
        JPanel jpContador = new JPanel();
        JList opciones = new JList(new String[]{"Importar los datos",})
        jtfNombre = new JTextField(20);
        Escuchador escuchador = new Escuchador();
        JButton jbNuevo = new JButton("Nuevo");
        jbNuevo.addActionListener(escuchador);
        JButton jbAtras = new JButton("Atras");
        jbAtras.addActionListener(escuchador);
        JButton jbAdelante = new JButton("Adelante");
        jbAdelante.addActionListener(escuchador);
        jlContador = new JLabel(infoEstadoEntradas());
        jpEntrada.add(jtfNombre);
        jpEntrada.add(jbNuevo);
        jpEntrada.add(jbAtras);
        jpEntrada.add(jbAdelante);
        jpContador.add(jlContador);
        contenedor.add(jpEntrada, BorderLayout.NORTH);
        contenedor.add(jpContador, BorderLayout.SOUTH);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.pack();
        ventana.setVisible(true);
    }
    public void creaGUI() {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                GUI();
            }
        });
    }

    public void cambiaNombre(String nombre) {
        jtfNombre.setText(nombre);
    }
}
