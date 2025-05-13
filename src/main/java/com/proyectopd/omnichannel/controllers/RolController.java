package com.proyectopd.omnichannel.controllers;

import com.proyectopd.omnichannel.models.Rol;
import com.proyectopd.omnichannel.services.RolService;
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

    @PostMapping("/nuevoRol")
    public ResponseEntity<Rol> crearRol(@RequestBody Rol newRol) {
        try {
            rolService.createNewRol(newRol);
            return new ResponseEntity<>(newRol, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(new Rol("ERROR"), HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/nombreRol")
    public ResponseEntity<Rol> getRol(@RequestBody Rol rolToFind) {
        try {
            Rol rolToReturn = rolService.getRolById(rolToFind.getNombreRol());
            return new ResponseEntity<>(rolToReturn, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new Rol("ERROR"), HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/borrarRol")
    public ResponseEntity<Boolean> deleteRol(@RequestParam String nombreRol) {
        try {
            rolService.deleteRol(nombreRol);
            return new ResponseEntity<>(true, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(false, HttpStatus.NOT_FOUND);
        }
    }

}
