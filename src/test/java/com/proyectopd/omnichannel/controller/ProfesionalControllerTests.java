package com.proyectopd.omnichannel.controller;

import com.proyectopd.omnichannel.controllers.ProfesionalController;
import com.proyectopd.omnichannel.models.Profesional;
import com.proyectopd.omnichannel.models.Rol;
import com.proyectopd.omnichannel.models.Usuario;
import com.proyectopd.omnichannel.services.ProfesionalService;
import com.proyectopd.omnichannel.services.UsuarioService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ProfesionalController.class)
@AutoConfigureMockMvc(addFilters = false)
public class ProfesionalControllerTests {

    String BASE_URL = "/profesionales";

    @Autowired
    private MockMvc mockMvc;
    @MockitoBean
    private ProfesionalService profesionalService;
    @MockitoBean
    private UsuarioService usuarioService;

    @Test
    public void testGetProfesionalBYId() throws Exception {
        Rol rol = new Rol();
        rol.setNombreRol("Admin");

        Usuario usuario = new Usuario();
        usuario.setIdUsuario(1);
        usuario.setRol(rol);

        Profesional profesional = new Profesional();
        profesional.setUsuario(usuario);

        when(profesionalService.getProfesionalById(1)).thenReturn(profesional);
        when(usuarioService.getUsuarioById(1)).thenReturn(usuario);
//        usuarioProfesionalDTO = mapProfesionalToUsuarioProfesionalDTO(usuario, profesional);
        mockMvc.perform(get(BASE_URL + "/1")).andExpect(status().isOk());
    }

    @Test
    public void testDeleteProfesional() throws Exception {

        when(profesionalService.deleteProfesionalById(1)).thenReturn(true);

        mockMvc.perform(delete(BASE_URL + "/1"))
                .andExpect(status().isOk());
    }

}
