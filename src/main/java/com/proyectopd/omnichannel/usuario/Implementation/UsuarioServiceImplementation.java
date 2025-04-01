package com.proyectopd.omnichannel.usuario.Implementation;

import com.proyectopd.omnichannel.usuario.Usuario;
import com.proyectopd.omnichannel.usuario.UsuarioService;

public class UsuarioServiceImplementation implements UsuarioService {


    @Override
    public Usuario getUsuarioById(Long cedula) {
        return null;
    }

    @Override
    public boolean createUsuario(Usuario usuario) {
        return false;
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
