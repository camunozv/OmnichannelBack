package com.proyectopd.omnichannel.repositories;

import com.proyectopd.omnichannel.models.Administrador;
import com.proyectopd.omnichannel.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

public interface AdministradorRepository extends JpaRepository<Administrador, Integer> {

    Administrador getAdministradorByIdAdministrador(Integer administradorId);
    @Transactional
    void deleteAdministradorByUsuarioIs(Usuario usuario);
}
