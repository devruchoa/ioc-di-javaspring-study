package com.uchoa.iocdijavaspringbootpoc.controller;

import com.uchoa.iocdijavaspringbootpoc.demo.A;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExampleController {

    private final A a;

    public ExampleController(A a) {
        this.a = a;
    }

    @GetMapping("/example")
    public String example() {
        return a.useB();
    }
}
