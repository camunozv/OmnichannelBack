package com.proyectopd.omnichannel.integration;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@ActiveProfiles("test")
@AutoConfigureMockMvc(addFilters = false)
public class UsuarioControllerTest {

    String BASE_URL = "/usuario";
    String BASE_URL2 = "/quejas";

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void createAdminTest() throws Exception {

        String requestBody = "{\"id\":1,\"nombre\":\"Carlos\",\"apellido\":\"Munoz\",\"contrasenha\":1234,\"rol\":\"Administrador\"}";
        String userId = "1";
        mockMvc.perform(post(BASE_URL + "/admin")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestBody))
                .andExpect(status().isCreated())
                .andExpect(content().string("{\"idUsuario\":1,\"contrasenha\":\"1234\",\"rol\":{\"nombreRol\":\"Administrador\"}}"));

        mockMvc.perform(get(BASE_URL + "/" + userId))
                .andExpect(status().isOk());
    }

    @Test
    public void createEmpresaTest() throws Exception {

        String requestBody = "{\"id\":2,\"contrasenha\":1234,\"nombre\":\"Emcali\",\"ciudad\":\"Cali\",\"tipoServicio\":\"Alcantarillado\",\"rol\":\"Empresa\"}";

        String userId = "2";
        mockMvc.perform(post(BASE_URL + "/empresa")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestBody))
                .andExpect(status().isCreated())
                .andExpect(content().string("{\"id\":2,\"contrasenha\":\"1234\",\"nombre\":\"Emcali\",\"ciudad\":\"Cali\",\"tipoServicio\":\"Alcantarillado\",\"rol\":\"Empresa\"}"));

        mockMvc.perform(get(BASE_URL + "/" + userId)).andExpect(status().isOk());
    }

    @Test
    public void createProfesionalTest() throws Exception {
        String requestBody = "{\"id\":3,\"contrasenha\":\"1234\",\"nombre\":\"Fernando\",\"apellido\":\"Martinez\",\"correoElectronico\":\"fernando@gmail.com\",\"telefonoMovil\":31256,\"cantidadQuejasEncargadas\":0,\"rol\":\"Profesional\"}";

        String userId = "3";
        mockMvc.perform(post(BASE_URL + "/profesional")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestBody))
                .andExpect(status().isCreated())
                .andExpect(content().string("{\"idUsuario\":3,\"contrasenha\":\"1234\",\"rol\":{\"nombreRol\":\"Profesional\"}}"));

        mockMvc.perform(get(BASE_URL + "/" + userId)).andExpect(status().isOk());
    }

    @Test
    public void createQuejaTest() throws Exception {
        String requestBody = "{\"idQueja\":1,\"prioridad\":\"Media\",\"tiempoMinimoRespuesta\":\"2025-05-19\",\"descripcion\":\"No me funciona el servicio de alcantarillado.\",\"archivo\":\"BASE 64 STRING\",\"tipoQueja\":\"Incumplimiento\",\"nombreEmpresa\":\"Emcali\"}";

        mockMvc.perform(post(BASE_URL2).contentType(MediaType.APPLICATION_JSON)
                        .content(requestBody))
                .andExpect(status().isCreated())
                .andExpect(content().string("{\"idQueja\":1,\"prioridad\":\"Media\",\"tiempoMinimoRespuesta\":\"2025-05-19\",\"descripcion\":\"No me funciona el servicio de alcantarillado.\",\"archivo\":\"BASE 64 STRING\",\"tipoQueja\":\"Incumplimiento\",\"nombreEmpresa\":\"Emcali\"}"));
    }

    @Test
    public void answerQuejaTest() throws Exception {
        String requestBody = "{\"idRespuesta\":1,\"textoRespuesta\":\"Pronto se arreglará\",\"idQueja\":1}";

        mockMvc.perform(put(BASE_URL2).contentType(MediaType.APPLICATION_JSON)
                        .content(requestBody))
                .andExpect(status().isOk())
                .andExpect(content().string("{\"idRespuesta\":1,\"textoRespuesta\":\"Pronto se arreglará\",\"idQueja\":1}"));

    }

    @Test
    public void getAllQuejasEmpresaTest() throws Exception {


        mockMvc.perform(get(BASE_URL2 + "/Emcali"))
                .andExpect(status().isOk())
                .andExpect(content().string("[{\"idQueja\":1,\"prioridad\":\"Media\",\"tiempoMinimoRespuesta\":\"2025-06-03\",\"descripcion\":\"No me funciona el servicio de alcantarillado.\",\"archivo\":\"BASE 64 STRING\",\"tipoQueja\":\"Incumplimiento\",\"nombreEmpresa\":\"Emcali\"}]"));
    }

}
