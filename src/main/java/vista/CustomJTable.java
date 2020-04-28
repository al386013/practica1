package vista;

import modelo.datos.TieneFecha;
import javax.swing.*;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import java.awt.*;
import java.util.Collection;

public class CustomJTable extends JFrame {
    //JScrollPane scrollPane;
    JTable tabla;

    public CustomJTable(String title) {
        super(title);
        setBounds(10,10,800,600);
    }

    public void anchoColumnas(){
        for (int column = 0; column < tabla.getColumnCount(); column++){
            TableColumn tableColumn = tabla.getColumnModel().getColumn(column);
            int preferredWidth = tableColumn.getMinWidth();
            int maxWidth = tableColumn.getMaxWidth();
            for (int row = 0; row < tabla.getRowCount(); row++) {
                TableCellRenderer cellRenderer = tabla.getCellRenderer(row, column);
                Component c = tabla.prepareRenderer(cellRenderer, row, column);
                int width = c.getPreferredSize().width + tabla.getIntercellSpacing().width;
                preferredWidth = Math.max(preferredWidth, width);
                if (preferredWidth >= maxWidth){
                    preferredWidth = maxWidth;
                    break;
                }
            }
            tableColumn.setPreferredWidth( preferredWidth );
        }
    }

    public <T extends TieneFecha> JScrollPane getScrollPane(String[] columnas, Collection<T> elementos) {
        tabla = new JTable(new ModeloTabla<T>(columnas, elementos));
        anchoColumnas(); //ajustar ancho columnas al texto


        //todo ESTO ESTA MUY FEO PERO SINO NO SE COMO HACERLO!!!!!
        if(columnas[0].equals("Codigo")) //si es la tabla de facturas
            tabla.setRowHeight(100);

        tabla.setAutoCreateRowSorter(true);
        JScrollPane scrollPane = new JScrollPane(tabla);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        return scrollPane;
    }

    /*public void cargarClientes(Collection<Cliente> clientes) {
        String[] columnas = {"DNI", "Telefono", "Nombre", "Apellidos", "Codigo Postal",
                "Poblacion", "Provincia", "E-mail", "Fecha de Alta", "Hora", "Tarifa"};
        //ModeloTablaClientes modeloTabla = new ModeloTablaClientes(columnas, clientes);
        ModeloTabla modeloTabla = new ModeloTabla(columnas, clientes);
        tabla = new JTable(modeloTabla);
        anchoColumnas();
    }

    public void cargarLlamadas(Collection<Llamada> llamadas) {
        String[] columnas = {"Destino", "Fecha", "Hora", "Duracion"};
        ModeloTabla modeloTabla = new ModeloTabla(columnas, llamadas);
        tabla = new JTable(modeloTabla);
        //definir ancho columnas
        anchoColumnas();
    }

    public void cargarFacturas(Collection<Factura> facturas){
        String[] columnas = {"Codigo", "Fecha factura", "Hora", "Importe",
                "Fecha inicio", "Fecha fin", "Llamadas"};
        ModeloTabla modeloTabla = new ModeloTabla(columnas, facturas);
        tabla = new JTable(modeloTabla);
        //definir ancho columnas
        anchoColumnas();
        tabla.setRowHeight(30);
    }

    public JScrollPane getScrollPane() {
        tabla.setAutoCreateRowSorter(true);
        scrollPane = new JScrollPane(tabla);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        return scrollPane;
    }*/
}