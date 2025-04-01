package com.proyectopd.omnichannel.usuario;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    // Add methods if considered necessary.
}
