package com.proyectopd.omnichannel.controllers;

import com.proyectopd.omnichannel.models.TipoServicio;
import com.proyectopd.omnichannel.services.TipoServicioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tipoServicio")
public class TipoServicioController {

    private TipoServicioService tipoServicioService;

    public TipoServicioController(TipoServicioService tipoServicioService) {
        this.tipoServicioService = tipoServicioService;
    }

    @PostMapping
    public ResponseEntity<TipoServicio> createTipoServicio(@RequestBody TipoServicio tipoServicio) {

        boolean created = tipoServicioService.createTipoServicio(tipoServicio);

        if (created) {
            return new ResponseEntity<>(tipoServicio, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(tipoServicio, HttpStatus.BAD_REQUEST);
        }

    }
}
