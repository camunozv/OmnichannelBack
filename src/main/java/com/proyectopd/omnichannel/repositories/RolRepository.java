package com.proyectopd.omnichannel.repositories;

import com.proyectopd.omnichannel.models.Rol;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

// <dtype of the entity, dtype of the pk>
public interface RolRepository extends JpaRepository<Rol, Integer> {
    List<Rol> getRolByNombreRol(String nombreRol);
}
