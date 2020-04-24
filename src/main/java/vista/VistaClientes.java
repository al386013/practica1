package vista;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VistaClientes {

    public VistaClientes() { super(); } //?????????????????

    public JPanel panel() {

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
        tipoCli.add(botonAnadir);

        anadirCliente.setLayout(new BoxLayout(anadirCliente, BoxLayout.PAGE_AXIS));
        anadirTitulo.add(new JLabel( "<html>" + "<b><i>AÑADIR CLIENTE</i></b><br/>" + "</html>"));
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
        JTextField telf2 = new JTextField(16);
        telf2.setText("Escribe teléfono");

        borrarIzq.setLayout(new GridLayout(1,1));
        borrarDer.setLayout(new GridLayout(1,1));
        borrarIzq.add(telfLabel2);
        borrarDer.add(telf2);

        borrarCampos.setLayout(new BoxLayout(borrarCampos, BoxLayout.X_AXIS));
        borrarCampos.add(borrarIzq);
        borrarCampos.add(borrarDer);

        JButton botonBorrar = new JButton("Borrar");
        botonBorrar.setActionCommand("borrar");
        botonBorrar.addActionListener(escuchadorBoton);
        borrarCampos.add(botonBorrar);

        borrarCliente.setLayout(new BoxLayout(borrarCliente, BoxLayout.PAGE_AXIS));
        borrarTitulo.add(new JLabel( "<html>" + "<b><i>BORRAR CLIENTE</i></b><br/>" + "</html>"));
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
        JTextField nif2 = new JTextField(11);
        nif2.setText("Escribe NIF");

        cambiarTarifaIzq.setLayout(new GridLayout(1,1));
        cambiarTarifaDer.setLayout(new GridLayout(1,1));
        cambiarTarifaIzq.add(nifLabel2);
        cambiarTarifaDer.add(nif2);

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

        JButton botonTarifa = new JButton("Contratar");
        botonTarifa.setActionCommand("tarifa");
        botonTarifa.addActionListener(escuchadorBoton);
        cambiarTarifaCampos.add(botonTarifa);

        cambiarTarifa.setLayout(new BoxLayout(cambiarTarifa, BoxLayout.PAGE_AXIS));
        cambiarTarifaTitulo.add(new JLabel( "<html>" + "<b><i>CONTRATAR TARIFA ESPECIAL</i></b><br/>" + "</html>"));
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
        JTextField nif3 = new JTextField(12);
        nif3.setText("Escribe NIF");

        datosCliIzq.setLayout(new GridLayout(1,1));
        datosCliDer.setLayout(new GridLayout(1,1));
        datosCliIzq.add(nifLabel3);
        datosCliDer.add(nif3);

        datosCliCampos.setLayout(new BoxLayout(datosCliCampos, BoxLayout.X_AXIS));
        datosCliCampos.add(datosCliIzq);
        datosCliCampos.add(datosCliDer);

        JButton botonDatosCli = new JButton("Mostrar");
        botonDatosCli.setActionCommand("datosCli");
        botonDatosCli.addActionListener(escuchadorBoton);
        datosCliCampos.add(botonDatosCli);

        datosCliente.setLayout(new BoxLayout(datosCliente, BoxLayout.PAGE_AXIS));
        datosCliTitulo.add(new JLabel( "<html>" + "<b><i>MOSTRAR DATOS CLIENTE</i></b><br/>" + "</html>"));
        datosCliente.add(datosCliTitulo);
        datosCliente.add(datosCliCampos);

        //LISTADO CLIENTES

        JPanel listadoClientes = new JPanel();
        JButton botonListarCli = new JButton("Listar");
        botonListarCli.setActionCommand("listarCli");
        botonListarCli.addActionListener(escuchadorBoton);

        listadoClientes.add(new JLabel( "<html>" + "<b><i>LISTAR CLIENTES</i></b><br/>" + "</html>"));
        listadoClientes.add(botonListarCli);


        //LISTADO CLIENTES ENTRE FECHAS

        JPanel listadoCliEntreFechas = new JPanel();
        JPanel listadoCliFechasTitulo = new JPanel();
        JPanel listadoCliFechasCampos = new JPanel();
        JPanel listadoCliFechasIzq = new JPanel();
        JPanel listadoCliFechasDer = new JPanel();

        JLabel fechaIniLabel = new JLabel("Fecha inicio: ");
        JLabel fechaFinLabel = new JLabel("Fecha fin:  ");

        JTextField fechaIni = new JTextField(18);
        JTextField fechaFin = new JTextField(18);
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

        JButton botonListarCliFechas = new JButton("Listar");
        botonListarCliFechas.setActionCommand("listarCliFechas");
        botonListarCliFechas.addActionListener(escuchadorBoton);
        botonListarCliFechas.setAlignmentX(Component.CENTER_ALIGNMENT);
        listadoCliFechasCampos.add(botonListarCliFechas);

        listadoCliEntreFechas.setLayout(new BoxLayout(listadoCliEntreFechas, BoxLayout.PAGE_AXIS));
        listadoCliFechasTitulo.add(new JLabel( "<html>" + "<b><i>LISTAR CLIENTES ENTRE FECHAS</i></b><br/>" + "</html>"));
        listadoCliEntreFechas.add(listadoCliFechasTitulo);
        listadoCliEntreFechas.add(listadoCliFechasCampos);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
        panel.add(anadirCliente);
        panel.add(borrarCliente);
        panel.add(cambiarTarifa);
        panel.add(datosCliente);
        panel.add(listadoClientes);
        panel.add(listadoCliEntreFechas);
        return panel;
    }
}
