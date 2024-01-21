package com.uchoa.iocdijavaspringbootpoc.config;

import com.uchoa.iocdijavaspringbootpoc.util.A;
import com.uchoa.iocdijavaspringbootpoc.util.B;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class AppConfig {

    @Bean
    public B b() {
        return new B();
    }

    // DI via constructor
    @Bean
    public A a(B b) {
        return new A(b);
    }

    // DI via setter
    @Bean
    public A a2(B b) {
        A a = new A();
        a.setB(b);
        return a;
    }
}
