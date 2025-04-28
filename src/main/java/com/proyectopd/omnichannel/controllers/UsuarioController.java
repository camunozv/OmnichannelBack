package com.proyectopd.omnichannel.controllers;

import com.proyectopd.omnichannel.dtos.createuser.models.UsuarioAdministradorDTO;
import com.proyectopd.omnichannel.dtos.createuser.models.UsuarioProfesionalDTO;
import com.proyectopd.omnichannel.models.Administrador;
import com.proyectopd.omnichannel.models.Profesional;
import com.proyectopd.omnichannel.models.Rol;
import com.proyectopd.omnichannel.models.Usuario;
import com.proyectopd.omnichannel.services.AdministradorService;
import com.proyectopd.omnichannel.services.ProfesionalService;
import com.proyectopd.omnichannel.services.UsuarioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    private UsuarioService usuarioService;
    private AdministradorService administradorService;
    private ProfesionalService profesionalService;

    public UsuarioController(UsuarioService usuarioService, AdministradorService administradorService, ProfesionalService profesionalService) {
        this.usuarioService = usuarioService;
        this.administradorService = administradorService;
        this.profesionalService = profesionalService;
    }

    @PostMapping("/admin")
    public ResponseEntity<Usuario> createAdmin(@RequestBody UsuarioAdministradorDTO newAdmin) {

        Usuario usuario = new Usuario();

        usuario.setIdUsuario(newAdmin.getId());
        usuario.setContrasenha(newAdmin.getContrasenha());

        Rol rol = new Rol(newAdmin.getRol());
        usuario.setRol(rol); // VERY IMPORTANT FOR THE DATABASE TO SAVE IT

        Administrador administrador = new Administrador();

        administrador.setNombre(newAdmin.getNombre());
        administrador.setApellido(newAdmin.getApellido());
        administrador.setUsuario(usuario); // VERY IMPORTANT FOR THE DATABASE TO SAVE IT

        boolean created = usuarioService.createUsuario(usuario);
        Administrador created2 = administradorService.crearAdministrador(administrador);

        if (created && !Objects.equals(created2.getNombre(), "NOT FOUND")) {
            return new ResponseEntity<>(usuario, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(usuario, HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/profesional")
    public ResponseEntity<Usuario> createProfesional(@RequestBody UsuarioProfesionalDTO newProfesional) {

        Rol rol = new Rol(newProfesional.getRol());

        Usuario usuario = new Usuario();

        usuario.setIdUsuario(newProfesional.getId());
        usuario.setContrasenha(newProfesional.getContrasenha());

        usuario.setRol(rol);

        Profesional profesional = new Profesional();

        profesional.setNombre(newProfesional.getNombre());
        profesional.setApellido(newProfesional.getApellido());
        profesional.setCorreoElectronico(newProfesional.getCorreoElectronico());
        profesional.setTelefonoMovil(newProfesional.getTelefonoMovil());
        profesional.setCantidadQuejasEncargadas(newProfesional.getCantidadQuejasEncargadas());

        profesional.setUsuario(usuario); // VERY IMPORTANT FOR THE DATABASE TO SAVE IT

        boolean created1 = usuarioService.createUsuario(usuario);
        boolean created2 = profesionalService.crearProfesional(profesional);

        if (created1 && created2) {
            return new ResponseEntity<>(usuario, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(usuario, HttpStatus.INTERNAL_SERVER_ERROR);
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
