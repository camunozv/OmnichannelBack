package com.proyectopd.omnichannel.services.Implementation;

import com.proyectopd.omnichannel.dtos.createuser.creators.CreateAdministradorProfesionalDTO;
import com.proyectopd.omnichannel.dtos.createuser.models.UsuarioAdministradorDTO;
import com.proyectopd.omnichannel.models.Administrador;
import com.proyectopd.omnichannel.models.Usuario;
import com.proyectopd.omnichannel.repositories.AdministradorRepository;
import com.proyectopd.omnichannel.repositories.UsuarioRepository;
import com.proyectopd.omnichannel.services.AdministradorService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class AdministradorServiceImplementation implements AdministradorService {

    AdministradorRepository administradorRepository;
    UsuarioRepository usuarioRepository;

    public AdministradorServiceImplementation(AdministradorRepository administradorRepository, UsuarioRepository usuarioRepository) {
        this.administradorRepository = administradorRepository;
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public Administrador crearAdministrador(Administrador newAdministrador) {

        try {
            administradorRepository.save(newAdministrador);
            return newAdministrador;
        } catch (Exception e) {
            return new Administrador("NOT CREATED");
        }

    }

    @Override
    public UsuarioAdministradorDTO getAdministradorById(Integer administradorId) {

        try {
            Administrador originalAdmin = administradorRepository.getAdministradorByIdAdministrador(administradorId);
            UsuarioAdministradorDTO adminToReturn = new CreateAdministradorProfesionalDTO().createNewUserDTO();
            adminToReturn.setId(originalAdmin.getUsuario().getIdUsuario());
            adminToReturn.setNombre(originalAdmin.getNombre());
            adminToReturn.setApellido(originalAdmin.getApellido());
            adminToReturn.setRol("Administrador");

            return adminToReturn;
        } catch (Exception e) {
            return new UsuarioAdministradorDTO();
        }
    }

    @Override
    @Transactional
    public boolean deleteAdministradorById(Integer idUsuario) {

        boolean deleted;

        try {
            Optional<Usuario> usuario = usuarioRepository.findById(idUsuario);
            if (usuario.isPresent()) {
                // We delete both in the admin and user table.
                Usuario administrador = usuario.get();
                administradorRepository.deleteAdministradorByUsuarioIs(administrador);
                usuarioRepository.deleteUsuarioByIdUsuario(idUsuario);
                deleted = true;
            } else {
                deleted = false;
            }
        } catch (Exception e) {
            e.printStackTrace();
            deleted = false;
        }

        return deleted;
    }
}
