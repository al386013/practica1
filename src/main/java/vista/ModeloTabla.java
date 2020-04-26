package vista;

import modelo.datos.clientes.Cliente;
import modelo.datos.clientes.Direccion;
import modelo.datos.clientes.Particular;
import modelo.datos.contrato.tarifas.Tarifa;
import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.Collection;

public class ModeloTabla extends AbstractTableModel {
    private final String nombreColumnas[] = {"DNI", "Telefono", "Nombre", "Apellidos",
            "Direccion", "E-mail", "Fecha de Alta", "Tarifa"};
    //private Object datos[][];
    private ArrayList<Cliente> datos;

    public ModeloTabla(Collection<Cliente> clientes) {
        super();
        this.datos = new ArrayList<>();
        this.datos.addAll(clientes);
    }

    public int getColumnCount() {
        return nombreColumnas.length;
    }
    public int getRowCount() {
        return datos.size();
    }
    public Object getValueAt(int row, int col) {
        Cliente cliente = datos.get(row);
        switch(col) {
            case 0:
                return cliente.getNIF();
            case 1:
                return cliente.getTelf();
            case 2:
                return cliente.getNombre();
            case 3:
                String apellidos = "";
                if(cliente instanceof Particular)
                    apellidos = ((Particular) cliente).getApellidos();
                return apellidos;
            case 4:
                return cliente.getDireccion().toString();
            case 5:
                return cliente.getEmail();
            case 6:
                return cliente.getTarifa().toString();
        }
        return null;
    }

    @Override
    public String getColumnName(int column) {
        return nombreColumnas[column];
    }

    public Class getColumnClass(int col) {
        if (col == 4)
            return Direccion.class;
        else if (col == 6)
            return Tarifa.class;
        else
            return String.class;
    }
}
