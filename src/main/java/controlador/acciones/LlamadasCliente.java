package controlador.acciones;

import modelo.principal.BaseDeDatos;
import modelo.principal.TelfNoExistenteException;
import vista.InterrogaVista;
import vista.InterrogaVistaLlamadas;

import java.time.LocalDate;

public class LlamadasCliente implements Accion {
    public void ejecutaAccion(BaseDeDatos baseDeDatos, InterrogaVista vista) throws TelfNoExistenteException {
        InterrogaVistaLlamadas vistaLlamadas = vista.getVistaLlamadas();
        String telf = vistaLlamadas.getTelfListado();
        baseDeDatos.compruebaTelfExistente(telf);
        LocalDate fechaIni = LocalDate.parse("1999-01-01");
        LocalDate hoy = LocalDate.now();
        vista.getVistaLlamadas().listadoLlamadasEntreFechas(telf,fechaIni, hoy);


    }
}
