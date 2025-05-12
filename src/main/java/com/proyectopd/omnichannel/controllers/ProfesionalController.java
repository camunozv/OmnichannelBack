package com.proyectopd.omnichannel.controllers;

import com.proyectopd.omnichannel.dtos.createuser.models.UsuarioProfesionalDTO;
import com.proyectopd.omnichannel.models.Profesional;
import com.proyectopd.omnichannel.models.Usuario;
import com.proyectopd.omnichannel.services.ProfesionalService;
import com.proyectopd.omnichannel.services.UsuarioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.proyectopd.omnichannel.mappers.UsuarioProfesionalDTOMapper.mapProfesionalToUsuarioProfesionalDTO;
import static com.proyectopd.omnichannel.mappers.UsuarioProfesionalDTOMapper.mapUsuarioProfesionalDTOToProfesional;

@RestController
@RequestMapping("/profesionales")
public class ProfesionalController {

    ProfesionalService profesionalService;
    UsuarioService usuarioService;

    public ProfesionalController(ProfesionalService profesionalService, UsuarioService usuarioService) {
        this.profesionalService = profesionalService;
        this.usuarioService = usuarioService;
    }

    // Integration test pending
    @GetMapping("/{idUsuario}")
    public ResponseEntity<UsuarioProfesionalDTO> getProfesionalById(@PathVariable Integer idUsuario) {

        Profesional profesional = profesionalService.getProfesionalById(idUsuario);
        Usuario usuario = usuarioService.getUsuarioById(idUsuario);

        UsuarioProfesionalDTO usuarioProfesionalDTO = null;
        if (profesional != null && usuario != null) {
            usuarioProfesionalDTO = mapProfesionalToUsuarioProfesionalDTO(usuario, profesional);
            return new ResponseEntity<>(usuarioProfesionalDTO, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    // Integration test pending
    @DeleteMapping("/{idUsuario}")
    public ResponseEntity<Boolean> deleteProfesional(@PathVariable Integer idUsuario) {

        boolean deleted = profesionalService.deleteProfesionalById(idUsuario);

        if (deleted) {
            return new ResponseEntity<>(true, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(false, HttpStatus.NOT_FOUND);
        }
    }
}
