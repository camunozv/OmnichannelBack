package com.proyectopd.omnichannel.rol;

public interface RolService {

    // Post
    boolean createNewRol(Rol newRol);

    // Get
    Rol getRolById(String rolName);
}
