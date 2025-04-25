package com.proyectopd.omnichannel.rol;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rol")
public class RolController {

    private RolService rolService;

    public RolController(RolService rolService) {
        this.rolService = rolService;
    }

    @PostMapping()
    public ResponseEntity<Rol> crearRol(@RequestBody Rol newRol) {
        try {
            rolService.createNewRol(newRol);
            return new ResponseEntity<>(newRol, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(new Rol(0, "ERROR"), HttpStatus.NOT_FOUND);
        }

    }


}
