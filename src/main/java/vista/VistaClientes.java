package vista;

import controlador.Controlador;
import modelo.InterrogaModelo;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VistaClientes implements InformaVista, InterrogaVista {
    private Controlador controlador;
    private InterrogaModelo modelo;

    public VistaClientes() {}

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
                ventanaClientes();
            }
        });
    }

    public void ventanaClientes() {
        JFrame ventana = new JFrame("Gestión Clientes");
        Container contenedor = ventana.getContentPane();

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
        ActionListener escuchadorRadio = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Botón " + e.getActionCommand() + " pulsado.");
            }
        };
        particular.addActionListener(escuchadorRadio);
        empresa.addActionListener(escuchadorRadio);
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
        JLabel cpLabel = new JLabel("Código Postal:  ");

        JTextField nif = new JTextField(25);
        nif.setText("Escribe NIF");
        JTextField nombre = new JTextField(25);
        nombre.setText("Escribe nombre");
        JTextField apellido = new JTextField(25);
        apellido.setText("Escribe apellido si particular");
        JTextField telf = new JTextField(25);
        telf.setText("Escribe teléfono");
        JTextField email = new JTextField(25);
        email.setText("Escribe email");
        JTextField provincia = new JTextField(25);
        provincia.setText("Escribe provincia");
        JTextField poblacion = new JTextField(25);
        poblacion.setText("Escribe población");
        JTextField cp = new JTextField(25);
        cp.setText("Escribe CP");

        anadirIzq.setLayout(new GridLayout(8,1));
        anadirDer.setLayout(new GridLayout(8,1));

        anadirIzq.add(nifLabel);
        anadirIzq.add(telfLabel);
        anadirIzq.add(nombreLabel);
        anadirIzq.add(apellidoLabel);
        anadirIzq.add(emailLabel);
        anadirIzq.add(provinciaLabel);
        anadirIzq.add(poblacionLabel);
        anadirIzq.add(cpLabel);

        anadirDer.add(nif);
        anadirDer.add(telf);
        anadirDer.add(nombre);
        anadirDer.add(apellido);
        anadirDer.add(email);
        anadirDer.add(provincia);
        anadirDer.add(poblacion);
        anadirDer.add(cp);

        anadirCampos.setLayout(new BoxLayout(anadirCampos, BoxLayout.X_AXIS));
        anadirCampos.add(anadirIzq);
        anadirCampos.add(anadirDer);


        ActionListener escuchadorBoton = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Botón " + e.getActionCommand() + " pulsado.");
            }
        };
        JButton botonAnadir = new JButton("Añadir");
        botonAnadir.setActionCommand("anadir");
        botonAnadir.addActionListener(escuchadorBoton);
        botonAnadir.setAlignmentX(Component.CENTER_ALIGNMENT);

        anadirCliente.setLayout(new BoxLayout(anadirCliente, BoxLayout.PAGE_AXIS));
        anadirTitulo.add(new JLabel( "<html>" + "<b><i>AÑADIR CLIENTE</i></b><br/>" + "</html>"));
        anadirCliente.add(anadirTitulo);
        anadirCliente.add(tipoCli);
        anadirCliente.add(anadirCampos);
        anadirCliente.add(botonAnadir);

        //BORRAR CLIENTE

        JPanel borrarTitulo = new JPanel();
        JPanel borrarCliente = new JPanel();
        JPanel borrarCampos = new JPanel();
        JPanel borrarIzq = new JPanel();
        JPanel borrarDer = new JPanel();

        borrarIzq.setLayout(new GridLayout(2,1));
        borrarDer.setLayout(new GridLayout(2,1));
        borrarIzq.add(telfLabel);
        borrarDer.add(telf);

        borrarCampos.setLayout(new BoxLayout(borrarCampos, BoxLayout.X_AXIS));
        borrarCampos.add(borrarIzq);
        borrarCampos.add(borrarDer);

        JButton botonBorrar = new JButton("Borrar");
        botonBorrar.setActionCommand("borrar");
        botonBorrar.addActionListener(escuchadorBoton);
        botonBorrar.setAlignmentX(Component.CENTER_ALIGNMENT);

        borrarCliente.setLayout(new BoxLayout(borrarCliente, BoxLayout.PAGE_AXIS));
        borrarTitulo.add(new JLabel( "<html>" + "<b><i>BORRAR CLIENTE</i></b><br/>" + "</html>"));
        borrarCliente.add(borrarTitulo);
        borrarCliente.add(borrarCampos);
        borrarCliente.add(botonBorrar);


        //CAMBIAR TARIFA

        JPanel cambiarTarifaTitulo = new JPanel();
        JPanel cambiarTarifa = new JPanel();
        JPanel tipoTarifa = new JPanel();
        JPanel cambiarTarifaCampos = new JPanel();
        JPanel cambiarTarifaIzq = new JPanel();
        JPanel cambiarTarifaDer = new JPanel();

        cambiarTarifaIzq.setLayout(new GridLayout(2,1));
        cambiarTarifaDer.setLayout(new GridLayout(2,1));
        cambiarTarifaIzq.add(nifLabel);
        cambiarTarifaDer.add(nif);

        cambiarTarifaCampos.setLayout(new BoxLayout(cambiarTarifaCampos, BoxLayout.X_AXIS));
        cambiarTarifaCampos.add(cambiarTarifaIzq);
        cambiarTarifaCampos.add(cambiarTarifaDer);

        JRadioButton tardes = new JRadioButton("Tarifa tardes reducida");
        JRadioButton domingo = new JRadioButton("Tarifa domingos gratis");
        tardes.setActionCommand("tardes");
        domingo.setActionCommand("domingo");
        tardes.addActionListener(escuchadorRadio);
        domingo.addActionListener(escuchadorRadio);

        tipoTarifa.add(new JLabel("Elije el tipo de tarifa:"));
        tipoTarifa.add(tardes);
        tipoTarifa.add(domingo);

        ButtonGroup grupoTipoTarifas = new ButtonGroup();
        grupoTipoTarifas.add(tardes);
        grupoTipoTarifas.add(domingo);

        cambiarTarifa.setLayout(new BoxLayout(cambiarTarifa, BoxLayout.Y_AXIS));
        cambiarTarifaTitulo.add(new JLabel( "<html>" + "<b><i>CONTRATAR TARIFA ESPECIAL</i></b><br/>" + "</html>"));
        cambiarTarifa.add(cambiarTarifaTitulo);
        cambiarTarifa.add(tipoTarifa);
        cambiarTarifa.add(cambiarTarifaCampos);

        //DATOS CLIENTE

        JPanel datosCliTitulo = new JPanel();
        JPanel datosCliente = new JPanel();

        datosCliente.setLayout(new BoxLayout(datosCliente, BoxLayout.Y_AXIS));
        datosCliTitulo.add(new JLabel( "<html>" + "<b><i>MOSTRAR DATOS CLIENTE</i></b><br/>" + "</html>"));
        datosCliente.add(datosCliTitulo);
        datosCliente.add(cambiarTarifaCampos);

        //LISTADO CLIENTES

        JPanel listadoClientes = new JPanel();
        JPanel listadoCliTitulo = new JPanel();
        listadoClientes.setLayout(new BoxLayout(listadoClientes, BoxLayout.Y_AXIS));
        listadoCliTitulo.add(new JLabel( "<html>" + "<b><i>LISTAR CLIENTES</i></b><br/>" + "</html>"));
        listadoClientes.add(listadoCliTitulo);

        //LISTADO CLIENTES ENTRE FECHAS

        JPanel listadoCliEntreFechas = new JPanel();
        JPanel listadoCliFechasTitulo = new JPanel();
        JPanel listadoCliFechasCampos = new JPanel();
        JPanel listadoCliFechasIzq = new JPanel();
        JPanel listadoCliFechasDer = new JPanel();

        JLabel fechaIniLabel = new JLabel("Fecha inicio (aaaa-mm-dd): ");
        JLabel fechaFinLabel = new JLabel("Fecha fin (aaaa-mm-dd):  ");

        JTextField fechaIni = new JTextField(25);
        JTextField fechaFin = new JTextField(25);
        fechaIni.setText("aaaa-mm-dd");
        fechaFin.setText("aaaa-mm-dd");

        listadoCliFechasIzq.setLayout(new GridLayout(2,1));
        listadoCliFechasDer.setLayout(new GridLayout(2,1));
        listadoCliFechasIzq.add(fechaIniLabel);
        listadoCliFechasIzq.add(fechaFinLabel);
        listadoCliFechasDer.add(fechaIni);
        listadoCliFechasDer.add(fechaFin);

        listadoCliFechasCampos.setLayout(new BoxLayout(listadoCliFechasCampos, BoxLayout.X_AXIS));
        listadoCliFechasCampos.add(listadoCliFechasIzq);
        listadoCliFechasCampos.add(listadoCliFechasDer);

        listadoCliEntreFechas.setLayout(new BoxLayout(listadoCliEntreFechas, BoxLayout.Y_AXIS));
        listadoCliFechasTitulo.add(new JLabel( "<html>" + "<b><i>LISTAR CLIENTES ENTRE FECHAS</i></b><br/>" + "</html>"));
        listadoCliEntreFechas.add(listadoCliFechasTitulo);
        listadoCliEntreFechas.add(listadoCliFechasCampos);


        contenedor.setLayout(new BoxLayout(contenedor, BoxLayout.PAGE_AXIS));
        contenedor.add(anadirCliente);
        contenedor.add(borrarCliente);
        contenedor.add(cambiarTarifa);
        contenedor.add(datosCliente);
        contenedor.add(listadoClientes);
        contenedor.add(listadoCliEntreFechas);

        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.pack();
        ventana.setVisible(true);
    }
}
