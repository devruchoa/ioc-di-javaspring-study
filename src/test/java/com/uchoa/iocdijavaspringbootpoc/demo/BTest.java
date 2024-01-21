package com.uchoa.iocdijavaspringbootpoc.demo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BTest {

    private B b;

    @BeforeEach
    public void setUp() {
        b = new B();
    }

    @Test
    public void messageReturnsExpectedValue() {
        assertEquals("Hi! I'm B", b.message());
    }
}
