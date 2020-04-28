package vista;

import modelo.datos.clientes.Cliente;
import modelo.datos.contrato.Factura;
import modelo.datos.llamadas.Llamada;

import javax.swing.*;
import java.awt.*;
import java.util.Collection;

public class CustomJTable extends JFrame {
    JScrollPane scrollPane;
    JPanel panelTabla;
    JTable tabla;

    public CustomJTable(String title) {
        super(title);
        setBounds(10,10,800,600);
    }
    //Todo: Mirar como unificar este metodo para que sea generico
    public void cargarClientes(Collection<Cliente> clientes) {
        String[] columnas = {"DNI", "Telefono", "Nombre", "Apellidos",
                "Direccion", "E-mail", "Fecha de Alta", "Hora de alta", "Tarifa"};
        ModeloTabla modeloTabla = new ModeloTabla(columnas, clientes);
        tabla = new JTable(modeloTabla);
    }

    public void cargarLlamadas(Collection<Llamada> llamadas) {
        ModeloTabla modeloTabla = new ModeloTabla(llamadas);
        tabla = new JTable(modeloTabla);
    }

    public void cargarFacturas(Collection<Factura> facturas){
        ModeloTabla modeloTabla= new ModeloTabla(facturas);
        tabla = new JTable(modeloTabla);
    }




    public JPanel getPanelTabla() {
        tabla.setAutoCreateRowSorter(true); //??????????????????????
        for(int i = 0; i < tabla.getColumnCount(); i++)
            tabla.getColumnModel().getColumn(i).setPreferredWidth(100);
        scrollPane = new JScrollPane(tabla);
        scrollPane.setPreferredSize(new Dimension(380,280));
        panelTabla = new JPanel();
        panelTabla.add(scrollPane);
        add(panelTabla,BorderLayout.CENTER);
        return panelTabla;
    }
}
