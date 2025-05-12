package com.proyectopd.omnichannel.services.Implementation;

import com.proyectopd.omnichannel.models.Usuario;
import com.proyectopd.omnichannel.repositories.UsuarioRepository;
import com.proyectopd.omnichannel.services.UsuarioService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsuarioServiceImplementation implements UsuarioService {

    private UsuarioRepository usuarioRepository;

    public UsuarioServiceImplementation(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
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
    public boolean deleteUsuario(Integer idUsuario) {

        boolean deleted;

        try {
            usuarioRepository.deleteUsuarioByIdUsuario(idUsuario);
            deleted = true;
        } catch (Exception e) {
            e.printStackTrace();
            deleted = false;
        }

        return deleted;
    }
}
