package com.proyectopd.omnichannel.usuario.Implementation;

import com.proyectopd.omnichannel.usuario.Usuario;
import com.proyectopd.omnichannel.usuario.UsuarioRepository;
import com.proyectopd.omnichannel.usuario.UsuarioService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsuarioServiceImplementation implements UsuarioService {

    private UsuarioRepository usuarioRepository;

    public UsuarioServiceImplementation(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public Usuario getUsuarioById(Long cedula) {
        Optional<Usuario> usuarioOptional = usuarioRepository.findById(cedula);
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
