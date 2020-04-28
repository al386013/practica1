package vista;

import controlador.Controlador;
import modelo.InterrogaModelo;
import modelo.principal.BaseDeDatos;
import modelo.principal.IntervaloFechasIncorrectoException;
import modelo.principal.TelfNoExistenteException;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;

public class VistaLlamadas implements InterrogaVistaLlamadas {
    private Controlador controlador;
    private InterrogaModelo modelo;
    private InterrogaVista vista;
    private JTextField telfOrigen;
    private JTextField telfDestino;
    private JTextField duracion;
    private JTextField telfListado;
    private JTextField telfListadoFechas;
    private JTextField fechaIniListado;
    private JTextField fechaFinListado;

    public VistaLlamadas() {
        super();
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

    public JPanel panel() {

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
                } catch(TelfNoExistenteException | IllegalArgumentException | IntervaloFechasIncorrectoException e) {
                    vista.accionDenegada(e.getMessage());
                }
            }
        };

        //DAR DE ALTA LLAMADA

        JPanel darAltaLlamada = new JPanel();
        JPanel darAltaLlamadaTitulo = new JPanel();
        JPanel darAltaLlamadaCampos = new JPanel();
        JPanel darAltaLlamadaIzq = new JPanel();
        JPanel darAltaLlamadaDer = new JPanel();

        JLabel telfOrigenLabel = new JLabel("Teléfono origen: ");
        JLabel telfDestLabel = new JLabel("Teléfono destino: ");
        JLabel duracionLabel = new JLabel("Duración: ");

        telfOrigen = new JTextField(17);
        telfDestino = new JTextField(17);
        duracion = new JTextField(17);
        telfOrigen.setText("Teléfono origen");
        telfDestino.setText("Teléfono destino");
        duracion.setText("Duración en segundos");

        darAltaLlamadaIzq.setLayout(new GridLayout(3, 1));
        darAltaLlamadaDer.setLayout(new GridLayout(3, 1));
        darAltaLlamadaIzq.add(telfOrigenLabel);
        darAltaLlamadaIzq.add(telfDestLabel);
        darAltaLlamadaIzq.add(duracionLabel);
        darAltaLlamadaDer.add(telfOrigen);
        darAltaLlamadaDer.add(telfDestino);
        darAltaLlamadaDer.add(duracion);

        darAltaLlamadaCampos.setLayout(new BoxLayout(darAltaLlamadaCampos, BoxLayout.X_AXIS));
        darAltaLlamadaCampos.add(darAltaLlamadaIzq);
        darAltaLlamadaCampos.add(darAltaLlamadaDer);

        JButton botonLlamada = new JButton("Guardar");
        botonLlamada.setActionCommand("llamada");
        botonLlamada.addActionListener(escuchadorBoton);
        botonLlamada.setAlignmentX(Component.CENTER_ALIGNMENT);
        darAltaLlamadaCampos.add(botonLlamada);

        darAltaLlamada.setLayout(new BoxLayout(darAltaLlamada, BoxLayout.PAGE_AXIS));
        darAltaLlamadaTitulo.add(new JLabel("<html>" + "<b><i>DAR DE ALTA LLAMADA</i></b><br/>" + "</html>"));
        darAltaLlamada.add(darAltaLlamadaTitulo);
        darAltaLlamada.add(darAltaLlamadaCampos);

        //LISTADO TODAS LAS LLAMADAS DE UN CLIENTE

        JPanel llamadasCli = new JPanel();
        JPanel llamadasCliTitulo = new JPanel();
        JPanel llamadasCliCampos = new JPanel();
        JPanel llamadasCliIzq = new JPanel();
        JPanel llamadasCliDer = new JPanel();

        JLabel telfLabel = new JLabel("Teléfono: ");
        telfListado = new JTextField(13);
        telfListado.setText("Teléfono");

        llamadasCliIzq.setLayout(new GridLayout(1, 1));
        llamadasCliDer.setLayout(new GridLayout(1, 1));
        llamadasCliIzq.add(telfLabel);
        llamadasCliDer.add(telfListado);

        llamadasCliCampos.setLayout(new BoxLayout(llamadasCliCampos, BoxLayout.X_AXIS));
        llamadasCliCampos.add(llamadasCliIzq);
        llamadasCliCampos.add(llamadasCliDer);

        JButton botonLlamadasCli = new JButton("Listar");
        botonLlamadasCli.setActionCommand("llamadasCli");
        botonLlamadasCli.addActionListener(escuchadorBoton);
        botonLlamadasCli.setAlignmentX(Component.CENTER_ALIGNMENT);
        llamadasCliCampos.add(botonLlamadasCli);

        llamadasCli.setLayout(new BoxLayout(llamadasCli, BoxLayout.PAGE_AXIS));
        llamadasCliTitulo.add(new JLabel("<html>" + "<b><i>LISTAR LLAMADAS DE UN CLIENTE</i></b><br/>" + "</html>"));
        llamadasCli.add(llamadasCliTitulo);
        llamadasCli.add(llamadasCliCampos);

        //LISTADO LLAMADAS ENTRE FECHAS DE UN CLIENTE

        JPanel llamadasCliEntreFechas = new JPanel();
        JPanel llamadasCliFechasTitulo = new JPanel();
        JPanel llamadasCliFechasCampos = new JPanel();
        JPanel llamadasCliFechasIzq = new JPanel();
        JPanel llamadasCliFechasDer = new JPanel();

        JLabel telfLabel2 = new JLabel("Teléfono: ");
        JLabel fechaIniLabel = new JLabel("Fecha inicio: ");
        JLabel fechaFinLabel = new JLabel("Fecha fin:  ");

        telfListadoFechas = new JTextField(15);
        fechaIniListado = new JTextField(15);
        fechaFinListado = new JTextField(15);
        telfListadoFechas.setText("Teléfono");
        fechaIniListado.setText("aaaa-mm-dd");
        fechaFinListado.setText("aaaa-mm-dd");

        llamadasCliFechasIzq.setLayout(new GridLayout(3, 1));
        llamadasCliFechasDer.setLayout(new GridLayout(3, 1));
        llamadasCliFechasIzq.add(telfLabel2);
        llamadasCliFechasIzq.add(fechaIniLabel);
        llamadasCliFechasIzq.add(fechaFinLabel);
        llamadasCliFechasDer.add(telfListadoFechas);
        llamadasCliFechasDer.add(fechaIniListado);
        llamadasCliFechasDer.add(fechaFinListado);

        llamadasCliFechasCampos.setLayout(new BoxLayout(llamadasCliFechasCampos, BoxLayout.X_AXIS));
        llamadasCliFechasCampos.add(llamadasCliFechasIzq);
        llamadasCliFechasCampos.add(llamadasCliFechasDer);

        JButton botonLlamadasCliFechas = new JButton("Listar");
        botonLlamadasCliFechas.setActionCommand("llamadasCliFechas");
        botonLlamadasCliFechas.addActionListener(escuchadorBoton);
        botonLlamadasCliFechas.setAlignmentX(Component.CENTER_ALIGNMENT);
        llamadasCliFechasCampos.add(botonLlamadasCliFechas);

        llamadasCliEntreFechas.setLayout(new BoxLayout(llamadasCliEntreFechas, BoxLayout.PAGE_AXIS));
        llamadasCliFechasTitulo.add(new JLabel("<html>" + "<b><i>LISTAR LLAMADAS DE UN CLIENTE ENTRE FECHAS</i></b><br/>" + "</html>"));
        llamadasCliEntreFechas.add(llamadasCliFechasTitulo);
        llamadasCliEntreFechas.add(llamadasCliFechasCampos);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
        panel.add(darAltaLlamada);
        panel.add(llamadasCli);
        panel.add(llamadasCliEntreFechas);
        return panel;
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
    public void listadoLlamadas(String telf){
        JFrame ventana = new JFrame("Listado llamadas");
        CustomJTable customJTable = new CustomJTable("llamadas");
        customJTable.cargarLlamadas(modelo.getBaseDeDatos().devolverLlamadas(telf));
        ventana.getContentPane().add(customJTable.getScrollPane());
        ventana.setSize(600,200);
        ventana.setVisible(true);
    }

    @Override
    public void listadoLlamadasEntreFechas(String telf, LocalDate fechaIni, LocalDate fechaFin){
        JFrame ventana = new JFrame("Listado llamadas entre fechas");
        CustomJTable customJTable = new CustomJTable("llamadas entre fechas");
        BaseDeDatos baseDeDatos = modelo.getBaseDeDatos();
        customJTable.cargarLlamadas(baseDeDatos.entreFechas(baseDeDatos.devolverLlamadas(telf), fechaIni, fechaFin));
        ventana.getContentPane().add(customJTable.getScrollPane());
        ventana.setSize(600,200);
        ventana.setVisible(true);
    }
}
