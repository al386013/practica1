package vista;

import modelo.datos.TieneFecha;
import javax.swing.*;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import java.awt.*;
import java.util.Collection;

public class ScrollPanelConTabla {
    JTable tabla;

    public ScrollPanelConTabla() {
        super();
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

    public <T extends TieneFecha> JScrollPane crear(String[] columnas, Collection<T> elementos) {
        tabla = new JTable(new ModeloTabla<T>(columnas, elementos));
        anchoColumnas(); //ajustar ancho columnas al texto
        tabla.setAutoCreateRowSorter(true); //ordena solo los datos de la tabla
        tabla.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JScrollPane scrollPane = new JScrollPane(tabla);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        return scrollPane;
    }
}