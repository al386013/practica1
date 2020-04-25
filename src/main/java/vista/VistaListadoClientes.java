package vista;

import controlador.Controlador;
import modelo.InterrogaModelo;
import modelo.datos.clientes.Cliente;
import modelo.datos.clientes.Particular;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collection;

public class VistaListadoClientes extends JFrame  {
    private Controlador controlador;
    private InterrogaModelo modelo;



    public VistaListadoClientes() { super(); } //?????????????????

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
        //ModeloTabla modeloTabla = new ModeloTabla();

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
            if(cliente instanceof Particular){
                apellidos = ((Particular) cliente).getApellidos();
            }
            modeloTabla.addRow(new String[]{cliente.getNIF(), cliente.getTelf(),cliente.getNombre(), apellidos,
            cliente.getDireccion().toString(), cliente.getEmail(), cliente.getTarifa().toString()});
        }
        JTable tabla = new JTable();
        tabla.setModel(modeloTabla);
        return tabla;
    }


    public JPanel panel() {
        ActionListener escuchadorBoton = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Botón " + e.getActionCommand() + " pulsado.");
                String comando = e.getActionCommand();
                if (comando.equals("importar"))
                    controlador.importarDatos();
            }
        };
        JPanel importarPanel = new JPanel();
        JButton importarBoton = new JButton("Importar datos");
        importarBoton.setActionCommand("importar");
        importarBoton.addActionListener(escuchadorBoton);
        importarPanel.add(importarBoton);

        //LISTADO CLIENTES
        JTable listadoClientes = construirTabla();

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
        panel.add(importarPanel);
        panel.add(listadoClientes);
        return panel;

    }


}
