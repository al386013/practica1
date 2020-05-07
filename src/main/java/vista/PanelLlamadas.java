package vista;

import controlador.Controlador;
import modelo.InterrogaModelo;
import modelo.datos.llamadas.Llamada;
import modelo.principal.BaseDeDatos;
import modelo.principal.IntervaloFechasIncorrectoException;
import modelo.principal.TelfNoExistenteException;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.Collection;

public class PanelLlamadas extends JPanel implements InterrogaVistaLlamadas {
    private Controlador controlador;
    private InterrogaModelo modelo;
    private InformaVista vista;
    private Tabla tabla;
    private ModeloTabla<Llamada> modeloTabla;
    private JPanel titulo;
    private JTextField telfOrigen;
    private JTextField telfDestino;
    private JTextField duracion;
    private JTextField telfListado;
    private JTextField telfListadoFechas;
    private JTextField fechaIniListado;
    private JTextField fechaFinListado;

    public PanelLlamadas() {
        super();
        panel();
    }

    public void setModelo(InterrogaModelo modelo) {
        this.modelo = modelo;
    }

    public void setControlador(Controlador controlador) {
        this.controlador = controlador;
    }

    public void setVista(InformaVista vista) {
        this.vista = vista;
    }

    public void panel() {
        ActionListener escuchadorBoton = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evento) {
                String comando = evento.getActionCommand();
                try {
                    if (comando.equals("llamada"))
                        controlador.darAltaLlamada();
                    else if (comando.equals("llamadasCli"))
                        controlador.llamadasCli();
                    else if (comando.equals("llamadasCliFechas"))
                        controlador.llamadasCliFechas();
                } catch (TelfNoExistenteException | IntervaloFechasIncorrectoException e) {
                    vista.accionDenegada(e.getMessage());
                }
            }
        };

        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));

        //DAR DE ALTA LLAMADA

        titulo = new JPanel();
        JPanel panelCampos = new JPanel();
        JPanel panelIzq = new JPanel();
        JPanel panelDer = new JPanel();
        JPanel panelSeccion = new JPanel();

        telfOrigen = new JTextField(17);
        telfDestino = new JTextField(17);
        duracion = new JTextField(17);
        telfOrigen.setText("Escribe teléfono origen");
        telfDestino.setText("Escribe teléfono destino");
        duracion.setText("Escribe duración en segundos");

        panelIzq.setLayout(new GridLayout(3, 1));
        panelDer.setLayout(new GridLayout(3, 1));
        panelIzq.add(new JLabel("Teléfono origen: "));
        panelIzq.add(new JLabel("Teléfono destino: "));
        panelIzq.add(new JLabel("Duración: "));
        panelDer.add(telfOrigen);
        panelDer.add(telfDestino);
        panelDer.add(duracion);

        panelCampos.setLayout(new BoxLayout(panelCampos, BoxLayout.X_AXIS));
        panelCampos.add(panelIzq);
        panelCampos.add(panelDer);

        JButton botonLlamada = new JButton("Guardar");
        botonLlamada.setActionCommand("llamada");
        botonLlamada.addActionListener(escuchadorBoton);
        botonLlamada.setAlignmentX(Component.CENTER_ALIGNMENT);
        panelCampos.add(botonLlamada);

        panelSeccion.setLayout(new BoxLayout(panelSeccion, BoxLayout.PAGE_AXIS));
        titulo.add(new JLabel("<html><i>DAR DE ALTA LLAMADA</i></html>"));
        panelSeccion.add(titulo);
        panelSeccion.add(panelCampos);
        add(panelSeccion);

        //LISTADO TODAS LAS LLAMADAS DE UN CLIENTE

        titulo = new JPanel();
        panelCampos = new JPanel();
        panelIzq = new JPanel();
        panelDer = new JPanel();
        panelSeccion = new JPanel();

        telfListado = new JTextField(13);
        telfListado.setText("Escribe teléfono");

        panelIzq.setLayout(new GridLayout(1, 1));
        panelDer.setLayout(new GridLayout(1, 1));
        panelIzq.add(new JLabel("Teléfono: "));
        panelDer.add(telfListado);

        panelCampos.setLayout(new BoxLayout(panelCampos, BoxLayout.X_AXIS));
        panelCampos.add(panelIzq);
        panelCampos.add(panelDer);

        JButton botonLlamadasCli = new JButton("Listar");
        botonLlamadasCli.setActionCommand("llamadasCli");
        botonLlamadasCli.addActionListener(escuchadorBoton);
        botonLlamadasCli.setAlignmentX(Component.CENTER_ALIGNMENT);
        panelCampos.add(botonLlamadasCli);

        panelSeccion.setLayout(new BoxLayout(panelSeccion, BoxLayout.PAGE_AXIS));
        titulo.add(new JLabel("<html><i>LISTAR LLAMADAS DE UN CLIENTE</i></html>"));
        panelSeccion.add(titulo);
        panelSeccion.add(panelCampos);
        add(panelSeccion);

        //LISTADO LLAMADAS ENTRE FECHAS DE UN CLIENTE

        titulo = new JPanel();
        panelCampos = new JPanel();
        panelIzq = new JPanel();
        panelDer = new JPanel();
        panelSeccion = new JPanel();

        telfListadoFechas = new JTextField(15);
        fechaIniListado = new JTextField(15);
        fechaFinListado = new JTextField(15);
        telfListadoFechas.setText("Escribe teléfono");
        fechaIniListado.setText("aaaa-mm-dd");
        fechaFinListado.setText("aaaa-mm-dd");

        panelIzq.setLayout(new GridLayout(3, 1));
        panelDer.setLayout(new GridLayout(3, 1));
        panelIzq.add(new JLabel("Teléfono: "));
        panelIzq.add(new JLabel("Fecha inicio: "));
        panelIzq.add(new JLabel("Fecha fin:  "));
        panelDer.add(telfListadoFechas);
        panelDer.add(fechaIniListado);
        panelDer.add(fechaFinListado);

        panelCampos.setLayout(new BoxLayout(panelCampos, BoxLayout.X_AXIS));
        panelCampos.add(panelIzq);
        panelCampos.add(panelDer);

        JButton botonLlamadasCliFechas = new JButton("Listar");
        botonLlamadasCliFechas.setActionCommand("llamadasCliFechas");
        botonLlamadasCliFechas.addActionListener(escuchadorBoton);
        botonLlamadasCliFechas.setAlignmentX(Component.CENTER_ALIGNMENT);
        panelCampos.add(botonLlamadasCliFechas);

        panelSeccion.setLayout(new BoxLayout(panelSeccion, BoxLayout.PAGE_AXIS));
        titulo.add(new JLabel("<html><i>LISTAR LLAMADAS DE UN CLIENTE ENTRE FECHAS</i></html>"));
        panelSeccion.add(titulo);
        panelSeccion.add(panelCampos);
        add(panelSeccion);
    }

    @Override
    public String getTelfOrigen() {
        return telfOrigen.getText();
    }

    @Override
    public String getTelfDestino() {
        return telfDestino.getText();
    }

    @Override
    public int getDuracion() {
        return Integer.parseInt(duracion.getText());
    }

    @Override
    public String getTelfListado() {
        return telfListado.getText();
    }

    @Override
    public String getTelfListadoFechas() {
        return telfListadoFechas.getText();
    }

    @Override
    public LocalDate getFechaIniListado() {
        return LocalDate.parse(fechaIniListado.getText());
    }

    @Override
    public LocalDate getFechaFinListado() {
        return LocalDate.parse(fechaFinListado.getText());
    }

    //muestra las llamadas del cliente en una tabla
    @Override
    public void listadoLlamadasEntreFechas(String telf, LocalDate fechaIni, LocalDate fechaFin) {
        //crea la ventana y el texto
        JFrame ventana = new JFrame("Listado llamadas");
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
        titulo = new JPanel();
        titulo.add(new JLabel("<html><i><big>LLAMADAS DEL CLIENTE<big></i></html>"));
        panel.add(titulo);
        titulo = new JPanel();
        titulo.add(new JLabel("<html>Pulsa sobre una fila para más información.</html>"));
        panel.add(titulo);

        //crea modeloTabla y tabla
        String[] columnas = {"Origen", "Destino", "Fecha", "Hora", "Duracion"};
        BaseDeDatos baseDeDatos = modelo.getBaseDeDatos();
        Collection<Llamada> llamadas = baseDeDatos.devolverLlamadas(telf);
        modeloTabla = new ModeloTabla<>(columnas, baseDeDatos.entreFechas(llamadas, fechaIni, fechaFin));
        tabla = new Tabla(modeloTabla);

        //crea el escuchador de la tabla
        ListSelectionListener escuchadorTabla = new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                //si se ejecuta este metodo porque se da al boton de actualizar
                //y no se selecciona ninguna fila
                ListSelectionModel lsm = (ListSelectionModel)e.getSource();
                if(lsm.getMinSelectionIndex() == -1) return;

                if (!e.getValueIsAdjusting()) {
                    int fila = tabla.convertRowIndexToModel(tabla.getSelectedRow());
                    String telfOrigen = (String) modeloTabla.getValueAt(fila, 0);
                    String telfDestino = (String) modeloTabla.getValueAt(fila, 1);
                    LocalDate fecha = (LocalDate) modeloTabla.getValueAt(fila, 2);
                    String hora = (String) modeloTabla.getValueAt(fila, 3);
                    int duracion = (Integer) modeloTabla.getValueAt(fila, 4);
                    datosLlamada(telfOrigen, telfDestino, fecha, hora, duracion);
                }
            }
        };

        //crear escuchador para el boton actualizar tabla
        ActionListener escuchadorActualizar = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evento) {
                tabla.setModel(modeloTabla = new ModeloTabla<>(columnas,
                        baseDeDatos.entreFechas(llamadas, fechaIni, fechaFin)));
                tabla.anchoColumnas();
            }
        };

        //clase generica comun al resto de tablas
        ScrollYBoton<Llamada> scrollYBoton = new ScrollYBoton<>();
        JPanel panel2 = scrollYBoton.ejecuta(tabla, panel, escuchadorActualizar, escuchadorTabla);

        Container contenedor = ventana.getContentPane();
        contenedor.add(panel);
        contenedor.add(panel2);

        ventana.getContentPane().add(panel);
        ventana.setSize(700, 300);
        ventana.setVisible(true);
    }

    //lista los datos de una llamada
    @Override
    public void datosLlamada(String telfOrigen, String telfDest, LocalDate fecha, String hora, int duracion) {
        JFrame ventana = new JFrame("Datos de la llamada");
        String string = "<html><big> Datos llamada </big><br/>";
        string += "<ul><li> Teléfono origen: " + telfOrigen + "</li>";
        string += "<li> Telefono destino: " + telfDest + "</li>";
        string += "<li> Fecha: " + fecha + "</li>";
        string += "<li> Hora: " + hora + "</li>";
        string += "<li> Duración: " + duracion + "</li></ul></html>";
        JLabel texto = new JLabel(string);
        ventana.getContentPane().add(texto);
        ventana.setSize(300, 300);
        ventana.setVisible(true);
    }
}
