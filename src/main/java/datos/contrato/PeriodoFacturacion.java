package datos.contrato;

import java.time.LocalDate;

public class PeriodoFacturacion{
    private LocalDate fechaIni;
    private LocalDate fechaFin;

    public PeriodoFacturacion(LocalDate fechaIni, LocalDate fechaFin) {
        this.fechaIni = fechaIni;
        this.fechaFin = fechaFin;
    }

    public LocalDate getFechaFin() {
        return fechaFin;
    }

    public LocalDate getFechaIni() {
        return fechaIni;
    }


}
