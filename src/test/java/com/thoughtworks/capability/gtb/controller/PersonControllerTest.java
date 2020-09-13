package com.thoughtworks.capability.gtb.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class PersonControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    void should_get_person() throws Exception {
        mockMvc.perform(get("/persons/2"))
                .andExpect(jsonPath("$.id").value(2))
                .andExpect(jsonPath("$.age").value(0))
                .andExpect(jsonPath("$.name").value("张三"))
                .andExpect(jsonPath("$.hobby").doesNotExist())
                .andExpect(status().isOk());
    }
}