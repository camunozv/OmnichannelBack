package com.proyectopd.omnichannel.integration;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/*@SpringBootTest
@ActiveProfiles("test")
@AutoConfigureMockMvc(addFilters = false)
public class QuejaControllerTest {

    String BASE_URL = "/quejas";

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void createQuejaTest() throws Exception {
        String requestBody = "{\"idQueja\":154,\"prioridad\":\"Media\",\"tiempoMinimoRespuesta\":\"2025-05-19\",\"descripcion\":\"No me funciona el servicio de alcantarillado.\",\"archivo\":\"BASE 64 STRING\",\"tipoQueja\":\"Incumplimiento\",\"nombreEmpresa\":\"EMCALI\"}";

        mockMvc.perform(post(BASE_URL).contentType(MediaType.APPLICATION_JSON)
                        .content(requestBody))
                .andExpect(status().isCreated())
                .andExpect(content().string("{\"idQueja\":154,\"prioridad\":\"Media\",\"tiempoMinimoRespuesta\":\"2025-05-19\",\"descripcion\":\"No me funciona el servicio de alcantarillado.\",\"archivo\":\"BASE 64 STRING\",\"tipoQueja\":\"Incumplimiento\",\"nombreEmpresa\":\"EMCALI\"}"));
    }

    @Test
    public void answerQuejaTest() throws Exception {
        String requestBody = "{\"idRespuesta\":74,\"textoRespuesta\":\"Pronto se arreglará\",\"idQueja\":154}";

        mockMvc.perform(put(BASE_URL).contentType(MediaType.APPLICATION_JSON)
                        .content(requestBody))
                .andExpect(status().isOk())
                .andExpect(content().string("{\"idRespuesta\":74,\"textoRespuesta\":\"Pronto se arreglará\",\"idQueja\":154}"));

    }

}*/
