package vista;

import modelo.datos.clientes.Cliente;
import modelo.datos.contrato.Factura;
import modelo.datos.llamadas.Llamada;

import javax.swing.*;
import java.util.Collection;

public class CustomJTable extends JFrame {
    JScrollPane scrollPane;
    JTable tabla;
    int anchoCol;

    public CustomJTable(String title) {
        super(title);
        setBounds(10,10,800,600);
    }
    //Todo: Mirar como unificar este metodo para que sea generico
    public void cargarClientes(Collection<Cliente> clientes) {
        String[] columnas = {"DNI", "Telefono", "Nombre", "Apellidos",
                "Direccion", "E-mail", "Fecha de Alta", "Hora de alta", "Tarifa"};
        ModeloTabla modeloTabla = new ModeloTabla(columnas, clientes);
        tabla = new JTable(modeloTabla);
    }

    public void cargarLlamadas(Collection<Llamada> llamadas) {
        ModeloTabla modeloTabla = new ModeloTabla(llamadas);
        tabla = new JTable(modeloTabla);
        //definir ancho columnas
        for(int i = 0; i < tabla.getColumnCount(); i++) {
            if(i == 4 || i == 8)
                anchoCol = 310;
            else if(i == 2 || i == 3 || i == 5)
                anchoCol = 160;
            else
                anchoCol = 100;
            tabla.getColumnModel().getColumn(i).setPreferredWidth(anchoCol);
        }
    }

    public void cargarFacturas(Collection<Factura> facturas){
        ModeloTabla modeloTabla= new ModeloTabla(facturas);
        tabla = new JTable(modeloTabla);
    }

    public JScrollPane getScrollPane() {
        tabla.setAutoCreateRowSorter(true);
        scrollPane = new JScrollPane(tabla);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        return scrollPane;
    }
}