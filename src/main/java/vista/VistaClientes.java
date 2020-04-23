package vista;

import controlador.Controlador;
import modelo.InterrogaModelo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

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
        //ventana.setLayout(new GridLayout(2,8));
        Container contenedor = ventana.getContentPane();

        JPanel anadirCliente = new JPanel();
        //anadirCliente.setLayout(new BoxLayout(anadirCliente, BoxLayout.PAGE_AXIS));
        //ventana.setContentPane(anadirCliente);//Cambiamos el panel contenedor
        anadirCliente.add(new JLabel( "<html>" + "<b>AÑADIR CLIENTE</b><br/>" + "</html>"));


        anadirCliente.setLayout(new BoxLayout(anadirCliente, BoxLayout.PAGE_AXIS));
        JRadioButton particular = new JRadioButton("Particular");
        particular.setActionCommand("particular");
        JRadioButton empresa = new JRadioButton("Empresa");
        empresa.setActionCommand("empresa");
        ActionListener escuchador;

        particular.addActionListener(escuchador = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Botón " + e.getActionCommand() + " pulsado.");
            }
        });
        empresa.addActionListener(escuchador);
        anadirCliente.add(new JLabel("Elije el tipo de cliente:"));
        anadirCliente.add(particular);
        anadirCliente.add(empresa);

        ButtonGroup grupo = new ButtonGroup();
        grupo.add(particular);
        grupo.add(empresa);

        JPanel datosCliente = new JPanel();
        //datosCliente.setLayout(new FlowLayout());
        datosCliente.setLayout(new GridLayout(3, 3));

        JPanel panelNif = new JPanel();
        JTextField nif = new JTextField(15);
        nif.setText("Escribe NIF");
        JLabel nifLabel = new JLabel("NIF: ");
        panelNif.add(nifLabel);
        panelNif.add(nif);

        JPanel panelNombre = new JPanel();
        JTextField nombre = new JTextField(15);
        nombre.setText("Escribe nombre");
        JLabel nombreLabel = new JLabel("Nombre: ");
        panelNombre.add(nombreLabel);
        panelNombre.add(nombre);

        JPanel panelApellido = new JPanel();
        JTextField apellido = new JTextField(25);
        apellido.setText("Escribe apellido si particular");
        JLabel apellidoLabel = new JLabel("Apellido: ");
        panelApellido.add(apellidoLabel);
        panelApellido.add(apellido);

        JPanel panelTelf = new JPanel();
        JTextField telf = new JTextField(15);
        telf.setText("Escribe teléfono");
        JLabel telfLabel = new JLabel("Teléfono: ");
        panelTelf.add(telfLabel);
        panelTelf.add(telf);

        JPanel panelProvincia = new JPanel();
        JTextField provincia = new JTextField(25);
        provincia.setText("Escribe provincia");
        JLabel provinciaLabel = new JLabel("Provincia: ");
        panelProvincia.add(provinciaLabel);
        panelProvincia.add(provincia);

        JPanel panelPoblacion = new JPanel();
        JTextField poblacion = new JTextField(25);
        poblacion.setText("Escribe población");
        JLabel poblacionLabel = new JLabel("Población: ");
        panelPoblacion.add(poblacionLabel);
        panelPoblacion.add(poblacion);

        JPanel panelCP = new JPanel();
        JTextField cp = new JTextField(8);
        cp.setText("Escribe CP");
        JLabel cpLabel = new JLabel("Código Postal: ");
        panelCP.add(cpLabel);
        panelCP.add(cp);

        JPanel panelEmail = new JPanel();
        JTextField email = new JTextField(20);
        email.setText("Escribe email");
        JLabel emailLabel = new JLabel("Email: ");
        panelEmail.add(emailLabel);
        panelEmail.add(email);


        datosCliente.add(panelNif);
        datosCliente.add(panelNombre);
        datosCliente.add(panelApellido);
        datosCliente.add(panelTelf);
        datosCliente.add(panelProvincia);
        datosCliente.add(panelPoblacion);
        datosCliente.add(panelCP);
        datosCliente.add(panelEmail);
        datosCliente.setAlignmentX(Component.LEFT_ALIGNMENT);

        contenedor.add(anadirCliente);
        contenedor.add(datosCliente);
        contenedor.setLayout(new BoxLayout(contenedor, BoxLayout.PAGE_AXIS));


        //BORRAR CLIENTE

        JPanel borrarCliente = new JPanel();
        borrarCliente.add(new JLabel( "<html>" + "<b>BORRAR CLIENTE</b><br/>" + "</html>"));
        JTextField telf2 = new JTextField(15);
        telf2.setText("Escribe teléfono");
        JLabel telfLabel2 = new JLabel("Teléfono: ");
        borrarCliente.add(telfLabel2);
        borrarCliente.add(telf2);
        contenedor.add(borrarCliente);

        //CAMBIAR TARIFA

        JPanel cambiarTarifa = new JPanel();
        cambiarTarifa.add(new JLabel( "<html>" + "<b>CONTRATAR TARIFA ESPECIAL</b><br/>" + "</html>"));
        JTextField tarifa = new JTextField(15);

        JPanel panelNif2 = new JPanel();
        JTextField nif2 = new JTextField(15);
        nif2.setText("Escribe NIF");
        JLabel nifLabel2 = new JLabel("NIF: ");
        panelNif2.add(nifLabel2);
        panelNif2.add(nif2);

        cambiarTarifa.setLayout(new BoxLayout(cambiarTarifa, BoxLayout.PAGE_AXIS));
        JRadioButton tardes = new JRadioButton("Tarifa tardes reducida");
        tardes.setActionCommand("tardes");
        JRadioButton domingo = new JRadioButton("Tarifa domingos gratis");
        domingo.setActionCommand("domingo");

        tardes.addActionListener(escuchador);
        domingo.addActionListener(escuchador);
        cambiarTarifa.add(new JLabel("Elije el tipo de tarifa:"));
        cambiarTarifa.add(tardes);
        cambiarTarifa.add(domingo);

        ButtonGroup grupoTarifas = new ButtonGroup();
        grupoTarifas.add(particular);
        grupoTarifas.add(empresa);

        contenedor.add(cambiarTarifa);
        contenedor.add(panelNif2);

        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.pack();
        ventana.setVisible(true);
    }
}
