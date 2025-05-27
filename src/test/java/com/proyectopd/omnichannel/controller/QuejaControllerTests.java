package com.proyectopd.omnichannel.controller;

import com.proyectopd.omnichannel.controllers.NotificacionController;
import com.proyectopd.omnichannel.services.EmpresaService;
import com.proyectopd.omnichannel.services.QuejaService;
import com.proyectopd.omnichannel.services.RespuestaService;
import com.proyectopd.omnichannel.services.TipoQuejaService;
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
public class QuejaControllerTests {

    String BASE_URL = "/quejas";

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private QuejaService quejaService;
    @MockitoBean
    private TipoQuejaService tipoQuejaService;
    @MockitoBean
    private EmpresaService empresaService;
    @MockitoBean
    private RespuestaService respuestaService;
}
