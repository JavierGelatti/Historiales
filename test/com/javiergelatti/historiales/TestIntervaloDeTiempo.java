package com.javiergelatti.historiales;

import junit.framework.TestCase;

import java.util.Date;

import static org.junit.Assert.assertNotEquals;

public class TestIntervaloDeTiempo extends TestCase {

    public void testEquals() throws Exception {
        Date a = new Date(1);
        Date b = new Date(2);

        assertEquals(new IntervaloDeTiempo(a, b), new IntervaloDeTiempo(a, b));
        assertNotEquals(new IntervaloDeTiempo(a, b), new IntervaloDeTiempo(b, a));
    }

    public void testHashCode() throws Exception {
        Date a = new Date(1);
        Date b = new Date(2);

        assertEquals(new IntervaloDeTiempo(a, b).hashCode(), new IntervaloDeTiempo(a, b).hashCode());
        assertNotEquals(new IntervaloDeTiempo(a, b).hashCode(), new IntervaloDeTiempo(b, a).hashCode());
    }

    public void testContieneA() throws Exception {
        Date a = new Date(1);
        Date b = new Date(2);
        Date c = new Date(3);

        IntervaloDeTiempo elIntervalo = new IntervaloDeTiempo(a, c);

        assertTrue(elIntervalo.contieneA(a));
        assertTrue(elIntervalo.contieneA(b));
        assertFalse(elIntervalo.contieneA(c));
    }
}