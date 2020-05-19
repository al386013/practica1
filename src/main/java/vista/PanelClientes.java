package vista;

import controlador.Controlador;
import modelo.InterrogaModelo;
import modelo.datos.clientes.Cliente;
import modelo.principal.*;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.Collection;

public class PanelClientes extends JPanel implements InterrogaVistaClientes {
    private Controlador controlador;
    private InterrogaModelo modelo;
    private InformaVista vista;
    private Tabla tabla;
    private ModeloTabla<Cliente> modeloTabla;
    private JPanel titulo;
    private JTextField nifAnadir;
    private JTextField nombre;
    private JTextField apellido;
    private JTextField telfAnadir;
    private JTextField email;
    private JTextField provincia;
    private JTextField poblacion;
    private JTextField cp;
    private JTextField telfBorrar;
    private JTextField nifTarifa;
    private JTextField nifCli;
    private JTextField fechaIni;
    private JTextField fechaFin;
    private String tipoClienteOpcion;
    private String tipoTarifaOpcion;

    public PanelClientes() {
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

    private void anadir() throws NifRepetidoException, TelfRepetidoException {
        if (tipoClienteOpcion == null)
            vista.accionDenegada("No se ha seleccionado un tipo de cliente");
        else {
            controlador.anadirCliente();
            vista.accionCorrecta("Cliente guardado correctamente.");
        }
    }

    private void borrar() throws TelfNoExistenteException {
        controlador.borrarCliente();
        vista.accionCorrecta("Cliente borrado con éxito.");
    }

    private void tarifa() throws NifNoExistenteException {
        if (tipoTarifaOpcion == null)
            vista.accionDenegada("No se ha seleccionado un tipo de tarifa");
        else {
            controlador.contratarTarifa();
            vista.accionCorrecta("Tarifa especial " + tipoTarifaOpcion + " contratada." );
        }
    }


    public void panel() {
        //escuchador de los botones que llama al controlador en funcion del boton pulsado
        ActionListener escuchadorBoton = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evento) {
                String comando = evento.getActionCommand();
                try {
                    switch (comando) {
                        case "anadir":
                            anadir();
                            break;
                        case "borrar":
                            borrar();
                            break;
                        case "tarifa":
                            tarifa();
                            break;
                        case "datosCli":
                            controlador.datosCliente();
                            break;
                        case "listarCli": //la vista muestra la tabla con los clientes
                            listadoClientes();
                            break;
                        default:
                            controlador.listarCliFechas();
                            break;
                    }
                } catch (NifRepetidoException | TelfRepetidoException | TelfNoExistenteException | NifNoExistenteException |
                        IntervaloFechasIncorrectoException e) {
                    vista.accionDenegada(e.getMessage());
                }
            }
        };

        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));

        //ANADIR CLIENTE

        titulo = new JPanel();
        JPanel panelCampos = new JPanel();
        JPanel panelIzq = new JPanel();
        JPanel panelDer = new JPanel();
        JPanel panelSeccion = new JPanel();
        JPanel panelTipo = new JPanel();

        JRadioButton particular = new JRadioButton("Particular");
        JRadioButton empresa = new JRadioButton("Empresa");
        particular.setActionCommand("particular");
        empresa.setActionCommand("empresa");
        ActionListener escuchadorClientes = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tipoClienteOpcion = e.getActionCommand();
            }
        };

        particular.addActionListener(escuchadorClientes);
        empresa.addActionListener(escuchadorClientes);
        panelTipo.add(new JLabel("Elije el tipo de cliente:"));
        panelTipo.add(particular);
        panelTipo.add(empresa);

        ButtonGroup grupoTipoCli = new ButtonGroup();
        grupoTipoCli.add(particular);
        grupoTipoCli.add(empresa);

        nifAnadir = new JTextField(25);
        nifAnadir.setText("Escribe NIF");
        nombre = new JTextField(25);
        nombre.setText("Escribe nombre");
        apellido = new JTextField(25);
        apellido.setText("Escribe apellido si particular");
        telfAnadir = new JTextField(25);
        telfAnadir.setText("Escribe teléfono");
        email = new JTextField(25);
        email.setText("Escribe email");
        provincia = new JTextField(25);
        provincia.setText("Escribe provincia");
        poblacion = new JTextField(25);
        poblacion.setText("Escribe población");
        cp = new JTextField(25);
        cp.setText("Escribe CP");

        panelIzq.setLayout(new GridLayout(8, 1));
        panelDer.setLayout(new GridLayout(8, 1));

        panelIzq.add(new JLabel("NIF: "));
        panelIzq.add(new JLabel("Teléfono: "));
        panelIzq.add(new JLabel("Nombre: "));
        panelIzq.add(new JLabel("Apellidos: "));
        panelIzq.add(new JLabel("Email: "));
        panelIzq.add(new JLabel("Provincia: "));
        panelIzq.add(new JLabel("Población: "));
        panelIzq.add(new JLabel("Código Postal: "));

        panelDer.add(nifAnadir);
        panelDer.add(telfAnadir);
        panelDer.add(nombre);
        panelDer.add(apellido);
        panelDer.add(email);
        panelDer.add(provincia);
        panelDer.add(poblacion);
        panelDer.add(cp);

        panelCampos.setLayout(new BoxLayout(panelCampos, BoxLayout.X_AXIS));
        panelCampos.add(panelIzq);
        panelCampos.add(panelDer);

        JButton botonAnadir = new JButton("Añadir");
        botonAnadir.setActionCommand("anadir");
        botonAnadir.addActionListener(escuchadorBoton);
        panelTipo.add(botonAnadir);

        panelSeccion.setLayout(new BoxLayout(panelSeccion, BoxLayout.PAGE_AXIS));
        titulo.add(new JLabel("<html><i>AÑADIR CLIENTE</i></html>"));
        panelSeccion.add(titulo);
        panelSeccion.add(panelTipo);
        panelSeccion.add(panelCampos);
        add(panelSeccion);

        //BORRAR CLIENTE

        titulo = new JPanel();
        panelCampos = new JPanel();
        panelIzq = new JPanel();
        panelDer = new JPanel();
        panelSeccion = new JPanel();

        telfBorrar = new JTextField(16);
        telfBorrar.setText("Escribe teléfono");

        panelIzq.setLayout(new GridLayout(1, 1));
        panelDer.setLayout(new GridLayout(1, 1));
        panelIzq.add(new JLabel("Teléfono: "));
        panelDer.add(telfBorrar);

        panelCampos.setLayout(new BoxLayout(panelCampos, BoxLayout.X_AXIS));
        panelCampos.add(panelIzq);
        panelCampos.add(panelDer);

        JButton botonBorrar = new JButton("Borrar");
        botonBorrar.setActionCommand("borrar");
        botonBorrar.addActionListener(escuchadorBoton);
        panelCampos.add(botonBorrar);

        panelSeccion.setLayout(new BoxLayout(panelSeccion, BoxLayout.PAGE_AXIS));
        titulo.add(new JLabel("<html><i>BORRAR CLIENTE</i></html>"));
        panelSeccion.add(titulo);
        panelSeccion.add(panelCampos);
        add(panelSeccion);

        //CAMBIAR TARIFA

        titulo = new JPanel();
        panelCampos = new JPanel();
        panelIzq = new JPanel();
        panelDer = new JPanel();
        panelTipo = new JPanel();
        panelSeccion = new JPanel();

        nifTarifa = new JTextField(11);
        nifTarifa.setText("Escribe NIF");

        panelIzq.setLayout(new GridLayout(1, 1));
        panelDer.setLayout(new GridLayout(1, 1));
        panelIzq.add(new JLabel("NIF: "));
        panelDer.add(nifTarifa);

        panelCampos.setLayout(new BoxLayout(panelCampos, BoxLayout.X_AXIS));
        panelCampos.add(panelIzq);
        panelCampos.add(panelDer);

        ActionListener escuchadorTarifas = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tipoTarifaOpcion = e.getActionCommand();
            }
        };

        JRadioButton tardes = new JRadioButton("Tarifa tardes reducida");
        JRadioButton domingo = new JRadioButton("Tarifa domingos gratis");
        tardes.setActionCommand("tardes");
        domingo.setActionCommand("domingo");
        tardes.addActionListener(escuchadorTarifas);
        domingo.addActionListener(escuchadorTarifas);

        panelTipo.add(new JLabel("Elije el tipo de tarifa:"));
        panelTipo.add(tardes);
        panelTipo.add(domingo);

        ButtonGroup grupoTipoTarifas = new ButtonGroup();
        grupoTipoTarifas.add(tardes);
        grupoTipoTarifas.add(domingo);

        JButton botonTarifa = new JButton("Contratar");
        botonTarifa.setActionCommand("tarifa");
        botonTarifa.addActionListener(escuchadorBoton);
        panelCampos.add(botonTarifa);

        panelSeccion.setLayout(new BoxLayout(panelSeccion, BoxLayout.PAGE_AXIS));
        titulo.add(new JLabel("<html><i>CONTRATAR TARIFA ESPECIAL</i></html>"));
        panelSeccion.add(titulo);
        panelSeccion.add(panelTipo);
        panelSeccion.add(panelCampos);
        add(panelSeccion);

        //DATOS CLIENTE

        titulo = new JPanel();
        panelCampos = new JPanel();
        panelIzq = new JPanel();
        panelDer = new JPanel();
        panelSeccion = new JPanel();

        JLabel nifLabel3 = new JLabel("NIF: ");
        nifCli = new JTextField(12);
        nifCli.setText("Escribe NIF");

        panelIzq.setLayout(new GridLayout(1, 1));
        panelDer.setLayout(new GridLayout(1, 1));
        panelIzq.add(nifLabel3);
        panelDer.add(nifCli);

        panelCampos.setLayout(new BoxLayout(panelCampos, BoxLayout.X_AXIS));
        panelCampos.add(panelIzq);
        panelCampos.add(panelDer);

        JButton botonDatosCli = new JButton("Mostrar");
        botonDatosCli.setActionCommand("datosCli");
        botonDatosCli.addActionListener(escuchadorBoton);
        panelCampos.add(botonDatosCli);

        panelSeccion.setLayout(new BoxLayout(panelSeccion, BoxLayout.PAGE_AXIS));
        titulo.add(new JLabel("<html><i>MOSTRAR DATOS CLIENTE</i></html>"));
        panelSeccion.add(titulo);
        panelSeccion.add(panelCampos);
        add(panelSeccion);

        //LISTADO CLIENTES

        panelSeccion = new JPanel();
        JButton botonListarCli = new JButton("Listar");
        botonListarCli.setActionCommand("listarCli");
        botonListarCli.addActionListener(escuchadorBoton);

        panelSeccion.add(new JLabel("<html><i>LISTAR CLIENTES</i></html>"));
        panelSeccion.add(botonListarCli);
        add(panelSeccion);

        //LISTADO CLIENTES ENTRE FECHAS

        titulo = new JPanel();
        panelCampos = new JPanel();
        panelIzq = new JPanel();
        panelDer = new JPanel();
        panelSeccion = new JPanel();

        fechaIni = new JTextField(18);
        fechaFin = new JTextField(18);
        fechaIni.setText("aaaa-mm-dd");
        fechaFin.setText("aaaa-mm-dd");

        panelIzq.setLayout(new GridLayout(2, 1));
        panelDer.setLayout(new GridLayout(2, 1));
        panelIzq.add(new JLabel("Fecha inicio: "));
        panelIzq.add(new JLabel("Fecha fin: "));
        panelDer.add(fechaIni);
        panelDer.add(fechaFin);

        panelCampos.setLayout(new BoxLayout(panelCampos, BoxLayout.X_AXIS));
        panelCampos.add(panelIzq);
        panelCampos.add(panelDer);

        JButton botonListarCliFechas = new JButton("Listar");
        botonListarCliFechas.setActionCommand("listarCliFechas");
        botonListarCliFechas.addActionListener(escuchadorBoton);
        botonListarCliFechas.setAlignmentX(Component.CENTER_ALIGNMENT);
        panelCampos.add(botonListarCliFechas);

        panelSeccion.setLayout(new BoxLayout(panelSeccion, BoxLayout.PAGE_AXIS));
        titulo.add(new JLabel("<html><i>LISTAR CLIENTES ENTRE FECHAS</i></html>"));
        panelSeccion.add(titulo);
        panelSeccion.add(panelCampos);
        add(panelSeccion);
    }

    @Override
    public String getTipoCliente() {
        return tipoClienteOpcion;
    }

    @Override
    public String getNifAnadir() {
        return nifAnadir.getText();
    }

    @Override
    public String getNombre() {
        return nombre.getText();
    }

    @Override
    public String getApellido() {
        return apellido.getText();
    }

    @Override
    public String getTelfAnadir() {
        return telfAnadir.getText();
    }

    @Override
    public String getEmail() {
        return email.getText();
    }

    @Override
    public String getProvincia() {
        return provincia.getText();
    }

    @Override
    public String getPoblacion() {
        return poblacion.getText();
    }

    @Override
    public String getCP() {
        return cp.getText();
    }

    @Override
    public String getTelfBorrar() {
        return telfBorrar.getText();
    }

    @Override
    public String getNifTarifa() {
        return nifTarifa.getText();
    }

    @Override
    public String getTipoTarifa() {
        return tipoTarifaOpcion;
    }

    @Override
    public String getNifCli() {
        return nifCli.getText();
    }

    @Override
    public LocalDate getFechaIni() {
        return LocalDate.parse(fechaIni.getText());
    }

    @Override
    public LocalDate getFechaFin() {
        return LocalDate.parse(fechaFin.getText());
    }

    @Override
    public void listadoClientes() {
        listadoClientesEntreFechas(LocalDate.now(), LocalDate.parse("1990-01-01"));
    }

    //muestra los clientes en una tabla
    @Override
    public void listadoClientesEntreFechas(LocalDate fechaIni, LocalDate fechaFin) {
        //crea la ventana y el texto
        JFrame ventana = new JFrame("Listado clientes entre fechas");
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
        titulo = new JPanel();
        titulo.add(new JLabel("<html><i><big>CLIENTES<big></i></html>"));
        panel.add(titulo);
        titulo = new JPanel();
        titulo.add(new JLabel("<html>Pulsa sobre una fila para más información.</html>"));
        panel.add(titulo);

        //crea modeloTabla y tabla
        String[] columnas = {"DNI", "Telefono", "Nombre", "Apellidos", "Codigo Postal",
                "Poblacion", "Provincia", "E-mail", "Fecha de Alta", "Hora", "Tarifa"};

        BaseDeDatos baseDeDatos = modelo.getBaseDeDatos();
        Collection<Cliente> clientes = baseDeDatos.devolverClientes();
        modeloTabla = new ModeloTabla<>(columnas, baseDeDatos.entreFechas(clientes, fechaIni, fechaFin));
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
                    String nifTabla = (String) modeloTabla.getValueAt(fila, 0);
                    datosCliente(nifTabla);
                }
            }
        };

        //crear escuchador para el boton actualizar tabla
        ActionListener escuchadorActualizar = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evento) {
                tabla.setModel(modeloTabla = new ModeloTabla<>(columnas, clientes));
                tabla.anchoColumnas();
            }
        };

        //clase generica comun al resto de tablas
        ScrollYBoton<Cliente> scrollYBoton = new ScrollYBoton<>();
        JPanel panel2 = scrollYBoton.ejecuta(tabla, panel, escuchadorActualizar, escuchadorTabla);

        Container contenedor = ventana.getContentPane();
        contenedor.add(panel);
        contenedor.add(panel2);
        ventana.setSize(1200, 300);
        ventana.setVisible(true);
    }

    //lista los datos de un cliente
    @Override
    public void datosCliente(String nif) {
        JFrame ventana = new JFrame("Datos del cliente");
        JLabel texto = new JLabel("<html><h1>" + modelo.getBaseDeDatos().listarDatosCliente(nif) + "</h1></html>");
        ventana.getContentPane().add(texto);
        ventana.setSize(600, 300);
        ventana.setVisible(true);
    }
}