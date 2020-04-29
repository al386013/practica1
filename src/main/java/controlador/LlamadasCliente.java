package controlador;

import modelo.principal.TelfNoExistenteException;
import vista.InterrogaVistaLlamadas;
import java.time.LocalDate;

public class LlamadasCliente extends Accion {
    public void ejecutaAccion() throws TelfNoExistenteException {
        InterrogaVistaLlamadas vistaLlamadas = vista.getVistaLlamadas();
        String telf = vistaLlamadas.getTelfListado();
        baseDeDatos.compruebaTelfExistente(telf);
        LocalDate fechaIni = LocalDate.parse("1999-01-01");
        LocalDate hoy = LocalDate.now();
        vista.getVistaLlamadas().listadoLlamadasEntreFechas(telf,fechaIni, hoy);
    }
}
