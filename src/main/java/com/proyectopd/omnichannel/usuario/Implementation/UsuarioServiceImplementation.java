package com.proyectopd.omnichannel.usuario.Implementation;

import com.proyectopd.omnichannel.rol.RolRepository;
import com.proyectopd.omnichannel.usuario.Usuario;
import com.proyectopd.omnichannel.usuario.UsuarioRepository;
import com.proyectopd.omnichannel.usuario.UsuarioService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsuarioServiceImplementation implements UsuarioService {

    private UsuarioRepository usuarioRepository;
    private RolRepository rolRepository;

    public UsuarioServiceImplementation(UsuarioRepository usuarioRepository, RolRepository rolRepository) {
        this.usuarioRepository = usuarioRepository;
        this.rolRepository = rolRepository;
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
