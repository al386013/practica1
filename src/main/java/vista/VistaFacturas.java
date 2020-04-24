package vista;

import controlador.Controlador;
import modelo.InterrogaModelo;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;

public class VistaFacturas implements InterrogaVistaFacturas {
    private Controlador controlador;
    private InterrogaModelo modelo;
    private JTextField nifFac;
    private JTextField fechaIniFac;
    private JTextField fechaFinFac;
    private JTextField codFac;
    private JTextField nifFacCli;
    private JTextField nifFechas;
    private JTextField fechaIniFechas;
    private JTextField fechaFinFechas;

    public VistaFacturas() { super(); }

    public void setModelo(InterrogaModelo modelo) {
        this.modelo = modelo;
    }

    public void setControlador(Controlador controlador) {
        this.controlador = controlador;
    }

    public JPanel panel() {

        ActionListener escuchadorBoton = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Botón " + e.getActionCommand() + " pulsado.");
                String comando = e.getActionCommand();
                if(comando.equals("importar"))
                    controlador.importarDatos();
                else if(comando.equals("guardarFactura"))
                    controlador.emitirFactura();
                else if(comando.equals("datosFac"))
                    controlador.datosFactura();
                else if(comando.equals("facturasCli"))
                    controlador.listarFacCli();
                else
                    controlador.listarFacCliFechas();
            }
        };

        JPanel importarPanel = new JPanel();
        JButton importarBoton = new JButton("Importar datos");
        importarBoton.setActionCommand("importar");
        importarBoton.addActionListener(escuchadorBoton);
        importarPanel.add(importarBoton);

        //EMITIR FACTURA

        JPanel emitirFactura = new JPanel();
        JPanel emitirFacturaTitulo = new JPanel();
        JPanel emitirFacturaCampos = new JPanel();
        JPanel emitirFacturaIzq = new JPanel();
        JPanel emitirFacturaDer = new JPanel();

        JLabel nifLabel = new JLabel("NIF cliente: ");
        JLabel fechaIniFacLabel = new JLabel("Fecha inicio: ");
        JLabel fechaFinFacLabel = new JLabel("Fecha fin: ");

        nifFac = new JTextField(14);
        fechaIniFac = new JTextField(14);
        fechaFinFac = new JTextField(14);
        nifFac.setText("NIF");
        fechaIniFac.setText("aaaa-mm-dd");
        fechaFinFac.setText("aaaa-mm-dd");

        emitirFacturaIzq.setLayout(new GridLayout(3,1));
        emitirFacturaDer.setLayout(new GridLayout(3,1));
        emitirFacturaIzq.add(nifLabel);
        emitirFacturaIzq.add(fechaIniFacLabel);
        emitirFacturaIzq.add(fechaFinFacLabel);
        emitirFacturaDer.add(nifFac);
        emitirFacturaDer.add(fechaIniFac);
        emitirFacturaDer.add(fechaFinFac);

        emitirFacturaCampos.setLayout(new BoxLayout(emitirFacturaCampos, BoxLayout.X_AXIS));
        emitirFacturaCampos.add(emitirFacturaIzq);
        emitirFacturaCampos.add(emitirFacturaDer);

        JButton botonFactura = new JButton("Guardar");
        botonFactura.setActionCommand("guardarFactura");
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
        codFac = new JTextField(16);
        codFac.setText("Código");

        datosFacturaIzq.setLayout(new GridLayout(1,1));
        datosFacturaDer.setLayout(new GridLayout(1,1));
        datosFacturaIzq.add(codFacLabel);
        datosFacturaDer.add(codFac);

        datosFacturaCampos.setLayout(new BoxLayout(datosFacturaCampos, BoxLayout.X_AXIS));
        datosFacturaCampos.add(datosFacturaIzq);
        datosFacturaCampos.add(datosFacturaDer);

        JButton botonMostrarFac = new JButton("Mostrar");
        botonMostrarFac.setActionCommand("datosFac");
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
        nifFacCli = new JTextField(14);
        nifFacCli.setText("NIF");

        facturasCliIzq.setLayout(new GridLayout(1,1));
        facturasCliDer.setLayout(new GridLayout(1,1));
        facturasCliIzq.add(nifLabel2);
        facturasCliDer.add(nifFacCli);

        facturasCliCampos.setLayout(new BoxLayout(facturasCliCampos, BoxLayout.X_AXIS));
        facturasCliCampos.add(facturasCliIzq);
        facturasCliCampos.add(facturasCliDer);

        JButton botonFacturasCli = new JButton("Listar");
        botonFacturasCli.setActionCommand("facturasCli");
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

        nifFechas = new JTextField(15);
        fechaIniFechas = new JTextField(15);
        fechaFinFechas = new JTextField(15);
        nifFechas.setText("NIF");
        fechaIniFechas.setText("aaaa-mm-dd");
        fechaFinFechas.setText("aaaa-mm-dd");

        facturasCliFechasIzq.setLayout(new GridLayout(3,1));
        facturasCliFechasDer.setLayout(new GridLayout(3,1));
        facturasCliFechasIzq.add(nifLabel3);
        facturasCliFechasIzq.add(fechaIniLabel);
        facturasCliFechasIzq.add(fechaFinLabel);
        facturasCliFechasDer.add(nifFechas);
        facturasCliFechasDer.add(fechaIniFechas);
        facturasCliFechasDer.add(fechaFinFechas);

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

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
        panel.add(importarPanel);
        panel.add(emitirFactura);
        panel.add(datosFactura);
        panel.add(facturasCli);
        panel.add(facturasCliEntreFechas);
        return panel;
    }

    @Override
    public String getNifFac() {
        return nifFac.getText();
    }

    @Override
    public LocalDate getFechaIniFac() {
        return LocalDate.parse(fechaIniFac.getText());
    }

    @Override
    public LocalDate getFechaFinFac() {
        return LocalDate.parse(fechaFinFac.getText());
    }

    @Override
    public int getCodFac() {
        return Integer.parseInt(codFac.getText());
    }

    @Override
    public String getNifFacCli() {
        return nifFacCli.getText();
    }

    @Override
    public String getNifFechas() {
        return nifFechas.getText();
    }

    @Override
    public LocalDate getFechaIniFechas() {
        return LocalDate.parse(fechaIniFechas.getText());
    }

    @Override
    public LocalDate getFechasFinFechas() {
        return LocalDate.parse(fechaFinFechas.getText());
    }
}
