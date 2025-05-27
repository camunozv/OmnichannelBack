package com.proyectopd.omnichannel.controller;

import com.proyectopd.omnichannel.controllers.NotificacionController;
import com.proyectopd.omnichannel.services.EmpresaService;
import com.proyectopd.omnichannel.services.QuejaService;
import com.proyectopd.omnichannel.services.RespuestaService;
import com.proyectopd.omnichannel.services.TipoQuejaService;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;

@WebMvcTest(NotificacionController.class)
@AutoConfigureMockMvc(addFilters = false)
public class QuejaControllerTests {

    private QuejaService quejaService;
    private TipoQuejaService tipoQuejaService;
    private EmpresaService empresaService;
    private RespuestaService respuestaService;
}
