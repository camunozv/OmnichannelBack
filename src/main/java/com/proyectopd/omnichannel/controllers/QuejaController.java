package com.proyectopd.omnichannel.controllers;

import com.proyectopd.omnichannel.dtos.createqueja.models.QuejaEmpresaDTO;
import com.proyectopd.omnichannel.dtos.createrespuesta.QuejaRespuestaDTO;
import com.proyectopd.omnichannel.dtos.quejaBeauty.RespuestaQuejaDTO;
import com.proyectopd.omnichannel.models.Empresa;
import com.proyectopd.omnichannel.models.Queja;
import com.proyectopd.omnichannel.models.Respuesta;
import com.proyectopd.omnichannel.models.TipoQueja;
import com.proyectopd.omnichannel.services.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import com.google.gson.Gson;
import java.util.List;
import java.util.Random;

import static com.proyectopd.omnichannel.mappers.QuejaEmpresaDTOMapper.mapQuejaEmpresaDTOToQueja;
import static com.proyectopd.omnichannel.mappers.QuejaEmpresaDTOMapper.mapQuejaToQuejaEmpresaDTO;
import static com.proyectopd.omnichannel.mappers.RespuestaQuejaDTOMapper.mapRespuestaToRespuestaQuejaDTO;

@RestController
@RequestMapping("/quejas")
public class QuejaController {

    private QuejaService quejaService;
    private TipoQuejaService tipoQuejaService;
    private EmpresaService empresaService;
    private RespuestaService respuestaService;
    private Integer seq = 0;
    private Integer seq2 = 100;
    private final Gson gson = new Gson();

    public QuejaController(QuejaService quejaService, TipoQuejaService tipoQuejaService, EmpresaService empresaService, RespuestaService respuestaService) {
        this.quejaService = quejaService;
        this.tipoQuejaService = tipoQuejaService;
        this.empresaService = empresaService;
        this.respuestaService = respuestaService;
    }

    @GetMapping("/queja")
    public ResponseEntity<QuejaEmpresaDTO> getQuejaById(@RequestParam Integer idQueja) {
        Queja queja = quejaService.getQuejaById(idQueja);
        return new ResponseEntity<>(mapQuejaToQuejaEmpresaDTO(queja), HttpStatus.OK);
    }

    @GetMapping("/respuesta")
    public ResponseEntity<Respuesta> getRespuestaByQuejaId(@RequestParam Integer idQueja) {
        Queja queja = quejaService.getQuejaById(idQueja);
        return new ResponseEntity<>(queja.getRespuesta(), HttpStatus.OK);
    }


    // Funcionalidad de crear una queja
    @PostMapping("/nuevaQueja")
    public ResponseEntity<QuejaEmpresaDTO> registrarQueja(@RequestBody QuejaEmpresaDTO newQueja) {

        Queja queja = mapQuejaEmpresaDTOToQueja(newQueja);

        queja.setEstado("SIN RESOLVER");

        queja.setIdQueja(newQueja.getIdQueja());

        // Tipificación de quejas recibidas
        TipoQueja tipoQueja = tipoQuejaService.getTipoQuejaById(newQueja.getTipoQueja());

        queja.setTipoQueja(tipoQueja);

        Empresa empresa = empresaService.getEmpresaByName(newQueja.getNombreEmpresa());

        // Configuracion de tiempo de queja por tipo de queja.
        queja.setTiempoMinimoRespuesta(newQueja.getTiempoMinimoRespuesta().plusDays(tipoQueja.getDias()));

        queja.setEmpresa(empresa);

        newQueja.setIdQueja(++seq);

        boolean created = quejaService.createQueja(queja);

        if (created) {
            return new ResponseEntity<>(newQueja, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(newQueja, HttpStatus.NOT_ACCEPTABLE);
        }
    }

    // Funcionalidad de respuesta de quejas
    @PutMapping("/responderQueja")
    public ResponseEntity<QuejaRespuestaDTO> responderQueja(@RequestBody QuejaRespuestaDTO newRespuesta) {

        Respuesta respuesta = new Respuesta();

        respuesta.setIdRespuesta(++seq2);
        respuesta.setTextoRespuesta(newRespuesta.getTextoRespuesta());

        Queja quejaToAnswer = quejaService.getQuejaById(newRespuesta.getIdQueja());

        respuesta.setQueja(quejaToAnswer);

        System.out.println(respuesta.getIdRespuesta());
        System.out.println(respuesta.getTextoRespuesta());
        System.out.println(respuesta.getQueja().getIdQueja());
        System.out.println(respuesta.getQueja().getEstado());

        boolean saved = respuestaService.createRespuesta(respuesta);

        boolean answered = quejaService.answerQueja(respuesta, quejaToAnswer.getIdQueja());

        if (answered && saved) {
            return new ResponseEntity<>(newRespuesta, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(newRespuesta, HttpStatus.NOT_FOUND);
        }
    }

    // Integration test pending
    @DeleteMapping("/borrarQueja")
    public ResponseEntity<Boolean> deleteQueja(@RequestParam Integer idQueja) {

        boolean deleted = quejaService.deleteQuejaById(idQueja);

        if (deleted) {
            return new ResponseEntity<>(true, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(false, HttpStatus.NOT_FOUND);
        }
    }

    // Integration test pending
    @GetMapping("/quejasPorEstado")
    public ResponseEntity<List<RespuestaQuejaDTO>> getQuejasPorEstado(@RequestParam String estado) {

        try {
            ArrayList<RespuestaQuejaDTO> listToReturn = new ArrayList<>();
            for (Queja queja : quejaService.getQuejasByEstado(estado)) {
                listToReturn.add(mapRespuestaToRespuestaQuejaDTO(queja));
            }

            return new ResponseEntity<>(listToReturn, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }

    }

    // Get all quejas vencidas

    // Get all quejas respondidas

    // Get all quejas pendientes (menor a mayor tiempo)

    // Get all quejas pendientes (mayor a menor tiempo)

}
