package com.proyectopd.omnichannel.services;

import com.proyectopd.omnichannel.models.Administrador;

public interface AdministradorService {

    // Post
    Administrador crearAdministrador(Administrador newAdministrador);

    // Get
    Administrador getAdministradorById(Integer administradorId);
}
