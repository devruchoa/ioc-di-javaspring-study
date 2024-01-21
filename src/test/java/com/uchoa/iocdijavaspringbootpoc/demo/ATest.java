package com.uchoa.iocdijavaspringbootpoc.demo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

class ATest {

    private A a;
    private B b;

    @BeforeEach
    public void setUp() {
        b = Mockito.mock(B.class);
        a = new A(b);
    }

    @Test
    public void useBReturnsExpectedValue() {
        String expected = "Hi! I'm B";
        when(b.message()).thenReturn(expected);

        assertEquals(expected, a.useB());
    }

    @Test
    public void useBReturnsEmptyWhenBReturnsEmpty() {
        when(b.message()).thenReturn("");

        assertEquals("", a.useB());
    }
}
