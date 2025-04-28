package com.proyectopd.omnichannel.services;

import com.proyectopd.omnichannel.dtos.createuser.models.UsuarioAdministradorDTO;
import com.proyectopd.omnichannel.models.Administrador;

public interface AdministradorService {

    // Post
    Administrador crearAdministrador(Administrador newAdministrador);

    // Get
    UsuarioAdministradorDTO getAdministradorById(Integer administradorId);
}
