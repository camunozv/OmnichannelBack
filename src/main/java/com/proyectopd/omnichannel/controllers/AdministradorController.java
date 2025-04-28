package com.proyectopd.omnichannel.controllers;

import com.proyectopd.omnichannel.dtos.createuser.creators.CreateAdministradorProfesionalDTO;
import com.proyectopd.omnichannel.dtos.createuser.models.AdministradorProfesionalDTO;
import com.proyectopd.omnichannel.models.Usuario;
import com.proyectopd.omnichannel.services.AdministradorService;
import com.proyectopd.omnichannel.models.Administrador;
import com.proyectopd.omnichannel.services.UsuarioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@RestController
@RequestMapping("/admin")
public class AdministradorController {

    private AdministradorService administradorService;
    private UsuarioService usuarioService;

    public AdministradorController(AdministradorService administradorService, UsuarioService usuarioService) {
        this.administradorService = administradorService;
        this.usuarioService = usuarioService;
    }


    @GetMapping("/{adminId}")
    public ResponseEntity<AdministradorProfesionalDTO> getAdministradorById(@PathVariable Integer adminId) {

        // Called the Creator -> replace new by factory method.
        AdministradorProfesionalDTO adminToReturn = administradorService.getAdministradorById(adminId);

        if (Objects.equals(adminToReturn.getNombre(), null)) {
            return new ResponseEntity<>(adminToReturn, HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(adminToReturn, HttpStatus.OK);
        }

    }

    @PostMapping
    public ResponseEntity<Administrador> crearAdministrador(@RequestBody Administrador newAdministrador) {
        Administrador adminToReturn = administradorService.crearAdministrador(newAdministrador);
        if (Objects.equals(adminToReturn.getNombre(), "NOT CREATED")) {
            return new ResponseEntity<>(adminToReturn, HttpStatus.INTERNAL_SERVER_ERROR);
        } else {
            return new ResponseEntity<>(adminToReturn, HttpStatus.CREATED);
        }
    }
}
