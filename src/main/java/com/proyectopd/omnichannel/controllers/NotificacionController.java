package com.proyectopd.omnichannel.controllers;

import com.proyectopd.omnichannel.models.Notificacion;
import com.proyectopd.omnichannel.services.NotificacionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/notificacionesUsuario")
public class NotificacionController {

    NotificacionService notificacionService;

    public NotificacionController(NotificacionService notificacionService) {
        this.notificacionService = notificacionService;
    }

    // Tested
    @GetMapping("/todas")
    public ResponseEntity<List<Notificacion>> getAllNotificacionesUsuario(@RequestParam Integer idUsuario) {
        try {
            List<Notificacion> listaDeNotificaciones = notificacionService.getAllNotificacionesUsuario(idUsuario);
            return new ResponseEntity<>(listaDeNotificaciones, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    // Tested
    @GetMapping
    public ResponseEntity<Notificacion> getNotificacionById(@RequestParam Integer idNotificacion) {
        try {
            Notificacion notificacion = notificacionService.getNotificacionById(idNotificacion);
            return new ResponseEntity<>(notificacion, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    // Tested
    @DeleteMapping
    public ResponseEntity<Boolean> deleteNotificacion(@RequestParam Integer idNotificacion) {

        boolean deleted = notificacionService.deleteNotificacionById(idNotificacion);

        if (deleted) {
            return new ResponseEntity<>(true, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(false, HttpStatus.NOT_FOUND);
        }
    }
}
