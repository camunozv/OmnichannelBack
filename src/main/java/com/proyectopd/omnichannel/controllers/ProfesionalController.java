package com.proyectopd.omnichannel.controllers;

import com.proyectopd.omnichannel.dtos.createuser.models.UsuarioProfesionalDTO;
import com.proyectopd.omnichannel.services.ProfesionalService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/profesionales")
public class ProfesionalController {

    ProfesionalService profesionalService;

    public ProfesionalController(ProfesionalService profesionalService) {
        this.profesionalService = profesionalService;
    }

    @GetMapping("/{idUsuario}")
    public ResponseEntity<UsuarioProfesionalDTO> getProfesionalById(@PathVariable Integer idUsuario) {
        // pending to finish
        return null;
    }
}
