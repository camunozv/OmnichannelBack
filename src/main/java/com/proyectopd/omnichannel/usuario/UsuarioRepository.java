package com.proyectopd.omnichannel.usuario;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
    // Add methods if considered necessary.
}
