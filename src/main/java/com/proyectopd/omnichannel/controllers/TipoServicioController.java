package com.proyectopd.omnichannel.controllers;

import com.proyectopd.omnichannel.dtos.createuser.models.EmpresaDTO;
import com.proyectopd.omnichannel.models.TipoServicio;
import com.proyectopd.omnichannel.services.TipoServicioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tipoServicio")
public class TipoServicioController {

    private TipoServicioService tipoServicioService;

    public TipoServicioController(TipoServicioService tipoServicioService) {
        this.tipoServicioService = tipoServicioService;
    }

    // Tested
    @PostMapping("/nuevoServicio")
    public ResponseEntity<TipoServicio> createTipoServicio(@RequestBody TipoServicio tipoServicio) {

        boolean created = tipoServicioService.createTipoServicio(tipoServicio);

        if (created) {
            return new ResponseEntity<>(tipoServicio, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(tipoServicio, HttpStatus.BAD_REQUEST);
        }
    }

    // Get All TipoServicios
    @GetMapping("/all")
    public ResponseEntity<List<TipoServicio>> getAllTipoServicios() {
        try {
            List<TipoServicio> tipoServicios = tipoServicioService.getAllTipoServicios();
            if (tipoServicios != null && !tipoServicios.isEmpty()) {
                return new ResponseEntity<>(tipoServicios, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(tipoServicios, HttpStatus.NO_CONTENT);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Tested
    @DeleteMapping("/borrarTipoServicio")
    public ResponseEntity<Boolean> deleteTipoServicioByNombreTipoServicioApi(@RequestParam String nombreTipoServicio) {

        boolean deleted = tipoServicioService.deleteTipoServicioByNombreTipoServicio(nombreTipoServicio);

        if (deleted) {
            return new ResponseEntity<>(true, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(false, HttpStatus.NOT_FOUND);
        }

    }
}
