package com.proyectopd.omnichannel.controllers;

import com.proyectopd.omnichannel.models.Respuesta;
import com.proyectopd.omnichannel.services.RespuestaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/respuesta")
public class RespuestaController {

    // Ich glaube, dass ich dieses URL nicht brauche.
    RespuestaService respuestaService;

    public RespuestaController(RespuestaService respuestaService) {
        this.respuestaService = respuestaService;
    }

    @GetMapping("/id")
    public ResponseEntity<Respuesta> getRespuestaByIdRespuesta(@RequestParam Integer idRespuesta) {
        return new ResponseEntity<>(respuestaService.getRespuestaById(idRespuesta), HttpStatus.OK);
    }


}
