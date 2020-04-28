/*package vista;

import modelo.datos.clientes.Cliente;
import modelo.datos.clientes.Direccion;
import modelo.datos.clientes.Particular;
import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.Collection;
import static java.lang.String.format;

public class ModeloTablaClientes extends AbstractTableModel {
    private String nombreColumnas[];
    private ArrayList<Cliente> datos;

    public <T extends Cliente> ModeloTablaClientes(String[] nombreColumnas, Collection<T> clientes) {
        super();
        this.nombreColumnas = nombreColumnas;
        this.datos = new ArrayList<>();
        this.datos.addAll(clientes);
    }

//    public <T extends TieneFecha> ModeloTabla(String[] nombreColumnas, ArrayList<T> elementos) {
//        super();
//        this.nombreColumnas = nombreColumnas;
//        this.datos = new ArrayList<>();
//        for(T elemento: elementos){
//            this.datos.add(elemento);
//        }
//    }

    public int getColumnCount() {
        return nombreColumnas.length;
    }

    public int getRowCount() {
        return datos.size();
    }

    public Object getValueAt(int row, int col) {
        Cliente cliente = datos.get(row);
        Direccion direccion = cliente.getDireccion();
        switch (col) {
            case 0:
                return cliente.getNIF();
            case 1:
                return cliente.getTelf();
            case 2:
                return cliente.getNombre();
            case 3:
                String apellidos = "";
                if (cliente instanceof Particular)
                    apellidos = ((Particular) cliente).getApellidos();
                return apellidos;
            case 4:
                return direccion.getCP();
            case 5:
                return direccion.getPoblacion();
            case 6:
                return direccion.getProvincia();
            case 7:
                return cliente.getEmail();
            case 8:
                return cliente.getFecha();
            case 9:
                return format("%02d:%02d", cliente.getHora().getHour(), cliente.getHora().getMinute());
            case 10:
                return cliente.getTarifa().descripcion();
        }
        return null;
    }

    @Override
    public String getColumnName(int column) {
        return nombreColumnas[column];
    }
}*/
