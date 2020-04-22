package vista;


import controlador.Controlador;
import controlador.acciones.*;
import modelo.InterrogaModelo;
import modelo.principal.BaseDeDatos;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ImplementacionVista implements InformaVista, InterrogaVista {
    private Accion accion;
    private Controlador controlador;
    private InterrogaModelo modelo;
    private JLabel boton;
    private JList lista;
    private int indice;
    private BaseDeDatos baseDeDatos;

    public ImplementacionVista() {}

    public void setModelo(InterrogaModelo modelo) {
        this.modelo = modelo;
    }

    public void setControlador(Controlador controlador) {
        this.controlador = controlador;
    }


    public void creaGUI() {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                baseDeDatos = modelo.getBaseDeDatos();
                menuPrincipal();
            }
        });
    }

    private void menuPrincipal() {
        JFrame ventana = new JFrame("Programa");
        Container contenedor = ventana.getContentPane();
        JList jList = new JList(new String[]{
                "Importar los datos.",
                "Operacion clientes.",
                "Operacion llamadas.",
                "Operacion facturas.",
                "Salir y guardar datos."
        });
        jList.setVisibleRowCount(5);
        jList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JScrollPane scroll = new JScrollPane(jList);
        contenedor.add(scroll);
        contenedor.add(jList,BorderLayout.CENTER);
        EscuchadorPrincipal escuchador = new EscuchadorPrincipal();
        JButton boton = new JButton("Siguiente");
        boton.addActionListener(escuchador);
        contenedor.add(boton, BorderLayout.SOUTH);
        //selecciona un elemento de la lista
        Object seleccion = jList.getSelectedValue();
        //recoge el indice de los seleccionados
        indice = jList.getSelectedIndex();

//        JPanel jpEntrada = new JPanel();
//        JPanel jpContador = new JPanel();
//        jtfNombre = new JTextField(20);
//        JButton jbNuevo = new JButton("Nuevo");
//        jbNuevo.addActionListener(escuchador);
//        JButton jbAtras = new JButton("Atras");
//        jbAtras.addActionListener(escuchador);
//        JButton jbAdelante = new JButton("Adelante");
//        jbAdelante.addActionListener(escuchador);
//        jlContador = new JLabel(infoEstadoEntradas());
//        jpEntrada.add(jtfNombre);
//        jpEntrada.add(jbNuevo);
//        jpEntrada.add(jbAtras);
//        jpEntrada.add(jbAdelante);
//        jpContador.add(jlContador);
//        contenedor.add(jpEntrada, BorderLayout.NORTH);
//        contenedor.add(jpContador, BorderLayout.SOUTH);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.pack();
        ventana.setVisible(true);
    }


    private class EscuchadorPrincipal implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            switch (indice){
                case 0:
                    new ImportarDatos().ejecutaAccion(baseDeDatos);
                    break;
                case 1:
                    menuClientes();
                    break;
                case 2:
                    menuLlamadas();
                    break;
                case 3:
                    menuFacturas();
                    break;
                case 4:
                    new ExportarDatosYsalir().ejecutaAccion(baseDeDatos);
                    break;
            }
        }
    }

    private void menuClientes(){}

    private class EscuchadorClientes implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            try {
                switch (indice){
                    case 0:
                        new DarAltaCliente().ejecutaAccion(baseDeDatos);
                        break;
                    case 1:
                        new BorrarCliente().ejecutaAccion(baseDeDatos);
                        break;
                    case 2:
                        new SeleccionaOpcionCambiarTarifa().ejecutaAccion(baseDeDatos);
                        break;
                    case 3:
                        new DatosCliente().ejecutaAccion(baseDeDatos);
                        break;
                    case 4:
                        new ListadoClientes().ejecutaAccion(baseDeDatos);
                        break;
                    case 5:
                        new ClientesEntreFechas().ejecutaAccion(baseDeDatos);
                        break;
                    case 6:
                        menuPrincipal();
                        break;
                    case 7:
                        new ExportarDatosYsalir().ejecutaAccion(baseDeDatos);
                        break;
                }

            }catch (OpcionIncorrectaException exception){
                exception.printStackTrace();
            }

        }
    }

    private void menuLlamadas(){}

    private class EscuchadorLlamadas implements ActionListener{
        public void actionPerformed(ActionEvent event) {
            switch (indice){
                case 0:
                    new DaAltaLlamada().ejecutaAccion(baseDeDatos);
                    break;
                case 1:
                    new LlamadasCliente().ejecutaAccion(baseDeDatos);
                    break;
                case 2:
                    new LlamadasClienteEntreFechas().ejecutaAccion(baseDeDatos);
                    break;
                case 3:
                    menuPrincipal();
                    break;
                case 4:
                    new ExportarDatosYsalir().ejecutaAccion(baseDeDatos);
                    break;
            }
        }
    }

    private void menuFacturas(){}

    private class EscuchadorFacturas implements ActionListener{
        public void actionPerformed(ActionEvent event) {
            switch (indice){
                case 0:
                    new EmiteFactura().ejecutaAccion(baseDeDatos);
                    break;
                case 1:
                    new DatosFactura().ejecutaAccion(baseDeDatos);
                    break;
                case 2:
                    new FacturasCliente().ejecutaAccion(baseDeDatos);
                    break;
                case 3:
                    new FacturasCliEntreFechas().ejecutaAccion(baseDeDatos);
                    break;
                case 4:
                    menuPrincipal();
                    break;
                case 5:
                    new ExportarDatosYsalir().ejecutaAccion(baseDeDatos);
                    break;
            }
        }
    }

    private void menuCambiarTarifa(){}

    private class EscuchadorCambiarTarifa implements ActionListener{
        public void actionPerformed(ActionEvent event) {
            switch (indice){
                case 0:
                    new EmiteFactura().ejecutaAccion(baseDeDatos);
                    break;
                case 1:
                    new DatosFactura().ejecutaAccion(baseDeDatos);
                    break;
                case 2:
                    new FacturasCliente().ejecutaAccion(baseDeDatos);
                    break;
                case 3:
                    new FacturasCliEntreFechas().ejecutaAccion(baseDeDatos);
                    break;
                case 4:
                    menuPrincipal();
                    break;
                case 5:
                    new ExportarDatosYsalir().ejecutaAccion(baseDeDatos);
                    break;
            }
        }
    }
    private void menuTipoCliente(){}





}
