package com.proyectopd.omnichannel.controllers;

import com.proyectopd.omnichannel.dtos.createuser.models.UsuarioAdministradorDTO;
import com.proyectopd.omnichannel.services.AdministradorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@RestController
@RequestMapping("/administradores")
public class AdministradorController {

    private AdministradorService administradorService;

    public AdministradorController(AdministradorService administradorService) {
        this.administradorService = administradorService;
    }

    // Tested
    @GetMapping("/{idUsuario}")
    public ResponseEntity<UsuarioAdministradorDTO> getAdministradorById(@PathVariable Integer idUsuario) {

        UsuarioAdministradorDTO adminToReturn = administradorService.getAdministradorById(idUsuario);

        if (Objects.equals(adminToReturn.getNombre(), null)) {
            return new ResponseEntity<>(adminToReturn, HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(adminToReturn, HttpStatus.OK);
        }

    }

    // Tested
    @DeleteMapping("/{idUsuario}")
    public ResponseEntity<Boolean> deleteAdministrador(@PathVariable Integer idUsuario) {

        boolean deleted = administradorService.deleteAdministradorById(idUsuario);

        if (deleted) {
            return new ResponseEntity<>(true, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(false, HttpStatus.NOT_FOUND);
        }
    }

}
