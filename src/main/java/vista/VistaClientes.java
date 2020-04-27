package vista;

import controlador.Controlador;
import modelo.InterrogaModelo;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;

public class VistaClientes implements InterrogaVistaClientes {
    private Controlador controlador;
    private InterrogaModelo modelo;
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

    public VistaClientes() {
        super();
    }

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
                if (comando.equals("importar"))
                    controlador.importarDatos();
                else if (comando.equals("anadir"))
                    controlador.anadirCliente();
                else if (comando.equals("borrar"))
                    controlador.borrarCliente();
                else if (comando.equals("tarifa"))
                    controlador.contratarTarifa();
                else if (comando.equals("datosCli"))
                    controlador.datosCliente();
                else if (comando.equals("listarCli"))
                    controlador.listarClientes();
                else
                    controlador.listarCliFechas();
            }
        };

        JPanel importarPanel = new JPanel();
        JButton importarBoton = new JButton("Importar datos");
        importarBoton.setActionCommand("importar");
        importarBoton.addActionListener(escuchadorBoton);
        importarPanel.add(importarBoton);

        //ANADIR CLIENTE

        JPanel anadirCliente = new JPanel();
        JPanel anadirTitulo = new JPanel();
        JPanel tipoCli = new JPanel();
        JPanel anadirCampos = new JPanel();
        JPanel anadirIzq = new JPanel();
        JPanel anadirDer = new JPanel();

        JRadioButton particular = new JRadioButton("Particular");
        JRadioButton empresa = new JRadioButton("Empresa");
        particular.setActionCommand("particular");
        empresa.setActionCommand("empresa");
        ActionListener escuchadorClientes = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Botón " + e.getActionCommand() + " pulsado.");
                tipoClienteOpcion = e.getActionCommand();
            }
        };

        particular.addActionListener(escuchadorClientes);
        empresa.addActionListener(escuchadorClientes);
        tipoCli.add(new JLabel("Elije el tipo de cliente:"));
        tipoCli.add(particular);
        tipoCli.add(empresa);

        ButtonGroup grupoTipoCli = new ButtonGroup();
        grupoTipoCli.add(particular);
        grupoTipoCli.add(empresa);

        JLabel nifLabel = new JLabel("NIF: ");
        JLabel nombreLabel = new JLabel("Nombre: ");
        JLabel apellidoLabel = new JLabel("Apellidos: ");
        JLabel telfLabel = new JLabel("Teléfono: ");
        JLabel emailLabel = new JLabel("Email: ");
        JLabel provinciaLabel = new JLabel("Provincia: ");
        JLabel poblacionLabel = new JLabel("Población: ");
        JLabel cpLabel = new JLabel("Código Postal: ");

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

        anadirIzq.setLayout(new GridLayout(8, 1));
        anadirDer.setLayout(new GridLayout(8, 1));

        anadirIzq.add(nifLabel);
        anadirIzq.add(telfLabel);
        anadirIzq.add(nombreLabel);
        anadirIzq.add(apellidoLabel);
        anadirIzq.add(emailLabel);
        anadirIzq.add(provinciaLabel);
        anadirIzq.add(poblacionLabel);
        anadirIzq.add(cpLabel);

        anadirDer.add(nifAnadir);
        anadirDer.add(telfAnadir);
        anadirDer.add(nombre);
        anadirDer.add(apellido);
        anadirDer.add(email);
        anadirDer.add(provincia);
        anadirDer.add(poblacion);
        anadirDer.add(cp);

        anadirCampos.setLayout(new BoxLayout(anadirCampos, BoxLayout.X_AXIS));
        anadirCampos.add(anadirIzq);
        anadirCampos.add(anadirDer);

        JButton botonAnadir = new JButton("Añadir");
        botonAnadir.setActionCommand("anadir");
        botonAnadir.addActionListener(escuchadorBoton);
        tipoCli.add(botonAnadir);

        anadirCliente.setLayout(new BoxLayout(anadirCliente, BoxLayout.PAGE_AXIS));
        anadirTitulo.add(new JLabel("<html>" + "<b><i>AÑADIR CLIENTE</i></b><br/>" + "</html>"));
        anadirCliente.add(anadirTitulo);
        anadirCliente.add(tipoCli);
        anadirCliente.add(anadirCampos);

        //BORRAR CLIENTE

        JPanel borrarTitulo = new JPanel();
        JPanel borrarCliente = new JPanel();
        JPanel borrarCampos = new JPanel();
        JPanel borrarIzq = new JPanel();
        JPanel borrarDer = new JPanel();

        JLabel telfLabel2 = new JLabel("Teléfono: ");
        telfBorrar = new JTextField(16);
        telfBorrar.setText("Escribe teléfono");

        borrarIzq.setLayout(new GridLayout(1, 1));
        borrarDer.setLayout(new GridLayout(1, 1));
        borrarIzq.add(telfLabel2);
        borrarDer.add(telfBorrar);

        borrarCampos.setLayout(new BoxLayout(borrarCampos, BoxLayout.X_AXIS));
        borrarCampos.add(borrarIzq);
        borrarCampos.add(borrarDer);

        JButton botonBorrar = new JButton("Borrar");
        botonBorrar.setActionCommand("borrar");
        botonBorrar.addActionListener(escuchadorBoton);
        borrarCampos.add(botonBorrar);

        borrarCliente.setLayout(new BoxLayout(borrarCliente, BoxLayout.PAGE_AXIS));
        borrarTitulo.add(new JLabel("<html>" + "<b><i>BORRAR CLIENTE</i></b><br/>" + "</html>"));
        borrarCliente.add(borrarTitulo);
        borrarCliente.add(borrarCampos);


        //CAMBIAR TARIFA

        JPanel cambiarTarifaTitulo = new JPanel();
        JPanel cambiarTarifa = new JPanel();
        JPanel tipoTarifa = new JPanel();
        JPanel cambiarTarifaCampos = new JPanel();
        JPanel cambiarTarifaIzq = new JPanel();
        JPanel cambiarTarifaDer = new JPanel();

        JLabel nifLabel2 = new JLabel("NIF: ");
        nifTarifa = new JTextField(11);
        nifTarifa.setText("Escribe NIF");

        cambiarTarifaIzq.setLayout(new GridLayout(1, 1));
        cambiarTarifaDer.setLayout(new GridLayout(1, 1));
        cambiarTarifaIzq.add(nifLabel2);
        cambiarTarifaDer.add(nifTarifa);

        cambiarTarifaCampos.setLayout(new BoxLayout(cambiarTarifaCampos, BoxLayout.X_AXIS));
        cambiarTarifaCampos.add(cambiarTarifaIzq);
        cambiarTarifaCampos.add(cambiarTarifaDer);

        ActionListener escuchadorTarifas = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Botón " + e.getActionCommand() + " pulsado.");
                tipoTarifaOpcion = e.getActionCommand();
            }
        };

        JRadioButton tardes = new JRadioButton("Tarifa tardes reducida");
        JRadioButton domingo = new JRadioButton("Tarifa domingos gratis");
        tardes.setActionCommand("tardes");
        domingo.setActionCommand("domingo");
        tardes.addActionListener(escuchadorTarifas);
        domingo.addActionListener(escuchadorTarifas);

        tipoTarifa.add(new JLabel("Elije el tipo de tarifa:"));
        tipoTarifa.add(tardes);
        tipoTarifa.add(domingo);

        ButtonGroup grupoTipoTarifas = new ButtonGroup();
        grupoTipoTarifas.add(tardes);
        grupoTipoTarifas.add(domingo);

        JButton botonTarifa = new JButton("Contratar");
        botonTarifa.setActionCommand("tarifa");
        botonTarifa.addActionListener(escuchadorBoton);
        cambiarTarifaCampos.add(botonTarifa);

        cambiarTarifa.setLayout(new BoxLayout(cambiarTarifa, BoxLayout.PAGE_AXIS));
        cambiarTarifaTitulo.add(new JLabel("<html>" + "<b><i>CONTRATAR TARIFA ESPECIAL</i></b><br/>" + "</html>"));
        cambiarTarifa.add(cambiarTarifaTitulo);
        cambiarTarifa.add(tipoTarifa);
        cambiarTarifa.add(cambiarTarifaCampos);

        //DATOS CLIENTE

        JPanel datosCliTitulo = new JPanel();
        JPanel datosCliente = new JPanel();
        JPanel datosCliCampos = new JPanel();
        JPanel datosCliIzq = new JPanel();
        JPanel datosCliDer = new JPanel();

        JLabel nifLabel3 = new JLabel("NIF: ");
        nifCli = new JTextField(12);
        nifCli.setText("Escribe NIF");

        datosCliIzq.setLayout(new GridLayout(1, 1));
        datosCliDer.setLayout(new GridLayout(1, 1));
        datosCliIzq.add(nifLabel3);
        datosCliDer.add(nifCli);

        datosCliCampos.setLayout(new BoxLayout(datosCliCampos, BoxLayout.X_AXIS));
        datosCliCampos.add(datosCliIzq);
        datosCliCampos.add(datosCliDer);

        JButton botonDatosCli = new JButton("Mostrar");
        botonDatosCli.setActionCommand("datosCli");
        botonDatosCli.addActionListener(escuchadorBoton);
        datosCliCampos.add(botonDatosCli);

        datosCliente.setLayout(new BoxLayout(datosCliente, BoxLayout.PAGE_AXIS));
        datosCliTitulo.add(new JLabel("<html>" + "<b><i>MOSTRAR DATOS CLIENTE</i></b><br/>" + "</html>"));
        datosCliente.add(datosCliTitulo);
        datosCliente.add(datosCliCampos);

        //LISTADO CLIENTES

        JPanel listadoClientes = new JPanel();
        JButton botonListarCli = new JButton("Listar");
        botonListarCli.setActionCommand("listarCli");
        botonListarCli.addActionListener(escuchadorBoton);

        listadoClientes.add(new JLabel("<html>" + "<b><i>LISTAR CLIENTES</i></b><br/>" + "</html>"));
        listadoClientes.add(botonListarCli);


        //LISTADO CLIENTES ENTRE FECHAS

        JPanel listadoCliEntreFechas = new JPanel();
        JPanel listadoCliFechasTitulo = new JPanel();
        JPanel listadoCliFechasCampos = new JPanel();
        JPanel listadoCliFechasIzq = new JPanel();
        JPanel listadoCliFechasDer = new JPanel();

        JLabel fechaIniLabel = new JLabel("Fecha inicio: ");
        JLabel fechaFinLabel = new JLabel("Fecha fin: ");

        fechaIni = new JTextField(18);
        fechaFin = new JTextField(18);
        fechaIni.setText("aaaa-mm-dd");
        fechaFin.setText("aaaa-mm-dd");

        listadoCliFechasIzq.setLayout(new GridLayout(2, 1));
        listadoCliFechasDer.setLayout(new GridLayout(2, 1));
        listadoCliFechasIzq.add(fechaIniLabel);
        listadoCliFechasIzq.add(fechaFinLabel);
        listadoCliFechasDer.add(fechaIni);
        listadoCliFechasDer.add(fechaFin);

        listadoCliFechasCampos.setLayout(new BoxLayout(listadoCliFechasCampos, BoxLayout.X_AXIS));
        listadoCliFechasCampos.add(listadoCliFechasIzq);
        listadoCliFechasCampos.add(listadoCliFechasDer);

        JButton botonListarCliFechas = new JButton("Listar");
        botonListarCliFechas.setActionCommand("listarCliFechas");
        botonListarCliFechas.addActionListener(escuchadorBoton);
        botonListarCliFechas.setAlignmentX(Component.CENTER_ALIGNMENT);
        listadoCliFechasCampos.add(botonListarCliFechas);

        listadoCliEntreFechas.setLayout(new BoxLayout(listadoCliEntreFechas, BoxLayout.PAGE_AXIS));
        listadoCliFechasTitulo.add(new JLabel("<html>" + "<b><i>LISTAR CLIENTES ENTRE FECHAS</i></b><br/>" + "</html>"));
        listadoCliEntreFechas.add(listadoCliFechasTitulo);
        listadoCliEntreFechas.add(listadoCliFechasCampos);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
        panel.add(importarPanel);
        panel.add(anadirCliente);
        panel.add(borrarCliente);
        panel.add(cambiarTarifa);
        panel.add(datosCliente);
        panel.add(listadoClientes);
        panel.add(listadoCliEntreFechas);
        return panel;
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
    public void clienteAnadido(String nombre, String nif, String telf) {
        JOptionPane.showMessageDialog(null, "Creado cliente "
                + nombre + " con NIF " + nif + " y telefono " + telf + ".");
    }

    @Override
    public void clienteBorrado(String telf) {
        JOptionPane.showMessageDialog(null, ("Cliente con numero " + telf + " borrado con exito."));
    }

    @Override
    public void tarifaContratada(String nif) {
        JOptionPane.showMessageDialog(null, "Tarifa especial contratada para el cliente con nif" + nif);
    }

    @Override
    public void listadoClientes() {
        JFrame ventana = new JFrame("Listado clientes");
        //JOptionPane.showMessageDialog(null, vistaListadoClientes.panel());
        CustomJTable customJTable = new CustomJTable("clientes");
        customJTable.cargarTablaClientes(modelo.getBaseDeDatos().devolverClientes());
        ventana.add(customJTable.getPanelTabla());
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
        panel.add(customJTable.panelTabla);

        ventana.getContentPane().add(panel);
        ventana.setSize(700,700);
        //ventana.pack();
        ventana.setVisible(true);
    }

}