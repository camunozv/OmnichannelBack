package com.proyectopd.omnichannel.controller;

import com.proyectopd.omnichannel.controllers.NotificacionController;
import com.proyectopd.omnichannel.services.RespuestaService;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;

@WebMvcTest(NotificacionController.class)
@AutoConfigureMockMvc(addFilters = false)
public class RespuestaControllerTests {

    RespuestaService respuestaService;
}
