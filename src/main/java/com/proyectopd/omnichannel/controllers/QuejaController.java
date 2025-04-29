package com.proyectopd.omnichannel.controllers;

import com.proyectopd.omnichannel.dtos.createqueja.models.QuejaEmpresaDTO;
import com.proyectopd.omnichannel.models.Empresa;
import com.proyectopd.omnichannel.models.Queja;
import com.proyectopd.omnichannel.models.TipoQueja;
import com.proyectopd.omnichannel.services.EmpresaService;
import com.proyectopd.omnichannel.services.QuejaService;
import com.proyectopd.omnichannel.services.TipoQuejaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/quejas")
public class QuejaController {

    private QuejaService quejaService;
    private TipoQuejaService tipoQuejaService;
    private EmpresaService empresaService;

    public QuejaController(QuejaService quejaService, TipoQuejaService tipoQuejaService, EmpresaService empresaService) {
        this.quejaService = quejaService;
        this.tipoQuejaService = tipoQuejaService;
        this.empresaService = empresaService;
    }

    @PostMapping
    public ResponseEntity<QuejaEmpresaDTO> registrarQueja(@RequestBody QuejaEmpresaDTO newQueja) {

        Queja queja = new Queja();

        queja.setPrioridad(newQueja.getPrioridad());
        queja.setTiempoMinimoRespuesta(newQueja.getTiempoMinimoRespuesta());
        queja.setDescripcion(newQueja.getDescripcion());
        queja.setArchivo(newQueja.getArchivo());

        TipoQueja tipoQueja = tipoQuejaService.getTipoQuejaById(newQueja.getTipoQueja());

        queja.setTipoQueja(tipoQueja);

        Empresa empresa = empresaService.getEmpresaByName(newQueja.getNombreEmpresa());

        queja.setEmpresa(empresa);

        boolean created = quejaService.createQueja(queja);

        if (created) {
            return new ResponseEntity<>(newQueja, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(newQueja, HttpStatus.NOT_ACCEPTABLE);
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
