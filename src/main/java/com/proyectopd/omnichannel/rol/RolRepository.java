package com.proyectopd.omnichannel.rol;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

// <dtype of the entity, dtype of the pk>
public interface RolRepository extends JpaRepository<Rol, Integer> {
    List<Rol> getRolByNombreRol(String nombreRol);
}
