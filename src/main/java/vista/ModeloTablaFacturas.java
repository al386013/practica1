package vista;


import modelo.datos.clientes.Cliente;
import modelo.datos.clientes.Particular;
import modelo.datos.contrato.Factura;
import modelo.datos.llamadas.Llamada;
import modelo.principal.FabricaClientes;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.Collection;

import static java.lang.String.format;

public class ModeloTablaFacturas extends AbstractTableModel {
    private String nombreColumnas[];
    private ArrayList<Factura> datos;


    public <T extends Factura> ModeloTablaFacturas(String[] nombreColumnas, Collection<T> facturas) {
        super();
        this.nombreColumnas = nombreColumnas;
        this.datos = new ArrayList<>();
        this.datos.addAll(facturas);
    }

    public int getColumnCount() {
        return nombreColumnas.length;
    }
    public int getRowCount() {
        return datos.size();
    }
    public Object getValueAt(int row, int col) {
        Factura factura = datos.get(row);

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
            case 6:
                String string = "<html>";
                for (Llamada llamada : factura.getLlamadas())
                string += "<br/>" + llamada;
                return string + "</html>";
        }
        return null;
    }

    @Override
    public String getColumnName(int column) {
        return nombreColumnas[column];
    }
}
