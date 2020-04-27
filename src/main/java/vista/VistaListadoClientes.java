/*package vista;

import controlador.Controlador;
import modelo.InterrogaModelo;
import javax.swing.*;
import java.awt.*;

public class VistaListadoClientes extends JFrame  {
    private Controlador controlador;
    private InterrogaModelo modelo;

    public VistaListadoClientes() { super(); }

    public void setModelo(InterrogaModelo modelo) {
        this.modelo = modelo;
    }

    public void setControlador(Controlador controlador) {
        this.controlador = controlador;
    }

    private JTable construirTabla(){
        //Creamos el modelo de la tabla
        //todo ¿Porque no puedo usar el modeloTabla definido por nosotros?
        //todo ¿Esto deberia ir en la clase modeloTabla?
        ModeloTabla modeloTabla = new ModeloTabla(modelo.getBaseDeDatos().devolverClientes());

        DefaultTableModel modeloTabla = new DefaultTableModel();
        modeloTabla.addColumn("DNI");
        modeloTabla.addColumn("TELEFONO");
        modeloTabla.addColumn("NOMBRE");
        modeloTabla.addColumn("APELLIDOS");
        modeloTabla.addColumn("DIRECCION");
        modeloTabla.addColumn("E-MAIL");
        modeloTabla.addColumn("ALTA");
        modeloTabla.addColumn("TARIFA");

        //PEDIR DATOS, necesitamos un conjunto con todos los clientes:
        Collection<Cliente> clientes = modelo.getBaseDeDatos().devolverClientes();
        for(Cliente cliente : clientes){
            String apellidos = "";
            if(cliente instanceof Particular)
                apellidos = ((Particular) cliente).getApellidos();
            modeloTabla.addRow(new String[]{cliente.getNIF(), cliente.getTelf(),cliente.getNombre(), apellidos,
            cliente.getDireccion().toString(), cliente.getEmail(), cliente.getTarifa().toString()});
        }
        JTable tabla = new JTable();
        tabla.setModel(modeloTabla);
        return tabla;
    }

    class CustomJTable extends JFrame {
        JScrollPane scrollPane;
        JPanel panelTabla;
        public CustomJTable(String title) {
            super(title);
            setBounds(10,10,800,600);
            ModeloTabla modeloTabla = new ModeloTabla(modelo.getBaseDeDatos().devolverClientes());
            JTable tabla = new JTable(modeloTabla);
            tabla.setAutoCreateRowSorter(true); //??????????????????????
            for(int i = 0; i < tabla.getColumnCount(); i++)
                tabla.getColumnModel().getColumn(i).setPreferredWidth(100);
            scrollPane = new JScrollPane(tabla);
            scrollPane.setPreferredSize(new Dimension(380,280));
            panelTabla = new JPanel();
            panelTabla.add(scrollPane);
            add(panelTabla,BorderLayout.CENTER);
        }
    }

    public JPanel panel() {
        ActionListener escuchadorBoton = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Botón " + e.getActionCommand() + " pulsado.");
                controlador.importarDatos();
            }
        };

        JPanel importarPanel = new JPanel();
        JButton importarBoton = new JButton("Importar datos");
        importarBoton.setActionCommand("importar");
        importarBoton.addActionListener(escuchadorBoton);
        importarPanel.add(importarBoton);

        CustomJTable customJTable = new CustomJTable("clientes");
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
        //panel.add(importarPanel);
        panel.add(customJTable.panelTabla);
        return panel;
    }
}*/
