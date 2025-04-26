package com.proyectopd.omnichannel.rol;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
            return new ResponseEntity<>(new Rol("ERROR"), HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping
    public ResponseEntity<Rol> getRol(@RequestBody Rol rolToFind) {
        try {
            Rol rolToReturn = rolService.getRolById(rolToFind.getNombreRol());
            return new ResponseEntity<>(rolToReturn, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new Rol("ERROR"), HttpStatus.NOT_FOUND);
        }
    }

}
