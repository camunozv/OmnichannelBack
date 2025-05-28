package com.proyectopd.omnichannel.controller;

import com.proyectopd.omnichannel.controllers.NotificacionController;
import com.proyectopd.omnichannel.controllers.TipoQuejaController;
import com.proyectopd.omnichannel.models.TipoQueja;
import com.proyectopd.omnichannel.services.TipoQuejaService;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(TipoQuejaController.class)
@AutoConfigureMockMvc(addFilters = false)
public class TipoQuejaControllerTests {

    String BASE_URL = "/tipoQueja";

    @Autowired
    private MockMvc mockMvc;
    @MockitoBean
    private TipoQuejaService tipoQuejaService;

    @Test
    public void testCreateTipoQueja() throws Exception {
        String requestBody = "{"
                + "\"tipoQueja\": \"Retraso\""
                + ",\"dias\": \"1\""
                + "}";

        when(tipoQuejaService.createTipoQueja(ArgumentMatchers.any(TipoQueja.class))).thenReturn(true);

        mockMvc.perform(post(BASE_URL)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestBody)
                        .characterEncoding("UTF-8"))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.tipoQueja").value("Retraso"));
    }

    @Test
    public void testGetTipoQueja() throws Exception {
        TipoQueja tipoQueja = new TipoQueja();
        tipoQueja.setTipoQueja("Retraso");
        tipoQueja.setDias(1);

        when(tipoQuejaService.getTipoQuejaById("Retraso")).thenReturn(tipoQueja);

        mockMvc.perform(get(BASE_URL)
                        .param("nombreTipoQueja", "Retraso"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.tipoQueja").value("Retraso"))
                .andExpect(jsonPath("$.dias").value(1));
    }

    @Test
    public void testDeleteTipoQueja() throws Exception {
        when(tipoQuejaService.deleteTipoQueja("Retraso")).thenReturn(true);
        mockMvc.perform(delete(BASE_URL)
                        .param("nombreTipoQueja", "Retraso"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").value(true));
    }

}
