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

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void createAdmin() throws Exception {

        String requestBody = "{\"id\":1,\"nombre\":\"carlitos\",\"apellido\":\"munoz\",\"contrasenha\":1234,\"rol\":\"Administrador\"}";
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
    public void createEmpresa() throws Exception {

        String requestBody = "{\"id\":1230,\"contrasenha\":1234,\"nombre\":\"EMCALI\",\"ciudad\":\"Cali\",\"tipoServicio\":\"Alcantarillado\",\"rol\":\"Empresa\"}";

        String userId = "1230";
        mockMvc.perform(post(BASE_URL + "/empresa")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestBody))
                .andExpect(status().isCreated())
                .andExpect(content().string("{\"id\":1230,\"contrasenha\":\"1234\",\"nombre\":\"EMCALI\",\"ciudad\":\"Cali\",\"tipoServicio\":\"Alcantarillado\",\"rol\":\"Empresa\"}"));

        mockMvc.perform(get(BASE_URL + "/" + userId)).andExpect(status().isOk());
    }

    @Test
    public void createProfesional() throws Exception {
        String requestBody = "{\"id\":1,\"contrasenha\":\"1234\",\"nombre\":\"fernando\",\"apellido\":\"martinez\",\"correoElectronico\":\"fernando@gmail.com\",\"telefonoMovil\":31256,\"cantidadQuejasEncargadas\":0,\"rol\":\"Profesional\"}";

        String userId = "1";
        mockMvc.perform(post(BASE_URL + "/profesional")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestBody))
                .andExpect(status().isCreated())
                .andExpect(content().string("{\"idUsuario\":1,\"contrasenha\":\"1234\",\"rol\":{\"nombreRol\":\"Profesional\"}}"));

        mockMvc.perform(get(BASE_URL + "/" + userId)).andExpect(status().isOk());
    }
}
