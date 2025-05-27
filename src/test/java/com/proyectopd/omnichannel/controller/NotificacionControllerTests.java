package com.proyectopd.omnichannel.controller;

import com.proyectopd.omnichannel.controllers.NotificacionController;
import com.proyectopd.omnichannel.models.Notificacion;
import com.proyectopd.omnichannel.models.Usuario;
import com.proyectopd.omnichannel.services.NotificacionService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(NotificacionController.class)
@AutoConfigureMockMvc(addFilters = false)
public class NotificacionControllerTests {

    String BASE_URL = "/notificacionesUsuario";

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private NotificacionService notificacionService;


    @Test
    public void getAllNotificacionesUsuario() throws Exception {
        ArrayList<Notificacion> notificaciones = new ArrayList<>();
        Usuario usuario = new Usuario();
        usuario.setIdUsuario(1);
        for (int i = 0; i < 5; i++) {
            Notificacion notificacion = new Notificacion();
            notificacion.setIdNotificacion(i);
            notificacion.setTextoNotificacion("Notificacion " + i);
            notificacion.setUsuario(usuario);
            notificaciones.add(notificacion);
        }

        when(notificacionService.getAllNotificacionesUsuario(1)).thenReturn(notificaciones);

        mockMvc.perform(get(BASE_URL + "/all").param("idUsuario", "1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(5)))
                .andExpect(jsonPath("$[0].idNotificacion").value(0))
                .andExpect(jsonPath("$[1].idNotificacion").value(1))
                .andExpect(jsonPath("$[2].idNotificacion").value(2))
                .andExpect(jsonPath("$[3].idNotificacion").value(3))
                .andExpect(jsonPath("$[4].idNotificacion").value(4));
    }

    @Test
    public void testGetNotificacionById() throws Exception {
        Notificacion notificacion = new Notificacion();
        notificacion.setIdNotificacion(1);
        notificacion.setTextoNotificacion("Notificacion 1");

        when(notificacionService.getNotificacionById(1)).thenReturn(notificacion);

        mockMvc.perform(get(BASE_URL + "/id").param("idNotificacion", "1")).andExpect(status().isOk())
                .andExpect(jsonPath("$.idNotificacion").value(1))
                .andExpect(jsonPath("$.textoNotificacion").value("Notificacion 1"));
    }

    @Test
    public void testDeleteNotificacion() throws Exception {

        when(notificacionService.deleteNotificacionById(1)).thenReturn(true);

        mockMvc.perform(delete(BASE_URL + "/borrarNotificacion").param("idNotificacion", "1"))
                .andExpect(status().isOk());
    }

}
