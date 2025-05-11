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

    @PostMapping("/nuevoServicio")
    public ResponseEntity<TipoServicio> createTipoServicio(@RequestBody TipoServicio tipoServicio) {

        boolean created = tipoServicioService.createTipoServicio(tipoServicio);

        if (created) {
            return new ResponseEntity<>(tipoServicio, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(tipoServicio, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/empresasPorTipoServicio")
    public ResponseEntity<List<EmpresaDTO>> getAllEmpresasPorTipoServicio(@RequestParam String nombreServicio) {
        List<EmpresaDTO> empresas = tipoServicioService.getAllEmpresasPorTipoServicio(nombreServicio);
        return new ResponseEntity<>(empresas, HttpStatus.OK);
    }
}
