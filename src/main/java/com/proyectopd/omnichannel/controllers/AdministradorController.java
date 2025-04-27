package com.proyectopd.omnichannel.controllers;

import com.proyectopd.omnichannel.services.AdministradorService;
import com.proyectopd.omnichannel.models.Administrador;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@RestController
@RequestMapping("/admin")
public class AdministradorController {

    private AdministradorService administradorService;

    public AdministradorController(AdministradorService administradorService) {
        this.administradorService = administradorService;
    }

    @GetMapping("/{adminId}")
    public ResponseEntity<Administrador> getAdministradorById(@PathVariable Integer adminId) {
        Administrador adminToReturn = administradorService.getAdministradorById(adminId);

        if (Objects.equals(adminToReturn.getNombre(), "NOT FOUND")) {
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
