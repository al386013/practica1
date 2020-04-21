package modelo.datos.contrato;

import java.io.Serializable;
import java.time.LocalDate;

public class PeriodoFacturacion implements Serializable {
    private LocalDate fechaIni;
    private LocalDate fechaFin;

    public PeriodoFacturacion() {
        super();
        this.fechaIni = null;
        this.fechaFin = null;
    }

    public PeriodoFacturacion(LocalDate fechaIni, LocalDate fechaFin) {
        super();
        this.fechaIni = fechaIni;
        this.fechaFin = fechaFin;
    }

    public LocalDate getFechaFin() {
        return fechaFin;
    }

    public LocalDate getFechaIni() {
        return fechaIni;
    }

    @Override
    public String toString() {
        return fechaIni + " - " + fechaFin;
    }
}
