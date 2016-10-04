package com.javiergelatti.historiales;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class Historial<T> {

    private Map<IntervaloDeTiempo, T> valores = new HashMap<>();
    private T ultimoValor;
    private Date fechaInicioUltimoValor;

    private Supplier<Long> reloj;

    public Historial(T valorInicial) {
        this(valorInicial, System::currentTimeMillis);
    }

    public Historial(T valorInicial, Supplier<Long> reloj) {
        this.ultimoValor = valorInicial;
        this.fechaInicioUltimoValor = new Date(0);
        this.reloj = reloj;
    }

    public T ultimoValor() {
        return ultimoValor;
    }

    public void setValor(T valor) {
        valores.put(new IntervaloDeTiempo(fechaInicioUltimoValor, momentoActual()), ultimoValor);

        setUltimoValor(valor);
    }

    private void setUltimoValor(T valor) {
        ultimoValor = valor;
        fechaInicioUltimoValor = momentoActual();
    }

    private Date momentoActual() {
        return new Date(reloj.get());
    }

    public T getValorEn(Date unMomento) {
        if (unMomento.after(fechaInicioUltimoValor) || unMomento.equals(fechaInicioUltimoValor))
            return ultimoValor;

        return valores.get(getIntervaloPara(unMomento));
    }

    private IntervaloDeTiempo getIntervaloPara(Date unMomentoEnElTiempo) {
        return valores.keySet().stream()
                .filter(i -> i.contieneA(unMomentoEnElTiempo))
                .findAny()
                .get();
    }

}
