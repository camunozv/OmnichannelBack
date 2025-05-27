package com.proyectopd.omnichannel.controller;

import com.proyectopd.omnichannel.controllers.NotificacionController;
import com.proyectopd.omnichannel.services.AdministradorService;
import com.proyectopd.omnichannel.services.EmpresaService;
import com.proyectopd.omnichannel.services.ProfesionalService;
import com.proyectopd.omnichannel.services.UsuarioService;
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

@WebMvcTest(NotificacionController.class)
@AutoConfigureMockMvc(addFilters = false)
public class UsuarioControllerTests {

    String BASE_URL = "/usuario";

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private UsuarioService usuarioService;
    @MockitoBean
    private AdministradorService administradorService;
    @MockitoBean
    private ProfesionalService profesionalService;
    @MockitoBean
    private EmpresaService empresaService;


}
