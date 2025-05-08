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

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static com.proyectopd.omnichannel.mappers.QuejaEmpresaDTOMapper.mapQuejaEmpresaDTOToQueja;
import static com.proyectopd.omnichannel.mappers.QuejaEmpresaDTOMapper.mapQuejaToQuejaEmpresaDTO;

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



    /*@GetMapping()
    public ResponseEntity<QuejaEmpresaDTO> getQuejaById(@PathVariable Integer idQueja){
        Queja queja = quejaService.getQuejaById(idQueja);
        return new ResponseEntity<>(mapQuejaToQuejaEmpresaDTO(queja), HttpStatus.OK);
    }*/

    @GetMapping("/{nombreEmpresa}")
    public ResponseEntity<List<QuejaEmpresaDTO>> getAllQuejasEmpresa(@PathVariable String nombreEmpresa){

        ArrayList<QuejaEmpresaDTO> list = new ArrayList<>();

        for (Queja queja: quejaService.getAllQuejasEmpresa(nombreEmpresa)) {
            list.add(mapQuejaToQuejaEmpresaDTO(queja));
        }

        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<QuejaEmpresaDTO> registrarQueja(@RequestBody QuejaEmpresaDTO newQueja) {

        Queja queja = mapQuejaEmpresaDTOToQueja(newQueja);

        TipoQueja tipoQueja = tipoQuejaService.getTipoQuejaById(newQueja.getTipoQueja());

        queja.setTipoQueja(tipoQueja);

        Empresa empresa = empresaService.getEmpresaByName(newQueja.getNombreEmpresa());

        queja.setTiempoMinimoRespuesta(newQueja.getTiempoMinimoRespuesta().plusDays(tipoQueja.getDias()));

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

        respuesta.setQueja(quejaToAnswer);

        boolean saved = respuestaService.createRespuesta(respuesta);
//        System.out.println("Respuesta guardada: " + saved);
        boolean answered = quejaService.answerQueja(respuesta, quejaToAnswer.getIdQueja());

        if (answered && saved) {
            return new ResponseEntity<>(newRespuesta, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(newRespuesta, HttpStatus.NOT_FOUND);
        }
    }
}
