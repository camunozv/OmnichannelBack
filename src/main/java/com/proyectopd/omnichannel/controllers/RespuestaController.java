package com.proyectopd.omnichannel.controllers;

import com.proyectopd.omnichannel.dtos.createrespuesta.QuejaRespuestaDTO;
import com.proyectopd.omnichannel.models.Queja;
import com.proyectopd.omnichannel.models.Respuesta;
import com.proyectopd.omnichannel.services.QuejaService;
import com.proyectopd.omnichannel.services.RespuestaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/respuesta")
public class RespuestaController {

    // Ich glaube, dass ich dieses URL nicht brauche.
    /*RespuestaService respuestaService;
    QuejaService quejaService;

    public RespuestaController(RespuestaService respuestaService, QuejaService quejaService) {
        this.respuestaService = respuestaService;
        this.quejaService = quejaService;
    }

    @PostMapping
    public ResponseEntity<Respuesta> createRespuesta(@RequestBody QuejaRespuestaDTO newRespuesta) {

        Queja quejaToAnswer = quejaService.getQuejaById(newRespuesta.getIdQueja());
        Respuesta respuesta = new Respuesta();
        return null;
    }*/
}
