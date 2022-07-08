package com.swan.springbootdev.demo;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.hamcrest.Matchers.equalTo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.http.MediaType;

@SpringBootTest
@AutoConfigureMockMvc
public class HelloControllerTest {
    @Autowired
    private MockMvc mockMvc;
    
    @Test
    public void helloGetDefault() throws  Exception {
        String hello = "Hello World!";
        mockMvc.perform(MockMvcRequestBuilders.get("/hello").accept(MediaType.APPLICATION_JSON))
                                                            .andExpect(status().isOk())
                                                            .andExpect(content().string(equalTo(hello)));
    }
    @Test
    public void helloGetParam() throws  Exception {
        String hello = "Hello swan!";
        mockMvc.perform(MockMvcRequestBuilders.get("/hello?name=swan").accept(MediaType.APPLICATION_JSON))
                                                            .andExpect(status().isOk())
                                                            .andExpect(content().string(equalTo(hello)));
    }
    @Test
    public void helloPostParam() throws  Exception {
        String hello = "Hello World!(Post)";
        mockMvc.perform(MockMvcRequestBuilders.post("/hello").accept(MediaType.APPLICATION_JSON))
                                                            .andExpect(status().isOk())
                                                            .andExpect(content().string(equalTo(hello)));
    }
}
