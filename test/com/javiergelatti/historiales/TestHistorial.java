package com.javiergelatti.historiales;

import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.assertEquals;

public class TestHistorial {

    private long milisegundosActuales = 0;

    @Test
    public void siNoHayMasValores_ElUltimoValorEsElInicial() throws Exception {
        Historial<Integer> historial = new Historial<>(1);

        assertEquals(1, historial.ultimoValor().intValue());
    }

    @Test
    public void elUltimoValorEsElUltimoAsignado() throws Exception {
        Historial<Integer> historial = new Historial<>(1);

        historial.setValor(3);

        assertEquals(3, historial.ultimoValor().intValue());
    }

    @Test
    public void elValorEnElMomentoActualEsElUltimoValor() throws Exception {
        Historial<Integer> historial = new Historial<>(1);

        historial.setValor(3);

        assertEquals(3, historial.getValorEn(new Date()).intValue());
    }

    @Test
    public void sePuedeConsultarElValorEnMomentosAnteriores() throws Exception {
        Historial<Integer> historial = new Historial<>(1, () -> milisegundosActuales);

        milisegundosActuales = 100;
        historial.setValor(3);

        milisegundosActuales = 200;
        historial.setValor(4);

        assertEquals(3, historial.getValorEn(new Date(199)).intValue());
    }
}
