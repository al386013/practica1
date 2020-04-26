package vista;

import modelo.datos.clientes.Cliente;
import javax.swing.*;
import java.awt.*;
import java.util.Collection;

public class CustomJTable extends JFrame {
    JScrollPane scrollPane;
    JPanel panelTabla;
    public CustomJTable(String title, Collection<Cliente> clientes) {
        super(title);
        setBounds(10,10,800,600);
        ModeloTabla modeloTabla = new ModeloTabla(clientes);
        JTable tabla = new JTable(modeloTabla);
        tabla.setAutoCreateRowSorter(true); //??????????????????????
        for(int i = 0; i < tabla.getColumnCount(); i++)
            tabla.getColumnModel().getColumn(i).setPreferredWidth(100);
        scrollPane = new JScrollPane(tabla);
        scrollPane.setPreferredSize(new Dimension(380,280));
        panelTabla = new JPanel();
        panelTabla.add(scrollPane);
        add(panelTabla,BorderLayout.CENTER);
    }

    public JPanel getPanelTabla() {
        return panelTabla;
    }
}
