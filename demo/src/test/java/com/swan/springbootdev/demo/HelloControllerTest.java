package com.swan.springbootdev.demo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import com.swan.springbootdev.demo.controller.HelloController;

@SpringBootTest
public class HelloControllerTest {
    @Autowired
    private HelloController controller;
    private MockMvc mock;
    
    @BeforeEach
    public void init() {
    	mock = MockMvcBuilders.standaloneSetup(controller).build();
    }
    
    @Test
    public void hello_return() throws  Exception {
        String hello = "hello";
        
    }
}
