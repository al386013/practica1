package vista;

import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;

public class ModeloTabla extends AbstractTableModel {
    private final String nombreColumnas[] = {"DNI", "Telefono", "Nombre", "Apellidos",
            "Direccion", "E-mail", "Fecha de Alta", "Tarifa"};
    private Object datos[][];

    public int getColumnCount() {
        return nombreColumnas.length;
    }
    public int getRowCount() {
        return datos.length;
    }
    public Object getValueAt(int row, int column) {
        return datos[row][column];
    }
    @Override
    public String getColumnName(int column) {
        return nombreColumnas[column];
    }
}
