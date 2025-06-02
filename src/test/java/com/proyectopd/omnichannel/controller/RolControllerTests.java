package com.proyectopd.omnichannel.controller;

import com.google.gson.Gson;
import com.proyectopd.omnichannel.controllers.NotificacionController;
import com.proyectopd.omnichannel.controllers.RolController;
import com.proyectopd.omnichannel.models.Rol;
import com.proyectopd.omnichannel.services.RolService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(RolController.class)
@AutoConfigureMockMvc(addFilters = false)
public class RolControllerTests {

    String BASE_URL = "/rol";

    @Autowired
    private MockMvc mockMvc;
    @MockitoBean
    private RolService rolService;

    @Test
    public void testCrearRol() throws Exception {

        mockMvc.perform(post(BASE_URL + "/nuevoRol").param("newRol", "Admin")
                        .characterEncoding("UTF-8"))
                .andExpect(status().isCreated());
    }

    @Test
    public void testGetRol() throws Exception {
        Rol rol = new Rol();
        rol.setNombreRol("Admin");

        when(rolService.getRolById("Admin")).thenReturn(rol);

        mockMvc.perform(get(BASE_URL + "/nombreRol")
                        .param("nombreRol", "Admin"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.nombreRol").value("Admin"));
    }

    @Test
    public void testDeleteRol() throws Exception {
        when(rolService.deleteRol("Admin")).thenReturn(true);
        mockMvc.perform(delete(BASE_URL + "/borrarRol").param("nombreRol", "Admin"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").value(true));
    }

}
