package com.proyectopd.omnichannel.repositories;

import com.proyectopd.omnichannel.models.Administrador;
import com.proyectopd.omnichannel.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdministradorRepository extends JpaRepository<Administrador, Integer> {

    Administrador getAdministradorByIdAdministrador(Integer administradorId);

    void deleteAdministradorByUsuarioIs(Usuario usuario);
}
