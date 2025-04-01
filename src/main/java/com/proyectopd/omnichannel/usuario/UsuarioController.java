package com.proyectopd.omnichannel.usuario;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    private UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @PostMapping
    public ResponseEntity<Usuario> createUsuario(@RequestBody Usuario usuario) {
        boolean created = usuarioService.createUsuario(usuario);
        if (created) {
            return new ResponseEntity<>(usuario, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(usuario, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/{cedula}")
    public ResponseEntity<Usuario> getUsuarioById(@PathVariable Long cedula) {
        Usuario usuario = usuarioService.getUsuarioById(cedula);
        if (usuario == null) {
            return new ResponseEntity<>(usuario, HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(usuario, HttpStatus.OK);
        }
    }
}
