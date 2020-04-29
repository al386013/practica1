package vista;

import controlador.Controlador;
import modelo.InterrogaModelo;
import modelo.datos.llamadas.Llamada;
import modelo.principal.BaseDeDatos;
import modelo.principal.IntervaloFechasIncorrectoException;
import modelo.principal.TelfNoExistenteException;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.Collection;

public class PanelLlamadas extends JPanel implements InterrogaVistaLlamadas {
    private Controlador controlador;
    private InterrogaModelo modelo;
    private InterrogaVista vista;
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

    public void setVista(InterrogaVista vista) {
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
                } catch(TelfNoExistenteException | IntervaloFechasIncorrectoException e) {
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
        telfOrigen.setText("Teléfono origen");
        telfDestino.setText("Teléfono destino");
        duracion.setText("Duración en segundos");

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
        telfListado.setText("Teléfono");

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
        telfListadoFechas.setText("Teléfono");
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

    @Override
    public void listadoLlamadasEntreFechas(String telf, LocalDate fechaIni, LocalDate fechaFin){
        JFrame ventana = new JFrame("Listado llamadas");
        BaseDeDatos baseDeDatos = modelo.getBaseDeDatos();
        String[] columnas = {"Destino", "Fecha", "Hora", "Duracion"};
        Collection<Llamada> llamadas = baseDeDatos.devolverLlamadas(telf);
        Container contenedor = ventana.getContentPane();

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
        titulo = new JPanel();
        titulo.add(new JLabel("<html><i><big>LLAMADAS DEL CLIENTE<big></i></html>"));
        panel.add(titulo);
        titulo = new JPanel();
        titulo.add(new JLabel("<html>Pulsa sobre una fila para más información.</html>"));
        panel.add(titulo);
        Tabla tabla = new Tabla();
        JScrollPane scrollPane = new JScrollPane(tabla.crear(columnas, baseDeDatos.entreFechas(llamadas, fechaIni, fechaFin)));
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        panel.add(scrollPane);
        contenedor.add(panel);
        ventana.setSize(600,200);
        ventana.setVisible(true);
    }

}
