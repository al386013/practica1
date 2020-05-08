package vista;

import controlador.Controlador;
import modelo.InterrogaModelo;
import modelo.datos.contrato.Factura;
import modelo.principal.*;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.Collection;

public class PanelFacturas extends JPanel implements InterrogaVistaFacturas {
    private Controlador controlador;
    private InterrogaModelo modelo;
    private InformaVista vista;
    private Tabla tabla;
    private ModeloTabla<Factura> modeloTabla;
    private JPanel titulo;
    private JTextField nifFac;
    private JTextField fechaIniFac;
    private JTextField fechaFinFac;
    private JTextField codFac;
    private JTextField nifFacCli;
    private JTextField nifFechas;
    private JTextField fechaIniFechas;
    private JTextField fechaFinFechas;

    public PanelFacturas() {
        super();
        panel();
    }

    public void setModelo(InterrogaModelo modelo) {
        this.modelo = modelo;
    }

    public void setControlador(Controlador controlador) {
        this.controlador = controlador;
    }

    public void setVista(InformaVista vista) {
        this.vista = vista;
    }

    public void panel() {
        //escuchador de los botones que llama al controlador en funcion del boton pulsado
        ActionListener escuchadorBoton = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evento) {
                String comando = evento.getActionCommand();
                try {
                    if (comando.equals("guardarFactura")) {
                        controlador.emitirFactura();
                        vista.accionCorrecta("Factura del cliente emitida con éxito.");
                    } else if (comando.equals("datosFac"))
                        controlador.datosFactura();
                    else if (comando.equals("facturasCli")) {
                        controlador.listarFacCli();
                    } else
                        controlador.listarFacCliFechas();
                } catch (NifNoExistenteException | IntervaloFechasIncorrectoException e) {
                    vista.accionDenegada(e.getMessage());
                }
            }
        };

        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));

        //EMITIR FACTURA

        titulo = new JPanel();
        JPanel panelCampos = new JPanel();
        JPanel panelIzq = new JPanel();
        JPanel panelDer = new JPanel();
        JPanel panelSeccion = new JPanel();

        nifFac = new JTextField(14);
        fechaIniFac = new JTextField(14);
        fechaFinFac = new JTextField(14);
        nifFac.setText("Escribe NIF");
        fechaIniFac.setText("aaaa-mm-dd");
        fechaFinFac.setText("aaaa-mm-dd");

        panelIzq.setLayout(new GridLayout(3, 1));
        panelDer.setLayout(new GridLayout(3, 1));
        panelIzq.add(new JLabel("NIF cliente: "));
        panelIzq.add(new JLabel("Fecha inicio: "));
        panelIzq.add(new JLabel("Fecha fin: "));
        panelDer.add(nifFac);
        panelDer.add(fechaIniFac);
        panelDer.add(fechaFinFac);

        panelCampos.setLayout(new BoxLayout(panelCampos, BoxLayout.X_AXIS));
        panelCampos.add(panelIzq);
        panelCampos.add(panelDer);

        JButton botonFactura = new JButton("Guardar");
        botonFactura.setActionCommand("guardarFactura");
        botonFactura.addActionListener(escuchadorBoton);
        botonFactura.setAlignmentX(Component.CENTER_ALIGNMENT);
        panelCampos.add(botonFactura);

        panelSeccion.setLayout(new BoxLayout(panelSeccion, BoxLayout.PAGE_AXIS));
        titulo.add(new JLabel("<html><i>EMITIR FACTURA</i></html>"));
        panelSeccion.add(titulo);
        panelSeccion.add(panelCampos);
        add(panelSeccion);

        //MOSTRAR DATOS FACTURA

        titulo = new JPanel();
        panelCampos = new JPanel();
        panelIzq = new JPanel();
        panelDer = new JPanel();
        panelSeccion = new JPanel();

        codFac = new JTextField(16);
        codFac.setText("Escibe código");

        panelIzq.setLayout(new GridLayout(1, 1));
        panelDer.setLayout(new GridLayout(1, 1));
        panelIzq.add(new JLabel("Código factura: "));
        panelDer.add(codFac);

        panelCampos.setLayout(new BoxLayout(panelCampos, BoxLayout.X_AXIS));
        panelCampos.add(panelIzq);
        panelCampos.add(panelDer);

        JButton botonMostrarFac = new JButton("Mostrar");
        botonMostrarFac.setActionCommand("datosFac");
        botonMostrarFac.addActionListener(escuchadorBoton);
        botonMostrarFac.setAlignmentX(Component.CENTER_ALIGNMENT);
        panelCampos.add(botonMostrarFac);

        panelSeccion.setLayout(new BoxLayout(panelSeccion, BoxLayout.PAGE_AXIS));
        titulo.add(new JLabel("<html><i>MOSTRAR DATOS FACTURA</i></html>"));
        panelSeccion.add(titulo);
        panelSeccion.add(panelCampos);
        add(panelSeccion);

        //LISTADO TODAS LAS FACTURAS DE UN CLIENTE

        titulo = new JPanel();
        panelCampos = new JPanel();
        panelIzq = new JPanel();
        panelDer = new JPanel();
        panelSeccion = new JPanel();

        nifFacCli = new JTextField(14);
        nifFacCli.setText("Escribe NIF");

        panelIzq.setLayout(new GridLayout(1, 1));
        panelDer.setLayout(new GridLayout(1, 1));
        panelIzq.add(new JLabel("NIF cliente: "));
        panelDer.add(nifFacCli);

        panelCampos.setLayout(new BoxLayout(panelCampos, BoxLayout.X_AXIS));
        panelCampos.add(panelIzq);
        panelCampos.add(panelDer);

        JButton botonFacturasCli = new JButton("Listar");
        botonFacturasCli.setActionCommand("facturasCli");
        botonFacturasCli.addActionListener(escuchadorBoton);
        botonFacturasCli.setAlignmentX(Component.CENTER_ALIGNMENT);
        panelCampos.add(botonFacturasCli);

        panelSeccion.setLayout(new BoxLayout(panelSeccion, BoxLayout.PAGE_AXIS));
        titulo.add(new JLabel("<html><i>LISTAR FACTURAS DE UN CLIENTE</i></html>"));
        panelSeccion.add(titulo);
        panelSeccion.add(panelCampos);
        add(panelSeccion);

        //LISTADO FACTURAS ENTRE FECHAS DE UN CLIENTE

        titulo = new JPanel();
        panelCampos = new JPanel();
        panelIzq = new JPanel();
        panelDer = new JPanel();
        panelSeccion = new JPanel();

        nifFechas = new JTextField(15);
        fechaIniFechas = new JTextField(15);
        fechaFinFechas = new JTextField(15);
        nifFechas.setText("Escribe NIF");
        fechaIniFechas.setText("aaaa-mm-dd");
        fechaFinFechas.setText("aaaa-mm-dd");

        panelIzq.setLayout(new GridLayout(3, 1));
        panelDer.setLayout(new GridLayout(3, 1));
        panelIzq.add(new JLabel("NIF cliente: "));
        panelIzq.add(new JLabel("Fecha inicio: "));
        panelIzq.add(new JLabel("Fecha fin:  "));
        panelDer.add(nifFechas);
        panelDer.add(fechaIniFechas);
        panelDer.add(fechaFinFechas);

        panelCampos.setLayout(new BoxLayout(panelCampos, BoxLayout.X_AXIS));
        panelCampos.add(panelIzq);
        panelCampos.add(panelDer);

        JButton botonFacturasCliFechas = new JButton("Listar");
        botonFacturasCliFechas.setActionCommand("facturasCliFechas");
        botonFacturasCliFechas.addActionListener(escuchadorBoton);
        botonFacturasCliFechas.setAlignmentX(Component.CENTER_ALIGNMENT);
        panelCampos.add(botonFacturasCliFechas);

        panelSeccion.setLayout(new BoxLayout(panelSeccion, BoxLayout.PAGE_AXIS));
        titulo.add(new JLabel("<html><i>LISTAR FACTURAS DE UN CLIENTE ENTRE FECHAS</i></html>"));
        panelSeccion.add(titulo);
        panelSeccion.add(panelCampos);
        add(panelSeccion);
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

    @Override
    public void listadoFacturas(String nif) {
        listadoFacturasEntreFechas(nif, LocalDate.now(), LocalDate.parse("1990-01-01"));
    }

    //muestra las facturas del cliente en una tabla
    @Override
    public void listadoFacturasEntreFechas(String nif, LocalDate fechaIni, LocalDate fechaFin) {
        //crea la ventana y el texto
        JFrame ventana = new JFrame("Listado facturas");
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
        titulo = new JPanel();
        titulo.add(new JLabel("<html><i><big>FACTURAS DEL CLIENTE<big></i></html>"));
        panel.add(titulo);
        titulo = new JPanel();
        titulo.add(new JLabel("<html>Pulsa sobre una fila para más información.</html>"));
        panel.add(titulo);

        //crear modeloTabla y tabla
        String[] columnas = {"Codigo", "Fecha factura", "Hora", "Importe",
                "Fecha inicio", "Fecha fin"};
        BaseDeDatos baseDeDatos = modelo.getBaseDeDatos();
        Collection<Factura> facturas = baseDeDatos.devolverFacturas(nif);
        modeloTabla = new ModeloTabla<>(columnas, baseDeDatos.entreFechas(facturas, fechaIni, fechaFin));
        tabla = new Tabla(modeloTabla);

        //crea el escuchador de la tabla
        ListSelectionListener escuchadorTabla = new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                //si se ejecuta este metodo porque se da al boton de actualizar
                //y no se selecciona ninguna fila
                ListSelectionModel lsm = (ListSelectionModel)e.getSource();
                if(lsm.getMinSelectionIndex() == -1) return;

                if (!e.getValueIsAdjusting()) {
                    int fila = tabla.convertRowIndexToModel(tabla.getSelectedRow());
                    int codTabla = (Integer) modeloTabla.getValueAt(fila, 0);
                    datosFactura(codTabla);
                }
            }
        };

        //crear escuchador para el boton actualizar tabla
        ActionListener escuchadorActualizar = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evento) {
                tabla.setModel(modeloTabla = new ModeloTabla<>(columnas, facturas));
                tabla.anchoColumnas();
            }
        };

        //clase generica comun al resto de tablas
        ScrollYBoton<Factura> scrollYBoton = new ScrollYBoton<>();
        JPanel panel2 = scrollYBoton.ejecuta(tabla, panel, escuchadorActualizar, escuchadorTabla);

        Container contenedor = ventana.getContentPane();
        contenedor.add(panel);
        contenedor.add(panel2);

        ventana.getContentPane().add(panel);
        ventana.setSize(1200, 300);
        ventana.setVisible(true);
    }

    //lista los datos de una factura
    @Override
    public void datosFactura(int cod) {
        JFrame ventana = new JFrame("Datos de la factura");
        JLabel texto = new JLabel(modelo.getBaseDeDatos().listarDatosFactura(cod));
        ventana.getContentPane().add(texto);
        ventana.pack();
        ventana.setVisible(true);
    }
}
