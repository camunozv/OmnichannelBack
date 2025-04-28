package com.proyectopd.omnichannel.services.Implementation;

import com.proyectopd.omnichannel.models.Administrador;
import com.proyectopd.omnichannel.repositories.AdministradorRepository;
import com.proyectopd.omnichannel.repositories.RolRepository;
import com.proyectopd.omnichannel.models.Usuario;
import com.proyectopd.omnichannel.repositories.UsuarioRepository;
import com.proyectopd.omnichannel.services.UsuarioService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsuarioServiceImplementation implements UsuarioService {

    private UsuarioRepository usuarioRepository;
    private RolRepository rolRepository;
    private AdministradorRepository administradorRepository;

    public UsuarioServiceImplementation(UsuarioRepository usuarioRepository, RolRepository rolRepository, AdministradorRepository administradorRepository) {
        this.usuarioRepository = usuarioRepository;
        this.rolRepository = rolRepository;
        this.administradorRepository = administradorRepository;
    }

    @Override
    public Usuario getUsuarioById(Integer userId) {
        Optional<Usuario> usuarioOptional = usuarioRepository.findById(userId);
        Usuario usuario = null;
        if (usuarioOptional.isPresent()) {
            usuario = usuarioOptional.get();
        }
        return usuario;
    }



    @Override
    public boolean createUsuario(Usuario usuario) {

        boolean created;
        try {
            usuarioRepository.save(usuario);
            created = true;
        } catch (Exception e) {
            created = false;
        }
        return created;
    }

    @Override
    public boolean updateUsuario(Long cedula, Usuario usuario) {
        return false;
    }

    @Override
    public boolean deleteUsuario(Long cedula) {
        return false;
    }
}
