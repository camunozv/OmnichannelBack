package com.proyectopd.omnichannel.integration;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@ActiveProfiles("test")
@AutoConfigureMockMvc(addFilters = false)
public class TipoServicioContollerTest {

    String BASE_URL = "/tipoServicio";

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testCreateTipoServicio() throws Exception {

        String requestBody = "{\"nombreServicio\":\"Alcantarillado\"}";

        mockMvc.perform(post(BASE_URL + "/nuevoServicio").contentType(MediaType.APPLICATION_JSON)
                .content(requestBody)).andExpect(status().isOk())
                .andExpect(content().string("{\"nombreServicio\":\"Alcantarillado\",\"empresa\":null}"));

    }
}
