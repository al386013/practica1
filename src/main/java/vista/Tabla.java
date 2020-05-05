package vista;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import java.awt.*;

public class Tabla extends JTable {

    public Tabla(AbstractTableModel modelo) {
        super(modelo);
        setAutoCreateRowSorter(true); //ordena solo los datos de la tabla
        setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        anchoColumnas();
    }

    //metodo que ajusta en ancho de las columnas de la tabla al texto de las celdas
    public void anchoColumnas(){
        for (int column = 0; column < getColumnCount(); column++){
            TableColumn tableColumn = getColumnModel().getColumn(column);
            int preferredWidth = tableColumn.getMinWidth();
            int maxWidth = tableColumn.getMaxWidth();
            for (int row = 0; row < getRowCount(); row++) {
                TableCellRenderer cellRenderer = getCellRenderer(row, column);
                Component c = prepareRenderer(cellRenderer, row, column);
                int width = c.getPreferredSize().width + getIntercellSpacing().width;
                preferredWidth = Math.max(preferredWidth, width);
                if (preferredWidth >= maxWidth){
                    preferredWidth = maxWidth;
                    break;
                }
            }
            tableColumn.setPreferredWidth( preferredWidth );
        }
    }
}