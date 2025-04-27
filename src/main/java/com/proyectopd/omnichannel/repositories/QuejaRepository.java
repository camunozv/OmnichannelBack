package com.proyectopd.omnichannel.repositories;

import com.proyectopd.omnichannel.models.Queja;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuejaRepository extends JpaRepository<Queja, Long> {
    // Only implement methods if required
}
