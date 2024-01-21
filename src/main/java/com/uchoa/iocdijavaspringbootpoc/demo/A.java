package com.uchoa.iocdijavaspringbootpoc.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class A {

    private final B b;

    @Autowired
    public A(B b) {
        this.b = b;
    }

    public String useB() {
        return b.message();
    }
}
