package com.proyectopd.omnichannel.controller;

import com.proyectopd.omnichannel.controllers.NotificacionController;
import com.proyectopd.omnichannel.services.TipoServicioService;
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
public class TipoServicioControllerTests {

    String BASE_URL = "/tipoServicio";

    @Autowired
    private MockMvc mockMvc;
    @MockitoBean
    private TipoServicioService tipoServicioService;

}
