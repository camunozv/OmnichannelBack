package com.proyectopd.omnichannel.controller;

import com.proyectopd.omnichannel.controllers.NotificacionController;
import com.proyectopd.omnichannel.controllers.RespuestaController;
import com.proyectopd.omnichannel.models.Queja;
import com.proyectopd.omnichannel.models.Respuesta;
import com.proyectopd.omnichannel.services.RespuestaService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(RespuestaController.class)
@AutoConfigureMockMvc(addFilters = false)
public class RespuestaControllerTests {

    String BASE_URL = "/respuesta";

    @Autowired
    private MockMvc mockMvc;
    @MockitoBean
    private RespuestaService respuestaService;

    @Test
    public void testGetRespuestaById() throws Exception {
        Respuesta respuesta = new Respuesta();
        respuesta.setTextoRespuesta("Respuesta de queja");
        respuesta.setIdRespuesta(0);

        Queja queja = new Queja();
        queja.setIdQueja(1);

        respuesta.setQueja(queja);

        when(respuestaService.getRespuestaById(0)).thenReturn(respuesta);

        mockMvc.perform(get(BASE_URL + "/id").param("idRespuesta", "0"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.idRespuesta").value(0))
                .andExpect(jsonPath("$.textoRespuesta").value("Respuesta de queja"));

    }

}
