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

    @GetMapping("/todas")
    public ResponseEntity<List<NotificacionAdmin>> getAllNotificaciones() {
        return new ResponseEntity<>(notificacionAdminService.getAllNotificaciones(), HttpStatus.OK);
    }

    @GetMapping("/{idNotificacion}")
    public ResponseEntity<NotificacionAdmin> getNotificacionById(@PathVariable Integer idNotificacion) {
        return new ResponseEntity<>(notificacionAdminService.getNotificacionById(idNotificacion), HttpStatus.OK);
    }

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
