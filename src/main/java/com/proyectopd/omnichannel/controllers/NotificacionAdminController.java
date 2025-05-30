package com.proyectopd.omnichannel.controllers;

import com.proyectopd.omnichannel.models.NotificacionAdmin;
import com.proyectopd.omnichannel.services.NotificacionAdminService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/notificacionesAdmin")
public class NotificacionAdminController {

    NotificacionAdminService notificacionAdminService;

    public NotificacionAdminController(NotificacionAdminService notificacionAdminService) {
        this.notificacionAdminService = notificacionAdminService;
    }

    // Tested
    @GetMapping("/todas")
    public ResponseEntity<List<NotificacionAdmin>> getAllNotificaciones() {

        List<NotificacionAdmin> listOfNotificaciones = notificacionAdminService.getAllNotificaciones();

        if(!listOfNotificaciones.isEmpty()) {
            return new ResponseEntity<>(listOfNotificaciones, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    // Tested
    @GetMapping
    public ResponseEntity<NotificacionAdmin> getNotificacionById(@RequestParam Integer idNotificacion) {

        NotificacionAdmin notificacionAdmin = notificacionAdminService.getNotificacionById(idNotificacion);

        if (notificacionAdmin != null) {
            return new ResponseEntity<>(notificacionAdmin, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    // Tested
    @DeleteMapping
    public ResponseEntity<Boolean> deleteNotificacion(@RequestParam Integer idNotificacion) {

        boolean deleted = notificacionAdminService.deleteNotificacion(idNotificacion);

        if (deleted) {
            return new ResponseEntity<>(true, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(false, HttpStatus.NOT_FOUND);
        }
    }
}
