package com.proyectopd.omnichannel.repositories;

import com.proyectopd.omnichannel.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
    void deleteUsuarioByIdUsuario(Integer idUsuario);
    // Add methods if considered necessary.
}
