package com.proyectopd.omnichannel.controllers;

import com.proyectopd.omnichannel.models.Queja;
import com.proyectopd.omnichannel.services.QuejaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/quejas")
public class QuejaController {

    private QuejaService quejaService;

    public QuejaController(QuejaService quejaService) {
        this.quejaService = quejaService;
    }

    @PostMapping("/{companyId}/{cedula}")
    public ResponseEntity<String> registrarQueja(@PathVariable Long companyId, @PathVariable Long cedula, @RequestBody Queja queja) {
        boolean created = quejaService.createQueja(queja, cedula, companyId);
        if (created) {
            return new ResponseEntity<>("Queja registrada exitosamente", HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>("Usuario o empresa no registrados, queja no creada", HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{quejaId}")
    public ResponseEntity<String> responderQueja(@PathVariable Long quejaId, @RequestBody String respuesta) {
        boolean answered = quejaService.answerQueja(respuesta, quejaId);
        if (answered) {
            return new ResponseEntity<>("Queja respondida", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Queja no encontrada", HttpStatus.NOT_FOUND);
        }
    }
}
