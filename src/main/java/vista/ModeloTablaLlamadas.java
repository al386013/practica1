package vista;


import modelo.datos.clientes.Cliente;
import modelo.datos.clientes.Particular;
import modelo.datos.llamadas.Llamada;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.Collection;

import static java.lang.String.format;

public class ModeloTablaLlamadas extends AbstractTableModel {
    private String nombreColumnas[];
    private ArrayList<Llamada> datos;


    public <T extends Llamada> ModeloTablaLlamadas(String[] nombreColumnas, Collection<T> llamadas) {
        super();
        this.nombreColumnas = nombreColumnas;
        this.datos = new ArrayList<>();
        this.datos.addAll(llamadas);
    }

//
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
        Llamada llamada = datos.get(row);
        switch(col) {
            case 0:
                return llamada.getTelfDest();
            case 1:
                return llamada.getFecha();
            case 2:
                return format("%02d:%02d", llamada.getHora().getHour(), llamada.getHora().getMinute());
            case 3:
                return llamada.getDuracion();
        }
        return null;
    }

    @Override
    public String getColumnName(int column) {
        return nombreColumnas[column];
    }
}
