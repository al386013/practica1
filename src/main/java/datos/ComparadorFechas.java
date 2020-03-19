package datos;

import datos.llamadas.Llamada;
import interfaces.TieneFecha;
import java.io.Serializable;
import java.util.Comparator;

public class ComparadorFechas <T extends Llamada > implements Comparator< T >, Serializable {
    @Override
    public int compare(T obj1, T obj2) {
        if(obj1.getFecha().isBefore(obj2.getFecha())) return -1;     //obj1 con fecha anterior
        else if(obj1.getFecha().isAfter(obj2.getFecha())) return 1;  //obj1 con fecha posterior
        else return 0; //misma fecha
    }
}