package com.proyectopd.omnichannel.controller;

import com.proyectopd.omnichannel.controllers.AdministradorController;
import com.proyectopd.omnichannel.dtos.createuser.models.UsuarioAdministradorDTO;
import com.proyectopd.omnichannel.services.AdministradorService;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

// Allow us to only load the app context for the controller we are intending to test
@WebMvcTest(AdministradorController.class)
@AutoConfigureMockMvc (addFilters = false) // Allows us to disable the Spring Security filter chain
public class AdministradorControllerTests {

    String BASE_URL = "/administradores";

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private AdministradorService administradorService;

    @Test
    public void testGetAdministradorById() throws Exception {
        UsuarioAdministradorDTO administrador = new UsuarioAdministradorDTO();
        administrador.setApellido("Martinez");
        administrador.setNombre("Fernando");

        when(administradorService.getAdministradorById(1)).thenReturn(administrador);

        mockMvc.perform(get(BASE_URL + "/1")).andExpect(status().isOk());
    }

    @Test
    public void testDeleteAdministrador() throws Exception {
        when(administradorService.deleteAdministradorById(1)).thenReturn(true);

        mockMvc.perform(delete(BASE_URL + "/1")).andExpect(status().isOk());
    }
}
