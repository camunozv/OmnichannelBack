package com.proyectopd.omnichannel.controllers;

import com.proyectopd.omnichannel.dtos.createuser.models.AdministradorProfesionalDTO;
import com.proyectopd.omnichannel.models.Administrador;
import com.proyectopd.omnichannel.models.Rol;
import com.proyectopd.omnichannel.models.Usuario;
import com.proyectopd.omnichannel.services.AdministradorService;
import com.proyectopd.omnichannel.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    private UsuarioService usuarioService;
    private AdministradorService administradorService;

    public UsuarioController(UsuarioService usuarioService, AdministradorService administradorService) {
        this.usuarioService = usuarioService;
        this.administradorService = administradorService;
    }

    @PostMapping("/admin")
    public ResponseEntity<Usuario> createUsuario(@RequestBody AdministradorProfesionalDTO newAdmin) {

        Usuario usuario = new Usuario();

        usuario.setIdUsuario(newAdmin.getId());
        usuario.setContrasenha(newAdmin.getContrasenha());

        Rol rol = new Rol(newAdmin.getRol());
        usuario.setRol(rol);

        Administrador administrador = new Administrador();

        administrador.setNombre(newAdmin.getNombre());
        administrador.setApellido(newAdmin.getApellido());
        administrador.setUsuario(usuario);

        boolean created = usuarioService.createUsuario(usuario);
        Administrador created2 = administradorService.crearAdministrador(administrador);

        if (created && !Objects.equals(created2.getNombre(), "NOT FOUND")) {
            return new ResponseEntity<>(usuario, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(usuario, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/{cedula}")
    public ResponseEntity<Usuario> getUsuarioById(@PathVariable Integer cedula) {
        Usuario usuario = usuarioService.getUsuarioById(cedula);
        if (usuario == null) {
            return new ResponseEntity<>(usuario, HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(usuario, HttpStatus.OK);
        }
    }
}
