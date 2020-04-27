package vista;

import modelo.datos.clientes.Cliente;
import modelo.datos.clientes.Particular;
import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.Collection;
import static java.lang.String.format;

public class ModeloTabla extends AbstractTableModel {
    private final String nombreColumnas[] = {"DNI", "Telefono", "Nombre", "Apellidos",
            "Direccion", "E-mail", "Fecha de Alta", "Hora de alta", "Tarifa"};
    private ArrayList<Cliente> datos;

    public <T extends Cliente> ModeloTabla(Collection<T> clientes) {
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
                return cliente.getFecha().toString();
            case 7:
                return format("%02d:%02d", cliente.getHora().getHour(), cliente.getHora().getMinute());
            case 8:
                return cliente.getTarifa().descripcion();
        }
        return null;
    }

    @Override
    public String getColumnName(int column) {
        return nombreColumnas[column];
    }
}
