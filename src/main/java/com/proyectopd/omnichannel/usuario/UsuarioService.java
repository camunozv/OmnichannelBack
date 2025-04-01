package com.proyectopd.omnichannel.usuario;

import java.util.List;

public interface UsuarioService {

    Usuario getUsuarioById(Long cedula);
//    List<Usuario> getAllUsuarios();
    boolean createUsuario(Usuario usuario);
    boolean updateUsuario(Long cedula, Usuario usuario);
    boolean deleteUsuario(Long cedula);
}
