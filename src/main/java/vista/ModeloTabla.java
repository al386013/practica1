package vista;

import modelo.datos.TieneFecha;
import modelo.datos.clientes.Cliente;
import modelo.datos.clientes.Direccion;
import modelo.datos.clientes.Particular;
import modelo.datos.contrato.Factura;
import modelo.datos.llamadas.Llamada;
import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.Collection;
import static java.lang.String.format;

public class ModeloTabla <T extends TieneFecha> extends AbstractTableModel {
    private final String nombreColumnas[];
    private ArrayList<T> datos;

    public ModeloTabla (final String[] nombreColumnas, final Collection<T> coleccion) {
        super();
        this.nombreColumnas = nombreColumnas;
        this.datos = new ArrayList<>();
        this.datos.addAll(coleccion);
    }

    public int getColumnCount() {
        return nombreColumnas.length;
    }

    public int getRowCount() {
        return datos.size();
    }

    public Object getValueAt(int row, int col) {
        T elemento = datos.get(row);
        if(elemento instanceof Cliente)
            return datosCliente((Cliente) elemento, col);
        else if(elemento instanceof Llamada)
            return datosLlamada((Llamada) elemento, col);
        else
            return datosFactura((Factura) elemento, col);
    }

    private Object datosCliente(Cliente cliente, int col) {
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

    public Object datosFactura(Factura factura, int col) {
        switch(col) {
            case 0:
                return factura.getCodigo();
            case 1:
                return factura.getFecha();
            case 2:
                return format("%02d:%02d", factura.getHora().getHour(), factura.getHora().getMinute());
            case 3:
                return factura.getImporte();
            case 4:
                return factura.getPeriodoFact().getFechaIni();
            case 5:
                return factura.getPeriodoFact().getFechaFin();
        }
        return null;
    }

    public Object datosLlamada(Llamada llamada, int col) {
        switch(col) {
            case 0:
                return llamada.getTeflOrigen();
            case 1:
                return llamada.getTelfDest();
            case 2:
                return llamada.getFecha();
            case 3:
                return format("%02d:%02d", llamada.getHora().getHour(), llamada.getHora().getMinute());
            case 4:
                return llamada.getDuracion();
        }
        return null;
    }

    @Override
    public String getColumnName(int column) {
        return nombreColumnas[column];
    }
}

