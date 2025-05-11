package com.proyectopd.omnichannel.controllers;

import com.proyectopd.omnichannel.models.NotificacionAdmin;
import com.proyectopd.omnichannel.services.NotificacionServiceAdmin;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/notificaciones")
public class NotificacionAdminController {

    NotificacionServiceAdmin notificacionServiceAdmin;

    public NotificacionAdminController(NotificacionServiceAdmin notificacionServiceAdmin) {
        this.notificacionServiceAdmin = notificacionServiceAdmin;
    }

    @GetMapping("/todas")
    public ResponseEntity<List<NotificacionAdmin>> getAllNotificaciones() {
        return new ResponseEntity<>(notificacionServiceAdmin.getAllNotificaciones(), HttpStatus.OK);
    }

    @GetMapping("/{idNotificacion}")
    public ResponseEntity<NotificacionAdmin> getNotificacionById(@PathVariable Integer idNotificacion) {
        return new ResponseEntity<>(notificacionServiceAdmin.getNotificacionById(idNotificacion), HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity<Boolean> deleteNotificacion(@RequestParam Integer idNotificacion) {
        boolean deleted = notificacionServiceAdmin.deleteNotificacion(idNotificacion);
        if (deleted) {
            return new ResponseEntity<>(true, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(false, HttpStatus.NOT_FOUND);
        }
    }
}
