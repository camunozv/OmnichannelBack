package com.proyectopd.omnichannel.controllers;

import com.proyectopd.omnichannel.models.TipoQueja;
import com.proyectopd.omnichannel.services.TipoQuejaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tipoQueja")
public class TipoQuejaController {

    private TipoQuejaService tipoQuejaService;

    public TipoQuejaController(TipoQuejaService tipoQuejaService) {
        this.tipoQuejaService = tipoQuejaService;
    }

    // Tested
    @PostMapping
    public ResponseEntity<TipoQueja> createTipoQueja(@RequestBody TipoQueja tipoQueja) {

        boolean created = tipoQuejaService.createTipoQueja(tipoQueja);
        if (created) {
            return new ResponseEntity<>(tipoQueja, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_ACCEPTABLE);
        }
    }

    // Get All TipoQuejas
    @GetMapping("/all")
    public ResponseEntity<List<TipoQueja>> getAllTipoQuejas() {
        try {
            List<TipoQueja> tipoQuejas = tipoQuejaService.getAllTipoQuejas();
            if (tipoQuejas != null && !tipoQuejas.isEmpty()) {
                return new ResponseEntity<>(tipoQuejas, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(tipoQuejas, HttpStatus.NO_CONTENT);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Tested
    @GetMapping
    public ResponseEntity<TipoQueja> getTipoQueja(@RequestParam String nombreTipoQueja) {

        TipoQueja tipoQueja = tipoQuejaService.getTipoQuejaById(nombreTipoQueja);

        if (tipoQueja != null) {
            return new ResponseEntity<>(tipoQueja, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(tipoQueja, HttpStatus.NOT_FOUND);
        }
    }

    // Tested
    @DeleteMapping
    public ResponseEntity<Boolean> deleteTipoQuejaByNombreTipoQueja(@RequestParam String nombreTipoQueja) {

        boolean deleted = tipoQuejaService.deleteTipoQueja(nombreTipoQueja);

        if (deleted) {
            return new ResponseEntity<>(true, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(false, HttpStatus.NOT_FOUND);
        }
    }
}
