package com.proyectopd.omnichannel.controllers;

import com.proyectopd.omnichannel.services.NotificacionService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/notificacionesUsuario")
public class NotificacionController {

    NotificacionService notificacionService;

    public NotificacionController(NotificacionService notificacionService) {
        this.notificacionService = notificacionService;
    }


}
