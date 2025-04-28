package com.proyectopd.omnichannel.services;

import com.proyectopd.omnichannel.dtos.createuser.models.AdministradorProfesionalDTO;
import com.proyectopd.omnichannel.models.Administrador;

public interface AdministradorService {

    // Post
    Administrador crearAdministrador(Administrador newAdministrador);

    // Get
    AdministradorProfesionalDTO getAdministradorById(Integer administradorId);
}
