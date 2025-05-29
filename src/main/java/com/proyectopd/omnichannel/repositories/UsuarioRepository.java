package com.proyectopd.omnichannel.repositories;

import com.proyectopd.omnichannel.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
    @Transactional
    void deleteUsuarioByIdUsuario(Integer idUsuario);
}
