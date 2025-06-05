package com.proyectopd.omnichannel.controller;

import com.proyectopd.omnichannel.controllers.NotificacionAdminController;
import com.proyectopd.omnichannel.models.NotificacionAdmin;
import com.proyectopd.omnichannel.services.NotificacionAdminService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;

import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(NotificacionAdminController.class)
@AutoConfigureMockMvc(addFilters = false)
public class NotificacionAdminControllerTests {

    String BASE_URL = "/notificacionesAdmin";

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private NotificacionAdminService notificacionAdminService;

    @Test
    public void testGetAllNotificaciones() throws Exception {

        ArrayList<NotificacionAdmin> notificaciones = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            NotificacionAdmin notificacion = new NotificacionAdmin();
            notificacion.setIdNotificacion(i);
            notificacion.setTextoNotificacion("Notificacion " + i);
            notificaciones.add(notificacion);
        }

        when(notificacionAdminService.getAllNotificaciones()).thenReturn(notificaciones);

        mockMvc.perform(get(BASE_URL + "/todas")).andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(5)))
                .andExpect(jsonPath("$[0].idNotificacion").value(0))
                .andExpect(jsonPath("$[1].idNotificacion").value(1))
                .andExpect(jsonPath("$[2].idNotificacion").value(2))
                .andExpect(jsonPath("$[3].idNotificacion").value(3))
                .andExpect(jsonPath("$[4].idNotificacion").value(4));
    }

    @Test
    public void testGetNotificacionById() throws Exception {
        NotificacionAdmin notificacion = new NotificacionAdmin();
        notificacion.setIdNotificacion(1);
        notificacion.setTextoNotificacion("Notificacion 1");

        when(notificacionAdminService.getNotificacionById(1)).thenReturn(notificacion);

        mockMvc.perform(get(BASE_URL).param("idNotificacion", "1")).andExpect(status().isOk())
                .andExpect(jsonPath("$.idNotificacion").value(1))
                .andExpect(jsonPath("$.textoNotificacion").value("Notificacion 1"));
    }

    @Test
    public void testDeleteNotificacion() throws Exception {
        when(notificacionAdminService.deleteNotificacion(1)).thenReturn(true);

        mockMvc.perform(delete(BASE_URL).param("idNotificacion", "1"))
                .andExpect(status().isOk());
    }

}
