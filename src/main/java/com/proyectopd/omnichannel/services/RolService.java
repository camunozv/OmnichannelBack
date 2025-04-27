package com.proyectopd.omnichannel.services;

import com.proyectopd.omnichannel.models.Rol;

public interface RolService {

    // Post
    boolean createNewRol(Rol newRol);

    // Get
    Rol getRolById(String rolName);
}
