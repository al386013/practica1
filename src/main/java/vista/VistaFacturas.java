package vista;

import controlador.Controlador;
import modelo.InterrogaModelo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VistaFacturas implements InformaVista, InterrogaVista {
    private Controlador controlador;
    private InterrogaModelo modelo;

    public VistaFacturas() {}

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

        //EMITIR FACTURA

        JPanel emitirFactura = new JPanel();
        JPanel emitirFacturaTitulo = new JPanel();
        JPanel emitirFacturaCampos = new JPanel();
        JPanel emitirFacturaIzq = new JPanel();
        JPanel emitirFacturaDer = new JPanel();

        JLabel nifLabel = new JLabel("NIF cliente: ");
        JLabel fechaIniFacLabel = new JLabel("Fecha inicio:     ");
        JLabel fechaFinFacLabel = new JLabel("Fecha fin: ");

        JTextField nif = new JTextField(14);
        JTextField fechaIniFac = new JTextField(14);
        JTextField fechaFinFac = new JTextField(14);
        nif.setText("NIF");
        fechaIniFac.setText("aaaa-mm-dd");
        fechaFinFac.setText("aaaa-mm-dd");

        emitirFacturaIzq.setLayout(new GridLayout(3,1));
        emitirFacturaDer.setLayout(new GridLayout(3,1));
        emitirFacturaIzq.add(nifLabel);
        emitirFacturaIzq.add(fechaIniFacLabel);
        emitirFacturaIzq.add(fechaFinFacLabel);
        emitirFacturaDer.add(nif);
        emitirFacturaDer.add(fechaIniFac);
        emitirFacturaDer.add(fechaFinFac);

        emitirFacturaCampos.setLayout(new BoxLayout(emitirFacturaCampos, BoxLayout.X_AXIS));
        emitirFacturaCampos.add(emitirFacturaIzq);
        emitirFacturaCampos.add(emitirFacturaDer);

        ActionListener escuchadorBoton = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Botón " + e.getActionCommand() + " pulsado.");
            }
        };

        JButton botonFactura = new JButton("Guardar");
        botonFactura.setActionCommand("factura");
        botonFactura.addActionListener(escuchadorBoton);
        botonFactura.setAlignmentX(Component.CENTER_ALIGNMENT);
        emitirFacturaCampos.add(botonFactura);

        emitirFactura.setLayout(new BoxLayout(emitirFactura, BoxLayout.PAGE_AXIS));
        emitirFacturaTitulo.add(new JLabel( "<html>" + "<b><i>EMITIR FACTURA</i></b><br/>" + "</html>"));
        emitirFactura.add(emitirFacturaTitulo);
        emitirFactura.add(emitirFacturaCampos);

        //MOSTRAR DATOS FACTURA

        JPanel datosFactura = new JPanel();
        JPanel datosFacturaTitulo = new JPanel();
        JPanel datosFacturaCampos = new JPanel();
        JPanel datosFacturaIzq = new JPanel();
        JPanel datosFacturaDer = new JPanel();

        JLabel codFacLabel = new JLabel("Código factura:     ");
        JTextField codFac = new JTextField(16);
        codFac.setText("Código");

        datosFacturaIzq.setLayout(new GridLayout(1,1));
        datosFacturaDer.setLayout(new GridLayout(1,1));
        datosFacturaIzq.add(codFacLabel);
        datosFacturaDer.add(codFac);

        datosFacturaCampos.setLayout(new BoxLayout(datosFacturaCampos, BoxLayout.X_AXIS));
        datosFacturaCampos.add(datosFacturaIzq);
        datosFacturaCampos.add(datosFacturaDer);

        JButton botonMostrarFac = new JButton("Mostrar");
        botonMostrarFac.setActionCommand("llamadasCli");
        botonMostrarFac.addActionListener(escuchadorBoton);
        botonMostrarFac.setAlignmentX(Component.CENTER_ALIGNMENT);
        datosFacturaCampos.add(botonMostrarFac);

        datosFactura.setLayout(new BoxLayout(datosFactura, BoxLayout.PAGE_AXIS));
        datosFacturaTitulo.add(new JLabel( "<html>" + "<b><i>MOSTRAR DATOS FACTURA</i></b><br/>" + "</html>"));
        datosFactura.add(datosFacturaTitulo);
        datosFactura.add(datosFacturaCampos);

        //LISTADO TODAS LAS FACTURAS DE UN CLIENTE

        JPanel facturasCli = new JPanel();
        JPanel facturasCliTitulo = new JPanel();
        JPanel facturasCliCampos = new JPanel();
        JPanel facturasCliIzq = new JPanel();
        JPanel facturasCliDer = new JPanel();

        JLabel nifLabel2 = new JLabel("NIF cliente: ");
        JTextField nif2 = new JTextField(14);
        nif2.setText("NIF");

        facturasCliIzq.setLayout(new GridLayout(1,1));
        facturasCliDer.setLayout(new GridLayout(1,1));
        facturasCliIzq.add(nifLabel2);
        facturasCliDer.add(nif2);

        facturasCliCampos.setLayout(new BoxLayout(facturasCliCampos, BoxLayout.X_AXIS));
        facturasCliCampos.add(facturasCliIzq);
        facturasCliCampos.add(facturasCliDer);

        JButton botonFacturasCli = new JButton("Listar");
        botonFacturasCli.setActionCommand("llamadasCli");
        botonFacturasCli.addActionListener(escuchadorBoton);
        botonFacturasCli.setAlignmentX(Component.CENTER_ALIGNMENT);
        facturasCliCampos.add(botonFacturasCli);

        facturasCli.setLayout(new BoxLayout(facturasCli, BoxLayout.PAGE_AXIS));
        facturasCliTitulo.add(new JLabel( "<html>" + "<b><i>LISTAR FACTURAS DE UN CLIENTE</i></b><br/>" + "</html>"));
        facturasCli.add(facturasCliTitulo);
        facturasCli.add(facturasCliCampos);


        //LISTADO FACTURAS ENTRE FECHAS DE UN CLIENTE

        JPanel facturasCliEntreFechas = new JPanel();
        JPanel facturasCliFechasTitulo = new JPanel();
        JPanel facturasCliFechasCampos = new JPanel();
        JPanel facturasCliFechasIzq = new JPanel();
        JPanel facturasCliFechasDer = new JPanel();

        JLabel nifLabel3 = new JLabel("NIF cliente: ");
        JLabel fechaIniLabel = new JLabel("Fecha inicio: ");
        JLabel fechaFinLabel = new JLabel("Fecha fin:  ");

        JTextField nif3 = new JTextField(15);
        JTextField fechaIni = new JTextField(15);
        JTextField fechaFin = new JTextField(15);
        nif3.setText("NIF");
        fechaIni.setText("aaaa-mm-dd");
        fechaFin.setText("aaaa-mm-dd");

        facturasCliFechasIzq.setLayout(new GridLayout(3,1));
        facturasCliFechasDer.setLayout(new GridLayout(3,1));
        facturasCliFechasIzq.add(nifLabel3);
        facturasCliFechasIzq.add(fechaIniLabel);
        facturasCliFechasIzq.add(fechaFinLabel);
        facturasCliFechasDer.add(nif3);
        facturasCliFechasDer.add(fechaIni);
        facturasCliFechasDer.add(fechaFin);

        facturasCliFechasCampos.setLayout(new BoxLayout(facturasCliFechasCampos, BoxLayout.X_AXIS));
        facturasCliFechasCampos.add(facturasCliFechasIzq);
        facturasCliFechasCampos.add(facturasCliFechasDer);

        JButton botonFacturasCliFechas = new JButton("Listar");
        botonFacturasCliFechas.setActionCommand("facturasCliFechas");
        botonFacturasCliFechas.addActionListener(escuchadorBoton);
        botonFacturasCliFechas.setAlignmentX(Component.CENTER_ALIGNMENT);
        facturasCliFechasCampos.add(botonFacturasCliFechas);

        facturasCliEntreFechas.setLayout(new BoxLayout(facturasCliEntreFechas, BoxLayout.PAGE_AXIS));
        facturasCliFechasTitulo.add(new JLabel( "<html>" + "<b><i>LISTAR LLAMADAS DE UN CLIENTE ENTRE FECHAS</i></b><br/>" + "</html>"));
        facturasCliEntreFechas.add(facturasCliFechasTitulo);
        facturasCliEntreFechas.add(facturasCliFechasCampos);



        contenedor.setLayout(new BoxLayout(contenedor, BoxLayout.PAGE_AXIS));
        contenedor.add(emitirFactura);
        contenedor.add(datosFactura);
        contenedor.add(facturasCli);
        contenedor.add(facturasCliEntreFechas);

        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.pack();
        ventana.setVisible(true);
    }
}
