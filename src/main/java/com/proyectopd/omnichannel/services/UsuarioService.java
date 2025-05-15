package com.proyectopd.omnichannel.services;

import com.proyectopd.omnichannel.models.Administrador;
import com.proyectopd.omnichannel.models.Notificacion;
import com.proyectopd.omnichannel.models.Usuario;

import java.util.List;

public interface UsuarioService {
    // Implemented
    Usuario getUsuarioById(Integer userId);
    boolean createUsuario(Usuario usuario);


    // Not implemented
    boolean updateUsuario(Long cedula, Usuario usuario);
    boolean deleteUsuario(Integer idUsuario);

}
