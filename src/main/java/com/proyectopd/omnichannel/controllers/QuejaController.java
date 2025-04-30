package com.proyectopd.omnichannel.controllers;

import com.proyectopd.omnichannel.dtos.createqueja.models.QuejaEmpresaDTO;
import com.proyectopd.omnichannel.dtos.createrespuesta.QuejaRespuestaDTO;
import com.proyectopd.omnichannel.models.Empresa;
import com.proyectopd.omnichannel.models.Queja;
import com.proyectopd.omnichannel.models.Respuesta;
import com.proyectopd.omnichannel.models.TipoQueja;
import com.proyectopd.omnichannel.services.EmpresaService;
import com.proyectopd.omnichannel.services.QuejaService;
import com.proyectopd.omnichannel.services.RespuestaService;
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
    private RespuestaService respuestaService;

    public QuejaController(QuejaService quejaService, TipoQuejaService tipoQuejaService, EmpresaService empresaService, RespuestaService respuestaService) {
        this.quejaService = quejaService;
        this.tipoQuejaService = tipoQuejaService;
        this.empresaService = empresaService;
        this.respuestaService = respuestaService;
    }

    @PostMapping
    public ResponseEntity<QuejaEmpresaDTO> registrarQueja(@RequestBody QuejaEmpresaDTO newQueja) {

        Queja queja = new Queja();

        queja.setIdQueja(newQueja.getIdQueja());
        queja.setPrioridad(newQueja.getPrioridad());
        queja.setTiempoMinimoRespuesta(newQueja.getTiempoMinimoRespuesta());
        queja.setDescripcion(newQueja.getDescripcion());
        queja.setArchivo(newQueja.getArchivo());

        TipoQueja tipoQueja = tipoQuejaService.getTipoQuejaById(newQueja.getTipoQueja());
        System.out.println("hola" + tipoQueja);

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

    @PutMapping
    public ResponseEntity<QuejaRespuestaDTO> responderQueja(@RequestBody QuejaRespuestaDTO newRespuesta) {

        Respuesta respuesta = new Respuesta();
        respuesta.setIdRespuesta(newRespuesta.getIdRespuesta());
        respuesta.setTextoRespuesta(newRespuesta.getTextoRespuesta());

        Queja quejaToAnswer = quejaService.getQuejaById(newRespuesta.getIdQueja());

        //System.out.println(quejaToAnswer.getTipoQueja().getTipoQueja());

        respuesta.setQueja(quejaToAnswer);

        boolean saved = respuestaService.createRespuesta(respuesta);
        System.out.println("Respuesta guardada: " + saved);
        boolean answered = quejaService.answerQueja(respuesta, quejaToAnswer.getIdQueja());

        if (answered && saved) {
            return new ResponseEntity<>(newRespuesta, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(newRespuesta, HttpStatus.NOT_FOUND);
        }
    }
}
