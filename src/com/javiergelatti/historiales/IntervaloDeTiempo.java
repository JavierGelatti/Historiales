package com.javiergelatti.historiales;

import java.util.Date;
import java.util.Objects;

class IntervaloDeTiempo {
    private final Date inicio;
    private final Date fin;

    public IntervaloDeTiempo(Date inicio, Date fin) {
        this.inicio = inicio;
        this.fin = fin;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof IntervaloDeTiempo))
            return false;

        IntervaloDeTiempo elOtro = (IntervaloDeTiempo) obj;
        return inicio.equals(elOtro.inicio) && fin.equals(elOtro.fin);
    }

    @Override
    public int hashCode() {
        return Objects.hash(inicio, fin);
    }

    public boolean contieneA(Date unMomento) {
        return (unMomento.after(inicio) || unMomento.equals(inicio)) && unMomento.before(fin);
    }
}
