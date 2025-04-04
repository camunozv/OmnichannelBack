package com.proyectopd.omnichannel.usuario;

import java.util.List;

public interface UsuarioService {
    // Implemented
    Usuario getUsuarioById(Long cedula);
    boolean createUsuario(Usuario usuario);

    // Not implemented
    boolean updateUsuario(Long cedula, Usuario usuario);
    boolean deleteUsuario(Long cedula);
    //    List<Usuario> getAllUsuarios();
}
