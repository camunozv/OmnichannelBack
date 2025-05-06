package com.proyectopd.omnichannel.integration;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@ActiveProfiles("test")
@AutoConfigureMockMvc(addFilters = false)
public class TipoQuejaControllerTest {

    String BASE_URL = "/tipoQueja";

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void createTipoQueja() throws Exception {

        String requestBody = "{\"tipoQueja\":\"Incumplimiento\"}";

        mockMvc.perform(post(BASE_URL).contentType(MediaType.APPLICATION_JSON)
                        .content(requestBody))
                .andExpect(status().isCreated())
                .andExpect(content().string("{\"tipoQueja\":\"Incumplimiento\"}"));

        mockMvc.perform(get(BASE_URL).param("nombreTipoQueja", "Incumplimiento"))
                .andExpect(status().isOk())
                .andExpect(content().string("{\"tipoQueja\":\"Incumplimiento\"}"));
    }


}