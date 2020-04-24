package vista;

import controlador.Controlador;
import modelo.InterrogaModelo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VistaLlamadas implements InformaVista, InterrogaVista {
    private Controlador controlador;
    private InterrogaModelo modelo;

    public VistaLlamadas() {}

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
                ventana();
            }
        });
    }

    public void ventana() {
        JFrame ventana = new JFrame("Gestión Clientes");
        Container contenedor = ventana.getContentPane();

        //DAR DE ALTA LLAMADA

        JPanel darAltaLlamada = new JPanel();
        JPanel darAltaLlamadaTitulo = new JPanel();
        JPanel darAltaLlamadaCampos = new JPanel();
        JPanel darAltaLlamadaIzq = new JPanel();
        JPanel darAltaLlamadaDer = new JPanel();

        JLabel telfOrigenLabel = new JLabel("Teléfono origen: ");
        JLabel telfDestLabel = new JLabel("Teléfono destino:    ");
        JLabel duracionLabel = new JLabel("Duración: ");

        JTextField telfOrigen = new JTextField(17);
        JTextField telfDestino = new JTextField(17);
        JTextField duracion = new JTextField(17);
        telfOrigen.setText("Teléfono origen");
        telfDestino.setText("Teléfono destino");
        duracion.setText("Duración en segundos");

        darAltaLlamadaIzq.setLayout(new GridLayout(3,1));
        darAltaLlamadaDer.setLayout(new GridLayout(3,1));
        darAltaLlamadaIzq.add(telfOrigenLabel);
        darAltaLlamadaIzq.add(telfDestLabel);
        darAltaLlamadaIzq.add(duracionLabel);
        darAltaLlamadaDer.add(telfOrigen);
        darAltaLlamadaDer.add(telfDestino);
        darAltaLlamadaDer.add(duracion);

        darAltaLlamadaCampos.setLayout(new BoxLayout(darAltaLlamadaCampos, BoxLayout.X_AXIS));
        darAltaLlamadaCampos.add(darAltaLlamadaIzq);
        darAltaLlamadaCampos.add(darAltaLlamadaDer);

        ActionListener escuchadorBoton = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Botón " + e.getActionCommand() + " pulsado.");
            }
        };

        JButton botonLlamada = new JButton("Guardar");
        botonLlamada.setActionCommand("llamada");
        botonLlamada.addActionListener(escuchadorBoton);
        botonLlamada.setAlignmentX(Component.CENTER_ALIGNMENT);
        darAltaLlamadaCampos.add(botonLlamada);

        darAltaLlamada.setLayout(new BoxLayout(darAltaLlamada, BoxLayout.PAGE_AXIS));
        darAltaLlamadaTitulo.add(new JLabel( "<html>" + "<b><i>DAR DE ALTA LLAMADA</i></b><br/>" + "</html>"));
        darAltaLlamada.add(darAltaLlamadaTitulo);
        darAltaLlamada.add(darAltaLlamadaCampos);

        //LISTADO TODAS LAS LLAMADAS DE UN CLIENTE

        JPanel llamadasCli = new JPanel();
        JPanel llamadasCliTitulo = new JPanel();
        JPanel llamadasCliCampos = new JPanel();
        JPanel llamadasCliIzq = new JPanel();
        JPanel llamadasCliDer = new JPanel();

        JLabel telfLabel = new JLabel("Teléfono: ");
        JTextField telf = new JTextField(13);
        telf.setText("Teléfono");

        llamadasCliIzq.setLayout(new GridLayout(1,1));
        llamadasCliDer.setLayout(new GridLayout(1,1));
        llamadasCliIzq.add(telfLabel);
        llamadasCliDer.add(telf);

        llamadasCliCampos.setLayout(new BoxLayout(llamadasCliCampos, BoxLayout.X_AXIS));
        llamadasCliCampos.add(llamadasCliIzq);
        llamadasCliCampos.add(llamadasCliDer);

        JButton botonLlamadasCli = new JButton("Listar");
        botonLlamadasCli.setActionCommand("llamadasCli");
        botonLlamadasCli.addActionListener(escuchadorBoton);
        botonLlamadasCli.setAlignmentX(Component.CENTER_ALIGNMENT);
        llamadasCliCampos.add(botonLlamadasCli);

        llamadasCli.setLayout(new BoxLayout(llamadasCli, BoxLayout.PAGE_AXIS));
        llamadasCliTitulo.add(new JLabel( "<html>" + "<b><i>LISTAR LLAMADAS DE UN CLIENTE</i></b><br/>" + "</html>"));
        llamadasCli.add(llamadasCliTitulo);
        llamadasCli.add(llamadasCliCampos);

        //LISTADO LLAMADAS ENTRE FECHAS DE UN CLIENTE

        JPanel llamadasCliEntreFechas = new JPanel();
        JPanel llamadasCliFechasTitulo = new JPanel();
        JPanel llamadasCliFechasCampos = new JPanel();
        JPanel llamadasCliFechasIzq = new JPanel();
        JPanel llamadasCliFechasDer = new JPanel();

        JLabel telfLabel2 = new JLabel("Teléfono: ");
        JLabel fechaIniLabel = new JLabel("Fecha inicio: ");
        JLabel fechaFinLabel = new JLabel("Fecha fin:  ");

        JTextField telf2 = new JTextField(15);
        JTextField fechaIni = new JTextField(15);
        JTextField fechaFin = new JTextField(15);
        telf2.setText("Teléfono");
        fechaIni.setText("aaaa-mm-dd");
        fechaFin.setText("aaaa-mm-dd");

        llamadasCliFechasIzq.setLayout(new GridLayout(3,1));
        llamadasCliFechasDer.setLayout(new GridLayout(3,1));
        llamadasCliFechasIzq.add(telfLabel2);
        llamadasCliFechasIzq.add(fechaIniLabel);
        llamadasCliFechasIzq.add(fechaFinLabel);
        llamadasCliFechasDer.add(telf2);
        llamadasCliFechasDer.add(fechaIni);
        llamadasCliFechasDer.add(fechaFin);

        llamadasCliFechasCampos.setLayout(new BoxLayout(llamadasCliFechasCampos, BoxLayout.X_AXIS));
        llamadasCliFechasCampos.add(llamadasCliFechasIzq);
        llamadasCliFechasCampos.add(llamadasCliFechasDer);

        JButton botonLlamadasCliFechas = new JButton("Listar");
        botonLlamadasCliFechas.setActionCommand("llamadasCliFechas");
        botonLlamadasCliFechas.addActionListener(escuchadorBoton);
        botonLlamadasCliFechas.setAlignmentX(Component.CENTER_ALIGNMENT);
        llamadasCliFechasCampos.add(botonLlamadasCliFechas);

        llamadasCliEntreFechas.setLayout(new BoxLayout(llamadasCliEntreFechas, BoxLayout.PAGE_AXIS));
        llamadasCliFechasTitulo.add(new JLabel( "<html>" + "<b><i>LISTAR LLAMADAS DE UN CLIENTE ENTRE FECHAS</i></b><br/>" + "</html>"));
        llamadasCliEntreFechas.add(llamadasCliFechasTitulo);
        llamadasCliEntreFechas.add(llamadasCliFechasCampos);


        contenedor.setLayout(new BoxLayout(contenedor, BoxLayout.PAGE_AXIS));
        contenedor.add(darAltaLlamada);
        contenedor.add(llamadasCli);
        contenedor.add(llamadasCliEntreFechas);

        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.pack();
        ventana.setVisible(true);
    }
}
