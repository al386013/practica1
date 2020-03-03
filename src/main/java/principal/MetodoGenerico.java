package principal;

import datos.llamadas.Llamada;
import interfaces.tieneFecha;

import java.time.LocalDate;
import java.util.Collection;
import java.util.HashSet;

public class MetodoGenerico {
    public static < T extends tieneFecha> Collection< T > comparaFechas(HashSet< T > conjunto, LocalDate fechaIni, LocalDate fechaFin) {
        Collection< T > res = new HashSet< >();
        for (T elem : conjunto) {
            LocalDate fecha = elem.getFecha();
            if(fecha.isAfter(fechaIni) && fecha.isBefore(fechaFin))
                res.add(elem);
        }
        return res;
    }
}
