package com.thoughtworks.capability.gtb.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class EventControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    void should_get_event_by_id() throws Exception {
        mockMvc.perform(get("/events/2"))
                .andExpect(jsonPath("$.id").value(2))
                .andExpect(jsonPath("$.name").value("下载文件"))
                .andExpect(jsonPath("$.type").value("D"))
                .andExpect(jsonPath("$.time").isNumber())
                .andExpect(jsonPath("$.userId").value(3))
                .andExpect(jsonPath("$.userName").value("张三"))
                .andExpect(status().isOk());
    }
}