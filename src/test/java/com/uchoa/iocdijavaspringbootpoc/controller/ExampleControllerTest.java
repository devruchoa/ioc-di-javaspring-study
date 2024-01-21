package com.uchoa.iocdijavaspringbootpoc.controller;

import com.uchoa.iocdijavaspringbootpoc.demo.A;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class ExampleControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private A a;

    @Test
    public void exampleTest() throws Exception {
        String expected = "Hi! I'm B";
        when(a.useB()).thenReturn(expected);

        mockMvc.perform(get("/example"))
                .andExpect(status().isOk())
                .andExpect(content().string(expected));
    }
}
