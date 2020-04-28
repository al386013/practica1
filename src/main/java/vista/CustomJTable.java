package vista;

import modelo.datos.clientes.Cliente;
import modelo.datos.contrato.Factura;
import modelo.datos.llamadas.Llamada;
import javax.swing.*;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import java.awt.*;
import java.util.Collection;

public class CustomJTable extends JFrame {
    JScrollPane scrollPane;
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

    //Todo: Mirar como unificar este metodo para que sea generico
    public void cargarClientes(Collection<Cliente> clientes) {
        String[] columnas = {"DNI", "Telefono", "Nombre", "Apellidos",
                "Direccion", "E-mail", "Fecha de Alta", "Hora", "Tarifa"};
        ModeloTablaClientes modeloTabla = new ModeloTablaClientes(columnas, clientes);
        tabla = new JTable(modeloTabla);
        anchoColumnas();
    }

    public void cargarLlamadas(Collection<Llamada> llamadas) {
        String[] columnas = {"Destino", "Fecha", "Hora", "Duracion"};
        ModeloTablaLlamadas modeloTabla = new ModeloTablaLlamadas(columnas, llamadas);
        tabla = new JTable(modeloTabla);
        //definir ancho columnas
        anchoColumnas();
    }

    public void cargarFacturas(Collection<Factura> facturas){
        String[] columnas = {"Codigo", "Fecha", "Hora", "Importe",
                "Periodo", "Llamadas"};
        ModeloTablaFacturas modeloTabla = new ModeloTablaFacturas(columnas, facturas);
        tabla = new JTable(modeloTabla);
        //definir ancho columnas
        anchoColumnas();
        tabla.setRowHeight(100);
    }

    public JScrollPane getScrollPane() {
        tabla.setAutoCreateRowSorter(true);
        scrollPane = new JScrollPane(tabla);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        return scrollPane;
    }
}