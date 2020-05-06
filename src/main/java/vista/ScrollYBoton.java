package vista;

import modelo.datos.TieneFecha;
import javax.swing.*;
import javax.swing.event.ListSelectionListener;
import java.awt.event.ActionListener;

//clase con codigo comun para PanelLlamadas, PanelClientes y PanelFacturas
//inserta un scrollPanel en la tabla, crea el boton actualizar y suscribe el boton al escuchador

public class ScrollYBoton <T extends TieneFecha> {
    public ScrollYBoton() {
        super();
    }

    public JPanel ejecuta(Tabla tabla, JPanel panelIni, ListSelectionListener escuchadorTabla, ActionListener escuchadorBoton) {
        JPanel panel = panelIni;

        //anadir el escuchador de la tabla a la tabla
        ListSelectionModel listSelectionModel = tabla.getSelectionModel();
        listSelectionModel.addListSelectionListener(escuchadorTabla);

        //anadir una barra de scroll a la tabla: el scroll vertical siempre se muestra
        JScrollPane scrollPane = new JScrollPane(tabla);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        panel.add(scrollPane);

        //anadir el boton actualizar tabla al panel
        JButton boton = new JButton("Actualizar tabla");
        boton.addActionListener(escuchadorBoton);
        JPanel panelBoton = new JPanel();
        panelBoton.add(boton);
        panel.add(panelBoton);

        return panel;
    }
}
