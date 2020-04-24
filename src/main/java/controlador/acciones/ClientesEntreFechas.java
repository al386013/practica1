package controlador.acciones;

import modelo.principal.BaseDeDatos;
import modelo.principal.IntervaloFechasIncorrectoException;
import vista.InterrogaVista;
import vista.InterrogaVistaClientes;

import java.time.LocalDate;

public class ClientesEntreFechas implements Accion {
    @Override
    public void ejecutaAccion(BaseDeDatos baseDeDatos, InterrogaVista vista) {
        try {
            InterrogaVistaClientes vistaClientes = vista.getVistaClientes();
            LocalDate fechaIni = vistaClientes.getFechaIni();
            LocalDate fechaFin = vistaClientes.getFechaFin();
            baseDeDatos.compruebaFechas(fechaIni, fechaFin);
            entradaSalida.imprimirConSalto("\nLISTADO DE CLIENTES ENTRE " + fechaIni + " y " + fechaFin);
            System.out.println(baseDeDatos.listarClientesEntreFechas(fechaIni, fechaFin));
        } catch (IntervaloFechasIncorrectoException e) {
            e.printStackTrace();
        }
    }
}
