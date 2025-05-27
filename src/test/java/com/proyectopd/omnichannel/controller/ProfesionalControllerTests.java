package com.proyectopd.omnichannel.controller;

import com.proyectopd.omnichannel.controllers.NotificacionController;
import com.proyectopd.omnichannel.services.ProfesionalService;
import com.proyectopd.omnichannel.services.UsuarioService;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;

@WebMvcTest(NotificacionController.class)
@AutoConfigureMockMvc(addFilters = false)
public class ProfesionalControllerTests {

    ProfesionalService profesionalService;
    UsuarioService usuarioService;
}
