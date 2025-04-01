package com.proyectopd.omnichannel.queja;

import org.springframework.data.jpa.repository.JpaRepository;

public interface QuejaRepository extends JpaRepository<Queja, Long> {
    // Only implement methods if required
}
